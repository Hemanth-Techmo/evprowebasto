package cpms.webasto.repository;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cpms.webasto.base.TestBase;

public class SignInPage extends TestBase {
	
	public SignInPage() throws IOException
	{
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	
	@FindBy(css="input[id='txtCaptcha']")
	WebElement txtCaptcha;
	
	public WebElement txtCaptcha()
	{
		return txtCaptcha;
	}
	
	@FindBy(css="input[placeholder='Enter the Captcha']")
	WebElement captcha;
	
	
	@FindBy(css="button[type='submit']")
	WebElement signInButn;
	
	@FindBy(xpath="//*[@id='navbar']//p")
	WebElement dashboardText;

	public DashboardPage logIn(String mail, String pwd) throws InterruptedException, IOException 
	{
		email.sendKeys(mail);
		password.click();
		password.sendKeys(pwd);
		captcha.click();
		
		
		//WebElement img = driver.findElement(By.cssSelector("input#txtCaptcha.input_captcha"));
		// img.getCssValue("background-image");
				// System.out.println(imgpath);	
		 
		 
    	Thread.sleep(8000);
    	signInButn.click();
    	return new DashboardPage();
    	
	}
}
