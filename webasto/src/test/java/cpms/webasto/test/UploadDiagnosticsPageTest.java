package cpms.webasto.test;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cpms.webasto.base.TestBase;
import cpms.webasto.miscellaneous.GenericClass;
import cpms.webasto.repository.DashboardPage;
import cpms.webasto.repository.MaintenanceInventoryPage;
import cpms.webasto.repository.SelectChargePointModel;
import cpms.webasto.repository.SignInPage;
import cpms.webasto.repository.UploadDiagnosticsPage;

public class UploadDiagnosticsPageTest extends TestBase{

	public UploadDiagnosticsPageTest() throws IOException {
		super();
	}

	SignInPage signIn;
	DashboardPage dashboard;
	UploadDiagnosticsPage uploadDiagnostics;
	MaintenanceInventoryPage inventory;
	SelectChargePointModel selectChargePoint;	
	GenericClass extractFile;
	
	@BeforeMethod
	public void launchBrowser() throws Exception {
		// Initialize Driver
		initializeDriver();
		signIn = new SignInPage();
		dashboard = signIn.logIn(prop.getProperty("email_Webasto_SuperAdmin_Devops"),
				prop.getProperty("password_Webasto_SuperAdmin_Devops"));
		uploadDiagnostics=new UploadDiagnosticsPage();
		inventory = new MaintenanceInventoryPage();
		selectChargePoint=new SelectChargePointModel();
		extractFile=new GenericClass();
	}
	
	@Test(priority=4)
	public void uploadDiagnostics() throws Exception
	{
		inventory.maintenance().click();
		uploadDiagnostics.uploadDiagnosticsSideBar().click();
		selectChargePoint.selectChargePointBtn().click();
		String chargePointID="JMSRE142";
		selectChargePoint.selectCheckBox(chargePointID);
		Thread.sleep(2000);
		String selectedChargePoint=selectChargePoint.selectedChargePoint().getText();
		if(selectedChargePoint.equalsIgnoreCase(chargePointID))
		{
			Thread.sleep(1000);
			selectChargePoint.doneBtn().click();
		}
		
		String fileName=extractFile.extractFileName();		
		String filePath="C:\\Users\\DELL\\Downloads\\"+fileName+"";
		System.out.println(filePath);
		uploadDiagnostics.chooseDiagnosticsFile().sendKeys(filePath);
		uploadDiagnostics.performButton().click();
		WebDriverWait wait = new WebDriverWait(driver, 6);
		try {
		wait.until(ExpectedConditions.visibilityOf(uploadDiagnostics.diagnosticsUploadedSuccessMsg()));
		boolean sucessMsgFlag=uploadDiagnostics.diagnosticsUploadedSuccessMsg().isDisplayed();
		Assert.assertTrue(sucessMsgFlag);
		String sucessMsg=uploadDiagnostics.diagnosticsUploadedSuccessMsg().getText();
		System.out.println(sucessMsg);
		}
		catch(Exception e)
		{
			System.out.println("Diagnostics not uploaded");
		}
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
