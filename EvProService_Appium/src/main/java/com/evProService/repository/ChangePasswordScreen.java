package com.evProService.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evProService.base.TestBaseAppium;

public class ChangePasswordScreen extends TestBaseAppium {

	public ChangePasswordScreen() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Change Password']")
	WebElement changePasswordHeaderText;
	public WebElement changePasswordHeaderText()
	{
		return changePasswordHeaderText;
	}
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView\r\n" + 
			"")
	WebElement changePasswordWebastoLogo;
	public WebElement changePasswordWebastoLogo()
	{
		return changePasswordWebastoLogo;
	}
	
	@FindBy(xpath="(//android.widget.EditText[@index='0'])[1]")
	WebElement oldPasswordTextField;
	public WebElement oldPasswordTextField()
	{
		return oldPasswordTextField;
	}
	
	@FindBy(xpath="(//android.widget.EditText[@index='0'])[2]")
	WebElement newPasswordTextField;
	public WebElement newPasswordTextField()
	{
		return newPasswordTextField;
	}
	
	@FindBy(xpath="(//android.widget.EditText[@index='0'])[3]")
	WebElement confirmPasswordTextField;
	public WebElement confirmPasswordTextField()
	{
		return confirmPasswordTextField;
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Submit']")
	WebElement submitButton;
	public WebElement submitButton()
	{
		return submitButton;
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Change password is done successfully. Please login with new credentials.']")
	WebElement passwordChangedSuccessPopupText;
	public WebElement passwordChangedSuccessPopupText()
	{
		return passwordChangedSuccessPopupText;
	}
	
	@FindBy(xpath="//android.widget.Button[@text='OK']")
	WebElement popupOkButton;
	public WebElement popupOkButton()
	{
		return popupOkButton;
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Old password does not match']")
	WebElement oldPasswordNotMatchedPopupText;
	public WebElement oldPasswordNotMatchedPopupText()
	{
		return oldPasswordNotMatchedPopupText;
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Password should be atleast 8-20 characters']")
	WebElement passwordLimitPopupText;
	public WebElement passwordLimitPopupText()
	{
		return passwordLimitPopupText;
	}
	
}
