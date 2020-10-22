package cpms.webasto.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.excel.lib.util.Xls_Reader;

import cpms.webasto.base.TestBase;
import cpms.webasto.repository.ChargePointsOverviewPage;
import cpms.webasto.repository.DashboardPage;
import cpms.webasto.repository.MaintenanceInventoryPage;
import cpms.webasto.repository.SignInPage;
import junit.framework.Assert;

public class MaintenanceInventoryPageTest extends TestBase {
	SignInPage signIn;
	DashboardPage dashboard;
	MaintenanceInventoryPage inventory;
	ChargePointsOverviewPage chargePoint;

	public MaintenanceInventoryPageTest() throws Exception {
		super();
	}

	@BeforeMethod
	public void launchBrowser() throws IOException, InterruptedException {
		// Initialize Driver
		initializeDriver();
		signIn = new SignInPage();
		dashboard = signIn.logIn(prop.getProperty("email_Webasto_SuperAdmin_Devops"), prop.getProperty("password_Webasto_SuperAdmin_Devops"));
		inventory = new MaintenanceInventoryPage();
		chargePoint = new ChargePointsOverviewPage();
	}

	@Test(enabled=false)
	public void inventoryBulkImport() throws Exception {
		inventory.maintenance().click();
		inventory.inventory().click();
		inventory.bulkImport().click();
		inventory.chooseFile().sendKeys(prop.getProperty("bulkImportExcelPath"));
		Select s = new Select(inventory.bulkImportOrganisation());
		s.selectByVisibleText("WEBASTO");
		inventory.upload().click();
		// driver.switchTo().alert().accept();
		inventory.start().click();
		inventory.downloadBtn().click();
		Thread.sleep(5000);
		Xls_Reader reader = new Xls_Reader(prop.getProperty("bulkImportDownloadedExcelPath"));
		String sheetName = "Import Inventory";
		int rowCount = reader.getRowCount(sheetName);
		String status1 = "Record already saved";
		String status2 = "Successfully saved";
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			String rowData = reader.getCellData(sheetName, "Comments", rowNum);
			if (rowData == status1) {
				Assert.assertEquals(rowData, status1);
			} else if (rowData == status2) {
				Assert.assertEquals(rowData, status2);
			}
		}

		// Delete the downloaded excel file to not get any error on next time execution
		File importedExcelFile = new File(prop.getProperty("bulkImportDownloadedExcelPath"));
		importedExcelFile.delete();

	}

	@Test(enabled=false)
	public void chargePointFindInInventory() throws Exception {
		inventory.maintenance().click();
		inventory.inventory().click();
		//After Bulk Import, check the added Charge Points are present in Inventory.
		Xls_Reader reader = new Xls_Reader(prop.getProperty("bulkImportExcelPath"));
		String sheetName = "Import Inventory";
		int rowCount = reader.getRowCount(sheetName);
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			inventory.chargePointIDSearch().click();
			String rowData = reader.getCellData(sheetName, "Charge Point", rowNum);
			inventory.chargePointIDSearch().sendKeys(rowData);
			inventory.findBtn().click();
			inventory.chargePointIDSearch().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			try {
				boolean searchID = inventory.chargePointRow().isDisplayed();
				String searchIDName = inventory.chargePointRow().getText();
				if (searchID == true) {
					Assert.assertEquals(rowData, searchIDName);
					System.out.println("Searched CP ID " + rowData + " is present");
				}
			} catch (Exception e) {
				System.out.println("Searched CP ID " + rowData + " is not present");
			}

		}
	}

	@Test(enabled=true)
	public void reassignToOrganization() throws Exception {
		inventory.maintenance().click();
		inventory.inventory().click();
		String rows = "";
		List<String> chargeNames = null;
		// Upto 5 rows
		int rowsToReassign = 2;
		// Start from second row
		int rowStartFrom = 1;
		
		//Reassign Charge Points to Ford Organization
		for (int i = rowStartFrom; i < rowsToReassign; i++) {
			inventory.chargePointCheckBox().get(i).click();
			List<WebElement> cpNames = inventory.chargePointID();
			chargeNames = new ArrayList<String>();
			for (WebElement names : cpNames) {
				chargeNames.add(names.getText());
				}
		}
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(inventory.organisation()));
		Select s = new Select(inventory.organisation());
		s.selectByVisibleText("FORD");
		String reassignTxt = "REASSIGN";
		WebDriverWait w1 = new WebDriverWait(driver, 6);
		w1.until(ExpectedConditions.elementToBeClickable(inventory.reassignBtn()));
		String reassignBtn = inventory.reassignBtn().getText();
		if (reassignTxt.equals(reassignBtn)) {
			inventory.reassignBtn().click();
			Thread.sleep(3000);
		    inventory.yesButton().click();
			Thread.sleep(3000);
			try {
				inventory.dropdownOkBtn().click();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//Checking Reassigned Charge Points are still present in Inventory
		for (int i = rowStartFrom; i < rowsToReassign; i++) {
			rows = chargeNames.get(i);
			Thread.sleep(3000);
			inventory.maintenance().click();
			inventory.inventory().click();
			inventory.chargePointIDSearch().click();
			inventory.chargePointIDSearch().sendKeys(rows);
			inventory.findBtn().click();
			inventory.chargePointIDSearch().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			try {
				//boolean searchID = inventory.chargePointRow().isDisplayed();
				boolean idNotExist=chargePoint.cpIDNotExistsText().isDisplayed();
				if (idNotExist == true) {
					System.out.println("Searched CP ID " + rows + " is moved to FORD organisation");
				}
				else
				{
					String searchIDName = inventory.chargePointRow().getText();
					Assert.assertEquals(rows, searchIDName);
					System.out.println("Searched CP ID " + rows + " is not moved to FORD organisation");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        //Switch to FORD account
		Thread.sleep(4000);
		inventory.topRightDropdown().click();
		inventory.switchAccountBtn().click();
		Select se = new Select(inventory.switchAccDropdown());
		se.selectByVisibleText("FORD");
		 Thread.sleep(4000);
		inventory.dropdownOkBtn().click();
		// driver.navigate().refresh();
		 //driver.navigate().to(driver.getCurrentUrl());
		driver.get(driver.getCurrentUrl());
		 String[] orgText = inventory.verifyOrganisationText().getText().split(":");
		 String trimOrgText = orgText[1].trim();
		 Assert.assertEquals("FORD", trimOrgText);
		
        //Check the assigned Charge Points are present in FORD account inventory
		for (int i = rowStartFrom; i < rowsToReassign; i++) {
			rows = chargeNames.get(i);
			inventory.maintenance().click();
			inventory.inventory().click();
			inventory.chargePointIDSearch().click();
			inventory.chargePointIDSearch().sendKeys(rows);
			inventory.findBtn().click();
			inventory.chargePointIDSearch().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			try {
				Thread.sleep(3000);
			//	boolean searchID = inventory.chargePointRow().isDisplayed();
				boolean idNotExist=chargePoint.cpIDNotExistsText().isDisplayed();
				if (idNotExist == true) {
					System.out.println("Searched CP ID " + rows + " is not present in Inventory");
				}
				else
				{
					String searchIDName = inventory.chargePointRow().getText();
					Assert.assertEquals(rows, searchIDName);
					System.out.println("Searched CP ID " + rows + " is present in Inventory");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		chargePoint.chargePointsBtn().click();
		chargePoint.overviewBtn().click();
		
        //Check the assigned Charge Points are present in FORD account Overview page
		for (int i = rowStartFrom; i < rowsToReassign; i++) {
			rows = chargeNames.get(i);
			chargePoint.chargePointIDSearch().click();
			chargePoint.chargePointIDSearch().sendKeys(rows);
			chargePoint.findBtn().click();
			try {
				String searchIDName = driver
						.findElement(By.xpath("//*[@id='root']//div[4]//td[2]/a[text()='"+rows+"']")).getText();
				Assert.assertEquals(rows, searchIDName);
				System.out.println("Searched CP ID " + rows + " is present in Overview page");
				
			} catch (Exception e) {
				Thread.sleep(3000);
				boolean errorMsg = chargePoint.cpIDNotExistsText().isDisplayed();
				Assert.assertTrue(errorMsg);
				System.out.println("Searched CP ID " + rows + " is not present in Overview page");
			}
			chargePoint.chargePointIDSearch().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		}
		
		//Log off Organization
		inventory.topRightDropdown().click();
		Thread.sleep(3000);
		inventory.logOff().click();
		 String trimOrgText1 = orgText[1].trim();
		 Assert.assertEquals("WEBASTO", trimOrgText1);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
