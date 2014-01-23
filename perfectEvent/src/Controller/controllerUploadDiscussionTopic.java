package Controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import Model.*;


public class controllerUploadDiscussionTopic extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	           throws ServletException, java.io.IOException {
		System.out.println("called controllerUploadDiscussionTopic");
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin","*");
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();
		ArrayList<String> data = new ArrayList<String>();
		String appId=request.getParameter("appId");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String fbUserName=request.getParameter("fbUserName");
		String topicTitle=request.getParameter("topicTitle");
		String topicSummary=request.getParameter("topicSummary");
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
			if (email == null) {
			data.add("email");
			}
			if (fbUserName == null) {
			data.add("fbUserName");
			}
			if (topicTitle == null) {
			data.add("topicTitle");
			}
			if (topicSummary == null) {
			data.add("topicSummary");
			}
			if(data.size() != 0) {
			obj.put("response","error");
			obj.put("responseString","Insufficient Data");
			obj.put("data", data);
			} else {
			
				try
				{	
				
					beanUploadDiscussionTopic bean=new beanUploadDiscussionTopic();
					bean.setAppId(appId);
					bean.setName(name);
					bean.setEmail(email);
					bean.setFbUserName(fbUserName);
					bean.setTopicTitle(topicTitle);
					bean.setTopicSummary(topicSummary);
				
					daoUploadDiscussionTopic dao = new daoUploadDiscussionTopic();
					bean =dao.create(bean);
					System.out.println("After Dao");
				 if(bean.getValid()) {
						obj.put("response","success");
						obj.put("responseString","event uploaded successfully");
						obj.put("topicId",bean.getTopicId());
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
		}	else {
			obj.put("response","error");
			obj.put("responseString","Session expired"); 
		}
		if(responseType.equals("jsonp")) 
		out.print(callback+"("+obj+")");
		else
		out.print(obj);
	}
}
