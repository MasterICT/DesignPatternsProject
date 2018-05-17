package it.master.travelagency.travel;

import java.util.ArrayList;
import java.util.List;

public class MultiStep extends Travel {

	private List<Travel> steps;
	
	public MultiStep(String name) {
		super(name, 0);
		steps = new ArrayList<>();
	}

	@Override
	public void addStep(Travel travel) throws Exception {
		steps.add(travel);
		cost += travel.getCost();
	}

	@Override
	public boolean removeStep(Travel travel) throws Exception {
		boolean ret = steps.remove(travel);
		if (ret) {
			cost -= travel.getCost();
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
}
