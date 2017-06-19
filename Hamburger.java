package hamburger;

import java.util.Arrays;
import java.util.ArrayList;

class Hamburger {
	private String name;
	private String meetType;
	protected int charge;
	private String bunsType;
	
	protected ArrayList<Topping> toppings;
	
	public Hamburger(String name, String meetType, int charge, String bunsType) {
		super();
		this.name = name;
		this.meetType = meetType;
		this.charge = charge;
		this.bunsType = bunsType;
		this.toppings = new ArrayList<Topping>();
	}

	public void toppingControll() {
		this.toppings.forEach( (topping) -> { 
			System.out.println("名称 : " + topping.getName() + "　値段 : " + topping.getCharge() + "円");
		});
	}
	
	public void addTopping(Topping topping) {
		if ( this.toppings.size() >= 3 ) {
			throw new IllegalStateException("トッピングは3つまでです。");
		}
		this.toppings.add(topping);
	}
	
	public String baseBurger() {
		return "「" + this.bunsType + "」バンズと「" + this.meetType + "」からなる、「" + this.name + "」ハンバーガーの値段は、350円です。";
	}
	
	public String itemizeBurger() {
		int charge = this.charge;
		for ( Topping topping : this.toppings ) {
			charge += topping.getCharge();
		}
		
		return "トッピングを加えたバーガーの金額は、" + charge + "円です。";
	}
}
