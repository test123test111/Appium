package cn.crazy.appium.page;

import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.util.GetByLocator;
import io.appium.java_client.android.AndroidElement;

public class ZhihuMore extends BasePage{
	
	public AndroidElement personInfo;
	public AndroidElement myFollow;
	public AndroidElement myCollection;
	public AndroidElement myDraft;
	public AndroidElement mySeen;
	public AndroidElement myText_zhi;
	public AndroidElement myLives;
	public AndroidElement night_mode;
	public AndroidElement settings;

	public AndroidElement getMyFollow(){
		return driver.findElement(GetByLocator.getLocator("myfollow"));
	}
	public AndroidElement getPersonInfo(){
		return driver.findElement(GetByLocator.getLocator("persioninfo"));
	}

	public ZhihuMore(AndroidDriverBase driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
