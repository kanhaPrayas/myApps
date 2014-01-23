package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;

import org.json.simple.*;

import java.util.*;
import java.text.*;

import Model.*;


/**
 * Servlet implementation class LoginServlet
 */


public class controllerGetFbUserName extends HttpServlet{


	public void doPost(HttpServletRequest request, HttpServletResponse response) 
				           throws ServletException, java.io.IOException {
		System.out.println("called eventAppUpload");
		String userName=request.getParameter("userName");
		String callback = request.getParameter("callback");
		String responseType = request.getParameter("responseType");
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin","*");
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();
		ArrayList<String> data = new ArrayList<String>(); 
		if (userName == null) {
			data.add("userName");
		}

		if(data.size() != 0) {
			obj.put("response","error");
			obj.put("responseString","Insufficient Data");
			obj.put("data", data);
		} else {
			
			try
			{	 	
				beanGetFbUserName bean=new beanGetFbUserName();   
				bean.setUserName(userName);
				daoGetFbUserName dao = new daoGetFbUserName();
				bean =dao.create(bean);
			    if(bean.getValid()) {
					obj.put("response","success");
					obj.put("fbUserName",bean.getFbUserName());
			    } else {
			    	System.out.println("I am here");
					obj.put("response","error");
					obj.put("responseString",bean.getException());
			    }
			}
					
					
			catch (Throwable theException) 	    
			{	
				obj.put("response","error");
				obj.put("responseString",theException.toString()); 
			}
		}
		if(responseType.equals("jsonp")) 
			out.print(callback+"("+obj+")");
		else
			out.print(obj);
	}
}
