package it.master.travelagency.customer;

import java.util.Date;

/**
 * The <strong>Aggregate</strong> interface of the Decorator pattern used to model customers of the application. 
 *
 */
public interface CustomerInterface {	
	
	public String getName();
	public Date getDateOfBirth();
	public String getEmail();
	public String getIdType();
	public String getIdNumber();
	
	public void sendNotification(String msgTxt);

}
