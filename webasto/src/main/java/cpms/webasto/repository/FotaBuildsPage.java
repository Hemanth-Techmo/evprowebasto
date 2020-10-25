package cpms.webasto.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cpms.webasto.base.TestBase;

public class FotaBuildsPage extends TestBase{
	
	public FotaBuildsPage() throws Exception
	{
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(xpath="//*[@id='collapse3']//div[1]//a")
	WebElement fotaSideBarButton;
	public WebElement fotaSideBarButton()
	{
		return fotaSideBarButton;
	}
	
	@FindBy(xpath="//*[@id='collapse9']//a")
	WebElement buildsSideBarButton;
	public WebElement buildsSideBarButton()
	{
		return buildsSideBarButton;
	}

	@FindBy(xpath="//*[@id='root']//div[2]/div[1]//a")
	WebElement addBuildButton;
	public WebElement addBuildButton()
	{
		return addBuildButton;
	}
	
	@FindBy(css="select#productId")
	WebElement selectModelDropdown;
	public WebElement selectModelDropdown()
	{
		return selectModelDropdown;
	}
	
	@FindBy(xpath="//*[@id='root']//div[3]/div[3]//input")
	WebElement versionTextField;
	public WebElement versionTextField()
	{
		return versionTextField;
	}
	
	@FindBy(css="select#prerequisites")
	WebElement prerequisiteDropdown;
	public WebElement prerequisiteDropdown()
	{
		return prerequisiteDropdown;
	}
	
	@FindBy(css="input.simple_file_upload")
	WebElement chooseFirmwareFile;
	public WebElement chooseFirmwareFile()
	{
		return chooseFirmwareFile;
	}
	
	@FindBy(css="input.simple_upload1")
	WebElement chooseReleaseNotes;
	public WebElement chooseReleaseNotes()
	{
		return chooseReleaseNotes;
	}
	
	@FindBy(xpath="//*[@id='root']//button[1]")
    WebElement saveButton;
    public WebElement saveButton()
    {
    	return saveButton;
    }
    
    @FindBy(xpath="//div[text()='New build is added sucessfully.']")
    WebElement buildAddedSuccessMessage;
    public WebElement buildAddedSuccessMessage()
    {
    	return buildAddedSuccessMessage;
    }
    
    @FindBy(xpath="//span[text()='Build already exists with this model and version.']")
    WebElement buildAlreadyExistMessage;
    public WebElement buildAlreadyExistMessage()
    {
    	return buildAlreadyExistMessage;
    }
}
