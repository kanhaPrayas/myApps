package Controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;


public class controllerValidateSession extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	           throws ServletException, java.io.IOException {
	System.out.println("called validateSession");
	response.setContentType("application/json");
	response.setHeader("Access-Control-Allow-Origin","*");
	PrintWriter out = response.getWriter();
	JSONObject obj = new JSONObject();
	HttpSession session = request.getSession(true);
	String currentSessionUserName = (String) session.getAttribute("currentSessionUserName");
	String currentSessionUserId = (String)session.getAttribute("currentSessionUserId");
	String currentSessionUserEmail = (String)session.getAttribute("currentSessionUserEmail");
	String currentSessionAppId = (String)session.getAttribute("currentSessionAppId");
	String currentSessionFbUserName = (String)session.getAttribute("currentSessionFbUserName");
	if(currentSessionUserName != null && currentSessionUserId != null & currentSessionUserEmail != null && currentSessionAppId != null && currentSessionFbUserName != null) {
		obj.put("response","success");
		obj.put("responseString","Session Alive");
		obj.put("currentSessionFbUserName",currentSessionUserName);
	} else {
		obj.put("response","error");
		obj.put("responseString","Session Dead");
	}
	out.print(obj);
}

}
