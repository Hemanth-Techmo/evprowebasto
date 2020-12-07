package com.evProService.test;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.evProService.base.TestBaseAppium;
import com.evProService.repository.AddYourOwnChargerScreen;
import com.evProService.repository.ChargingPointsScreen;
import com.evProService.repository.DashboardScreen;
import com.evProService.repository.SignInScreen;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class SignInScreenTest extends TestBaseAppium {

	SignInScreen signInScreen;
	DashboardScreen dashboard;
	AddYourOwnChargerScreen ownCharger;
	ChargingPointsScreen chargingPoint;

	public SignInScreenTest() throws Exception {
		super();
	}

	@BeforeMethod
	public void openApplication() throws Exception {
		initialization();
		Thread.sleep(5000);
		signInScreen = new SignInScreen();
		dashboard = new DashboardScreen();
		ownCharger = new AddYourOwnChargerScreen();
		chargingPoint = new ChargingPointsScreen();
	}

	@Test(enabled = false)
	public void signIn() throws Exception {
		signInScreen.signIn(prop.getProperty("email_Webasto_SuperAdmin_Devops"),
				prop.getProperty("password_Webasto_SuperAdmin_Devops"));
	}

	@Test(enabled = true)
	public void signInAddOwnCharger() throws Exception {
		signInScreen.signIn(prop.getProperty("email_Webasto_SuperAdmin_Devops"),
				prop.getProperty("password_Webasto_SuperAdmin_Devops"));

		try {
			if (ownCharger.ownChargerText().getText().equalsIgnoreCase("Do you have an own charger?")) {
				ownCharger = ownCharger.ownChargerYesButton();
				ownCharger.step1NextButton().click();
				ownCharger.wlanHotspotSSIDTextField().sendKeys("hemanth");
				ownCharger.wlanHotspotPasswordTextField().sendKeys("hemanth@545");
				driver.navigate().back();
				for (int i = 1; i <= 2; i++) {
					ownCharger.step2ConnectButton().click();
				}
				ownCharger.accessDeviceLocationPermission().click();
				Thread.sleep(3000);
				ownCharger.addChargerButton().click();
				ownCharger.addChargerChargePointIDTextField().sendKeys("WebDec123");
				Thread.sleep(2000);
				driver.navigate().back();
				ownCharger.addChargerSearchButton().click();
				String randomString = RandomStringUtils.randomNumeric(2);
				String chargerName = "ChargerTest" + randomString;
				ownCharger.chargePointNameTextField().sendKeys(chargerName);
				// Scroll till Next button
				MobileElement nextButton = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"Next\"));"));
				nextButton.click();
				ownCharger.addChargerHouseNumberTextField().sendKeys("1-23/B");
				ownCharger.addChargerStreetTextField().sendKeys("Hyper Street");
				ownCharger.addChargerCityTextField().sendKeys("Hyderabad");
				ownCharger.addChargerZipCodeTextField().sendKeys("500318");
				ownCharger.addChargerCountryTextField().sendKeys("India");
				ownCharger.addChargerSubmitButton().click();
				Thread.sleep(2000);
				try {
					if (ownCharger.chargerInUseAlertText().isDisplayed() == true) {
						System.out.println(ownCharger.chargerInUseAlertText().getText());
						ownCharger = ownCharger.chargerInUseAlertOkButton();		
					}
				} catch (Exception e1) {
					boolean cpName = driver.findElementByXPath("//android.widget.TextView[@text='" + chargerName + "']")
							.isDisplayed();
					Assert.assertTrue(cpName);
					System.out.println("Charger added successfully");
				}
			} 
		} catch (Exception e) {
			Assert.assertEquals(dashboard.dashboardHeaderText().getText(), "Dashboard");
			WebElement userName = driver.findElement(By.xpath("//android.widget.TextView[@text='"
					+ prop.getProperty("firstName") + " " + prop.getProperty("lastName") + "']"));
			String actualUserName = userName.getText();
			String expectedUserName = prop.getProperty("firstName") + " " + prop.getProperty("lastName");
			Assert.assertEquals(actualUserName, expectedUserName);
		}
	}

	@Test(enabled = false)
	public void signInNoAddOwnCharger() throws Exception {
		signInScreen.signIn(prop.getProperty("email_Webasto_SuperAdmin_Devops"),
				prop.getProperty("password_Webasto_SuperAdmin_Devops"));
		try {
			if (ownCharger.ownChargerText().getText().equalsIgnoreCase("Do you have an own charger?")) {
				chargingPoint = ownCharger.ownChargerNoButton();
			}
		} catch (Exception e) {
			try {
				Assert.assertEquals(dashboard.dashboardHeaderText().getText(), "Dashboard");
				WebElement userName = driver.findElement(By.xpath("//android.widget.TextView[@text='"
						+ prop.getProperty("firstName") + " " + prop.getProperty("lastName") + "']"));
				String actualUserName = userName.getText();
				String expectedUserName = prop.getProperty("firstName") + " " + prop.getProperty("lastName");
				Assert.assertEquals(actualUserName, expectedUserName);
			} catch (Exception e1) {
				System.out.println("Username Not Matched");
			}
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
