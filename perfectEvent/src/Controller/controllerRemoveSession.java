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


public class controllerRemoveSession extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	           throws ServletException, java.io.IOException {
	System.out.println("called validateSession");
	response.setContentType("application/json");
	response.setHeader("Access-Control-Allow-Origin","*");
	PrintWriter out = response.getWriter();
	JSONObject obj = new JSONObject();
	HttpSession session = request.getSession(true);
	session.invalidate();
		obj.put("response","success");
		obj.put("responseString","Session Dead");
	out.print(obj);
}

}