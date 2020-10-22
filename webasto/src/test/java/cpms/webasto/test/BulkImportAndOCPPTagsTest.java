package cpms.webasto.test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.excel.lib.util.Xls_Reader;

import cpms.webasto.base.TestBase;
import cpms.webasto.repository.CalendarWidget;
import cpms.webasto.repository.ChargePointsOcppTagsPage;
import cpms.webasto.repository.ChargePointsOverviewPage;
import cpms.webasto.repository.DashboardPage;
import cpms.webasto.repository.MaintenanceInventoryPage;
import cpms.webasto.repository.SignInPage;
import junit.framework.Assert;

public class BulkImportAndOCPPTagsTest extends TestBase {
	SignInPage signIn;
	DashboardPage dashboard;
	MaintenanceInventoryPage inventory;
	ChargePointsOverviewPage chargePoint;
	ChargePointsOcppTagsPage ocppTagsPage;
	CalendarWidget calWidget;

	public BulkImportAndOCPPTagsTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void launchBrowser() throws Exception {
		initializeDriver();
		signIn = new SignInPage();
		dashboard = signIn.logIn(prop.getProperty("email_Webasto_SuperAdmin_Devops"),
				prop.getProperty("password_Webasto_SuperAdmin_Devops"));
		inventory = new MaintenanceInventoryPage();
		chargePoint = new ChargePointsOverviewPage();
		ocppTagsPage = new ChargePointsOcppTagsPage();
		calWidget=new CalendarWidget();
	}

	@Test(enabled = false)
	public void bulkImportForDifferentTenants() throws Exception {
		String s1[] = { "WEBASTO", "FORD", "GilchingOperational" };
		for (int i = 0; i <= s1.length - 1; i++) {
			inventory.maintenance().click();
			inventory.inventory().click();
			inventory.bulkImport().click();
			inventory.chooseFile().sendKeys(prop.getProperty("bulkImportExcelPath"));
			Select s = new Select(inventory.bulkImportOrganisation());
			s.selectByVisibleText(s1[i]);
			inventory.upload().click();
			// driver.switchTo().alert().accept();
			inventory.start().click();
			inventory.downloadBtn().click();
			Thread.sleep(5000);
			Xls_Reader reader = new Xls_Reader(prop.getProperty("bulkImportDownloadedExcelPath"));
			String sheetName = "Import_Inventory_Dev";
			int rowCount = reader.getRowCount(sheetName);
			String status1 = "Record already saved";
			String status2 = "Successfully saved";
			String status3 = "Please verify the Organization ID";
			System.out.println("*****" + s1[i] + "*****");
			for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
				String rowData = reader.getCellData(sheetName, "Comments", rowNum);
				if (rowData == status1) {
					Assert.assertEquals(rowData, status1);
				} else if (rowData == status2) {
					Assert.assertEquals(rowData, status2);
				} else if (rowData == status3) {
					Assert.assertEquals(rowData, status3);
				}
				System.out.println("row " + rowNum + " comment:" + rowData);
				// Delete the downloaded excel file to not get any error on next time execution
				File importedExcelFile = new File(prop.getProperty("bulkImportDownloadedExcelPath"));
				importedExcelFile.delete();
				Thread.sleep(2000);
			}

		}
	}
	
	@Test
	public void addOCPPTag() throws Exception {
		chargePoint.chargePointsBtn().click();
		ocppTagsPage.ocppTagsSideBar().click();
		Xls_Reader reader = new Xls_Reader(prop.getProperty("bulkImportExcelPath"));
		String sheetName = "OCPP Tags";
		int rowCount = reader.getRowCount(sheetName);
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			String tagIdRow1 = reader.getCellData(sheetName, "Tag ID", rowNum);
			String tenantRow1 = reader.getCellData(sheetName, "Tenant", rowNum);
			if (tenantRow1.equalsIgnoreCase("webasto")) {
				ocppTagsPage.ocppAddButton().click();
				ocppTagsPage.idTagTextField().click();
				ocppTagsPage.idTagTextField().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				Thread.sleep(1000);
				ocppTagsPage.idTagTextField().sendKeys(tagIdRow1);
				ocppTagsPage.expiryDateTime().click();
				calWidget.currentMonth().click();
				calWidget.lastDateInWidget().click();
				ocppTagsPage.idTagTextField().click();
				ocppTagsPage.saveButton().click();
//			Timestamp timeStamp=new Timestamp(System.currentTimeMillis());
				try {
					boolean idTagAlreadyExist = ocppTagsPage.idTagExistErrorMessage().isDisplayed();
					if (idTagAlreadyExist == true) {
						System.out.println("Entered OCPP Tag " + tagIdRow1 + " is already exist.");
					}
				} catch (Exception e) {
					ocppTagsPage.ocppTagSuccessMessage().click();
					System.out.println("OCPP Tag " + tagIdRow1 + " successfully added.");
				}
				Thread.sleep(2000);
			}
		}

		String s1[] = { "FORD", "GilchingOperational" };
		for (int i = 0; i <= s1.length-1; i++) {
			inventory.topRightDropdown().click();
			inventory.switchAccountBtn().click();
			Select se = new Select(inventory.switchAccDropdown());
			se.selectByVisibleText(s1[i]);
			inventory.dropdownOkBtn().click();
			 driver.navigate().refresh();
			 //driver.navigate().to(driver.getCurrentUrl());
			//driver.get(driver.getCurrentUrl());
			Thread.sleep(12000);
			
			for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
				String tagIdRow2 = reader.getCellData(sheetName, "Tag ID", rowNum);
				String tenantRow2 = reader.getCellData(sheetName, "Tenant", rowNum);
				if (tenantRow2.equalsIgnoreCase(s1[i])) {
					ocppTagsPage.ocppAddButton().click();
					ocppTagsPage.idTagTextField().click();
					ocppTagsPage.idTagTextField().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
					Thread.sleep(2000);
					ocppTagsPage.idTagTextField().sendKeys(tagIdRow2);
					ocppTagsPage.expiryDateTime().click();
					calWidget.currentMonth().click();
					calWidget.lastDateInWidget().click();
					ocppTagsPage.idTagTextField().click();
					ocppTagsPage.saveButton().click();
//			Timestamp timeStamp=new Timestamp(System.currentTimeMillis());
					try {
						boolean idTagAlreadyExist = ocppTagsPage.idTagExistErrorMessage().isDisplayed();
						if (idTagAlreadyExist == true) {
							System.out.println("Entered OCPP Tag " + tagIdRow2 + " is already exist.");
						}
					} catch (Exception e) {
						ocppTagsPage.ocppTagSuccessMessage().click();
						System.out.println("OCPP Tag " + tagIdRow2 + " successfully added.");

					}
					Thread.sleep(2000);
				}
			}
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
