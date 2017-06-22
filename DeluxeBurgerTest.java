package hamburger;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class DeluxeBurgerTest {

	@Test
	public void test_トッピングを追加しようとすると例外が出る() {
		DeluxeBurger deluxeBurger = new DeluxeBurger("デラックス", "ベーコン&ソーセージ", 1000, "バンズ&クラブ");
		Topping tomato = new Topping("トマト", 30);
		try{
			deluxeBurger.addTopping(tomato);
		} catch (IllegalStateException e) {
			assertThat(e.getMessage(), is("デラックスバーガーにはトッピングを加えることが出来ません。"));
		}
	}
}
