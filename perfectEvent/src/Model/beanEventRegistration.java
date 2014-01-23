package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class beanEventRegistration {
	String appId, eventId, userId, feeReceived,exception;
	boolean valid;
	public void setValid(Boolean x)
	{
		valid=x;
	}
	public Boolean getValid()
	{
		return valid;
	}
	
     public void setAppId(String bAppId)
	  {
    	 appId=bAppId;
	  }
      public void setEventId(String bEventId)
	  {
    	  eventId=bEventId;
	  }
      public void setException(String bException)
	  {
   	 exception=bException;
	  }
     public void setUserId(String bUserId)
	  {
    	 userId=bUserId;
	  }
     public void setFeeReceived(String bFeeReceived)
	  {
    	 feeReceived=bFeeReceived;
	  }

     public String getAppId()
	  {
    	 return appId;
	  }
     public String getRegistrationDate()
	  {
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 		Date date = new Date();		   
 	    String RegistrationDate=dateFormat.format(date);
 	    return RegistrationDate;
	  }
     public String getEventId()
	  {
    	 return eventId;
	  }
     public String getUserId()
	  {
    	 return userId;
	  }
     public String getFeeReceived()
	  {
    	 return feeReceived;
	  }
     public String getException()
 	  {
    	 return exception;
 	  }
     
}


