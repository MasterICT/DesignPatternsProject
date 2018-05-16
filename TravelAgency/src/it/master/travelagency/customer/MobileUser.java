package it.master.travelagency.customer;

import it.master.travelagency.travel.Travel;

public class MobileUser extends CustomerType {

	public MobileUser(CustomerInterface customerInterface) {
		super(customerInterface);
	}
	
	@Override
	public void sendNotification(String msgTxt) {
		System.out.println("sending a push notification");
		System.out.println(msgTxt);
	}
	
	public void share(Travel travel, String social) {
		System.out.println("Publishing on: " + social);
		System.out.println("I am traveling here! " + travel);
	}

}
