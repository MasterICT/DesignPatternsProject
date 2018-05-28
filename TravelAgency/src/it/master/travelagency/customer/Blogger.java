package it.master.travelagency.customer;

/**
 * <strong>Concrete Decorator</strong>. Models a customer who has a travel blog and can publish
 * content to it.
 *
 */
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
