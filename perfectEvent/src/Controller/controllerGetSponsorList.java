
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
public class controllerGetSponsorList extends HttpServlet{


	public void doGet(HttpServletRequest request, HttpServletResponse response) 
				           throws ServletException, java.io.IOException {
		System.out.println("called getSponsorList");
		String appId=request.getParameter("appId");
		String callback = request.getParameter("callback");
		String responseType = request.getParameter("responseType");
		
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin","*");
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();
		ArrayList<String> data = new ArrayList<String>(); 
		if (appId == null) {
			data.add("appId");
		}
		if(data.size() != 0) {
			obj.put("response","error");
			obj.put("responseString","Insufficient Data");
			obj.put("data", data);
		} else {		
			try
			{	 	
				beanGetSponsorList bean=new beanGetSponsorList();   

				bean.setAppId(appId);
				daoGetSponsorList dao = new daoGetSponsorList();
				bean =dao.create(bean);
			    if(bean.getValid()) {
					obj.put("response","success");
					obj.put("responseString",bean.getResultSetList());
			    } else {
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
