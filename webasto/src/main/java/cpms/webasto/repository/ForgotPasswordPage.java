package cpms.webasto.repository;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cpms.webasto.base.TestBase;

public class ForgotPasswordPage extends TestBase {

	public ForgotPasswordPage() throws IOException {
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(xpath="//a[text()='Forgot password?']")
	WebElement forgotPassword;

	@FindBy(id="email")
	WebElement email;
	public WebElement email()
	{
		return email;
	}
	
	@FindBy(css="button[type='submit']")
	WebElement submitBtn;
	public WebElement submitBtn()
	{
		return submitBtn;
	}
	
	@FindBy(xpath="//*[@id='root']//div[2]")
	WebElement successMsg;
	public WebElement successMsg()
	{
		return successMsg;
	}
	
	public ForgotPasswordPage clickOnForgot() throws IOException
	{
		forgotPassword.click();
		return new ForgotPasswordPage();
	}
}
