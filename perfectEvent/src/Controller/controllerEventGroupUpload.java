
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


public class controllerEventGroupUpload extends HttpServlet{


	public void doPost(HttpServletRequest request, HttpServletResponse response) 
				           throws ServletException, java.io.IOException {
		System.out.println("called eventGroupUpload");
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin","*");
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();
		ArrayList<String> data = new ArrayList<String>();
		String appId=request.getParameter("appId");
		String name=request.getParameter("name");
		String imgUrl=request.getParameter("imgUrl");
		String about=request.getParameter("about");
		String rules=request.getParameter("rules");
		String contact=request.getParameter("contact");
		String callback = request.getParameter("callback");
		String responseType = request.getParameter("responseType");

		accessToken token = new accessToken();
		String accessToken = request.getParameter("accessToken");
		if((accessToken != null) && token.get(accessToken)) {
			if (appId == null) {
				data.add("appId");
			}
			if (name == null) {
				data.add("name");
			}
			if (imgUrl == null) {
				data.add("imgUrl");
			}
			if (about == null) {
				data.add("about");
			}
			if (rules == null) {
				data.add("rules");
			}
			if (contact == null) {
				data.add("contact");
			}
			if(data.size() != 0) {
				obj.put("response","error");
				obj.put("responseString","Insufficient Data");
				obj.put("data", data);
			} else {
				
				try
				{	 	
					beanEventGroupUpload bean=new beanEventGroupUpload();
					bean.setAppId(appId);
					bean.setName(name);
					bean.setImgUrl(imgUrl);
					bean.setAbout(about);
					bean.setRules(rules);
					bean.setContact(contact);
					daoEventGroupUpload dao = new daoEventGroupUpload();
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
