package cpms.websocket.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SampleWebSocketPage {
	
	WebDriver driver;

	public SampleWebSocketPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		} 

	@FindBy(css = "input#urlInput")
	WebElement serverURLTextField;

	public WebElement serverURLTextField() {
		return serverURLTextField;
	}

	@FindBy(css = "input#protocolInput")
	WebElement serverProtocolTextField;

	public WebElement serverProtocolTextField() {
		return serverProtocolTextField;
	}

	@FindBy(css = "button#connectButton")
	WebElement connectBtn;

	public WebElement connectBtn() {
		return connectBtn;
	}

	@FindBy(xpath = "//span[text()='OPENED']")
	WebElement connectionStatus;

	public WebElement connectionStatus() {
		return connectionStatus;
	}
	
	@FindBy(css="button#disconnectButton")
	WebElement disconnectBtn;
	public WebElement disconnectBtn()
	{
		return disconnectBtn;
	}
	
	@FindBy(xpath="//*[@id='messageTextarea']")
	WebElement sendMessageTextField;
	public WebElement sendMessageTextField()
	{
		return sendMessageTextField;
	}
	
	@FindBy(xpath="//*[@id='messageSendButton']")
	WebElement sendButton;
	public WebElement sendButton()
	{
		return sendButton;
	}
}
