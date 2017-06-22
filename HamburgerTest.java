package hamburger;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class HamburgerTest {

	@Test
	public void test_ハンバーガーの説明が正しい() {
		Hamburger hamburger = new Hamburger("ベーシック", "ソーセージ", 350, "レギュラー");
		assertThat(hamburger.baseBurger(), is("「レギュラー」バンズと「ソーセージ」からなる、「ベーシック」ハンバーガーの値段は、350 円です。"));
	}
	
	@Test
	public void test_追加したトッピングの値段を含めたハンバーガーの値段が正しい() {
		Hamburger hamburger = this.makeToppingHamburger();
		assertThat(hamburger.itemizeBurger(), is("トッピングを加えたバーガーの金額は、605円です。"));	
	}
	
	@Test
	public void test_トッピングの削除が出来る() {
		Hamburger hamburger = this.makeToppingHamburger();
		hamburger.deleteTopping("チーズ");
		assertThat(hamburger.itemizeBurger(), is("トッピングを加えたバーガーの金額は、505円です。"));	
	}
	
	@Test
	public void test_トッピングが4つを超えたら例外を出す() {
		Hamburger hamburger = this.makeToppingHamburger();
		Topping egg = new Topping("ピクルス", 10);
		try {
			hamburger.addTopping(egg);
			fail();
		} catch (IllegalStateException e) {
			assertThat(e.getMessage(), is("トッピングは4つまでです。"));
		}
	}
	
	// 3種のトッピングが付いたハンバーガーを生成する
	private Hamburger makeToppingHamburger() {
		Hamburger hamburger = new Hamburger("ベーシック", "ソーセージ", 350, "レギュラー");
		Topping tomato = new Topping("トマト", 30);
		Topping lettuce = new Topping("レタス", 75);
		Topping cheese = new Topping("チーズ", 100);
		Topping egg = new Topping("タマゴ", 50);
		hamburger.addTopping(tomato);
		hamburger.addTopping(lettuce);
		hamburger.addTopping(cheese);
		hamburger.addTopping(egg);
		return hamburger;
	}
	
	

}
