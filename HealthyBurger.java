package hamburger;

import java.util.ArrayList;

public class HealthyBurger extends Hamburger{

	private ArrayList<HealthyTopping> healthyToppings;
	
	public HealthyBurger(String name, String meetType, int price, String bunsType) {
		super(name, meetType, price, bunsType);
		this.healthyToppings = new ArrayList<HealthyTopping>();
	}
	
	// ヘルシートッピング追加
	public void addTopping(HealthyTopping topping) {
		if ( this.healthyToppings.size() >= 2 ) {
			throw new IllegalStateException("ヘルシートッピングは2つまでです。");
		}
		System.out.println(topping.getName() + "を " + topping.getPrice() + " 円でヘルシートッピングとして加えます。");
		this.healthyToppings.add(topping);
	}
	
	// トッピング一覧表示 (普通のトッピングとヘルシートッピングの両方)
	@Override
	public void showTopping() {
		super.showTopping();
		this.healthyToppings.forEach( (topping) -> { 
			System.out.println("名称 : " + topping.getName() + "　値段 : " + topping.getPrice() + "円");
		});
	}
	
	// トッピングを含めた値段を返す
	@Override
	public String itemizeBurger() {
		// TODO: toppings が null だと動かないので Optional したい
		final int hamburgerToppingPrice = this.toppings
			.stream()
			.map( topping -> { return topping.getPrice(); })
			.reduce( (sum, n) -> { return sum + n; })
			.get();
		
		// TODO: healthyToppings が null だと動かない
//		final int healthyToppingPrice = this.healthyToppings
//			.stream()
//			.map( topping -> { return topping.getPrice(); })
//			.reduce( (sum, n) -> { return sum + n; })
//			.get();
		
//		int charge = this.price;
//		for ( Topping topping : this.toppings ) {
//			charge += topping.getPrice();
//		}
//		
//		for ( HealthyTopping topping : this.healthyToppings ) {
//			charge += topping.getPrice();
//		}
		
		// TODO:  + healthyToppingPrice する
		return "トッピングを加えたバーガーの金額は、" + ( this.price + hamburgerToppingPrice ) + "円です。";
	}
	
}
