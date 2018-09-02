package cn.crazy.appium.testngtest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class study2 {

	@Test(groups = "add")
	public static void test1() {
		Reporter.log("start add test");
		System.out.println("这是study2的test1方法");
		int a = 10,b = 20;
		int sum = a+b;
		Reporter.log("10 add 20 finished");
		Assert.assertEquals(sum, 30,"加法10+20的结果显示");
	}
	
	@Test(groups = "add")
	public static void test2() {
		Reporter.log("start add test");
		System.out.println("这是study2的test1方法");
		int a = 10,b = 20;
		int sum = a+b;
		Reporter.log("10 add 20 finished");
		Assert.assertEquals(sum, 30,"加法10+20的结果显示");
	}
	
	@Test(groups = "sub")
	public static void test3() {
//		Reporter.log("start add test");
		System.out.println("这是study2的test1方法");
		int a = 10,b = 20;
		int sub = a-b;
//		Reporter.log("10 add 20 finished");
		Assert.assertEquals(sub, -10,"加法10+20的结果显示");
		Assert.fail();
	}
	
}
