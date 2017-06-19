package hamburger;

public class Topping {
	private String name;
	private int charge;
	
	public Topping(String name, int charge) {
		super();
		this.name = name;
		this.charge = charge;
	}

	public String getName() {
		return name;
	}

	public int getCharge() {
		return charge;
	}
}
