package cpms.webasto.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cpms.webasto.base.TestBase;

public class CalendarWidget extends TestBase {

	public CalendarWidget() throws Exception
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div.react-datepicker__current-month")
	WebElement currentMonth;
	public WebElement currentMonth()
	{
		return currentMonth;
	}
	
	@FindBy(xpath="//button[text()='Next Month']")
	WebElement nextMonthBtn;
	public WebElement nextMonthBtn()
	{
		return nextMonthBtn;
	}
	
	@FindBy(css="div[class*='datepicker__day--today']")
	WebElement todayDate;
	public WebElement todayDate()
	{
		return todayDate;
	}
	
	@FindBy(xpath="//*[@id='root']//div[5]/div[7]")
	WebElement lastDateInWidget;
	public WebElement lastDateInWidget()
	{
		return lastDateInWidget;
	}
}
