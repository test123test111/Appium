package cn.crazy.appium.page;

import java.util.List;

import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.util.GetByLocator;
import io.appium.java_client.android.AndroidElement;

public class ZhihuArticle extends BasePage{
	
	public AndroidElement attention;
	public AndroidElement notAttention;
	public List<AndroidElement> biaoti;
	public ZhihuHome zhihuhome;
	public ZhihuMore zhihumore;

	public AndroidElement getAttention() {
		return super.driver.findElement(GetByLocator.getLocator("attention"));
	}
	
	public AndroidElement getNotAttention() {
		return super.driver.findElement(GetByLocator.getLocator("notAttention"));
	}
	
	public List<AndroidElement> getBiaoti() {
		return super.driver.findElements(GetByLocator.getLocator("biaoti"));
	}
	public ZhihuArticle(AndroidDriverBase driver) {
		super(driver);
		zhihuhome = new ZhihuHome(driver);
		zhihumore = new ZhihuMore(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean attention() {
		String text = zhihuhome.getTitles().get(0).getText();
		click(zhihuhome.getTitles().get(0));
		while(true) {
			if(driver.isElementExist(getAttention())) {
				click(getAttention());
				System.out.println("文章关注成功");
				break;
//			}else {
//				driver.swipe("up", 1000);
			}
		}

		driver.pressBack();
		click(driver.findElement(GetByLocator.getLocator("tab5")));
		
		click(zhihumore.getMyFollow());
		
		boolean flag = false;
		if (driver.getPageSouce().contains(text)) {
			flag = true;
		}else {
			flag = false;
		}
		return flag;
		
		
		
		
		
	}
	

}
