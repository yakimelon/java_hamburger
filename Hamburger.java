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

	// トッピング一覧表示
	public void showTopping() {
		this.toppings.forEach( (topping) -> { 
			System.out.println("名称 : " + topping.getName() + "　値段 : " + topping.getCharge() + "円");
		});
	}
	
	// トッピング追加
	public void addTopping(Topping topping) {
		if ( this.toppings.size() >= 4 ) {
			throw new IllegalStateException("トッピング4つまでです。");
		}
		System.out.println(topping.getName() + "を " + topping.getCharge() + " 円で加えます。");
		this.toppings.add(topping);
	}
	
	// このハンバーガーについての説明を返す
	public String baseBurger() {
		return "「" + this.bunsType + "」バンズと「" + this.meetType + "」からなる、「" + this.name + "」ハンバーガーの値段は、" + this.charge + " 円です。";
	}
	
	// トッピングを含めた値段を返す
	public String itemizeBurger() {
		int charge = this.charge;
		for ( Topping topping : this.toppings ) {
			charge += topping.getCharge();
		}
		
		return "トッピングを加えたバーガーの金額は、" + charge + "円です。";
	}
}
