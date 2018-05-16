package it.master.travelagency.main;

import it.master.travelagency.travel.MultiStep;
import it.master.travelagency.travel.Step;
import it.master.travelagency.travel.Travel;

public class MainApp {

	public static void main(String[] args) throws Exception {
		
		Travel africa = new MultiStep("Viaggio in africa");
		
		Travel andata = new Step("Volo andata", 100, "Torino", "Mombasa");
		africa.addStep(andata);
		
		Travel ritorno = new Step("Volo ritorno", 700, "Mombasa", "Torino");
		africa.addStep(ritorno);
		
		System.out.println(africa);
		System.out.println(africa.getCost());
	}

}
