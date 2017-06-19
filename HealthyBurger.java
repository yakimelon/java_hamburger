package hamburger;

import java.util.ArrayList;

public class HealthyBurger extends Hamburger{

	private ArrayList<HealthyTopping> healthyToppings;
	
	public HealthyBurger(String name, String meetType, int charge, String bunsType) {
		super(name, meetType, charge, bunsType);
		this.healthyToppings = new ArrayList<HealthyTopping>();
	}
	
	public void addHealthyTopping(HealthyTopping topping) {
		if ( this.healthyToppings.size() >= 2 ) {
			throw new IllegalStateException("ヘルシートッピングは2つまでです。");
		}
		this.healthyToppings.add(topping);
	}
	
	@Override
	public void toppingControll() {
		super.toppingControll();
		this.healthyToppings.forEach( (topping) -> { 
			System.out.println("名称 : " + topping.getName() + "　値段 : " + topping.getCharge() + "円");
		});
	}
	
	@Override
	public String itemizeBurger() {
		int charge = this.charge;
		for ( Topping topping : this.toppings ) {
			charge += topping.getCharge();
		}
		
		for ( HealthyTopping topping : this.healthyToppings ) {
			charge += topping.getCharge();
		}
		
		return "トッピングを加えたバーガーの金額は、" + charge + "円です。";
	}
	
}
