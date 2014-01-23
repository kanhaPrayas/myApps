package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

 public class beanUploadQuiz{
	String question, answer, questionImage, comment, appId, positiveCash, negativeCash, postDateTime, expiryTime, exception;
	boolean valid;
	
     public void setQuestion(String bQuestion)
	  {
    	 question=bQuestion;
	  }
     public void setAnswer(String bAnswer)
	  {
    	 answer=bAnswer;
	  }
     public void setQuestionImage(String bAppId)
	  {
  	 questionImage=bAppId;
	  }
   public void setComment(String bAppId)
	  {
  	 comment=bAppId;
	  }
   public void setAppId(String bAppId)
	  {
	 appId=bAppId;
	  }
     public void setPositiveCash(String bPositiveCash)
	  {
    	 positiveCash=bPositiveCash;
	  }
     public void setNegativeCash(String bNegativeCash)
	  {
    	 negativeCash=bNegativeCash;
	  }
     public void setPostDateTime(String bPostDateTime)
	  {
    	 postDateTime=bPostDateTime;
	  }
     public void setExpiryTime(String bExpiryTime)
	  {
    	 expiryTime=bExpiryTime;
	  }
     public void setException(String bException)
	  {
    	 exception=bException;
	  }
     public void setValid(Boolean bValid)
	  {
    	 valid=bValid;
	  }
     public Boolean getValid()
	  {
    	 return valid;
	  }
     public String getQuestion()
	  {
    	 return question;
	  }
     public String getAnswer()
	  {
   	 return answer;
	  }
     public String getQuestionImage()
	  {
   	 return questionImage;
	  }
     public String getComment()
	  {
   	 return comment;
	  }
     public String getAppId()
	  {
   	 return appId;
	  }
     public String getPositiveCash()
	  {
   	 return positiveCash;
	  }
     public String getNegativeCash()
	  {
   	 return negativeCash;
	  }
     public String getPostDateTime()
	  {
     	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   		Date date = new Date();		   
   	    String dt=dateFormat.format(date);
   	    postDateTime = dt;
     	return postDateTime;
	  }
     public String getExpiryTime()
	  {
   	 return expiryTime;
	  }
     public String getException()
	  {
   	 return exception;
	  }
}