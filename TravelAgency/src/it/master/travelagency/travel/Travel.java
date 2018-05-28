package it.master.travelagency.travel;

/**
 * The <strong>Component</strong> abastract class used by the Composite pattern that models travels. <br />
 * Implementing methods differently according to the children's nature is deferred to their
 * concrete implementations.
 *
 */
public abstract class Travel {
	
	protected String name;
	protected int cost;
	protected int costToPay;
	protected boolean paidFor;
	
	public Travel(String name, int cost) {
		this.name = name;
		this.cost = cost;
		costToPay = cost;
	}
	
	public abstract void addStep(Travel travel) throws Exception;
	public abstract boolean removeStep(Travel travel) throws Exception;
	public abstract Travel getStep(int i);
	
	public abstract String describe();
	public abstract int getCost();
	
	/**
	 * Gets the cost of the travel that still has to be paid
	 * @return The cost still to pay. Cycles through the steps that still have to be paid and
	 * adds their cost.
	 */
	public abstract int getCostToPay();
	
	/**
	 * Sets payment status of the travel.
	 * @param paid
	 */
	public abstract void setPaidFor(boolean paid);
	
	/**
	 * Checks if the travel has steps still to be paid.
	 * @return true if every step of the travel has been paid for. <br>
	 * false if it exists at least one step that has been not paid for.
	 */
	public abstract boolean isPaidFor();
	
	@Override
	public String toString() {
		return describe();
	}
	
	public String getName() {
		return this.name;
	}
}
