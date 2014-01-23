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


public class controllerConfirmInvitation extends HttpServlet{


	public void doPost(HttpServletRequest request, HttpServletResponse response) 
				           throws ServletException, java.io.IOException {
		System.out.println("called eventAppUpload");
		String registrationId=request.getParameter("x");
		String eventRegistrationId=request.getParameter("y");
		String callback = request.getParameter("callback");
		String responseType = request.getParameter("responseType");
		response.setContentType("text/html");
		response.setHeader("Access-Control-Allow-Origin","*");
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();
		ArrayList<String> data = new ArrayList<String>(); 
		if (registrationId == null) {
			data.add("registrationId");
		}
		if (eventRegistrationId == null) {
			data.add("eventRegistrationId");
		}
		if(data.size() != 0) {
			obj.put("response","error");
			obj.put("responseString","Insufficient Data");
			obj.put("data", data);
		} else {
			
			try
			{	 	
				beanConfirmInvitation bean=new beanConfirmInvitation();   
				bean.setEventReistrationId(eventRegistrationId);
				bean.setRegistrationId(registrationId);
				daoConfirmInvitation dao = new daoConfirmInvitation();
				bean =dao.create(bean);
			    if(bean.getValid()) {
			    	out.print("You are successfully Registered with the event. Thank you. Have a nice experience with Advaita");
			    } else {
			    	out.print("Registration Failed due to "+bean.getException());
			    }
			}
					
					
			catch (Throwable theException) 	    
			{	
			}
		}
	}
}
