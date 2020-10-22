package cpms.webasto.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cpms.webasto.base.TestBase;

public class ChargePointsOcppTagsPage extends TestBase{

	public ChargePointsOcppTagsPage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}
	 
	@FindBy(xpath="//*[@id='collapse2']//li[2]/a")
	WebElement ocppTagsSideBar;
	public WebElement ocppTagsSideBar()
	{
		return ocppTagsSideBar;
	}
	
	@FindBy(xpath="//*[@id='root']//div[2]//button[1]")
	WebElement ocppAddButton;
	public WebElement ocppAddButton()
	{
		return ocppAddButton;
	}
	
	@FindBy(css="input#idTag")
	WebElement idTagTextField;
	public WebElement idTagTextField()
	{
		return idTagTextField;
	}
	
	@FindBy(css="input.cal_margin.tag_cal")
	WebElement expiryDateTime;
	public WebElement expiryDateTime()
	{
		return expiryDateTime;
	}
	
	
	@FindBy(xpath="//*[@id='root']//button[1]")
	WebElement saveButton;
	public WebElement saveButton()
	{
		return saveButton;
	}
	
	@FindBy(xpath="//span[text()='ID Tag is already exists.']")
	WebElement idTagExistErrorMessage;
	public WebElement idTagExistErrorMessage()
	{
		return idTagExistErrorMessage;
	}
	
	@FindBy(xpath="//*[@id='root']//div[3]/button")
	WebElement ocppTagSuccessMessage;
	public WebElement ocppTagSuccessMessage()
	{
		return ocppTagSuccessMessage;
	}
}
