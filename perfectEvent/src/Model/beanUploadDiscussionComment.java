package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class beanUploadDiscussionComment {
	String name, appId, email, fbUserName, topicId, message, postDateTime,exception;
	boolean valid;
	
     public void setName(String bName)
	  {
    	 name=bName;
	  }
     public void setEmail(String bEmail)
	  {
    	 email=bEmail;
	  }
     public void setTopicId(String bTopicId)
	  {
    	 topicId=bTopicId;
	  }
   public void setMessage(String bMessage)
	  {
	   message=bMessage;
	  }
   public void setPostDateTime(String bPostDateTime)
	  {
	   postDateTime=bPostDateTime;
	  }
   public void setAppId(String bAppId)
	  {
    	 appId=bAppId;
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
	 public String getName()
	  {
		 return name;
	  }
	 public String getEmail()
	  {
		 return email;
	  }
	 public String getFbUserName()
	  {
		 return fbUserName;
	  }
	 public String getAppId()
	  {
		 return appId;
	  }
	 public String getTopicId()
	  {
		 return topicId;
	  }
	 public String getMessage()
	  {
		 return message;
	  }
	  public String getPostDateTime()
	  {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();		   
	    String dt=dateFormat.format(date);
	    postDateTime = dt;
		return postDateTime;
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