package hamburger;

public class DeluxeBurger extends Hamburger {

	public DeluxeBurger(String name, String meetType, int charge, String bunsType) {
		super(name, meetType, charge, bunsType);
	}

	public void addTopping(Topping topping) {
		throw new IllegalStateException("デラックスバーガーにはトッピングを加えることが出来ません。");
	}
}
