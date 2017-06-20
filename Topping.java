package hamburger;

public class Topping {
	private String name;
	private int price;
	
	public Topping(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}
