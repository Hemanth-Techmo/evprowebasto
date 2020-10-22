package cpms.webasto.repository;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cpms.webasto.base.TestBase;

public class ChargePointsOverviewPage extends TestBase {

	public ChargePointsOverviewPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//*[@id='slide-out']//li[2]/div[1]//a")
	WebElement chargePointsBtn;

	public WebElement chargePointsBtn() {
		return chargePointsBtn;
	}

	@FindBy(xpath = "//*[@id='collapse2']//li[1]/a")
	WebElement overviewBtn;

	public WebElement overviewBtn() {
		return overviewBtn;
	}
	
	@FindBy(css="input[placeholder='Choose a Charge Point ID']")
	WebElement chargePointIDSearch;

	public WebElement chargePointIDSearch() {
		return chargePointIDSearch;
	}
	
	@FindBy(xpath="//*[@id='root']//div[3]//button[2]")
	WebElement findBtn;
	public WebElement findBtn()
	{
	return findBtn;
	}
	
	@FindBy(xpath="//*[@id='root']//span[1]/span")
	WebElement cpIDNotExistsText;
	public WebElement cpIDNotExistsText()
	{
		return cpIDNotExistsText;
	}

}
