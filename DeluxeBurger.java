package hamburger;

public class DeluxeBurger extends Hamburger {

	public DeluxeBurger(String name, String meetType, int price, String bunsType) {
		super(name, meetType, price, bunsType);
		
		super.addTopping(new Topping("ポテト", 100));
		super.addTopping(new Topping("ドリンク", 100));
	}

	// デラックスバーガーはトッピングできないので、呼び出されたら例外を出すようにする
	public void addTopping(Topping topping) {
		throw new IllegalStateException("デラックスバーガーにはトッピングを加えることが出来ません。");
	}
}
