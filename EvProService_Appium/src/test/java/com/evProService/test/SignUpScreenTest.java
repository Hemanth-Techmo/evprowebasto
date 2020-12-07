package com.evProService.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.evProService.base.TestBaseAppium;
import com.evProService.repository.SignInScreen;
import com.evProService.repository.SignUpScreen;

public class SignUpScreenTest extends TestBaseAppium{
	 SignInScreen signInScreen;
	 SignUpScreen signUpScreen;
	
	public SignUpScreenTest() throws Exception {
		super();
	}
	@BeforeMethod
	public void launchApplication() throws Exception
	{
       initialization();
       signInScreen=new SignInScreen();
       signUpScreen=new SignUpScreen();
    }
	
	@Test
	public void signUp() throws Exception
	{
		driver.navigate().back();
		signUpScreen=signInScreen.createNewAccountButton();
		if(signUpScreen.signUpHeaderText().isDisplayed()==true)
		{
			signUpScreen.fisrtNameTextField().sendKeys(prop.getProperty("firstName"));
			signUpScreen.lastNameTextField().sendKeys(prop.getProperty("lastName"));
			signUpScreen.emailTextField().sendKeys(prop.getProperty("email_Webasto_SuperAdmin_Devops"));
			signUpScreen.passwordTextField().sendKeys(prop.getProperty("password_Webasto_SuperAdmin_Devops"));
			signUpScreen.confirmPasswordTextField().sendKeys(prop.getProperty("password_Webasto_SuperAdmin_Devops"));
			signUpScreen.termsConditionsCheckbox().click();
			Assert.assertTrue(signUpScreen.termsConditionsText().isDisplayed()); 
			signUpScreen.submitButton().click();	
			try {
				if(signUpScreen.accountCreatedPopUpText().isDisplayed()==true)
				{
					String successMsg=signUpScreen.accountCreatedPopUpText().getText();
					String accountCreated="Your Account has been successfully created.";
					Assert.assertEquals(successMsg, accountCreated);
					signInScreen=signUpScreen.popUpOkButton();
					Assert.assertTrue(signInScreen.webastoLogoImage().isDisplayed());
					System.out.println(accountCreated);
				}
			}
				catch(Exception e)
				{
					String accountExist=signUpScreen.userAlreadyExistsPopUpText().getText();
					String userAlreadyExists="User already exists";
					Assert.assertEquals(accountExist, userAlreadyExists);
					signUpScreen.popUpOkButton();
					System.out.println(userAlreadyExists);	
				}
			}	
		}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
