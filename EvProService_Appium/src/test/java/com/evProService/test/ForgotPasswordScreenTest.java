package com.evProService.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.evProService.base.TestBaseAppium;
import com.evProService.repository.ForgotPasswordScreen;
import com.evProService.repository.SignInScreen;

public class ForgotPasswordScreenTest extends TestBaseAppium {
	
	SignInScreen signInScreen;
	ForgotPasswordScreen forgotPasswordScreen;

	public ForgotPasswordScreenTest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void launchApplication() throws Exception
	{
       initialization();
       Thread.sleep(5000);
       signInScreen=new SignInScreen();
       forgotPasswordScreen=new ForgotPasswordScreen();
	}
	
	@Test
	public void forgotPassword() throws Exception
	{
		forgotPasswordScreen=signInScreen.forgotPasswordButton();
		String headerText=forgotPasswordScreen.forgotPasswordHeaderText().getText();
		Assert.assertEquals(headerText, "Forgot Password");
		forgotPasswordScreen.emailTextField().sendKeys("testk4@gmail.com");
		forgotPasswordScreen.submitButton().click();
		Assert.assertTrue(forgotPasswordScreen.passwordSentToMailText().isDisplayed());
		forgotPasswordScreen.popUpOkButton().click();
		Assert.assertTrue(signInScreen.webastoLogoImage().isDisplayed());	
	}
}
