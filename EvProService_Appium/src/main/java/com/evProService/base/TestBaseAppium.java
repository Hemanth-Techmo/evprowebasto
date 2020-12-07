package com.evProService.base;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBaseAppium {
	
	public static AndroidDriver<WebElement> driver;
	public static Properties prop;
	
public TestBaseAppium() throws Exception
{
	prop = new Properties();
	FileInputStream fis = new FileInputStream(
			"C:\\Users\\DELL\\eclipse-workspace\\EvProService_Appium\\src\\main\\java\\com\\evProService\\properties\\propertiesAppium");
	prop.load(fis);
}
	public static void initialization() throws Exception
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
		//For Real Device
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		//For Virtual Device
		//dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\DELL\\Downloads\\ChargeConnectApp30Nov.apk");
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		driver=new AndroidDriver<WebElement>(url,dc);
		Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
