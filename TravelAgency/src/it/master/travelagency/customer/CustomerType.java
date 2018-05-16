package it.master.travelagency.customer;

import java.util.Date;

public abstract class CustomerType implements CustomerInterface {
	
	protected CustomerInterface customerInterface;
	
	public CustomerType(CustomerInterface customerInterface) {
		this.customerInterface = customerInterface;
	}

	@Override
	public String getName() {
		return customerInterface.getName();
	}

	@Override
	public Date getDateOfBirth() {
		return customerInterface.getDateOfBirth();
	}

	@Override
	public String getEmail() {
		return customerInterface.getEmail();
	}

	@Override
	public String getIdType() {
		return customerInterface.getIdType();
	}

	@Override
	public String getIdNumber() {
		return customerInterface.getIdNumber();
	}
	
	@Override
	public void sendNotification(String msgTxt) {
		customerInterface.sendNotification(msgTxt);
	}
}
