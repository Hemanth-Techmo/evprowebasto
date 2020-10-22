package cpms.webasto.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cpms.webasto.base.TestBase;

public class SelectChargePointModel extends TestBase {
	
	public SelectChargePointModel() throws Exception
	{
		PageFactory.initElements(driver, this); 
	}
	@FindBy(css="button#btn_image_div")
	WebElement selectChargePointBtn;
	public WebElement selectChargePointBtn()
	{
		return selectChargePointBtn;
	}
	@FindBy(xpath="//*[@id='root']//div[4]/button[2]")
	WebElement doneBtn;
	public WebElement doneBtn()
	{
		return doneBtn;
	}
	
	@FindBy(xpath="//*[contains(@id,'chargepoint')]")
	WebElement selectedChargePoint;
	public WebElement selectedChargePoint()
	{
		return selectedChargePoint;
	}
	String chargePointIDSelect;
	public void selectCheckBox(String chargePointID)
	{
		chargePointIDSelect=chargePointID;
		String checkBox="input#custom-"+chargePointID;
		WebElement element = driver.findElement(By.cssSelector(checkBox));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
}
