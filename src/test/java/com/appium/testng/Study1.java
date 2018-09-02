package com.appium.testng;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Study1 {
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objects = {{1,2,3},{10,20,30},{12,15,18}};
		return objects;
	}
	
	
	
	@Test(dataProvider = "getData")
	public void testData(int a,int b,int expecteds ){
		int sum = a+b;
		Assert.assertEquals(expecteds, sum);
	}
	
	
	@Parameters({"name","age"})
	@Test(groups = "bingfa")
	public void printInfo(String name,int age){
		System.out.println(name+"   is"+age);
	}

}
