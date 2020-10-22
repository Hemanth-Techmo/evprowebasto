package cpms.webasto.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cpms.webasto.base.TestBase;

public class UploadDiagnosticsPage extends TestBase{

	public UploadDiagnosticsPage() throws Exception
	{
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(xpath="//*[@id='collapse3']//li[4]/a")
	WebElement uploadDiagnosticsSideBar;
	public WebElement uploadDiagnosticsSideBar()
	{
		return uploadDiagnosticsSideBar;
	}
	
	@FindBy(css="input#buildFile")
	WebElement chooseDiagnosticsFile;
	public WebElement chooseDiagnosticsFile()
	{
		return chooseDiagnosticsFile;
	}
	
	@FindBy(css="button.btn-primary.btn.Ripple-parent.mt-5")
	WebElement performButton;
	public WebElement performButton()
	{
		return performButton;
	}
}
