package cpms.webasto.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cpms.webasto.base.TestBase;
import cpms.webasto.repository.DashboardPage;
import cpms.webasto.repository.SignInPage;

public class SignInPageTest extends TestBase
{
	SignInPage signIn;
	DashboardPage dashboard;  
    public SignInPageTest() throws Exception
    {
    	super();
    }
    
    @BeforeMethod
	public void launchBrowser() throws Exception
	{
		//Initialize Driver
		initializeDriver();
		signIn=new SignInPage();
		
	}
    
    @Test
    public void signInPageTest() throws Exception
    {
    	dashboard=signIn.logIn(prop.getProperty("email_Webasto_SuperAdmin_Devops"), prop.getProperty("password_Webasto_SuperAdmin_Devops"));
    }
    
    @AfterMethod
   	public void tearDown() 
   	{
   		driver.quit();
   	}
    
   
}
