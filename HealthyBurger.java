package hamburger;

import java.util.ArrayList;

public class HealthyBurger extends Hamburger{

	private ArrayList<HealthyTopping> healthyToppings;
	
	public HealthyBurger(String name, String meetType, int charge, String bunsType) {
		super(name, meetType, charge, bunsType);
		this.healthyToppings = new ArrayList<HealthyTopping>();
	}
	
	// ヘルシートッピング追加
	public void addTopping(HealthyTopping topping) {
		if ( this.healthyToppings.size() >= 2 ) {
			throw new IllegalStateException("ヘルシートッピングは2つまでです。");
		}
		System.out.println(topping.getName() + "を " + topping.getCharge() + " 円でヘルシートッピングとして加えます。");
		this.healthyToppings.add(topping);
	}
	
	// トッピング一覧表示 (普通のトッピングとヘルシートッピングの両方)
	@Override
	public void showTopping() {
		super.showTopping();
		this.healthyToppings.forEach( (topping) -> { 
			System.out.println("名称 : " + topping.getName() + "　値段 : " + topping.getCharge() + "円");
		});
	}
	
	// トッピングを含めた値段を返す
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
