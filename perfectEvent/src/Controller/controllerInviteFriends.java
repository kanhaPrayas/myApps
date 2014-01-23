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


public class controllerInviteFriends extends HttpServlet{


	public void doPost(HttpServletRequest request, HttpServletResponse response) 
				           throws ServletException, java.io.IOException {
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin","*");
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();
		ArrayList<String> data = new ArrayList<String>();
		sendMail sm=new sendMail();
		System.out.println("called InviteFriends");
		String inviterId=request.getParameter("registrationId");
		String appId=request.getParameter("appId");
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		String eventId=request.getParameter("eventId");
		String eventName=request.getParameter("eventName");
		String responseType=request.getParameter("responseType");
		String callback=request.getParameter("callback");
		
		accessToken token = new accessToken();
		String accessToken = request.getParameter("accessToken");

		if((accessToken != null) && token.get(accessToken)) {
			if (name == null) {
				data.add("name");
			}
			if (email == null) {
				data.add("email");
			}
			if (eventId == null) {
				data.add("eventId");
			}
			if (eventName == null) {
				data.add("eventName");
			}
			if (inviterId == null) {
				data.add("registrationId");
			}
			if(data.size() != 0) {
				obj.put("response","error");
				obj.put("responseString","Insufficient Data");
				obj.put("data", data);
			} else {
				
				try
				{	
					beanInviteFriends bean=new beanInviteFriends();
					bean.setAppId(appId);
					bean.setEmail(email);
					bean.setEventId(eventId);
					bean.setInviterId(inviterId);
					daoInviteFriends dao = new daoInviteFriends();
					bean =dao.create(bean);
					String lnk = "http://advaita.iiit-bh.ac.in:8080/perfetEvent/Servlet/controllerConfirmInvitation?x="+bean.getId()+"&y="+bean.getEventRegistrationId();
					String subject = "Request From "+name+" for Advaita 2k14";
					String body = "Hello There. Greetings from Team Advaita.\n Your friend Mr."+name+" has requested you to join as a team member for the event "+eventName+" in Advaita2k14.\nTo confirm participation with Mr. "+name+" click the link below\n\n"+lnk+"\n\n with warm regards\nTeam Advaita.";
					sm.sendValidateMail(subject, body, email);
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
