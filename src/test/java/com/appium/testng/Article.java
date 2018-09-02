package com.appium.testng;

import java.util.List;

import org.testng.Assert;

import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.page.BasePage;
import cn.crazy.appium.util.GetByLocator;
import io.appium.java_client.android.AndroidElement;

public class Article extends BasePage{

	public Article(AndroidDriverBase driver) {
		super(driver);
		home = new Home(driver);
		more=new More(driver);
		// TODO 自动生成的构造函数存根
	}
	private AndroidElement attention;
	private AndroidElement notattention;
	private Home home;
	private More more;
	public AndroidElement getThank() {
		return driver.findElement(GetByLocator.getLocator("attention"));
	}
	public AndroidElement getIsthank() {
		return driver.findElement(GetByLocator.getLocator("notattention"));
	}

	//感谢
	public boolean thank(){
		click(home.getArticle());
		List<AndroidElement> follows=more.getMyfollows();
		boolean flag = false;
		if(driver.isElementExist(getThank())){
			click(getThank());
			driver.findElement(GetByLocator.getLocator("tab5")).click();
			more.getMyFllow().click();
			if(follows.get(0).getText().contains(ZhiHuTest.returnValue())){
				flag=true;
			}else {
				flag=false;
			}
		}
		return flag;
//		}else {
//			click(getIsthank());
//			driver.findElement(GetByLocator.getLocator("tab5")).click();
//			more.getMyFllow().click();
//			if(!getPageSource().contains(more.getMyFllow().getText())){
//				return "取消关注成功";
//			}else {
//				return "取消关注失败";
//			}
//		}
	}
	
}
