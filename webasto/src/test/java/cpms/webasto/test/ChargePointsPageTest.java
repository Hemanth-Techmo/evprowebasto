package cpms.webasto.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.excel.lib.util.Xls_Reader;

import cpms.webasto.base.TestBase;
import cpms.webasto.repository.ChargePointsPage;
import cpms.webasto.repository.DashboardPage;
import cpms.webasto.repository.SignInPage;
import junit.framework.Assert;

public class ChargePointsPageTest extends TestBase {
	SignInPage signIn;
	DashboardPage dashboard;
	ChargePointsPage chargePoint;

	public ChargePointsPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void launchBrowser() throws IOException, InterruptedException {
		// Initialize Driver
		initializeDriver();
		signIn = new SignInPage();
		dashboard = signIn.logIn(prop.getProperty("email_Webasto_SuperAdmin_Devops"), prop.getProperty("password_Webasto_SuperAdmin_Devops"));
		chargePoint = new ChargePointsPage();
	}

	@Test
	public void searchCreatedChargePoints() throws Exception {

		chargePoint.chargePointsBtn().click();
		chargePoint.overviewBtn().click();
		chargePoint.chargePointIDSearch().click();

		Xls_Reader reader = new Xls_Reader(prop.getProperty("bulkImportDownloadedExcelPath"));
		String sheetName = "Import Inventory";
		int rowCount = reader.getRowCount(sheetName);

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			String rowData = reader.getCellData(sheetName, "Charge Point", rowNum);
			chargePoint.chargePointIDSearch().sendKeys(rowData);
			chargePoint.findBtn().click();
			try {
				String searchIDName = driver
						.findElement(By.xpath("//*[@id='root']//div[4]//td[2]/a[text()=" + rowData + "]")).getText();
				Assert.assertEquals(rowData, searchIDName);
				System.out.println("Searched CP ID"+ rowData +"is present in Overview page");
			} catch (Exception e) {
				Thread.sleep(2000);
				boolean errorMsg = chargePoint.cpIDNotExistsText().isDisplayed();
				Assert.assertTrue(errorMsg);
				System.out.println("Searched CP ID " + rowData + " is not present in Overview page");
			}
			chargePoint.chargePointIDSearch().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
