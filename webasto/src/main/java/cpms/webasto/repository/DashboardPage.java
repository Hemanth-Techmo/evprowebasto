package cpms.webasto.repository;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cpms.webasto.base.TestBase;

public class DashboardPage extends TestBase {
	
	public DashboardPage() throws IOException
	{
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(xpath="//*[@id='navbar']//p")
	WebElement dashboardText;
	public WebElement dashboardText()
	{
		return dashboardText;
	}
	@FindBy(xpath="//*[@id='slide-out']/ul/li[3]/ul/li[1]/a")
	WebElement dashboardBtn;
	public WebElement dashboardBtn()
	{
		return dashboardBtn;
	}
	
	@FindBy(xpath="//*[@id='root']//div[1]/div/div/h4/following-sibling::p")
	WebElement chargePoints;
	
	public WebElement chargePoints()
	{
		return chargePoints;
	}
	
	@FindBy(xpath="//*[@id='root']//div[2]/div/div/h4/following-sibling::p")
	WebElement activeChargePoints;
	
	public WebElement activeChargePoints()
	{
		return activeChargePoints;
	}
	
	@FindBy(xpath="//*[@id='root']//div[3]/div/div/h4/following-sibling::p")
	WebElement unknownChargePoints;
	
	public WebElement unknownChargePoints()
	{
		return unknownChargePoints;
	}
	
	@FindBy(xpath="//*[@id='root']//div[4]/div/div/h4/following-sibling::p")
	WebElement ocppTags;
	
	public WebElement ocppTags()
	{
		return ocppTags;
	}
	
	@FindBy(xpath="//*[@id='root']//div[5]/div/div/h4/following-sibling::p")
	WebElement transactions;
	
	public WebElement transactions()
	{
		return transactions;
	}
	
	@FindBy(xpath="//*[@id='root']//div[4]//tbody/tr")
	List<WebElement> chargePointID;
	
	public List<WebElement> chargePointID()
	{
		return chargePointID;
	}
	
	@FindBy(xpath="//*[@id='root']//div[3]//tbody/tr")
	List<WebElement> unknownChargePoint;
	
	public List<WebElement> unknownChargePoint()
	{
		return unknownChargePoint;
	}
	
	@FindBy(xpath="//*[@id='root']//div[3]/div[1]//tbody/tr")
	List<WebElement> transactionID;
	public List<WebElement> transactionID()
	{
		return transactionID;
	}
	
	@FindBy(xpath="//*[@id='root']//div[4]/div[2]/ul/li")
	List<WebElement> pages;
	
	public List<WebElement> pages()
	{
		return pages;
	}
	

	

}
