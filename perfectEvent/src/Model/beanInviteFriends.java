package Model;

public class beanInviteFriends {
		String email, appId, id, eventId,inviterId, eventRegistrationId, exception;
		boolean valid;
	     public void setValid(boolean bValid)
		  {
	    	 valid=bValid;
		  }
	     public void setInviterId(String bInviterId)
		  {
	    	 inviterId=bInviterId;
		  }
	     public void setEventId(String bEventId)
		  {
	    	 eventId=bEventId;
		  }	
	     public void setEventRegistrationId(String bEventRegistrationId)
		  {
	    	 eventRegistrationId=bEventRegistrationId;
		  }	
	     public void setEmail(String bEmail)
		  {
	    	 email=bEmail;
		  }
	     public void setId(String bId)
		  {
	    	 id=bId;
		  }
	     public void setAppId(String bAppId)
		  {
	    	 appId=bAppId;
		  }
	     public void setException(String bException)
		  {
	    	 exception=bException;
		  }
	     public String getEmail()
		  {
	    	 return email;
		  }
	     public String getId()
		  {
	    	 return id;
		  }
	     public String getAppId()
		  {
	    	 return appId;
		  }
	     public String getException()
		  {
	    	 return exception;
		  }
	     public String getEventId()
		  {
	    	 return eventId;
		  }
	     public String getInviterId()
		  {
	    	 return inviterId;
		  }
	     public String getEventRegistrationId()
		  {
	    	 return eventRegistrationId;
		  }
	     public boolean getValid()
		  {
	    	 return valid;
		  }
}
