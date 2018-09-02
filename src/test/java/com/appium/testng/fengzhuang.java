package com.appium.testng;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cn.crazy.appium.util.SendMail;
import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class fengzhuang {
	AndroidDriver<AndroidElement> driver;
	public fengzhuang(AndroidDriver<AndroidElement> driver){
		this.driver=driver;
	}
	
	
	
	
	/**
	 * Android手机的appium关键字设置
	 * @author duanhao
	 * @return
	 * @throws Exception
	 */
    public static  AndroidDriver<AndroidElement> AndroidsetUp(){
   	 // set up appium
       File classpathRoot = new File(System.getProperty("user.dir"));
       File appDir = new File(classpathRoot, "/apps");
       File app = new File(appDir,"deersteward_phone.apk");
       DesiredCapabilities caps =new DesiredCapabilities();
       caps.setCapability(MobileCapabilityType.DEVICE_NAME,"a64c4287d540");//a64c4287d540//d8c6d48b7d63
       caps.setCapability("platformVersion","7.1.2");
       caps.setCapability("platformName","android");
       //caps.setCapability("app", app.getAbsolutePath());
       caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.yce.deerstewardphone");
       caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.yce.deerstewardphone.activity.SplashActivity");
       //caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.yce.deerstewardphone.activity.SplashActivity");
       caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD,true);
       caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD,true);
       caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
       caps.setCapability(MobileCapabilityType.NO_RESET,true);
       AndroidDriver<AndroidElement> driver = null;
	try {
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		System.out.println("driver启动成功");
	} catch (Exception e) {
		// TODO 自动生成的 catch 块
		SendMail.send("driver启动失败", e.getMessage());
	}
	return driver;
   }
    
    /**
     * 参数port和udid进行传入,int类型的port，string类型的udid
     * @author duanhao
     * @param port
     * @param udid
     * @return
     * @throws Exception
     */
    public static  AndroidDriver<AndroidElement> AndroidsetUp(int port,String udid) throws Exception {
     	 // set up appium
         File classpathRoot = new File(System.getProperty("user.dir"));
         File appDir = new File(classpathRoot, "/apps");
         File app = new File(appDir,"deersteward_phone.apk");
         DesiredCapabilities caps =new DesiredCapabilities();
         caps.setCapability(MobileCapabilityType.DEVICE_NAME,udid);//a64c4287d540//d8c6d48b7d63
//         caps.setCapability(MobileCapabilityType.UDID,udid);
         caps.setCapability("platformVersion","7.1.2");
         caps.setCapability("platformName","android");
         //caps.setCapability("app", app.getAbsolutePath());
         caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.yce.deerstewardphone");
         caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.yce.deerstewardphone.activity.SplashActivity");
         //caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.yce.deerstewardphone.activity.SplashActivity");
         caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
         caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
         caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
         caps.setCapability(MobileCapabilityType.NO_RESET,true);
         AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
         		new URL("http://127.0.0.1:"+port+"/wd/hub"), caps);
         return driver;
     }
    
    public static  AndroidDriver<AndroidElement> AndroidByParameter(String udid,String appPackage,String appActivity) throws Exception {
      	 // set up appium
          File classpathRoot = new File(System.getProperty("user.dir"));
          File appDir = new File(classpathRoot, "/apps");
          File app = new File(appDir,"deersteward_phone.apk");
          DesiredCapabilities caps =new DesiredCapabilities();
          caps.setCapability(MobileCapabilityType.UDID,udid);//a64c4287d540//d8c6d48b7d63
          caps.setCapability("platformVersion","7.1.2");
          caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
          caps.setCapability("platformName","android");
          //caps.setCapability("app", app.getAbsolutePath());
          caps.setCapability(MobileCapabilityType.DEVICE_NAME, "xxx");
          caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
          caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
          caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
          caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
          caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
          AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
          		new URL("http://127.0.0.1:4723/wd/hub"), caps);
          return driver;
      }
    
    
    /**
     * H5的启动driver
     * @return
     * @throws Exception
     */
    public static AndroidDriver<AndroidElement> androidByH5SetUp() throws Exception{
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "xxx");
		caps.setCapability(MobileCapabilityType.UDID, "a64c4287d540");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
		caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), caps);
		return driver;
	}
    
	public static IOSDriver initIosDriverByH5() throws IOException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "9.3");
		capabilities.setCapability("deviceName", "iPhone 6");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		//capabilities.setCapability("app", "/Users/lixionggang/Library/Developer/Xcode/DerivedData/Book-brixbgarbyxyeybewnllyzizwpln/Build/Products/Debug-iphonesimulator/Book.app");
		capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
		capabilities.setCapability(IOSMobileCapabilityType.SEND_KEY_STRATEGY,"grouped");
		//capabilities.setCapability(MobileCapabilityType.UDID, "be4be033372e9c7f4bc558a0a6fc4c1b41e8e2f2");
		IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL("http://192.168.216.128:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public static IOSDriver initIosDriverByWebview() throws IOException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "9.3.2");
		capabilities.setCapability("deviceName", "iPhone 5s");
		capabilities.setCapability("app", "/Users/lixionggang/Library/Developer/Xcode/DerivedData/Book-brixbgarbyxyeybewnllyzizwpln/Build/Products/Debug-iphonesimulator/Book.app");
		capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
		capabilities.setCapability(IOSMobileCapabilityType.SEND_KEY_STRATEGY,"grouped");
		capabilities.setCapability(MobileCapabilityType.UDID, "be4be033372e9c7f4bc558a0a6fc4c1b41e8e2f2");
		IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL("http://192.168.216.128:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
	public static IOSDriver initIosDriver() throws IOException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "9.3");
		capabilities.setCapability("deviceName", "iPhone 5s");
		capabilities.setCapability("app", "/Users/lixionggang/Library/Developer/Xcode/DerivedData/SmallDay-apeemwhoeruhdlavdjskumgyeldy/Build/Products/Debug-iphonesimulator/SmallDay.app");
		capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
		capabilities.setCapability(IOSMobileCapabilityType.SEND_KEY_STRATEGY,"grouped");
		IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL("http://192.168.216.128:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	/**
	 * deiveceName:moniqi
	 * app:C:/Users/LXG/Desktop/zhihu.apk
	 */
	public static void  initDriver1(String udid,String port) throws Exception {
		File app=new File("C:/Users/LXG/Desktop/zhihu.apk");
		DesiredCapabilities caps=new DesiredCapabilities();
		//deviceName是必须项，但是值可以随便写
		caps.setCapability("deviceName", "moniqi");
		//要安装的app路径，路径必须是服务端所在的电脑上存放的apk文件路径
		caps.setCapability("app", app.getAbsolutePath());
		//如果你的安卓是4.2以下，需要使用automationName指定Selendroid
		//caps.setCapability("automationName", "Selendroid");
		//使用appium的输入法，支持中文并隐藏键盘
		caps.setCapability("unicodeKeyboard", true);
		//将输入法重置回设备默认的输入法
		caps.setCapability("resetKeyboard", true);
		//不重签名app
		caps.setCapability("noSign", true);
		//设置driver超时时间，单位s
		caps.setCapability("newCommandTimeout", 600);
		//appPackage表示要启动的应用的包名
//		caps.setCapability("appPackage", "com.zhihu.android");
//		//appActivity表示要启动的应用的起始activity
//		caps.setCapability("appActivity", "com.zhihu.android.app.ui.activity.MainActivity");
//		//appWaitActivity,这个参数的值写的是app启动后真正的界面activity
		caps.setCapability("appWaitActivity", "com.zhihu.android.app.ui.activity.MainActivity1");
		//deviceReadyTimeout修改appium判断设备正常响应的超时时间，默认是5秒
		caps.setCapability("deviceReadyTimeout",30);
		//browserName手机web自动化的浏览器的名字
		//caps.setCapability("browserName", "Chrome");
		//udid表示指定连接某台设备
		caps.setCapability("udid", "127.0.0.1:62001");
		//caps.setCapability("noReset", false);
		caps.setCapability("fullReset", true);
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}
	
	public static AndroidDriver<AndroidElement> initDriver1() throws Exception{
		File app=new File("C:/Users/LXG/Desktop/zhihu.apk");
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "xxx");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		caps.setCapability(MobileCapabilityType.UDID, "127.0.0.1:62001");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
		//caps.setCapability(MobileCapabilityType.FULL_RESET, true);
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.zhihu.android");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.zhihu.android.app.ui.activity.MainActivity");
		caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), caps);
		
		return driver;
		
	}
	public static AndroidDriver<AndroidElement> initDriverBySelendroid() throws Exception{
		File app=new File("C:/Users/LXG/Desktop/zhihu.apk");
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "xxx");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//这个参数表示要选择的测试引擎
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Selendroid");
		caps.setCapability(MobileCapabilityType.UDID, "127.0.0.1:62001");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
		//caps.setCapability(MobileCapabilityType.FULL_RESET, true);
//		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.zhihu.android");
//		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.zhihu.android.app.ui.activity.MainActivity");
		caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		//caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), caps);
		return driver;
	}
	public static AndroidDriver<AndroidElement> initDriverByH5() throws Exception{
		//File app=new File("C:/Users/LXG/Desktop/zhihu.apk");
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "xxx");
		//caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//这个参数表示要选择的测试引擎
		//caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Selendroid");
		caps.setCapability(MobileCapabilityType.UDID, "d8c6d48b7d63");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
		//caps.setCapability(MobileCapabilityType.FULL_RESET, true);
//		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.zhihu.android");
//		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.zhihu.android.app.ui.activity.MainActivity");
		caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		//caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), caps);
		return driver;
	}
	
	public static AndroidDriver<AndroidElement> initDriverAlreadyInstall(String appPackage,String appActivity) throws Exception{
		//File app=new File("C:/Users/LXG/Desktop/zhihu.apk");
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "xxx");
		//caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//这个参数表示要选择的测试引擎
		//caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Selendroid");
		caps.setCapability(MobileCapabilityType.UDID, "d8c6d48b7d63");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
		//caps.setCapability(MobileCapabilityType.FULL_RESET, true);
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,appPackage);
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,appActivity);
		caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		//caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
		caps.setCapability("noReset", true);
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), caps);
		return driver;
	}
	public static  AndroidDriver<AndroidElement> AndroidsetUpByZhihu(){
	   	 // set up appium
	       File classpathRoot = new File(System.getProperty("user.dir"));
	       File appDir = new File(classpathRoot, "/apps");
	       File app = new File(appDir,"zhihu.apk");
	       DesiredCapabilities caps =new DesiredCapabilities();
	       caps.setCapability(MobileCapabilityType.DEVICE_NAME,"a64c4287d540");//a64c4287d540//d8c6d48b7d63
	       caps.setCapability("platformVersion","7.1.2");
	       caps.setCapability("platformName","android");
	       //caps.setCapability("app", app.getAbsolutePath());
	       caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.zhihu.android");
	       caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.zhihu.android.app.ui.activity.MainActivity");
	       //caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.yce.deerstewardphone.activity.SplashActivity");
	       caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD,true);
	       caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD,true);
	       caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
	       caps.setCapability(MobileCapabilityType.NO_RESET,true);
	       AndroidDriver<AndroidElement> driver = null;
		try {
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			System.out.println("driver启动成功");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			SendMail.send("driver启动失败", e.getMessage());
		}
		return driver;
	   }
	
	public static AndroidDriver<AndroidElement>  initDriver(String udid,String port) throws Exception {
		
		File app=new File("C:/Users/dhqinli/Desktop/meituan.apk");
		DesiredCapabilities caps=new DesiredCapabilities();
		//deviceName是必须项，但是值可以随便写
		caps.setCapability("deviceName", "Android");
		//要安装的app路径，路径必须是服务端所在的电脑上存放的apk文件路径
		caps.setCapability("app", app.getAbsolutePath());
		//如果你的安卓是4.2以下，需要使用automationName指定Selendroid
		//caps.setCapability("automationName", "Selendroid");
		//使用appium的输入法，支持中文并隐藏键盘
		caps.setCapability("unicodeKeyboard", true);
		//将输入法重置回设备默认的输入法
		caps.setCapability("resetKeyboard", true);
		//不重签名app
		caps.setCapability("noSign", true);
		//设置driver超时时间，单位s
		caps.setCapability("newCommandTimeout", 600);
		//appPackage表示要启动的应用的包名
		caps.setCapability("appPackage", "com.sankuai.meituan");
		//appActivity表示要启动的应用的起始activity
		caps.setCapability("appActivity", "com.sankuai.meituan.activity.Welcome");
//		//appWaitActivity,这个参数的值写的是app启动后真正的界面activity
	//	caps.setCapability("appWaitActivity", "com.zhihu.android.app.ui.activity.MainActivity1");
		//deviceReadyTimeout修改appium判断设备正常响应的超时时间，默认是5秒
		caps.setCapability("deviceReadyTimeout",30);
		//browserName手机web自动化的浏览器的名字
		//caps.setCapability("browserName", "Chrome");
		//udid表示指定连接某台设备
		caps.setCapability("udid",udid);
		caps.setCapability("noReset",true);
	//	caps.setCapability("fullReset", true);
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:"+port+"/wd/hub"), caps);
		return driver;
	}
	
	/**
	 * 点击底部菜单按钮
	 */
    public static void clickMenu(AndroidDriver<AndroidElement>driver,int order){
		//android.widget.HorizontalScrollView/android.widget.LinearLayout/*[5]
		if(order>0&&order<6){
			driver.findElementByXPath("//android.widget.LinearLayout/android.widget.RelativeLayout["+order+"]/android.widget.LinearLayout[1]/android.widget.ImageView[1]").click();
		}else{
			System.out.println("没有这个菜单");
		}
		
	}
    
    
    public void elementSwipe(){
    	AndroidElement element = driver.findElement(By.id(""));
    	//offsetFromStartBorder---偏移量
    	//offsetFromEndBorder---偏移量
    	//Direction--方向
    	//
    	element.swipe(SwipeElementDirection.DOWN, 10, 10, 1000);
    }
    
    
    //获取元素上的属性attribute
    public static void ElementAttribute(AndroidDriver<AndroidElement> driver) throws Exception{
    	Thread.sleep(2000);
    	driver.findElementByXPath("//android.widget.ImageView[@resource-id=\"com.sankuai.meituan:id/settings\"]").click();
    	Thread.sleep(1000);
    	driver.findElementByXPath("//android.widget.TextView[@resource-id=\"com.sankuai.meituan:id/settings_common_settings_label\"]").click();
    	Thread.sleep(1000);
    	AndroidElement Close=driver.findElementByXPath("//android.widget.ToggleButton[@resource-id=\"com.sankuai.meituan:id/settings_no_picture_mode_toggle\"]");
    	Close.click();
    	Thread.sleep(1000);
    	String status=Close.getAttribute("checked");
//    	String text=Close.getAttribute("text");
//    	String id=Close.getAttribute("resourceId");
//    	String className=Close.getAttribute("className");
//    	String content_desc=Close.getAttribute("content-desc");
//    	String clickable=Close.getAttribute("clickable");
//    	//对复选框进行勾选
//    	String checked=Close.getAttribute("checked");
//    	String checkable=Close.getAttribute("checkable");
//    	String long_clickable=Close.getAttribute("longClickable");
//    	//name参数优先获取cantent-desc属性的值，如果这个值为空字符串，那么会获取text属性的值
//    	String name=Close.getAttribute("name");
    	if (status.equals("false")) {
			System.out.println("省流量开关关闭成功");
		}else {
			System.out.println("省流量开关开启成功");
		}
    }
	//向左滑动
	public static void swipeToLeft(AndroidDriver<AndroidElement>driver,int duration) throws Exception{
		int x=driver.manage().window().getSize().getWidth();
		int y=driver.manage().window().getSize().getHeight();
		driver.swipe(4*x/5, 1*y/2, 1*x/5, 1*y/2, duration);
		Thread.sleep(500);
	}
	//向右滑动
	public static void swipeToRight(AndroidDriver<AndroidElement>driver,int duration) throws Exception{
		int x=driver.manage().window().getSize().getWidth();
		int y=driver.manage().window().getSize().getHeight();
		driver.swipe(x/5, y/2, 4*x/5, y/2, duration);
		Thread.sleep(500);
	}
	//向上滑动
	public static void swipeToUp(AndroidDriver<AndroidElement>driver,int duration) throws Exception{
		int x=driver.manage().window().getSize().getWidth();
		int y=driver.manage().window().getSize().getHeight();
		driver.swipe(x/2, 3*y/4, x/2, y/4, duration);
		Thread.sleep(500);
	}
	//向下滑动
	public static void swipeToDown(AndroidDriver<AndroidElement>driver,int duration) throws Exception{
		int x=driver.manage().window().getSize().getWidth();
		int y=driver.manage().window().getSize().getHeight();
		driver.swipe(x/2,y/4,x/2,3*y/4,duration);
		Thread.sleep(500);
	}
	/**
	 * 
	 * @param driver
	 * @param up,down,left,right
	 * @param duration-ms
	 * @throws Exception
	 */
	public static void swipe(AndroidDriver<AndroidElement>driver,String direction,int duration) throws Exception{
		switch (direction.toLowerCase()) {
		case "up":
			swipeToUp(driver, duration);
			break;
		case "down":
			swipeToDown(driver, duration);
			break;
		case "left":
			swipeToLeft(driver, duration);
			break;
		case "right":
			swipeToRight(driver, duration);
			break;
		default:
			System.out.println("方向参数不准确");
			break;
		}
		
	}
	/**
	 * 启动另外一个app的命令
	 * @param args
	 */
	public static void StartAvtivity(AndroidDriver<AndroidElement> driver){
		driver.startActivity("", "");
	}
	public static void main(String[] args) {
		try {
			fengzhuang.AndroidsetUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取输入框的text文本
	 * 将光标置于输入框的最后
	 * 根据文本长度循环调用物理键盘删除操作，逐个字符进行删除; 对于密码输入框无效
	 * @throws Exception 
	 * @param driver
	 * @param ele
	 * @throws Exception
	 */
	public static void clearElement(AndroidDriver<AndroidElement> driver,By by,String value) throws Exception{
		AndroidElement ele=driver.findElement(by);
		ele.click();
		String text=ele.getText();
		//将光标置于最后
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_MOVE_END);
		for(int i=0;i<text.length();i++){
			Thread.sleep(200);
			driver.pressKeyCode(AndroidKeyCode.BACKSPACE);
		}
		ele.sendKeys(value);
	}
	/**
	 * 针对密码输入框clear不干净时使用
	 * @param driver
	 * @param ele
	 * @throws Exception
	 */
	public static void clearPassword(AndroidDriver<AndroidElement> driver,AndroidElement ele) throws Exception{
		ele.click();
		//将光标置于最后
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_MOVE_END);
		for(int i=0;i<20;i++){
			Thread.sleep(200);
			driver.pressKeyCode(AndroidKeyCode.BACKSPACE);
		}
	}
	/**
	 * 滑动查找元素
	 * @param driver
	 * @throws Exception
	 */
	public static void swipeElement(AndroidDriver<AndroidElement> driver) throws Exception{
		if(fengzhuang.isElememtExist(driver, By.name("设置"))){
			driver.findElement(By.name("设置")).click();
			
		}else {
			fengzhuang.swipe(driver, "up", 500);
			driver.findElement(By.name("设置")).click();
		}
		while(true){
			if(fengzhuang.isElememtExist(driver, By.name("退出账号"))){
				driver.findElement(By.name("退出账号")).click();
				break;
			}else {
				fengzhuang.swipe(driver, "up", 500);
				driver.findElement(By.name("退出账号")).click();
			}
		}
	}

	public static void ElementSwipe(AndroidDriver<AndroidElement> driver,int start,int end) throws Exception{
    	AndroidElement elementscoll=driver.findElementByXPath("//android.widget.FrameLayout[@resource-id=\"com.sankuai.meituan:id/index_fragment_container\"]");
    	//elementscoll.swipe(SwipeElementDirection.DOWN, 1000);
    	Thread.sleep(5000);
    	elementscoll.swipe(SwipeElementDirection.DOWN,start, end, 1000);
	}
	
	//获取元素结束点坐标，在我们仅仅想使用这个元素的结束点坐标的时候使用
	public static Point getEndElementLocatian(AndroidDriver<AndroidElement> driver,By by){
		AndroidElement element=driver.findElement(by);
//		int startx=element.getLocation().getX();//获取起始点X
//		int starty=element.getLocation().getY();//获取起始点Y
//		
//		int width=element.getSize().getWidth();//获取元素的宽
//		int height=element.getSize().getHeight();//获取元素的高
//		
//		int endx=startx+width;//结束点的X
//		int endy=starty+height;//结束点的y
//		
//		int centerx=element.getCenter().getX();//中点x
//		int centery=element.getCenter().getY();//中点y
		return getElementLocatian(element);
	}

	/*元素结束点坐标
	 * element
	 * 返回一个point对象
	 */
	public static Point getElementLocatian(AndroidElement element){
		int startx=element.getLocation().getX();//获取起始点X
		int starty=element.getLocation().getY();//获取起始点Y
		
		int width=element.getSize().getWidth();//获取元素的宽
		int height=element.getSize().getHeight();//获取元素的高
		
		int endx=startx+width;//结束点的X
		int endy=starty+height;//结束点的y
		
		int centerx=element.getCenter().getX();//中点x
		int centery=element.getCenter().getY();//中点y
		return new Point(endx, endy);	
	}
	
    public static void end(AndroidDriver<AndroidElement>driver){
    	int endx=fengzhuang.getEndElementLocatian(driver, By.id("xx")).getX();
    	int endy=fengzhuang.getEndElementLocatian(driver, By.id("xx")).getY();
    	
    	Point point=fengzhuang.getEndElementLocatian(driver, By.id("xx"));
    	int end_x=point.getX();
    	int end_y=point.getX();
    	
    }
    public static void tap(AndroidDriver<AndroidElement>driver){
    	AndroidElement element=driver.findElement(By.xpath("xx"));
    	driver.tap(1, element, 50);
    	//点击元素的坐标
    	driver.tap(1, element.getCenter().x, element.getCenter().y, 50);
    	element.replaceValue("xx");//输入内容的另一种方式
    	
    }
	
	
	public static void startMaiMai(AndroidDriver<AndroidElement> driver){
		//启动另一个应用脉脉
		driver.startActivity("", "");
		//获取当前activity，可以用来判断界面跳转
		String currentActivity=driver.currentActivity();
		//获取当前网络连接状态
		NetworkConnectionSetting network=driver.getNetworkConnection();
		System.out.println(network.toString());
		System.out.println(network.value);
	}
	//设置网络
	public static void  getNetworkConnection(AndroidDriver<AndroidElement> driver){
		NetworkConnectionSetting network=driver.getNetworkConnection();
		//打印当前的网络状态
		System.out.println(network.toString());
		System.out.println(network.value);
		//设置网络为wifi
		NetworkConnectionSetting wifi=new NetworkConnectionSetting(2);
		driver.setNetworkConnection(wifi);
		System.out.println(network.value);
	}
	//设置手机的横竖屏
	public static void  ScreenOrientation(AndroidDriver<AndroidElement> driver){
		ScreenOrientation orientation=driver.getOrientation();
		System.out.println(orientation.value());
		//设置手机屏幕为横屏LANDSCAPE
		driver.rotate(ScreenOrientation.LANDSCAPE);
		System.out.println(orientation.value());
		//当当前app不支持设置横竖屏时，运行脚本会报错
	}
	//应用的卸载和安装
	public static void installAnduninstall(AndroidDriver<AndroidElement> driver){
		if (driver.isAppInstalled("com.luguanjia.test")) {
			driver.removeApp("com.luguanjia.test");
		}
		driver.installApp("路径");
		System.out.println(driver.isAppInstalled("com.luguanjia.test"));
	}
	//重置app
	public static void resetapp(AndroidDriver<AndroidElement> driver){
		driver.resetApp();
	}
	
	//打开通知栏
	//显式等待
	public static void waitUtilElement(final AndroidDriver<AndroidElement> driver){
		WebDriverWait wait=new WebDriverWait(driver, 10);
		AndroidElement element=(AndroidElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.id("xxxx")));
		
		
		
		//自定义显式等待
		WebDriverWait wait1=new WebDriverWait(driver, 30);
		boolean flag=wait1.until(new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return driver.findElement(By.id("xxxxx")).getText().contains("验证码");
				
			}
		});
	}
	//截图方法
	public static void ScreenShot(AndroidDriver<AndroidElement>driver,String filename) throws Exception{
		File file=driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("images\\"+filename+".png"));
	}
	
	public static void Screenshot(AndroidDriver<AndroidElement> driver,String ScreenName) throws IOException{
		//设置时间格式
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		//生成时间戳
		String dataString=formater.format(new Date());
		String dir_name=System.getProperty("user.dir")+"\\异常图片";
		System.out.println("异常图片目录"+dir_name);
		//由于可能存在异常图片的目录被删除的可能，所以这边先判断目录是否存在
		if (!(new File(dir_name).isDirectory())) 
		{
			//判断是否存在该目录
			new File(dir_name).mkdir();
		}
		//调用方法捕捉画面
		File screen=driver.getScreenshotAs(OutputType.FILE);
		//复制文件到指定目录
		//图片最后存放的路径有 目录：dir_name+时间戳+测试套件+测试用例+测试步骤组合生成
		System.out.println("异常图片名称"+dir_name+"\\"+dataString+ScreenName+".jpg");
		FileUtils.copyFile(screen,new File(dir_name+"\\"+dataString+ScreenName+".jpg"));
	}
	
	
	//判断屏幕是否锁屏,如果锁屏，则解锁
	public static void locked(AndroidDriver<AndroidElement>driver){
		if (driver.isLocked()) {
			driver.unlockDevice();
		}
	}
	//放大
	public static void zoom(AndroidDriver<AndroidElement>driver){
		driver.zoom(300, 500);
	}
	//缩小
	public static void pinch(AndroidDriver<AndroidElement>driver){
		driver.pinch(300, 500);
	}
	//拖拽
	public static void touchaction1(AndroidDriver<AndroidElement>driver){
		AndroidElement element1=driver.findElement(By.id("xxxx"));
		AndroidElement element2=driver.findElement(By.id("xxxx"));
		TouchAction ta=new TouchAction(driver);
		
		//从一个点拖拽到另一个点，可用于屏幕的解锁
		ta.press(element1).moveTo(element2).release().perform();
		ta.longPress(element1).moveTo(element2).release().perform();
		
		//对某一个元素进行长按操作
		ta.longPress(element1).release().perform();
		//对某一个元素根据坐标进行长按操作
		ta.longPress(300,500).release().perform();
		
		//对某一个元素进行点击
		ta.press(element1).release().perform();
		ta.press(300, 500).release().perform();	
	}
	//拖拽
	public static void touchaction(AndroidDriver<AndroidElement>driver) throws Exception{
		TouchAction ta=new TouchAction(driver);
		driver.pressKeyCode(3);
		Thread.sleep(2000);
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		Thread.sleep(500);
		fengzhuang.swipe(driver, "left", 1000);
		AndroidElement zhihu=driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"知乎\"]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.ImageView[1]"));
		AndroidElement rili=driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"日历\"]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.ImageView[1]"));
		ta.press(zhihu).moveTo(rili).release().perform();
		
	}
	
	//通过id定位当前屏幕所有设置，并且获取所有设置的文本存入list，如果这个list的大小小于**，那就向上滑动
	//再次获取当前屏幕的所有设置，并且将所有设置的文本存入list，并且判重，再次判断list的大小是否大于**，如果大于，直接list.get(**-1).clik，完成点击
	public static void listClick(AndroidDriver<AndroidElement>driver) throws Exception{
		driver.pressKeyCode(3);
		Thread.sleep(2000);
		driver.pressKeyCode(3);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"设置\"]")).click();
		List<String> settingTexts=new ArrayList<String>();
		List<AndroidElement> settings=new ArrayList<AndroidElement>();
		while(true){
			List<AndroidElement> titles=driver.findElements(By.id("android:id/title"));
			for(AndroidElement ae:titles){
				String text=ae.getText();
				if(!settingTexts.contains(text)){
					settingTexts.add(text);
					settings.add(ae);
				}
			}
			if(settingTexts.size()>15){
				settings.get(16).click();
				Thread.sleep(5000);
				break;
			}else{
				fengzhuang.swipe(driver, "up", 1000);
			}
		}
	}
	//滑动查找元素
	public static void findelement(AndroidDriver<AndroidElement>driver) throws Exception{
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		driver.findElement(By.name("设置")).click();
		if (fengzhuang.isElememtExist(driver, By.xpath("//android.widget.TextView[@text=\"锁屏和密码\"]"))) {
			driver.findElement(By.xpath("//android.widget.TextView[@text=\"锁屏和密码\"]")).click();
		}else {
			fengzhuang.swipe(driver, "up", 2000);
			driver.findElement(By.xpath("//android.widget.TextView[@text=\"锁屏和密码\"]")).click();
		}		
	}
	
	public void logout(AndroidDriver<AndroidElement>driver) throws Exception{
		if(fengzhuang.isElememtExist(driver, By.name("设置"))){
			driver.findElement(By.name("设置")).click();
		}else{
			fengzhuang.swipe(driver, "up", 500);
			driver.findElement(By.name("设置")).click();
		}
		while(true){
			if(fengzhuang.isElememtExist(driver, By.name("退出帐号"))){
				driver.findElement(By.name("退出帐号")).click();
				driver.findElement(By.name("确定")).click();
				break;
			}else{
				fengzhuang.swipe(driver, "up", 500);
			}
		}
	}

	/**
	 * @throws Exception 
	 * 
	 */
	public static void selectElement(AndroidDriver<AndroidElement> driver) throws Exception{
		driver.pressKeyCode(3);
		driver.findElement(By.id("xxx"));
		List<String> settingTexts = new ArrayList<String>();
		List<AndroidElement> settings = new ArrayList<AndroidElement>();
		while(!fengzhuang.isElememtExist(driver,By.xpath(""))){
			List<AndroidElement> titles = driver.findElements(By.id(""));
			for(AndroidElement ae:titles){
				String text = ae.getText();
				if(!settingTexts.contains(text)){
					settingTexts.add(text);
					settings.add(ae);
				}
			}
			if(settingTexts.size()>13){
				settings.get(14).click();
				Thread.sleep(1000);
				break;
				
			}else {
				fengzhuang.swipe(driver, "up", 1000);
			}
		}
		
	}

	/**
	 * 长按home键，3值是home键
	 * @param driver
	 */
	public static void longPressKeyCode(AndroidDriver<AndroidElement> driver){
		driver.longPressKeyCode(3);
	}
	
	/**
	 * 对元素进行缩小
	 * @param driver
	 * @param by
	 */
	public static void suoxiao(AndroidDriver<AndroidElement> driver,By by){
		//可以使用元素进行缩小
		driver.pinch(driver.findElement(by));
		//可以对某一个坐标进行缩小
		driver.pinch(300,500);
	}
	
	/**
	 * 对元素进行放大
	 * @param driver
	 * @param by
	 */
	public static void fangda(AndroidDriver<AndroidElement> driver,By by){
		//对某一个元素进行放大
		driver.zoom(driver.findElement(by));
		//对某一个坐标点进行放大
		driver.zoom(300, 500);
	}

	public static void touchAction(AndroidDriver<AndroidElement> driver){
		AndroidElement element=driver.findElement(By.id("xx"));
		TouchAction touchAction=new TouchAction(driver);
		touchAction.longPress(element).release().perform();
		driver.scrollTo("");
	}
	
	//解锁手势锁
	public static void shoushisuo(AndroidDriver<AndroidElement>driver) throws Exception{
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		driver.findElement(By.name("设置")).click();
		if (fengzhuang.isElememtExist(driver, By.name("锁屏和密码"))) {
			driver.findElement(By.name("锁屏和密码")).click();
		}else {
			fengzhuang.swipe(driver,"up", 2000);
			Thread.sleep(2000);
			driver.findElement(By.name("锁屏和密码")).click();
		}	
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"锁屏密码\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"图案\"]")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
		AndroidElement element=driver.findElement(By.id("com.android.settings:id/lockPattern"));
		Point p=element.getLocation();
		int x=p.getX();
		int y=p.getY();
		Dimension d=element.getSize();
		int width=d.getWidth();
		int height=d.getHeight();
		List<Point> pList=new ArrayList<Point>();
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				int center_x=x+(2*j+1)*width/6;
				int center_y=y+(2*i+1)*height/6;
				Point p1=new Point(center_x, center_y);
				pList.add(p1);
			}
		}
		//绘制手势图，moveTo里的坐标是相对与前一个点的偏移量
		TouchAction ta=new TouchAction(driver);
		ta.press(pList.get(0).getX(),pList.get(0).getY())
		.moveTo(pList.get(1).getX()-pList.get(0).getX(),pList.get(1).getY()-pList.get(0).getY())
		.moveTo(pList.get(2).getX()-pList.get(1).getX(),pList.get(2).getY()-pList.get(1).getY())
		.moveTo(pList.get(4).getX()-pList.get(2).getX(),pList.get(4).getY()-pList.get(2).getY())
		.moveTo(pList.get(6).getX()-pList.get(4).getX(),pList.get(6).getY()-pList.get(4).getY())
		.moveTo(pList.get(7).getX()-pList.get(6).getX(),pList.get(7).getY()-pList.get(6).getY())
		.moveTo(pList.get(8).getX()-pList.get(7).getX(),pList.get(8).getY()-pList.get(7).getY())
		.moveTo(1,1).release().perform();
		Thread.sleep(3000);
		//再滑动一次进行确认 
		ta.press(pList.get(0).getX(),pList.get(0).getY())
		.moveTo(pList.get(1).getX()-pList.get(0).getX(),pList.get(1).getY()-pList.get(0).getY())
		.moveTo(pList.get(2).getX()-pList.get(1).getX(),pList.get(2).getY()-pList.get(1).getY())
		.moveTo(pList.get(4).getX()-pList.get(2).getX(),pList.get(4).getY()-pList.get(2).getY())
		.moveTo(pList.get(6).getX()-pList.get(4).getX(),pList.get(6).getY()-pList.get(4).getY())
		.moveTo(pList.get(7).getX()-pList.get(6).getX(),pList.get(7).getY()-pList.get(6).getY())
		.moveTo(pList.get(8).getX()-pList.get(7).getX(),pList.get(8).getY()-pList.get(7).getY())
		.moveTo(1,1).release().perform();
		Thread.sleep(2000);
		driver.findElement(By.name("确认")).click();	
	}
	//
	public static void xiangduizuobiao(AndroidDriver<AndroidElement>driver) throws Exception{
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		driver.findElement(By.name("设置")).click();
		if (fengzhuang.isElememtExist(driver, By.name("锁屏和密码"))) {
			driver.findElement(By.name("锁屏和密码")).click();
		}else {
			fengzhuang.swipe(driver,"up", 2000);
			Thread.sleep(2000);
			driver.findElement(By.name("锁屏和密码")).click();
		}	
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"锁屏密码\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"图案\"]")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
		AndroidElement element=driver.findElement(By.id("com.android.settings:id/lockPattern"));
		Point p=element.getLocation();
		int x=p.getX();
		int y=p.getY();
		Dimension d=element.getSize();
		int width=d.getWidth();
		int height=d.getHeight();
		List<Point> pList=new ArrayList<Point>();
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				int center_x=x+(2*j+1)*width/6;
				int center_y=y+(2*i+1)*height/6;
				Point p1=new Point(center_x, center_y);
				pList.add(p1);
			}
		}
		
		TouchAction ta=new TouchAction(driver);
		ta.press(171,693).moveTo(358,693).moveTo(547,693).moveTo(361,880).moveTo(171,1066)
		.moveTo(358,1066).moveTo(547,1066).moveTo(1,1).release().perform();
		Thread.sleep(5000);
	}
	
	
	public static void login(AndroidDriver<AndroidElement> driver) throws Exception{
		
		Thread.sleep(2000);
		driver.findElement(By.name("我的")).click();
		if (driver.getPageSource().contains("个人信息")) {
			System.out.println("账号已经登录");
		} else {
			Thread.sleep(500);
			driver.findElement(By.name("请点击登录")).click();
			Thread.sleep(500);
			driver.findElement(By.name("使用其他方式登录")).click();
			Thread.sleep(500);
			driver.findElement(By.name("账号密码")).click();
			Thread.sleep(500);
			driver.findElement(By.id("com.sankuai.meituan:id/edit_account")).sendKeys("18025478840");
			Thread.sleep(500);
			driver.findElement(By.id("com.sankuai.meituan:id/edit_password")).sendKeys("62218852000duan");
			Thread.sleep(500);
			driver.findElement(By.name("登录")).click();
			Thread.sleep(2000);
			System.out.println(driver.getPageSource());
			if (driver.getPageSource().contains("个人信息")) {
				System.out.println("账号登录成功");
				fengzhuang.clickMenu(driver, 1);
			} else {
				System.out.println("登录失败");
			}

		}
	}
	
	public static void login_out(AndroidDriver<AndroidElement> driver) throws Exception{
		Thread.sleep(2000);
		driver.findElement(By.name("我的")).click();
		if (driver.getPageSource().contains("请点击登录")) {
			System.out.println("账号还未登录");
		} else {
			Thread.sleep(500);
			driver.findElement(By.id("com.sankuai.meituan:id/settings")).click();
			Thread.sleep(500);
			driver.findElement(By.name("退出账户")).click();
			Thread.sleep(500);
			driver.findElement(By.id("android:id/button1")).click();
			System.out.println("账号退出成功");
			fengzhuang.clickMenu(driver, 1);

		}
	}
	
	
	/**
	 * 打印倒数第三个
	 * 先是滑到底部，获取最后一屏的所有title，然后点倒数第三个
	 * 如何判断滑动到最后一屏
	 * 判断每次滑动前后的界面内容是否一致，如果一致则表示滑动到底部，在这里以每项设置的文本作为判断滑动屏幕是否一样的依据
	 * @author duanhao
	 * @param driver
	 * @param a 是要点击的第几个
	 * @param by传进来的元素对象
	 * @throws Exception
	 */
	public static void scollEndScrren(AndroidDriver<AndroidElement> driver,int a,By by) throws Exception{
		boolean flag=false;
		while(true){
			List<String> oldTexts=new ArrayList<String>();
			List<String> newTexts=new ArrayList<String>();
			
			List<AndroidElement> titles=driver.findElements(by);
			for(AndroidElement ae:titles){
				String text=ae.getText();
				oldTexts.add(text);
			}
			if(!flag){
				fengzhuang.swipe(driver, "up",1000);
			}else{
				titles.get(a).click();
				Thread.sleep(1000);
				break;
			}
			List<AndroidElement> titles1=driver.findElements(by);
			for(AndroidElement ae:titles1){
				String text=ae.getText();
				newTexts.add(text);
			}
			System.out.println(oldTexts.get(oldTexts.size()-1));
			System.out.println(newTexts.get(newTexts.size()-1));
			if(oldTexts.get(oldTexts.size()-1).equals(newTexts.get(newTexts.size()-1))){
				flag=true;
			}
//			if(oldTexts.size()==newTexts.size()){
//				for(int i=0;i<oldTexts.size();i++){
//					if(oldTexts.get(i).equals(newTexts.get(i))){
//						flag=true;
//						continue;
//					}else{
//						flag=false;
//						break;
//					}
//				}
//			}
			
		}
	}
	
	/**
	 * 返回的时间是以秒作为单位
	 * @author duanhao
	 * @param driver
	 * @param time
	 */
	public static void yinshiWait(AndroidDriver<AndroidElement> driver,int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	/**
	 * 截图
	 * @author duanhao
	 * @param driver
	 * @param filename
	 * @throws Exception
	 */
	public static void screenShort(AndroidDriver<AndroidElement> driver,String filename) throws Exception{
		File file = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("images\\"+filename+".png"));
		
	}
	/**
	 * 拖拽的方法封装
	 * @author duanhao
	 * @param driver
	 * @param startLocation：开始点的坐标位置
	 * @param endLocation：结束点的坐标位置
	 */
	public static void drag(AndroidDriver<AndroidElement> driver,By startLocation,By endLocation){
		TouchAction touchAction = new TouchAction(driver);
		AndroidElement start = driver.findElement(startLocation);
		AndroidElement end = driver.findElement(endLocation);
		touchAction.press(start).moveTo(end).release().perform();
		
		
	}
	
	/**
	 * 该方法用户对某个元素只能左滑后才能出现，该方法为知道元素出现为止
	 * swip方法为偏移量滑动，20位偏移量，持续时间1s
	 * @author duanhao
	 * @param driver
	 * @param by
	 */
	public static void pianyiLeft(AndroidDriver<AndroidElement> driver,By by){
		AndroidElement element = driver.findElement(by);
		element.swipe(SwipeElementDirection.LEFT, 20, 20, 1000);
	}
	
	/**
	 * 对不能定位到的手势密码元素进行定位，并且进行分割，然后定位元素中的每一个单元格，然后进行滑动
	 * @author duanhao
	 * @param driver
	 * @param by
	 * @throws Exception
	 */
	public static void shoushiLock(AndroidDriver<AndroidElement> driver,By by) throws Exception{
		AndroidElement element = driver.findElement(by);
		Point point = element.getLocation();
		int x = point.getX();
		int y = point.getY();
		Dimension dimension = element.getSize();
		int width = dimension.getWidth();
		int higth = dimension.getHeight();
		List<Point> points = new ArrayList<Point>();
		for(int i = 0;i<3;i++){
			for(int j = 0;j <3;j++){
				int center_x = x+(2*j+1)*width/6;
				int center_y = y+(2*i+1)*higth/6;
				Point point2 = new Point(center_x, center_y);
				points.add(point2);
			}
		}
		TouchAction touchAction = new TouchAction(driver);
		touchAction.press(points.get(0).getX(),points.get(0).getY())
		.moveTo(points.get(1).getX()-points.get(0).getX(),points.get(1).getY()-points.get(0).getY())
		.moveTo(points.get(2).getX()-points.get(1).getX(),points.get(2).getY()-points.get(1).getY())
		.moveTo(points.get(4).getX()-points.get(2).getX(),points.get(4).getY()-points.get(2).getY())
		.moveTo(points.get(6).getX()-points.get(4).getX(),points.get(6).getY()-points.get(4).getY())
		.moveTo(points.get(7).getX()-points.get(6).getX(),points.get(7).getY()-points.get(6).getY())
		.moveTo(points.get(8).getX()-points.get(7).getX(),points.get(8).getY()-points.get(7).getY())
		.release().perform();
		Thread.sleep(2000);
		
	}
	/**
	 * 判断屏幕是否锁定，如果锁定，则解锁
	 * @author duanhao
	 * @param driver
	 */
	public static void unlock(AndroidDriver<AndroidElement> driver){
		if(driver.isLocked()){
			driver.unlockDevice();
		}
		
	}
	/**
	 * 对鹿管家的首页四个菜单键进行点击，手起1
	 * @author duanhao
	 * @param driver
	 * @param order
	 */
	public static void ClickMenu(AndroidDriver<AndroidElement> driver,int order){
		driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout["+order+"]/android.widget.Button[1]")).click();
	}
	
	
	
	/**
	 * 封装了滑动查找元素并且点击
	 * @author duanhao
	 * @param driver
	 * @param by
	 * @throws Exception
	 */
	public static void isElementAndClick(AndroidDriver<AndroidElement> driver,By by) throws Exception{
		while(true){
			if(fengzhuang.isElememtExist(driver, by)){
				driver.findElement(by).click();
				break;
			}else {
				fengzhuang.swipe(driver, "up", 1000);
			}
		}
	}
	
	
	/**
	 * 封装了滑动查找元素
	 * @author duanhao
	 * @param driver
	 * @param by
	 * @return
	 */
	public static boolean isElememtExist(AndroidDriver<AndroidElement> driver,By by){
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	


}
