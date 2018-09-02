package com.appium.testng;

import java.util.List;

import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.page.BasePage;
import cn.crazy.appium.util.GetByLocator;
import io.appium.java_client.android.AndroidElement;

public class More extends BasePage{
	public More(AndroidDriverBase driver) {
		super(driver);
		// TODO 自动生成的构造函数存根
	}
	private AndroidElement myFllow;
	private List<AndroidElement> myfollows;
	
	
	public AndroidElement getMyFllow() {
		return driver.findElement(GetByLocator.getLocator("myfollow"));
	}
	public List<AndroidElement> getMyfollows() {
		return driver.findElements(GetByLocator.getLocator("myfollows"));
	}

	
	
}
