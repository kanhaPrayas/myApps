package Controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import Model.accessToken;

public class controllerEventRegistration extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	           throws ServletException, java.io.IOException {
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin","*");
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();
		ArrayList<String> data = new ArrayList<String>();
		String appId=request.getParameter("appId");
		String eventId=request.getParameter("eventId");
		String feeReceived=request.getParameter("feeReceived");
		String userId=request.getParameter("userId");
		String callback = request.getParameter("callback");
		
		accessToken token = new accessToken();
		String accessToken = request.getParameter("accessToken");
		String responseType = request.getParameter("responseType");
		if((accessToken != null) && token.get(accessToken)) {
			if (appId == null) {
			data.add("appId");
			}
			if (eventId == null) {
			data.add("eventId");
			}
			if (userId == null) {
			data.add("userId");
			}
			if (feeReceived == null) {
			data.add("feeReceived");
			}
			if(data.size() != 0) {
			obj.put("response","error");
			obj.put("responseString","Insufficient Data");
			obj.put("data", data);
			} else {
			
				try
				{	 	
					Model.beanEventRegistration bean=new Model.beanEventRegistration();	
					Model.daoEventRegistration dao=new Model.daoEventRegistration();
					bean.setAppId(appId);
					bean.setEventId(eventId);
					bean.setUserId(userId);
					bean.setFeeReceived(feeReceived);
					bean.setValid(false);
					bean=dao.create(bean);
					if(bean.getValid())
						{
						obj.put("response","success");
						obj.put("responseString","You have successfully registered the event");
						}
					else {
				    	
						obj.put("response","error");
				    }
					
				}
				catch(Exception e)
				{
					System.out.println(e);
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