package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class beanUploadDiscussionTopic {
	String name, appId, email, topicId, fbUserName, topicTitle, topicSummary, postDateTime, updatedDateTime,exception;
	boolean valid;
	
     public void setName(String bName)
	  {
    	 name=bName;
	  }
     public void setEmail(String bEmail)
	  {
    	 email=bEmail;
	  }
     public void setTopicTitle(String bTopicTitle)
	  {
    	 topicTitle=bTopicTitle;
	  }
   public void setTopicSummary(String bTopicSummary)
	  {
	   topicSummary=bTopicSummary;
	  }
   public void setPostDateTime(String bPostDateTime)
	  {
	   postDateTime=bPostDateTime;
	  }
     public void setUpdatedDateTime(String bUpdatedDateTime)
	  {
    	 updatedDateTime=bUpdatedDateTime;
	  }
     public void setAppId(String bAppId)
	  {
    	 appId=bAppId;
	  }
     public void setTopicId(String bTopicId)
	  {
    	 topicId=bTopicId;
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
     public String getTopicTitle()
	  {
    	 return topicTitle;
	  }
     public String getTopicSummary()
 	  {
    	 return topicSummary;
 	  }
      public String getPostDateTime()
 	  {
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  		Date date = new Date();		   
  	    String dt=dateFormat.format(date);
  	    postDateTime = dt;
    	return postDateTime;
 	  }
      public String getUpdatedDateTime()
 	  {
	    updatedDateTime = postDateTime;
    	return updatedDateTime;
 	  }
      public String getTopicId()
 	  {
     	 return topicId;
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