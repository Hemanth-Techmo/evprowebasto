package com.evProService.test;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.evProService.base.TestBaseAppium;
import com.evProService.repository.ChangePasswordScreen;
import com.evProService.repository.SettingsScreen;
import com.evProService.repository.SignInScreen;

public class ChangePasswordScreenTest extends TestBaseAppium {

	SignInScreen signInScreen;
	SettingsScreen settingsScreen;
	ChangePasswordScreen changePasswordScreen;

	public ChangePasswordScreenTest() throws Exception {
		super();
	}

	@BeforeMethod
	public void launchApplication() throws Exception {
		initialization();
		signInScreen = new SignInScreen();
		settingsScreen = new SettingsScreen();
		changePasswordScreen = new ChangePasswordScreen();
	}

	@Test
	public void changePassword() throws Exception {
		signInScreen.signIn(prop.getProperty("email_Webasto_SuperAdmin_Devops"),
				prop.getProperty("password_Webasto_SuperAdmin_Devops"));
		settingsScreen.MoreButtonBottomLayout().click();
		settingsScreen.SettingsButton();
		Assert.assertEquals(settingsScreen.settingsHeaderText().getText(), "Settings");
		settingsScreen.changePasswordButton();
		Assert.assertEquals(changePasswordScreen.changePasswordHeaderText().getText(), "Change Password");
		boolean webastoLogo = changePasswordScreen.changePasswordWebastoLogo().isDisplayed();
		Assert.assertTrue(webastoLogo);
		changePasswordScreen.oldPasswordTextField().sendKeys(prop.getProperty("password_Webasto_SuperAdmin_Devops"));
		changePasswordScreen.newPasswordTextField().sendKeys(prop.getProperty("changePassword_New"));
		changePasswordScreen.confirmPasswordTextField().sendKeys(prop.getProperty("changePassword_New"));
		changePasswordScreen.submitButton().click();
		// To change password
		try {
			Assert.assertEquals(changePasswordScreen.passwordChangedSuccessPopupText().getText(),
					"Change password is done successfully. Please login with new credentials.");
			System.out.println("Change password is done successfully. Please login with new credentials.");
			changePasswordScreen.popupOkButton().click();
			Assert.assertEquals(settingsScreen.logoutSuccessfulPopupText().getText(), "Logged out successfully");
			settingsScreen.logoutSuccessfulOKButton();
			boolean logoPresent = signInScreen.webastoLogoImage().isDisplayed();
			Assert.assertTrue(logoPresent);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		// For invalid Old password
		try {
			Assert.assertEquals(changePasswordScreen.oldPasswordNotMatchedPopupText().getText(),
					"Old password does not match");
			System.out.println("Old password does not match");
			changePasswordScreen.popupOkButton().click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		// For character limit
		try {
			Assert.assertEquals(changePasswordScreen.passwordLimitPopupText().getText(),
					"Password should be atleast 8-20 characters");
			System.out.println("Password should be atleast 8-20 characters");
			changePasswordScreen.popupOkButton().click();
		}

		catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
