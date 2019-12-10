package com.as.improve;
import java.math.BigDecimal;

/**
 * 购买糖果的货币计算
 * 
 * @author as_pixar
 */
public class FloatDoubleImprove {

	public static void main(String[] args) {
		// float double 比较精确类型,不能用于货币计算
		// BigDecimal 精确类型,用于货币计算,速度有点慢,写法上也有些麻烦,速度可以忽略。
		System.out.println(1.03 - 0.42); // 0.61 != 0.6100000000000001
		System.out.println(1.00 - 9 * 0.10); // 0.1 != 0.09999999999999998

		buyGoods1();

		buyGoods2();

		buyGoods3();
	}

	// 购买糖 1
	private static void buyGoods1() {
		int itemsBought = 0; // 可以买几块糖果
		double funds = 1.00; // 总共有1元
		double price = 0.10;// 第一块糖果1角钱
		for (; funds > price; price += 0.10) {
			funds -= price;
			itemsBought++;
		}
		String result = "买" + itemsBought + "块糖果,还剩零钱¥" + funds;
		System.out.println(result);
	}

	// 购买糖 2
	private static void buyGoods2() {
		int itemsBought = 0; // 可以买几块糖果
		BigDecimal funds = new BigDecimal("1.00"); // 总共有1元
		BigDecimal TEN_CENTS = new BigDecimal("0.10"); // 第一块糖果1角钱
		for (BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
			itemsBought++;
			funds = funds.subtract(price); // 每买一块糖果还剩多少钱
		}
		String result = "买" + itemsBought + "块糖果,还剩零钱¥" + funds;
		System.out.println(result);
	}

	// 购买糖 3
	private static void buyGoods3() {
		int itemsBought = 0;
		int funds = 100;
		for (int price = 10; funds >= price; price += 10) {
			funds -= price;
			itemsBought++;
		}

		String result = "买" + itemsBought + "块糖果,还剩零钱¥" + funds;
		System.out.println(result);
	}

}
