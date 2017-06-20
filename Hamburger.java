package hamburger;

import java.util.Arrays;
import java.util.Optional;
import java.util.ArrayList;

class Hamburger {
	private String name;
	private String meetType;
	protected int price;
	private String bunsType;
	
	protected ArrayList<Topping> toppings;
	
	public Hamburger(String name, String meetType, int price, String bunsType) {
		super();
		this.name = name;
		this.meetType = meetType;
		this.price = price;
		this.bunsType = bunsType;
		this.toppings = new ArrayList<Topping>();
	}

	// トッピング一覧表示
	public void showTopping() {
		this.toppings.forEach( (topping) -> { 
			System.out.println("名称 : " + topping.getName() + "　値段 : " + topping.getPrice() + "円");
		});
	}
	
	// トッピング追加
	public void addTopping(Topping topping) {
		if ( this.toppings.size() >= 4 ) {
			throw new IllegalStateException("トッピング4つまでです。");
		}
		System.out.println(topping.getName() + "を " + topping.getPrice() + " 円で加えます。");
		this.toppings.add(topping);
	}
	
	// このハンバーガーについての説明を返す
	public String baseBurger() {
		return "「" + this.bunsType + "」バンズと「" + this.meetType + "」からなる、「" + this.name + "」ハンバーガーの値段は、" + this.price + " 円です。";
	}
	
	// トッピングを含めた値段を返す
	public String itemizeBurger() {
		// TODO: toppingsはnullになることがあるのでOptionalにしたい
//		Optional<ArrayList> toppingsOpt = Optional.ofNullable(this.toppings);
//		Optional<Integer> x = toppingsOpt.map(toppings -> {
//			return toppings
//				.stream()
//				.map( topping -> topping.getPrice() )
//				.reduce( (sum, n) -> sum + n )
//				.get();
//		});
		
		final int price = this.toppings
			.stream()
			.map( topping -> topping.getPrice() )
			.reduce( (sum, n) -> sum + n )
			.get();
		return "トッピングを加えたバーガーの金額は、" + ( price + this.price ) + "円です。";
	}
}
