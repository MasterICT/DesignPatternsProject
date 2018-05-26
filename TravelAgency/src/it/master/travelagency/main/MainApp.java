package it.master.travelagency.main;

import java.text.SimpleDateFormat;

import it.master.travelagency.Constants;
import it.master.travelagency.customer.Blogger;
import it.master.travelagency.customer.Buyer;
import it.master.travelagency.customer.Customer;
import it.master.travelagency.customer.MobileUser;
import it.master.travelagency.customer.Traveler;
import it.master.travelagency.travel.MultiStep;
import it.master.travelagency.travel.Step;
import it.master.travelagency.travel.Travel;

public class MainApp {

	public static void main(String[] args) throws Exception {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		printLog("Gino registers using the mobile app: he is a mobile user.");
		Customer ginoBase = new Customer("Gino", dateFormat.parse("01/01/1982"), "gino@ginomail.com", "Passport", "123");
		MobileUser ginoMobile = new MobileUser(ginoBase);
		
		printLog("Gino receives a notification about an offer");
		ginoMobile.sendNotification(
				"Hello, " + ginoMobile.getName() + "! Do you want to travel to MOMBASA super cheap?");
		
		printLog("Gino is excited and shares the news");
		ginoMobile.shareMsg(Constants.POPULAR_SOCIAL_NETWORK, "Traveling to MOMBASA!!! who wants to join me?");
		
		printLog("Tina and her son sign up for the trip. None of them downloads the app");
		Customer tinaBase = new Customer("Tina", dateFormat.parse("01/01/1985"), "tina@tinamail.com", "Passport", "456");
		Customer linoBase = new Customer("Lino", dateFormat.parse("01/01/2010"), "lino@linomail.com", "Id Card", "ABC");
		
		printLog("Travel details are arranged");
		Travel africaTrip = new MultiStep("Africa trip");
		
		// defining steps
		Travel outbound = new Step("Outbound flight", 100, "Torino", "Mombasa");
		Travel safari = new Step("Safari", 200, "Mombasa", "The Savannah");
		Travel inbound = new Step("Inbound flight", 700, "Mombasa", "Torino");
		
		// adding steps to main travel
		africaTrip.addStep(outbound);
		africaTrip.addStep(safari);
		africaTrip.addStep(inbound);
		
		// Travel roles are added
		Traveler ginoTraveler = new Traveler(ginoMobile, africaTrip);
		Traveler tinaTraveler = new Traveler(tinaBase, africaTrip);
		Traveler linoTraveler = new Traveler(linoBase, africaTrip);
		
		System.out.println(ginoTraveler + ", " + tinaTraveler + " and " + linoTraveler
				+ " are about to leave for their trip!");
		System.out.println(africaTrip);
		System.out.println("The travel costs: " + africaTrip.getCost());
		printPaidFor(africaTrip);
		
		printLog("Gino is supposed to be paying for the travel."
				+ "	Sadly, he forgets to say HOW he's going to pay for it");
		Buyer ginoBuyer = new Buyer(ginoTraveler);
		ginoBuyer.pay(africaTrip);
		printLog("he decides to pay by credit card");
		ginoBuyer.setPaymentMethod(Constants.CREDIT_CARD);
		
		printLog("Tina's mother swoops in and decides to pay for the travel");
		Customer motherOfTinaBase = new Customer("Mommy", dateFormat.parse("01/01/1960"), "mommy@tinamail.com", "Id Card", "1XC");
		Buyer motherOfTinaBuyer = new Buyer(motherOfTinaBase, Constants.CREDIT_CARD);
		motherOfTinaBuyer.pay(africaTrip);
		System.out.println("Costs still to be paid: " + africaTrip.getCostToPay());
		printTransactionHistory(motherOfTinaBuyer);
		
		printLog("Clumsy Gino tries to pay one more time but it's already done");
		ginoBuyer.pay(africaTrip);
		
		printLog("In order to save face he adds a surprise activity and pays for it");
		Travel boatSurprise = new MultiStep("Boat excursion surprise");
		Travel boatRide = new Step("Boat ride", 20, "Mombasa", "Sea");
		Travel scubaExcursion = new Step("Scuba diving", 2, "The boat", "Underwater");
		boatSurprise.addStep(boatRide);
		boatSurprise.addStep(scubaExcursion);
		
		// adding the surprise to the main trip
		africaTrip.addStep(boatSurprise);
		System.out.println(boatSurprise);
		printPaidFor(africaTrip);
		
		ginoBuyer.pay(boatSurprise);
		
		// alternatively he could have paid for the individual steps
		/*ginoBuyer.pay(boatRide);
		ginoBuyer.pay(scubaExcursion);*/
		
		printPaidFor(africaTrip);
		printTransactionHistory(ginoBuyer);
		
		printLog("Tina decides to open a blog about her experience");
		Blogger tinaBlogger = new Blogger(tinaTraveler, "I hear the drums echoing tonight");
		tinaBlogger.publish("I bless the rains down in " + tinaTraveler.getTravel().getName());
	}
	
	/**
	 * Utility method to print payment info about the travel
	 * @param travel
	 */
	public static void printPaidFor(Travel travel) {
		String travelPaid = "The travel " + travel.getName() + " has ";
		if (!travel.isPaidFor()) {
			travelPaid += "NOT ";
		}
		travelPaid += "been paid for.";
		System.out.println(travelPaid);
		System.out.println("Still have to pay: " + travel.getCostToPay());
	}
	
	/**
	 * Utility method to print a buyer's transaction history
	 * @param buyer
	 */
	public static void printTransactionHistory(Buyer buyer) {
		System.out.println(buyer.getName() + "'s transaction history:");
		for (String transaction : buyer.getTransactionHistory()) {
			System.out.println(transaction);
		}
	}
	
	/**
	 * Utility method to print a message to the console in a distinctive way
	 * @param msg
	 */
	public static void printLog(String msg) {
		System.out.println("\n--" + msg + "--");
	}

}
