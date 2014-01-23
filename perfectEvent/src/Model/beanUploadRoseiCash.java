package Model;

 public class beanUploadRoseiCash{
	String userId, cash, exception;
	boolean valid;
	
     public void setUserId(String bUserId)
	  {
    	 userId=bUserId;
	  }
     public void setCash(String bCash)
	  {
    	 cash=bCash;
	  }

     public void setValid(boolean bValid)
	  {
    	 valid=bValid;
	  }
     public void setException(String bException)
	  {
    	 exception=bException;
	  }
     public String getUserId()
	  {
    	 return userId;
	  }
     public String getCash()
	  {
    	 return cash;
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