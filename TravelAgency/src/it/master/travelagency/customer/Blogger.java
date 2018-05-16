package it.master.travelagency.customer;

public class Blogger extends CustomerType {
	
	private String blogName;

	public Blogger(CustomerInterface customerInterface, String blogName) {
		super(customerInterface);
		this.blogName = blogName;
	}
	
	public void publish(String content) {
		System.out.println("I am publishing: " + content + " on my blog: " + blogName);
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
}
