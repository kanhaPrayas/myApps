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


public class controllerUploadRoseiCash extends HttpServlet{


	public void doPost(HttpServletRequest request, HttpServletResponse response) 
				           throws ServletException, java.io.IOException {
		System.out.println("called UploadRoseiCase");
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin","*");
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();
		ArrayList<String> data = new ArrayList<String>();
		
		accessToken token = new accessToken();
		String accessToken = request.getParameter("accessToken");
		String userId = request.getParameter("userId");
		String cash=request.getParameter("cash");
		String callback = request.getParameter("callback");
		String responseType = request.getParameter("responseType");

		if((accessToken != null) && token.get(accessToken)) {
			if (userId == null) {
				data.add("userId");
			}
			if (cash == null) {
				data.add("cash");
			}
			if(data.size() != 0) {
				obj.put("response","error");
				obj.put("responseString","Insufficient Data");
				obj.put("data", data);
			} else {
				
				try
				{	 	
					beanUploadRoseiCash bean=new beanUploadRoseiCash();   
					bean.setUserId(userId);
					bean.setCash(cash);
					daoUploadRoseiCash dao = new daoUploadRoseiCash();
					bean =dao.create(bean);
				    if(bean.getValid()) {
						obj.put("response","success");
						obj.put("responseString","Cash updated");
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
		} else {
			obj.put("response","error");
			obj.put("responseString","Session expired"); 
		}
		if(responseType.equals("jsonp")) 
			out.print(callback+"("+obj+")");
		else
			out.print(obj);
	}
}
