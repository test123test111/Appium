package cn.crazy.appium.testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Handle {
	
	public static String getHandle(AndroidDriver<AndroidElement> driver){
		return driver.getWindowHandle();
	}
	
	public static void yuanHandle(AndroidDriver<AndroidElement> driver){
		System.out.println("原窗口的句柄为：  "+Handle.getHandle(driver)+"------->标题为: "+driver.getTitle());
		String handle = driver.getWindowHandle();
	}
	
	
	public static void zhuanhuanHandle(AndroidDriver<AndroidElement> driver){
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		System.out.println(handles.size());
		
		while(iterator.hasNext()){
			if(getHandle(driver)==iterator.next()){
				continue;
			}
			String newhandle = iterator.next();
			driver.switchTo().window(newhandle);
			System.out.println("新窗口的句柄为：  "+newhandle+"----->标题为：  "+driver.getTitle());
			break;
		}
		
		
		
		//转换driver到新的handle上
//		for(String ae:handles){
//			System.out.println(ae);
//			if(!ae.equals(Handle.getHandle(driver))){
//				driver.switchTo();
//				break;
//			}
//		}
	}

}
