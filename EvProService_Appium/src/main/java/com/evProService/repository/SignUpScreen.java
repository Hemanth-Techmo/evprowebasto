package com.evProService.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evProService.base.TestBaseAppium;

public class SignUpScreen extends TestBaseAppium {
	
	public SignUpScreen() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Sign Up']")
	WebElement signUpHeaderText;
	public WebElement signUpHeaderText()
	{
		return signUpHeaderText;
	}

	@FindBy(xpath="(//android.widget.EditText)[1]")
	WebElement fisrtNameTextField;
	public WebElement fisrtNameTextField()
	{
		return fisrtNameTextField;
	}
	
	@FindBy(xpath="(//android.widget.EditText)[2]")
	WebElement lastNameTextField;
	public WebElement lastNameTextField()
	{
		return lastNameTextField;
	}
	
	@FindBy(xpath="(//android.widget.EditText)[3]")
	WebElement emailTextField;
	public WebElement emailTextField()
	{
		return emailTextField;
	}
	
	@FindBy(xpath="(//android.widget.EditText)[4]")
	WebElement passwordTextField;
	public WebElement passwordTextField()
	{
		return passwordTextField;
	}
	
	@FindBy(xpath="(//android.widget.EditText)[5]")
	WebElement confirmPasswordTextField;
	public WebElement confirmPasswordTextField()
	{
		return confirmPasswordTextField;
	}
	
	
	@FindBy(xpath="//android.widget.TextView[@index=11]")
	WebElement termsConditionsText;
	public WebElement termsConditionsText()
	{
		return termsConditionsText;
	}
	
	@FindBy(xpath="//android.widget.TextView[@index='0']")
	WebElement termsConditionsCheckbox;
	public WebElement termsConditionsCheckbox()
	{
		return termsConditionsCheckbox;
	}
	
	@FindBy(xpath="//android.widget.ImageButton")
	WebElement backButton;
	public WebElement backButton()
	{
		return backButton;
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Submit']")
	WebElement submitButton;
	public WebElement submitButton()
	{
		return submitButton;
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Your Account has been successfully created.']")
	WebElement accountCreatedPopUpText;
	public WebElement accountCreatedPopUpText()
	{
		return accountCreatedPopUpText;
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='User already exists']")
	WebElement userAlreadyExistsPopUpText;
	public WebElement userAlreadyExistsPopUpText()
	{
		return userAlreadyExistsPopUpText;
	}
	
	@FindBy(xpath="//android.widget.Button[@index='0']")
	WebElement popUpOkButton;
	public SignInScreen popUpOkButton() throws Exception
	{
		popUpOkButton.click();
		return new SignInScreen();
	}
}
