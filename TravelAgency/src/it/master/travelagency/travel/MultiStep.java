package it.master.travelagency.travel;

import java.util.ArrayList;
import java.util.List;

/**
 * The <strong>Composite</strong> component. A <code>MultiStep</code> is composed of multiple
 * {@link Step}s, which are used to calculate costs.
 *
 */
public class MultiStep extends Travel {

	private List<Travel> steps;
	
	public MultiStep(String name) {
		super(name, 0);
		steps = new ArrayList<>();
		System.out.println("Creating multistep travel '" + name + "'");
	}

	@Override
	public void addStep(Travel travel) throws Exception {
		steps.add(travel);
		cost += travel.getCost();
		System.out.println("Adding step '" + travel.getName() + "' to '" + name + "'");
	}

	@Override
	public boolean removeStep(Travel travel) throws Exception {
		boolean ret = steps.remove(travel);
		if (ret) {
			cost -= travel.getCost();
			System.out.println("Removing step '" + travel.getName() + "' from '" + name + "'");
		}
		return ret;
	}

	@Override
	public Travel getStep(int i) {
		return steps.get(i);
	}

	@Override
	public String describe() {
		String ret = "";
		ret += name + ": composed by\n";
		for (Travel step : steps) {
			ret += step.describe() + "\n";
		}
		return ret;
	}

	@Override
	public int getCost() {
		return cost;
	}
	
	/**
	 * The paidfor value trickles down to all the steps.
	 */
	@Override
	public void setPaidFor(boolean paid) {
		for (Travel step : steps) {
			step.setPaidFor(paid);
		}
	}
	
	/**
	 * Cycles through the steps and adds the remaining cost of every unpaid one.
	 */
	@Override
	public int getCostToPay() {
		if (paidFor) return 0;
		int toPay = 0;
		for (Travel step : steps) {
			toPay += step.getCostToPay();
		}
		return toPay;
	}
	
	/**
	 * Cycles through the steps: as soon as an upaid one is found the whole trip
	 * is not paid for, so it returns false. True otherwise.
	 */
	@Override
	public boolean isPaidFor() {
		boolean paid = true;
		for (Travel step : steps) {
			if (!step.isPaidFor()) {
				paid = false;
			}
		}
		return paid;
	}
}
