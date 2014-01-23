package Controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ConnectionManager;

public class validateEmail extends HttpServlet{

	public void doGet (HttpServletRequest request, HttpServletResponse response) 
	           throws ServletException, java.io.IOException {
		Connection currentCon = null;
		ConnectionManager cm = new ConnectionManager();
		currentCon=cm.getConnection();
		String uuid1 = request.getParameter("aswert");
		String sql="update register set registrationStatus = 1 where registrationUUID='"+uuid1+"'";
		System.out.println("asdf"+uuid1);
		try
		{
			Statement statement  = currentCon.createStatement();
			int x=statement.executeUpdate(sql);
			if(x==1){
				System.out.println("Done");
				response.setContentType("text/html");
				response.setHeader("Access-Control-Allow-Origin","*");
				PrintWriter out = response.getWriter();
				JSONObject obj = new JSONObject();
				obj.put("response","success");
				obj.put("responseString","");
				out.print("You are successfully verified by Advaita App. Click here to <a href='http://advaita.iiit-bh.ac.in'>login Here</a>");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
