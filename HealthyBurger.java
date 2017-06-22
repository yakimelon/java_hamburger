package hamburger;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HealthyBurger extends Hamburger{

	private ArrayList<HealthyTopping> healthyToppings;
	
	private final int TOPPING_MAX = 2;
	
	public HealthyBurger(String name, String meetType, int price, String bunsType) {
		super(name, meetType, price, bunsType);
		this.healthyToppings = new ArrayList<HealthyTopping>();
	}
	
	// ヘルシートッピング追加
	public void addTopping(HealthyTopping topping) {
		if ( this.healthyToppings.size() >= TOPPING_MAX ) {
			throw new IllegalStateException("ヘルシートッピングは" + TOPPING_MAX + "つまでです。");
		}
		System.out.println(topping.getName() + "を " + topping.getPrice() + " 円でヘルシートッピングとして加えます。");
		this.healthyToppings.add(topping);
	}
	
	// トッピング削除
	@Override
	public void deleteTopping(String toppingName) {
		super.deleteTopping(toppingName);
		this.healthyToppings = this.healthyToppings
			.stream()
			.filter( topping -> topping.getName() != toppingName )
			.collect( Collectors.toCollection(ArrayList::new) );
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
		final int toppingPrice  = Stream
			.concat(this.toppings.stream(), this.healthyToppings.stream())
			.map( topping -> topping.getPrice() )
			.reduce( 0, (sum, n) -> sum + n );
		return "トッピングを加えたバーガーの金額は、" + ( this.price + toppingPrice ) + "円です。";
	}
	
}
