package cpms.webasto.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cpms.webasto.base.TestBase;

public class GetDiagnosticsPage extends TestBase {

	public GetDiagnosticsPage() throws Exception
	{
		PageFactory.initElements(driver, this); 
	}
	@FindBy(xpath="//*[@id='slide-out']//li[7]//span/a")
	WebElement operationsSideBarBtn;
	public WebElement operationsSideBarBtn()
	{
		return operationsSideBarBtn;
	}
	
	@FindBy(xpath="//*[@id='collapse1']//li[6]/a")
	WebElement getDiagnosticsBtn;
	public WebElement getDiagnosticsBtn()
	{
		return getDiagnosticsBtn;
	}
	
	
	@FindBy(css="input#retriesId")
	WebElement retriesTextField;
	public WebElement retriesTextField()
	{
		return retriesTextField;
	}
	
	@FindBy(css="input#retryIntervalId")
	WebElement retryIntervalTextField;
	public WebElement retryIntervalTextField()
	{
		return retryIntervalTextField;
	}
	
	@FindBy(xpath="//*[@id='root']//div[6]//input")
	WebElement startDateTime;
	public WebElement startDateTime()
	{
		return startDateTime;
	}
	
	@FindBy(xpath="//*[@id='root']//div[7]//input")
	WebElement stopDateTime;
	public WebElement stopDateTime()
	{
		return stopDateTime;
	}
	
	@FindBy(css="button.btn-primary.btn.Ripple-parent.mt-5")
	WebElement performButton;
	public WebElement performButton()
	{
		return performButton;
	}
	
	@FindBy(xpath="//div[text()='Request is processed Successfully']")
	WebElement requestProcessedMsg;
	public WebElement requestProcessedMsg()
	{
		return requestProcessedMsg;
	}
}
