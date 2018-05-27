package it.master.travelagency.customer;

import it.master.travelagency.Constants;
import it.master.travelagency.notification.NotificationAdapter;
import it.master.travelagency.notification.PushNotificationSender;
import it.master.travelagency.travel.Travel;

public class MobileUser extends CustomerType {

	protected NotificationAdapter notificationSender;

	public MobileUser(CustomerInterface customerInterface) {
		super(customerInterface);

		this.notificationSender = new PushNotificationSender();
	}

	@Override
	public void sendNotification(String msgTxt) {
		System.out.println("***");
		System.out.println("Sending a push notification to " + this.getName());
		this.notificationSender.notify(msgTxt);
		System.out.println("***");
	}
	
	public void share(Travel travel, String social) {
		System.out.println("***");
		System.out.println("Publishing on: " + social);
		System.out.println("I am traveling here! " + travel);
		System.out.println("***");
	}
	
	public void shareMsg(String social, String msg) {
		System.out.println("***");
		System.out.println("Sharing on: " + social + " - by: " + this.getName());
		System.out.println(msg + " #" + Constants.APPNAME);
		System.out.println("***");
	}

}
