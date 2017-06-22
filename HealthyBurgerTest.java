package hamburger;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class HealthyBurgerTest {

	@Test
	public void test_普通のトッピングとヘルシートッピングを含めたハンバーガーの値段が正しい() {
		HealthyBurger healthyBurger = this.makeToppingHealthyBurger();
		assertThat(healthyBurger.itemizeBurger(), is("トッピングを加えたバーガーの金額は、865円です。"));
	}
	
	@Test
	public void test_ヘルシートッピングが2つを超えたら例外を出す() {
		HealthyBurger healthyBurger = this.makeToppingHealthyBurger();
		try{
			HealthyTopping avocado = new HealthyTopping("アボカド", 80);
			healthyBurger.addTopping(avocado);
			fail();
		} catch (IllegalStateException e) {
			assertThat(e.getMessage(), is("ヘルシートッピングは2つまでです。"));
		}
	}
	
	private HealthyBurger makeToppingHealthyBurger() {
		HealthyBurger healthyBurger = new HealthyBurger("ライ麦", "ベーコン", 500, "ヘルシー");
		// 普通のトッピング追加
		Topping tomato = new Topping("トマト", 30);
		Topping lettuce = new Topping("レタス", 75);
		Topping cheese = new Topping("チーズ", 100);
		Topping egg = new Topping("タマゴ", 50);
		healthyBurger.addTopping(tomato);
		healthyBurger.addTopping(lettuce);
		healthyBurger.addTopping(cheese);
		healthyBurger.addTopping(egg);
		// ヘルシートッピング追加
		HealthyTopping avocado = new HealthyTopping("アボカド", 80);
		HealthyTopping sesame = new HealthyTopping("ゴマ", 30);
		healthyBurger.addTopping(avocado);
		healthyBurger.addTopping(sesame);
		
		return healthyBurger;
	}

}
