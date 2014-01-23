package Model;
import javax.servlet.http.HttpSession;
 public class UserBean{
	
	  private String userName;
	  
	  private String name, email, deviceId, id,fbUserName, appId;
	  boolean firstLoginMobile;
	  boolean valid = true;
	  public void setName(String newName) {
	         name = newName;
	  }	
      public String getName() {
         return name;
	  }
	  public void setUserId(String bId) {
	         id = bId;
	  }	
	  public String getUserId() {
		  return id;
	  }
	  public void setEmail(String bEmail) {
	         email = bEmail;
	  }	
	  public String getEmail() {
		  return email;
	  }
      public String getUserName() {
         return userName;
	  }
      public void setUserName(String bUserName) {
    	  userName = bUserName;
	  }
      public String getAppId() {
           return appId;
  	  }
      public void setAppId(String bAppId) {
           appId= bAppId;
  	  }
      public String getFbUserName() {
          return fbUserName;
 	  }
     public void setFbUserName(String bFbUserName) {
    	 fbUserName= bFbUserName;
 	  }
     public void setFirstLoginMobile(boolean bFirstLoginMobile) {
    	 firstLoginMobile= bFirstLoginMobile;
 	  }
     public boolean getFirstLoginMobile() {
         return firstLoginMobile;
	  }
     public void setDeviceId(String bDeviceId) {
    	 deviceId= bDeviceId;
 	  }
     public String getDeviceId() {
         return deviceId;
	  }
     public void setValid(boolean bValid)
	  {
    	 valid=bValid;
	  }
     public boolean getValid()
	  {
    	 return valid;
	  } 
}