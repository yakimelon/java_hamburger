package hamburger;

public class Main {
	// System.out.println が長いので省略したメソッドを用意
	public static <T> void p(T val) {
		System.out.println(val);
	}

	// 普通のバーガー
	public static void makeStandardBurger() {
		Hamburger hamburger = new Hamburger("ベーシック", "ソーセージ", 350, "レギュラー");
		p(hamburger.baseBurger());
		// トッピング追加
		Topping tomato = new Topping("トマト", 30);
		Topping lettuce = new Topping("レタス", 75);
		Topping cheese = new Topping("チーズ", 100);
		hamburger.addTopping(tomato);
		hamburger.addTopping(lettuce);
		hamburger.addTopping(cheese);
		p(hamburger.itemizeBurger());
		hamburger.showTopping();
		p("\n");
	}

	// ヘルシーバーガー
	public static void makeHealthyBurger() {
		HealthyBurger healthyBurger = new HealthyBurger("ライ麦", "ベーコン", 500, "ヘルシー");
		p(healthyBurger.baseBurger());
		// 普通のトッピング追加
		Topping tomato = new Topping("トマト", 30);
		Topping lettuce = new Topping("レタス", 75);
		Topping cheese = new Topping("チーズ", 100);
		Topping egg = new Topping("タマゴ", 50);
		healthyBurger.addTopping(tomato);
		healthyBurger.addTopping(lettuce);
		healthyBurger.addTopping(cheese);
		healthyBurger.addTopping(egg);
		p(healthyBurger.itemizeBurger());
		// ヘルシートッピング追加
		HealthyTopping avocado = new HealthyTopping("アボカド", 80);
		HealthyTopping sesame = new HealthyTopping("ゴマ", 30);
		healthyBurger.addTopping(avocado);
		healthyBurger.addTopping(sesame);
		p(healthyBurger.itemizeBurger());
		healthyBurger.showTopping();
		p("\n");
	}

	// デラックスバーガー
	public static void makeDeluxeBurger() {
		DeluxeBurger deluxeBurger = new DeluxeBurger("デラックス", "ベーコン&ソーセージ", 1000, "バンズ&クラブ");
		p(deluxeBurger.baseBurger());
		deluxeBurger.showTopping();
		// デラックスバーガーにトッピングを加えると例外が出る
		Topping tomato = new Topping("トマト", 30);
		deluxeBurger.addTopping(tomato);
		p("\n");
	}

	public static void main(String[] args) {
		// 各ハンバーガー作成
		makeStandardBurger();
		makeHealthyBurger();
		makeDeluxeBurger();
	}

}
