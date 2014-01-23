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


public class controllerEventAppUpload extends HttpServlet{


	public void doPost(HttpServletRequest request, HttpServletResponse response) 
				           throws ServletException, java.io.IOException {
		System.out.println("called eventAppUpload");
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin","*");
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();
		ArrayList<String> data = new ArrayList<String>();
		
		accessToken token = new accessToken();
		String accessToken = request.getParameter("accessToken");
		
		String name=request.getParameter("name");
		String imgUrl=request.getParameter("imgUrl");
		String about=request.getParameter("about");
		String contact=request.getParameter("contact");
		String scheduleFrom=request.getParameter("scheduleFrom");
		String scheduleTo=request.getParameter("scheduleTo");
		String fee=request.getParameter("fee");
		String callback = request.getParameter("callback");
		String responseType = request.getParameter("responseType");
		
		System.out.println("Image "+imgUrl);
		System.out.println("name "+name);
		if((accessToken != null) && token.get(accessToken)) {
			if (name == null) {
				data.add("name");
			}
			if (imgUrl == null) {
				data.add("imgUrl");
			}
			if (about == null) {
				data.add("about");
			}
			if (contact == null) {
				data.add("contact");
			}
			if (scheduleFrom == null) {
				data.add("scheduleFrom");
			}
			if (scheduleTo == null) {
				data.add("scheduleFrom");
			}
			if (fee == null) {
				data.add("fee");
			}
			if(data.size() != 0) {
				obj.put("response","error");
				obj.put("responseString","Insufficient Data");
				obj.put("data", data);
			} else {
				
				try
				{	 	
					beanEventAppUpload bean=new beanEventAppUpload();   
					bean.setName(name);
					bean.setImgUrl(imgUrl);
					bean.setAbout(about);
					bean.setContact(contact);
					bean.setFromDate(scheduleFrom);
					bean.setToDate(scheduleTo);
					bean.setFee(fee);
					daoEventAppUpload dao = new daoEventAppUpload();
					bean =dao.create(bean);
				    if(bean.getValid()) {
						obj.put("response","success");
						obj.put("responseString","event uploaded successfully");
				    } else {
				    	System.out.println("I am here");
						obj.put("response","error");
						obj.put("responseString",bean.getException());
				    }
				}
						
						
				catch (Throwable theException) 	    
				{	
					System.out.println("I am here1");
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
