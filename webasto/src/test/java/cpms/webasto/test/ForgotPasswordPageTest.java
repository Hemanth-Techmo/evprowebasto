package cpms.webasto.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cpms.webasto.base.TestBase;
import cpms.webasto.repository.ForgotPasswordPage;
import junit.framework.Assert;

public class ForgotPasswordPageTest extends TestBase{
	
	ForgotPasswordPage forgotPwd;

	public ForgotPasswordPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void launchBrowser() throws IOException, InterruptedException {
		// Initialize Driver
		initializeDriver();
		forgotPwd=new ForgotPasswordPage();
	}
	
	@Test
	public void forgotPassword() throws IOException, InterruptedException
	{
		forgotPwd.clickOnForgot();
		forgotPwd.email().click();
		forgotPwd.email().sendKeys(prop.getProperty("resetEmail_Webasto_SuperAdmin_Devops"));
		forgotPwd.submitBtn().click();
		Thread.sleep(2000);
		String successMsg=forgotPwd.successMsg().getText();
		String text="An email has been sent to the supplied email address.Follow the instructions in the email to reset your password.";
		Assert.assertEquals(text, successMsg);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
