package it.master.travelagency.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import it.master.travelagency.customer.Customer;
import it.master.travelagency.customer.Traveler;
import it.master.travelagency.travel.MultiStep;
import it.master.travelagency.travel.Step;
import it.master.travelagency.travel.Travel;

public class MainApp {

	public static void main(String[] args) throws Exception {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Travel africa = new MultiStep("Africa trip");
		
		Travel outbound = new Step("Outbound flight", 100, "Torino", "Mombasa");
		africa.addStep(outbound);
		
		Travel inbound = new Step("Inbound flight", 700, "Mombasa", "Torino");
		africa.addStep(inbound);
		
		Date d = dateFormat.parse("01/01/1960");
		System.out.println(d);
		
		Customer ginoBase = new Customer("Gino", dateFormat.parse("01/01/1960"), "gino@ginomail.com", "Passport", "123");
		Traveler ginoTraveler = new Traveler(ginoBase, africa);
		
		System.out.println(ginoTraveler + " is about to leave for his trip!");
		System.out.println(ginoTraveler.getTravel());
		
		System.out.println(ginoTraveler + " is spending a hefty sum of money: "  +
				ginoTraveler.getTravel().getCost() + "€!!!");
	}

}
