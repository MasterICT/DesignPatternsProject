package it.master.travelagency.customer;

public class Blogger extends CustomerType {
	
	private String blogName;

	public Blogger(CustomerInterface customerInterface, String blogName) {
		super(customerInterface);
		this.blogName = blogName;
	}
	
	public void publish(String content) {
		System.out.println(this.getName() + " is publishing: '" + content + "' on their blog: '"
				+ blogName + "'");
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
}
