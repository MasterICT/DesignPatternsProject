package it.master.travelagency.customer;

import java.util.Date;

public interface CustomerInterface {	
	
	public String getName();
	public Date getDateOfBirth();
	public String getEmail();
	public String getIdType();
	public String getIdNumber();
	
	public void sendNotification(String msgTxt);

}
