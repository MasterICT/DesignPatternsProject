package it.master.travelagency.customer;

import java.util.ArrayList;
import java.util.Collection;

import it.master.travelagency.travel.Travel;

public class Buyer extends CustomerType {
	
	private Collection<String> transactionHistory;

	public Buyer(CustomerInterface customerInterface) {
		super(customerInterface);
		transactionHistory = new ArrayList<>();
	}
	
	public void pay(Travel travel) {
		sendNotification("Getting account information");
		sendNotification("I paid for the travel: " + travel);
	}

	public Collection<String> getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(Collection<String> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}
	
}
