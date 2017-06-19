package hamburger;

public class Main {
	public static <T> void p(T val) {
		System.out.println(val);
	}

	public static void makeStandardBurger() {
		// 普通のバーガーの結果
		Hamburger hamburger = new Hamburger("ベーシック", "ソーセージ", 350, "レギュラー");
		p(hamburger.baseBurger());
		Topping tomato = new Topping("トマト", 30);
		Topping lettuce = new Topping("レタス", 75);
		Topping cheese = new Topping("チーズ", 100);
		hamburger.addTopping(tomato);
		hamburger.addTopping(lettuce);
		hamburger.addTopping(cheese);
		p(hamburger.itemizeBurger());
	}

	public static void makeHealthyBurger() {
		// ヘルシーバーガーの結果
		// TODO: 表示する
		HealthyBurger healthyBurger = new HealthyBurger("ライ麦", "ベーコン", 500, "ヘルシー");
		HealthyTopping avocado = new HealthyTopping("アボカド", 80);
		HealthyTopping sesame = new HealthyTopping("アボカド", 30);
		healthyBurger.addHealthyTopping(avocado);
		healthyBurger.addHealthyTopping(sesame);
	}

	public static void makeDeluxeBurger() {
		// デラックスバーガーの結果
		DeluxeBurger deluxeBurger = new DeluxeBurger("デラックス", "ベーコン&ソーセージ", 1000, "バンズ&クラブ");
		Topping tomato = new Topping("トマト", 30);
		deluxeBurger.addTopping(tomato);
	}

	public static void main(String[] args) {
		makeStandardBurger();
		makeHealthyBurger();
		makeDeluxeBurger();
	}

}
