package cpms.webasto.repository;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cpms.webasto.base.TestBase;

public class MaintenanceInventoryPage extends TestBase {

	public MaintenanceInventoryPage() throws IOException
	{
		PageFactory.initElements(driver, this); 
	}
	@FindBy(xpath="//*[@id='slide-out']//li[8]/div[1]//a")
	WebElement maintenance;
	public WebElement maintenance()
	{
		return maintenance;
	}
	
	@FindBy(xpath="//a[text()=' Inventory']")
	WebElement inventory;
	public WebElement inventory()
	{
		return inventory;
	}
	
	@FindBy(xpath="//span[text()='Bulk Import']")
	WebElement bulkImport;
	public WebElement bulkImport()
	{
		return bulkImport;
	}
	
	@FindBy(id="exampleFile")
	WebElement chooseFile;
	public WebElement chooseFile()
	{
		return chooseFile;
	}
	
	@FindBy(xpath="//select[@id='organization']")
	WebElement organisation;
	public WebElement organisation()
	{
		return organisation;
	}
	
	@FindBy(xpath="//select[@id='organisation']")
	WebElement bulkImportOrganisation;
	public WebElement bulkImportOrganisation()
	{
		return bulkImportOrganisation;
	}
	
	@FindBy(xpath="//*[@id='root']//button[1]")
	WebElement upload;
	public WebElement upload()
	{
		return upload;
	}
	@FindBy(xpath="//*[@id='root']//button[2]")
	WebElement start;
	public WebElement start()
	{
		return start;
	}
	@FindBy(xpath="//*[@id='root']//button[2]")
	WebElement okBtn;
	public WebElement okBtn()
	{
		return okBtn;
	}
	@FindBy(xpath="//*[@id='root']//button[1]/a")
	WebElement downloadBtn;
	public WebElement downloadBtn()
	{
		return downloadBtn;
	}
	
	@FindBy(xpath="//*[@id='root']//div[3]/div//div/input[1]")
	WebElement chargePointIDSearch;
	public WebElement chargePointIDSearch()
	{
		return chargePointIDSearch;
	}
	
	@FindBy(xpath="//*[@id='root']//div[2]/button")
	WebElement findBtn;
	public WebElement findBtn()
	{
		return findBtn;
	}
	
	@FindBy(xpath="//*[@id='root']//tr/td[2]")
	WebElement chargePointRow;
	public WebElement chargePointRow()
	{
		return chargePointRow;
	}
	
	@FindBy(css="tr>td.text-center")
	List<WebElement> chargePointCheckBox;
	public List<WebElement> chargePointCheckBox()
	{
		return chargePointCheckBox;
	}
	
	@FindBy(xpath="//*[@id='root']//tr/td[2]")
	List<WebElement> chargePointID;
	public List<WebElement> chargePointID()
	{
		return chargePointID;
	}
	
	@FindBy(xpath="//*[@id='root']//div[4]/button[1]")
	WebElement reassignBtn;
	public WebElement reassignBtn()
	{
		return reassignBtn;
	}
	
	@FindBy(xpath="//button[@class='btn-primary btn Ripple-parent']")
	WebElement dropdownOkBtn;
	public WebElement dropdownOkBtn()
	{
		return dropdownOkBtn;
	}
	
	@FindBy(css="li.nav-item.dropdown")
	WebElement topRightDropdown ;
	public WebElement topRightDropdown()
	{
		return topRightDropdown;
	}
	
	@FindBy(xpath="//*[@id='navbar-static-tools']/div/a[1]")
	WebElement switchAccountBtn ;
	public WebElement switchAccountBtn()
	{
		return switchAccountBtn;
	}
	
	@FindBy(xpath="//*[@id='root']//div[2]//label/following-sibling::div/select")
	WebElement switchAccDropdown;
	public WebElement switchAccDropdown()
	{
		return switchAccDropdown;
	}
	
	@FindBy(xpath="//*[@id='dpl-navbar-right-buttons']//li[1]")
	WebElement verifyOrganisationText;
	public WebElement verifyOrganisationText()
	{
		return verifyOrganisationText;
	}
	
	@FindBy(xpath="//*[@id='logoff_account']/span")
	WebElement logOff;
	public WebElement logOff()
	{
		return logOff;
	}
}
