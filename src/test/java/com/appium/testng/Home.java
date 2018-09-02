package com.appium.testng;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.page.BasePage;
import cn.crazy.appium.util.GetByLocator;
import io.appium.java_client.android.AndroidElement;

public class Home extends BasePage{
	public Home(AndroidDriverBase driver) {
		super(driver);
		// TODO 自动生成的构造函数存根
	}

	private AndroidElement search;
	private List<AndroidElement> titles;
	private AndroidElement article;

	public AndroidElement getArticle() {
		return driver.findElement(GetByLocator.getLocator("article"));
	}

	public List<AndroidElement> getTitles() {
		return driver.findElements(GetByLocator.getLocator("title"));
	}

	public AndroidElement getSearch() {
		return driver.findElement(GetByLocator.getLocator("search"));
	}
	//
	public boolean search(String sendKeyValue){
		click(getSearch());
		sendkeys(getSearch(), sendKeyValue);
		boolean flag=false;
		for(AndroidElement ae:getTitles()){
			if(ae.getText().toLowerCase().contains(sendKeyValue.toLowerCase())){
				flag = true;
				break;
			}else {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
}
