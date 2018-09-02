package cn.crazy.appium.testngtest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class study3 {
	
	@DataProvider
	public Object[][] data() {
		Object[][] objects = {{10,20,30},{100,200,300},{1000,2000,3000}};
		return objects;
		
	}
	
	@Test(dataProvider = "data")
	public void test1(int a,int b,int expected) {
		int sum = a+b;
		System.out.println("sum values is "+sum);
		Assert.assertEquals(sum, expected);
	}
	
	@Test
	@Parameters({"name","age"})
	public void printinfo(String name,String age) {
		System.out.println(name+" is "+age);
	}
	

}
