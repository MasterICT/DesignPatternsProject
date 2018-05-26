package it.master.travelagency.customer;

import java.util.Date;

public class Customer implements CustomerInterface {
	
	private String name;
	private Date dateOfBirth;
	private String email;
	private String idType;
	private String idNumber;
	
	public Customer(String name, Date dateOfBirth, String email, String idType, String idNumber) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.idType = idType;
		this.idNumber = idNumber;
	}
	@Override
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String getIdType() {
		return idType;
	}
	
	public void setIdType(String idType) {
		this.idType = idType;
	}
	
	@Override
	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	@Override
	public void sendNotification(String msgTxt) {
		System.out.println("***");
		System.out.println("Sending an email notification to " + this.getName()
			+ " at the address " + this.getEmail());
		System.out.println(msgTxt);
		System.out.println("***");
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}

