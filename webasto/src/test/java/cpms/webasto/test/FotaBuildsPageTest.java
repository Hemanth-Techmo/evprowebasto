package cpms.webasto.test;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cpms.webasto.base.TestBase;
import cpms.webasto.repository.DashboardPage;
import cpms.webasto.repository.FotaBuildsPage;
import cpms.webasto.repository.MaintenanceInventoryPage;
import cpms.webasto.repository.SignInPage;

public class FotaBuildsPageTest extends TestBase {

	public FotaBuildsPageTest() throws IOException {
		super();
	}
	SignInPage signIn;
	DashboardPage dashboard;
	MaintenanceInventoryPage inventory;
	FotaBuildsPage fotaBuild;

	@BeforeMethod
	public void launchBrowser() throws Exception {
		// Initialize Driver
		initializeDriver();
		signIn = new SignInPage();
		dashboard = signIn.logIn(prop.getProperty("email_Webasto_SuperAdmin_Devops"),
				prop.getProperty("password_Webasto_SuperAdmin_Devops"));
		inventory = new MaintenanceInventoryPage();
		fotaBuild=new FotaBuildsPage();
	}
	
	@Test
	public void addFotaBuild() throws Exception
	{
		inventory.maintenance().click();
		fotaBuild.fotaSideBarButton().click();
		fotaBuild.buildsSideBarButton().click();
		fotaBuild.addBuildButton().click();
		Select s=new Select(fotaBuild.selectModelDropdown());
		s.selectByVisibleText("JMR_evnpro_1264");
		fotaBuild.versionTextField().sendKeys("2.0");
		Select s1=new Select(fotaBuild.prerequisiteDropdown());
		s1.selectByIndex(2);
		String filePath="C:\\Users\\DELL\\Downloads\\Webasto_Ford_Setup_App_Release Notes_Final_Khk.doc";
		fotaBuild.chooseFirmwareFile().sendKeys(filePath);
		fotaBuild.chooseReleaseNotes().sendKeys(filePath);
		fotaBuild.saveButton().click();
		Thread.sleep(1000);
		try {
			boolean flagMsg=fotaBuild.buildAddedSuccessMessage().isDisplayed();
			System.out.println("New build is added sucessfully.");
			Assert.assertTrue(flagMsg);
		}
		catch(Exception e)
		{
			System.out.println("Build not added.");
		}
		try {
			boolean builExistFlag=fotaBuild.buildAlreadyExistMessage().isDisplayed();
			System.out.println("Build already exists with this model and version.");
			Assert.assertTrue(builExistFlag);
		}
		catch(Exception e)
		{
			System.out.println("Build added successfully");
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
