package com.appium.testng;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;

public class TestGroup {

    @BeforeGroups("database")
    public void setupDB() {
        System.out.println("setupDB()");
    }

    @AfterGroups("database")
    public void cleanDB() {
        System.out.println("cleanDB()");
    }

    @Test(groups = "selenium-test",priority = 1)
    public void runSelenium() {
        System.out.println("runSelenium()");
    }

    @Test(groups = "selenium-test",priority = 2)
    public void runSelenium1() {
        System.out.println("runSelenium()1");
//        Assert.fail("zhiweishibai");
    }

//    @Test(groups = "database")
//    public void test1(){
//    	System.out.println("test1");
//    }
    
    @Test(groups = "database",priority = 2)
    public void test2(){
    	int a = 10;
    	int b = 20;
    	int sum = a+b;
    	Assert.assertEquals(sum, 30,"加法");
    	System.out.println("test2");
    	
    }

    @Test(dependsOnGroups = { "database", "selenium-test" },priority = 3)
    public void runFinal() {
        System.out.println("runFinal");
    }

}