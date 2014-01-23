package Model;

 public class beanEventAppUpload{
	String name, imgUrl, about, contact, exception,from_date,to_date,fee;
	boolean valid;
	
     public void setName(String bName)
	  {
    	 name=bName;
	  }
     public void setImgUrl(String bImgUrl)
	  {
    	 imgUrl=bImgUrl;
	  }
     public void setFromDate(String bAppId)
	  {
  	 from_date=bAppId;
	  }
   public void setToDate(String bAppId)
	  {
  	 to_date=bAppId;
	  }
   public void setFee(String bAppId)
	  {
	 fee=bAppId;
	  }
     public void setAbout(String bAbout)
	  {
    	 about=bAbout;
	  }
     public void setContact(String bContact)
	  {
    	 contact=bContact;
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
     public String getImgUrl()
	  {
    	 return imgUrl;
	  }
     public String getAbout()
	  {
    	 return about;
	  }
     public String getContact()
	  {
    	 return contact;
	  }
     public String getFromDate()
 	  {
    	 return from_date;
 	  }
      public String getToDate()
 	  {
    	 return to_date;
 	  }
      public String getFee()
 	  {
    	 return fee;
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