package it.master.travelagency.travel;

/**
 * The <strong>Leaf</strong> component of a travel. A <code>Step</code> cannot have other
 * <code>Step</code>s added to itself.
 *
 */
public class Step extends Travel {
	
	private String from;
	private String to;
	
	public Step(String name, int cost, String from, String to) {
		super(name, cost);
		this.from = from;
		this.to = to;
		paidFor = false;
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

	@Override
	public void setPaidFor(boolean paid) {
		this.paidFor = paid;
	}
	
	/**
	 * The cost to pay is 0 if the step is paid.
	 */
	@Override
	public int getCostToPay() {
		return paidFor ? 0 : cost;
	}

	@Override
	public boolean isPaidFor() {
		return this.paidFor;
	}

}
