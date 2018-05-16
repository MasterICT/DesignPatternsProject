package it.master.travelagency.travel;

public class Step extends Travel {
	
	private String from;
	private String to;
	
	public Step(String name, int cost, String from, String to) {
		super(name, cost);
		this.from = from;
		this.to = to;
	}

	@Override
	public void addStep(Travel travel) throws Exception {
		throw new Exception("not available for a step");
	}

	@Override
	public boolean removeStep(Travel travel) throws Exception {
		throw new Exception("not available for a step");
	}

	@Override
	public Travel getStep(int i) {
		return null;
	}

	@Override
	public String describe() {
		return name + ": traveling from " + from + " to " + to;
	}

	@Override
	public int getCost() {
		return cost;
	}

}
