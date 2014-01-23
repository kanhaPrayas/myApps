package Model;

public class beanConfirmInvitation {
		String registrationId, eventRegistrationId, exception;
		boolean valid;
	     public void setValid(boolean bValid)
		  {
	    	 valid=bValid;
		  }
	     public void setRegistrationId(String bRegistrationId)
		  {
	    	 registrationId=bRegistrationId;
		  }
	     public void setEventReistrationId(String bEventRegistrationId)
		  {
	    	 eventRegistrationId=bEventRegistrationId;
		  }
	     public void setException(String bException)
		  {
	    	 exception=bException;
		  }
	     public String getRegistrationId()
		  {
	    	 return registrationId;
		  }
	     public String getEventRegistrationId()
		  {
	    	 return eventRegistrationId;
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
