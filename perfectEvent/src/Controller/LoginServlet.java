
package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.UUID;

import org.json.simple.JSONObject;

import Model.UserBean;
import Model.UserDAO;
import Model.accessToken;
import Model.hash;


/**
 * Servlet implementation class LoginServlet
 */


public class LoginServlet extends HttpServlet{


public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
System.out.println("called");
UserDAO dao = new UserDAO();
try
{	
	boolean firstLoginMobile = false;
	String stringFirstLoginMobile = "false";
	String userName=request.getParameter("userName") ;
	String password=request.getParameter("password") ;
	String deviceId = request.getParameter("deviceId") ;
	stringFirstLoginMobile = request.getParameter("firstLoginMobile") ;
	System.out.println("value "+stringFirstLoginMobile);
	if(stringFirstLoginMobile == null)
		stringFirstLoginMobile = "false";
	if((stringFirstLoginMobile).equals("true"))
		firstLoginMobile = true;
	System.out.println("LoginServlet says "+firstLoginMobile);
	System.out.println(userName+password);
	int hashval,chash,salt;
     UserBean user = new UserBean();
     user.setUserName(userName);
     user.setFirstLoginMobile(firstLoginMobile);
     user.setDeviceId(deviceId);
     
	salt=dao.getSalt(user);
	hash hashValue = new hash();
	chash=hashValue.getHash(password,salt);
	hashval=dao.getHash(user);
	System.out.println(chash+"\n");
	System.out.println(hashval+"\n");
    /*if(chash==-18)
    	response.sendRedirect("http://172.16.2.2:8081/rosei/fuckYou.jsp"); //error page*/
	int in;
	char st;
	for(int l=0;l<password.length()-1;l++)
	{
    st= password.charAt(l);
    in =(int)st;
    if(in==39 || in==61)
    {
    	//response.sendRedirect("http://172.16.2.2:8081/rosei/fuckYou.jsp"); //error page*/
	break;
    }
	}
	response.setContentType("application/json");
	response.setHeader("Access-Control-Allow-Origin","*");
	PrintWriter out = response.getWriter();
	JSONObject obj = new JSONObject();
	System.out.println("Here Flag is"+user.getValid());
   
    if(hashval==chash && user.getValid())
        {	
        	user=dao.login(user);
        	System.out.println(user.getAppId());
//            HttpSession session = request.getSession(true);	    
//            session.setAttribute("currentSessionUserName",user.getName());
//            session.setAttribute("currentSessionUserId",user.getUserId());
//            session.setAttribute("currentSessionUserEmail",user.getEmail());
//            session.setAttribute("currentSessionAppId",user.getAppId());
//            session.setAttribute("currentSessionFbUserName",user.getFbUserName());
//            System.out.println("Session ID = "+ session.getId());
        	UUID id = UUID.randomUUID();
            String key = String.valueOf(id);
            String value = user.getUserId()+user.getAppId();
            accessToken token = new accessToken();
            boolean valid = token.set(key, value);
            
            obj.put("response","success");  
            obj.put("accessToken", key);
            obj.put("currentSessionName",user.getName());
    		obj.put("currentSessionUserName",user.getUserName());
    		obj.put("currentSessionUserId",user.getUserId());
    		obj.put("currentSessionUserEmail",user.getEmail());
    		obj.put("currentSessionAppId",user.getAppId());
    		obj.put("currentSessionFbUserName",user.getFbUserName());
        }
	        
   else {
	   obj.put("response","error");

   		}
    
    out.print(obj);	
}		
catch (Throwable theException) 	    
{
   System.out.println(theException); 
}
}
}
