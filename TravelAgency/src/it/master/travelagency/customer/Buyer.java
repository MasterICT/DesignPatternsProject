package it.master.travelagency.customer;

import java.util.ArrayList;
import java.util.Collection;

import it.master.travelagency.travel.Travel;

public class Buyer extends CustomerType {
	
	private Collection<String> transactionHistory;
	private String paymentMethod;

	public Buyer(CustomerInterface customerInterface, String paymentMethod) {
		super(customerInterface);
		transactionHistory = new ArrayList<>();
		this.paymentMethod = paymentMethod;
	}
	
	public Buyer(CustomerInterface customerInterface) {
		this(customerInterface, null);
	}
	
	/**
	 * If {@link Buyer#paymentMethod} is specified and travel's {@link Travel#isPaidFor()} returns true
	 * then the travel is paid. <br>
	 * The result of the operation is sent via the {@link Customer#sendNotification(String)} method.
	 * @param travel The travel to be paid for.
	 */
	public void pay(Travel travel) {
		String msg = "";
		if (paymentMethod != null && !paymentMethod.isEmpty()) {
			if (travel.isPaidFor()) {
				msg = "The travel " + travel + " has already been paid for.";
			} else {
				int amountToPay = travel.getCostToPay();
				msg = "Getting account information\n";
				msg += "Paying: " + amountToPay + "\n";
				msg += "I paid for the travel: " + travel.getName();
				travel.setPaidFor(true);
				transactionHistory.add(travel.getName() + " - " + amountToPay);
			}
		} else {
			msg = "Please specify a payment method!";
		}
		sendNotification(msg);
	}

	public Collection<String> getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(Collection<String> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}
	
	/**
	 * Sets the preffered paying method. <br>
	 * A notification is sent via the {@link Customer#sendNotification(String)} method.
	 * @param paymentMethod the payment method to be set.
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
		sendNotification("Payment method for " + this.getName() + " is: " + paymentMethod);
	}
}
