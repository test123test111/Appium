package cn.crazy.appium.page;

import java.util.List;

import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.util.GetByLocator;
import io.appium.java_client.android.AndroidElement;

public class ZhihuHome extends BasePage{
	
	public AndroidElement search;
	public List<AndroidElement> titles;
	public AndroidElement article;
	public List<AndroidElement> tabs;

	public List<AndroidElement> getTabs() {
		return super.driver.findElements(GetByLocator.getLocator("tabs"));
	}
	public AndroidElement getSearch() {
		return super.driver.findElement(GetByLocator.getLocator("search"));
	}
	public List<AndroidElement> getTitles(){
		return super.driver.findElements(GetByLocator.getLocator("title"));
	}
	public AndroidElement getArtitle(){
		return super.driver.findElement(GetByLocator.getLocator("article"));
	}

	public ZhihuHome(AndroidDriverBase driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean zhihuSearchTest(String searchKeyword) {
		click(getSearch());
		sendkeys(getSearch(), searchKeyword);
		List<AndroidElement> titles=getTitles();
		boolean flag = false;
		for(AndroidElement ae:titles) {
			if(ae.getText().toLowerCase().contains(searchKeyword.toLowerCase())) {
				flag = true;
				
			}else {
				flag = false;
			}
		}
		return flag;
	}

}
