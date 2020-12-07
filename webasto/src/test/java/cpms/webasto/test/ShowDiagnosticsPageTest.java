package cpms.webasto.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cpms.webasto.base.TestBase;
import cpms.webasto.miscellaneous.GenericClass;
import cpms.webasto.repository.DashboardPage;
import cpms.webasto.repository.MaintenanceInventoryPage;
import cpms.webasto.repository.ShowDiagnosticsPage;
import cpms.webasto.repository.SignInPage;
import cpms.webasto.repository.UploadDiagnosticsPage;

public class ShowDiagnosticsPageTest extends TestBase {
	public ShowDiagnosticsPageTest() throws IOException {
		super();
	}

	SignInPage signIn;
	DashboardPage dashboard;
	UploadDiagnosticsPage uploadDiagnostics;
	MaintenanceInventoryPage inventory;
	ShowDiagnosticsPage showDiagnostics;
	GenericClass extractFile;

	@BeforeMethod
	public void launchBrowser() throws Exception {
		// Initialize Driver
		initializeDriver();
		signIn = new SignInPage();
		dashboard = signIn.logIn(prop.getProperty("email_Webasto_SuperAdmin_Devops"),
				prop.getProperty("password_Webasto_SuperAdmin_Devops"));
		uploadDiagnostics = new UploadDiagnosticsPage();
		inventory = new MaintenanceInventoryPage();
		showDiagnostics = new ShowDiagnosticsPage();
		extractFile=new GenericClass();
	}

	@Test(priority=5)
	public void showDiagnostics() {
		inventory.maintenance().click();
		showDiagnostics.showDiagnosticsSideBarBtn().click();
		String fileName=extractFile.extractFileName();
		List<WebElement> fromList = showDiagnostics.fileNameColumn();
		for (WebElement option : fromList) {
			if (option.getText().contains(fileName)) {
				System.out.println("File Name Exists");
				break;
			}
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
