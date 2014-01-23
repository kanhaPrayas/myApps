package Controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

public class controllerGeneralRegistration extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	           throws ServletException, java.io.IOException {
		String appId=request.getParameter("appId");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String year=request.getParameter("year");
		String branch=request.getParameter("branch");
		String college=request.getParameter("college");
		String mobileNo=request.getParameter("mobileNo");
		String fbUserName=request.getParameter("fbUserName");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String mobileOs=request.getParameter("mobileOs");
		String mobileImei=request.getParameter("mobileImei");
		String mobileSim=request.getParameter("mobileSim");
		String deviceId=request.getParameter("deviceId");
		String feeReceived=request.getParameter("feeReceived");
		String registrationFrom = request.getParameter("registrationFrom");
		String callback = request.getParameter("callback");
		String responseType = request.getParameter("responseType");
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin","*");
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();
		ArrayList<String> data = new ArrayList<String>();
		if (appId == null) {
		data.add("appId");
		}
		if (name == null) {
		data.add("name");
		}
		if (email == null) {
		data.add("email");
		}
		if (year == null) {
		data.add("year");
		}
		if (branch == null) {
		data.add("branch");
		}
		if (college == null) {
		data.add("college");
		}
		if (mobileNo == null) {
		data.add("mobileNo");
		}
		if (fbUserName == null) {
		data.add("fbUserName");
		}
		if (userName == null) {
		data.add("userName");
		}
		if (password == null) {
		data.add("password");
		}
		if (feeReceived == null) {
		data.add("feeReceived");
		}
		if(registrationFrom == null) {
		data.add("registrationFrom");
		}
		if(registrationFrom == "mobile") {
			if (mobileOs == null) {
			data.add("mobileOs");
			}
			if (mobileSim == null) {
			data.add("mobileSim");
			}
			if (mobileImei == null) {
			data.add("mobileImei");
			}
			if (deviceId == null) {
			data.add("deviceId");
			}
		}
		if(data.size() != 0) {
		obj.put("response","error");
		obj.put("responseString","Insufficient Data");
		obj.put("data", data);
		} else {
		
			try
			{	 	
				Model.beanGeneralRegistration bean=new Model.beanGeneralRegistration();	
				Model.daoGeneralRegistration dao=new Model.daoGeneralRegistration();
				bean.setAppId(appId);
				bean.setName(name);
				bean.setEmail(email);
				bean.setYear(year);
				bean.setBranch(branch);
				bean.setCollege(college);
				bean.setMobileNo(mobileNo);
				bean.setFbUserName(fbUserName);
				bean.setUserName(userName);
				bean.setPassword(password);
				bean.setMobileOs(mobileOs);
				bean.setMobileSim(mobileSim);
				bean.setMobileImei(mobileImei);
				bean.setDeviceId(deviceId);
				bean.setFeeReceived(feeReceived);
				bean.setValid(false);
				bean=dao.create(bean);
				if(bean.getValid())
					{
					obj.put("response","success");
					obj.put("responseString","REGISTERED SUCCESSFULLY.Please Click the link send to your email "+bean.getEmail()+" to verify your account");
					}
				else {
			    	
					obj.put("response","error");
					obj.put("resposeString",bean.getException());
			    }
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		}
		if(responseType.equals("jsonp")) 
			out.print(callback+"("+obj+")");
		else
			out.print(obj);


	}
}