package com.evProService.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evProService.base.TestBaseAppium;

public class SettingsScreen extends TestBaseAppium {
	
	public SettingsScreen() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.FrameLayout[@content-desc=\"More, tab, 5 out of 5\"]/android.widget.ImageView")
    WebElement MoreButtonBottomLayout;
	public WebElement MoreButtonBottomLayout()
	{
		return MoreButtonBottomLayout;
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Settings']")
	WebElement settingsHeaderText;
	public WebElement settingsHeaderText()
	{
		return settingsHeaderText;
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='About']")
	WebElement aboutButton;
	public AboutScreen aboutButton() throws Exception
	{
		aboutButton.click();
		return new AboutScreen();
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Settings']")
	WebElement settingsButton;
	public SettingsScreen SettingsButton() throws Exception
	{
		settingsButton.click();
		return new SettingsScreen();
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Change Password']")
	WebElement changePasswordButton;
	public ChangePasswordScreen changePasswordButton() throws Exception
	{
		changePasswordButton.click();
		return new ChangePasswordScreen();
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Logout']")
	WebElement logoutButton;
	public WebElement logoutButton()
	{
		return logoutButton;
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Are you sure you want to logout now?']")
	WebElement logoutConfirmationPopupText;
	public WebElement logoutConfirmationPopupText()
	{
		return logoutConfirmationPopupText;
	}
	
	@FindBy(xpath="//android.widget.Button[@text='OK']")
	WebElement confirmLogoutOKButton;
	public WebElement confirmLogoutOKButton()
	{
		return confirmLogoutOKButton;
	}
	
	@FindBy(xpath="//android.widget.Button[@text='CANCEL']")
	WebElement confirmLogoutCancelButton;
	public WebElement confirmLogoutCancelButton()
	{
		return confirmLogoutCancelButton;
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Logged out successfully']")
	WebElement logoutSuccessfulPopupText;
	public WebElement logoutSuccessfulPopupText()
	{
		return logoutSuccessfulPopupText;
	}
	
	@FindBy(xpath="//android.widget.Button[@text='OK']")
	WebElement logoutSuccessfulOKButton;
	public SignInScreen logoutSuccessfulOKButton() throws Exception
	{
		logoutSuccessfulOKButton.click();
		return new SignInScreen();
	}

}
