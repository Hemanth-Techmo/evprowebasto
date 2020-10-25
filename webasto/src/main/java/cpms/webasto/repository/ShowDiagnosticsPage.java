package cpms.webasto.repository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cpms.webasto.base.TestBase;

public class ShowDiagnosticsPage extends TestBase {
	public ShowDiagnosticsPage() throws Exception
	{
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(xpath="//*[@id='collapse3']//li[3]/a")
	WebElement showDiagnosticsSideBarBtn;
	public WebElement showDiagnosticsSideBarBtn()
	{
		return showDiagnosticsSideBarBtn;
	}
	
	@FindBy(xpath="//*[@id='root']//tbody//tr/td[2]")
	List<WebElement> fileNameColumn;
	public List<WebElement> fileNameColumn()
	{
		return fileNameColumn;
	}
}
