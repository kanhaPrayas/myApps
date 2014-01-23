
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
public class controllerUploadSponsor extends HttpServlet{


	public void doPost(HttpServletRequest request, HttpServletResponse response) 
				           throws ServletException, java.io.IOException {
		System.out.println("called uploadSponsor");
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin","*");
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();
		ArrayList<String> data = new ArrayList<String>();
		String appId=request.getParameter("appId");
		String name=request.getParameter("name");
		String imgUrl=request.getParameter("imgUrl");
		String about=request.getParameter("about");
		String contact=request.getParameter("contact");
		String status=request.getParameter("status");
		String amount=request.getParameter("amount");
		String callback = request.getParameter("callback");
		String responseType = request.getParameter("responseType");
		accessToken token = new accessToken();
		String accessToken = request.getParameter("accessToken");
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
			if (status == null) {
				data.add("status");
			}
			if (amount == null) {
				data.add("amount");
			}
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
					beanUploadSponsor bean=new beanUploadSponsor();   
					bean.setName(name);
					bean.setImgUrl(imgUrl);
					bean.setAbout(about);
					bean.setContact(contact);
					bean.setStatus(status);
					bean.setAmount(amount);
					bean.setAppId(appId);
					daoUploadSponsor dao = new daoUploadSponsor();
					bean =dao.create(bean);
				    if(bean.getValid()) {
						obj.put("response","success");
						obj.put("responseString","sponsor uploaded successfully");
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
		}  	else {
			obj.put("response","error");
			obj.put("responseString","Session expired"); 
		}
		if(responseType.equals("jsonp")) 
			out.print(callback+"("+obj+")");
		else
			out.print(obj);
	}
}
