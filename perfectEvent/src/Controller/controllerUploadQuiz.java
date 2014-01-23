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


public class controllerUploadQuiz extends HttpServlet{


	public void doPost(HttpServletRequest request, HttpServletResponse response) 
				           throws ServletException, java.io.IOException {
		System.out.println("called UploadQuiz");
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin","*");
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();
		ArrayList<String> data = new ArrayList<String>();
		HttpSession session = request.getSession(true);
		String appId=request.getParameter("appId");
		String question=request.getParameter("question");
		String comment=request.getParameter("comment");
		String answer=request.getParameter("answer");
		String questionImage=request.getParameter("questionImage");
		String positiveCash=request.getParameter("positiveCash");
		String negativeCash=request.getParameter("negativeCash");
		String expiryDateTime = request.getParameter("expiryDateTime");
		String callback = request.getParameter("callback");
		String responseType = request.getParameter("responseType");
		accessToken token = new accessToken();
		String accessToken = request.getParameter("accessToken");
		if((accessToken != null) && token.get(accessToken)) {
			if (appId == null) {
				data.add("appId");
			}
			if (question == null) {
				data.add("question");
			}
			if (comment == null) {
				data.add("comment");
			}
			if (answer == null) {
				data.add("answer");
			}
			if (positiveCash == null) {
				data.add("positiveCash");
			}
			if (negativeCash == null) {
				data.add("negativeCash");
			}
			if (expiryDateTime == null) {
				data.add("expiryDateTime");
			}
			if(data.size() != 0) {
				obj.put("response","error");
				obj.put("responseString","Insufficient Data");
				obj.put("data", data);
			} else {
				
				try
				{	 	
					beanUploadQuiz bean=new beanUploadQuiz();   
					bean.setAppId(appId);
					bean.setQuestion(question);
					bean.setComment(comment);
					bean.setAnswer(answer);
					bean.setPositiveCash(positiveCash);
					bean.setNegativeCash(negativeCash);
					bean.setQuestionImage(questionImage);
					bean.setExpiryTime(expiryDateTime);
					daoUploadQuiz dao = new daoUploadQuiz();
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
		} 	else {
			obj.put("response","error");
			obj.put("responseString","Session expired"); 
		}
		if(responseType.equals("jsonp")) 
			out.print(callback+"("+obj+")");
		else
			out.print(obj);
		
	}
}
