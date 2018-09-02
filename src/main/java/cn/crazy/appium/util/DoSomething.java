package cn.crazy.appium.util;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DoSomething {
	AndroidDriver<AndroidElement> driver;
	public DoSomething(AndroidDriver<AndroidElement> driver){
		this.driver=driver;
	}
	/**
	 * 元素属性的定位
	 */
	public void nightMode(){
		fengzhuang.clickMenu(driver, 5);
		AndroidElement nightMode=driver.findElement(By.id("com.zhihu.android:id/night_mode_switch"));
		String status=nightMode.getAttribute("checked");
		nightMode.click();
		status=nightMode.getAttribute("checked");
		if(status.equals("true")){
			System.out.println("夜间模式打开成功");
		}else{
			System.out.println("夜间模式关闭成功");
		}
		String text=nightMode.getAttribute("text");
		String id=nightMode.getAttribute("resourceId");
		String className=nightMode.getAttribute("className");
		//String content_desc=nightMode.getAttribute("content-desc");
		String checkable=nightMode.getAttribute("checkable");
		String clickable=nightMode.getAttribute("clickable");
		String enable=nightMode.getAttribute("enabled");
		String longClickable=nightMode.getAttribute("longClickable");
		//name参数优先获取content-desc属性的值，如果这个值为空字符串，那么会获取text属性的值
		String name=nightMode.getAttribute("name");
		//更新AppiumBootStrap包之后，可以使用contentDescription来获取content-desc的值
		//String content-desc=nightMode.getAttribute("contentDescription");
		String selected=nightMode.getAttribute("selected");
		String displayed=nightMode.getAttribute("displayed");
		//nightMode.isSelected();//这个方法没用，无法是否被选中
		System.out.println(selected+"============="+displayed);
				
	}

}
