package Model;

 public class beanGetFbUserName{
	String userName,fbUserName, exception;
	boolean valid;
	
     public void setUserName(String bUserName)
	  {
    	 userName=bUserName;
	  }
     public void setFbUserName(String bFbUserName)
	  {
    	 fbUserName=bFbUserName;
	  }
     public void setValid(boolean bValid)
	  {
    	 valid=bValid;
	  }
     public void setException(String bException)
	  {
    	 exception=bException;
	  }
     public String getUserName()
	  {
    	 return userName;
	  }
     public String getFbUserName()
	  {
    	 return fbUserName;
	  }
     public boolean getValid()
	  {
    	 return valid;
	  } 
     public String getException()
	  {
    	 return exception;
	  }
	  
	  
}