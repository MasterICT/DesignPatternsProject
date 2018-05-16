package it.master.travelagency.travel;

public abstract class Travel {
	
	protected String name;
	protected int cost;
	
	public Travel(String name, int cost) {
		this.name = name;
		this.cost = cost;
	}
	
	public abstract void addStep(Travel travel) throws Exception;
	public abstract boolean removeStep(Travel travel) throws Exception;
	public abstract Travel getStep(int i);
	
	public abstract String describe();
	public abstract int getCost();
	
	@Override
	public String toString() {
		return describe();
	}
	
}
