package com.evProService.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evProService.base.TestBaseAppium;

public class SignInScreen extends TestBaseAppium {

	AddYourOwnChargerScreen ownCharger;

	public SignInScreen() throws Exception {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//android.widget.ImageView[@index='0'])[1]")
	WebElement webastoLogoImage;

	public WebElement webastoLogoImage() {
		return webastoLogoImage;
	}

	@FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
	WebElement emailTextField;

	public WebElement emailTextField() {
		return emailTextField;
	}

	@FindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
	WebElement passwordTextField;

	public WebElement passwordTextField() {
		return passwordTextField;
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Sign in']")
	WebElement signInButton;

	public WebElement signInButton() {
		return signInButton;
	}

	@FindBy(id = "android:id/button1")
	WebElement popUpOkButton;

	public WebElement popUpOkButton() {
		return popUpOkButton;
	}

	@FindBy(id = "android:id/message")
	WebElement popUpText;

	public WebElement popUpText() {
		return popUpText;
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Create a new account']")
	WebElement createNewAccountButton;

	public SignUpScreen createNewAccountButton() throws Exception {
		createNewAccountButton.click();
		return new SignUpScreen();
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Forgot Password?']")
	WebElement forgotPasswordButton;

	public ForgotPasswordScreen forgotPasswordButton() throws Exception {
		forgotPasswordButton.click();
		return new ForgotPasswordScreen();
	}

	public void signIn(String email, String password) throws Exception {
		ownCharger = new AddYourOwnChargerScreen();
		emailTextField.click();
		emailTextField.click();
		emailTextField.sendKeys(email);
		passwordTextField.click();
		passwordTextField.sendKeys(password);
		Thread.sleep(2000);
		signInButton.click();
		Thread.sleep(3000);
	}
}
