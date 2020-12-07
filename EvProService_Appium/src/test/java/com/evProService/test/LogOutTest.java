package com.evProService.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.evProService.base.TestBaseAppium;
import com.evProService.repository.SettingsScreen;
import com.evProService.repository.SignInScreen;

public class LogOutTest extends TestBaseAppium {

	SignInScreen signInScreen;
	SettingsScreen settingsScreen;

	public LogOutTest() throws Exception {
		super();
	}

	@BeforeMethod
	public void launchApplication() throws Exception {
		initialization();
		signInScreen = new SignInScreen();
		settingsScreen = new SettingsScreen();
	}

	@Test
	public void logOut() throws Exception {
		signInScreen.signIn(prop.getProperty("email_Webasto_SuperAdmin_Devops"),
				prop.getProperty("password_Webasto_SuperAdmin_Devops"));
		settingsScreen.MoreButtonBottomLayout().click();
		settingsScreen.SettingsButton();
		Assert.assertEquals(settingsScreen.settingsHeaderText().getText(), "Settings");
		settingsScreen.logoutButton().click();
		Assert.assertEquals(settingsScreen.logoutConfirmationPopupText().getText(),
				"Are you sure you want to logout now?");
		settingsScreen.confirmLogoutOKButton().click();
		Assert.assertEquals(settingsScreen.logoutSuccessfulPopupText().getText(), "Logged out successfully");
		System.out.println("Logged out successfully");
		settingsScreen.logoutSuccessfulOKButton();
		boolean logoPresent=signInScreen.webastoLogoImage().isDisplayed();
		Assert.assertTrue(logoPresent);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}