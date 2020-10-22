package cpms.webasto.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cpms.webasto.base.TestBase;
import cpms.webasto.repository.DashboardPage;
import cpms.webasto.repository.GetDiagnosticsPage;
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
	}
	
	@Test(priority=3)
	public void uploadDiagnostics() throws Exception
	{
		inventory.maintenance().click();
		uploadDiagnostics.uploadDiagnosticsSideBar().click();
		selectChargePoint.selectChargePointBtn().click();
		String chargePointID="JMSTE146";
		selectChargePoint.selectCheckBox(chargePointID);
		String selectedChargePoint=selectChargePoint.selectedChargePoint().getText();
		if(selectedChargePoint.equalsIgnoreCase(chargePointID))
		{
			selectChargePoint.doneBtn().click();
		}
		uploadDiagnostics.chooseDiagnosticsFile().sendKeys("");
		uploadDiagnostics.performButton().click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
