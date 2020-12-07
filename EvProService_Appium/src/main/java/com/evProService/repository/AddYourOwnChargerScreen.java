package com.evProService.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evProService.base.TestBaseAppium;

public class AddYourOwnChargerScreen extends TestBaseAppium {

	SignInScreen signIn;
	AddYourOwnChargerScreen ownCharger;

	public AddYourOwnChargerScreen() throws Exception {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView\r\n"
			+ "")
	WebElement ownChargerText;

	public WebElement ownChargerText() {
		return ownChargerText;
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Yes']")
	WebElement ownChargerYesButton;

	public AddYourOwnChargerScreen ownChargerYesButton() throws Exception {
		ownChargerYesButton.click();
		return new AddYourOwnChargerScreen();	
	}

	@FindBy(xpath ="//android.widget.TextView[@text='No']")
	WebElement ownChargerNoButton;

	public ChargingPointsScreen ownChargerNoButton() throws Exception {
		ownChargerNoButton.click();
		return new ChargingPointsScreen();
	}

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.View\r\n"
			+ "")
	WebElement step1NextButton;

	public WebElement step1NextButton() {
		return step1NextButton;
	}

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText\r\n"
			+ "")
	WebElement wlanHotspotSSIDTextField;

	public WebElement wlanHotspotSSIDTextField() {
		return wlanHotspotSSIDTextField;
	}

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText\r\n"
			+ "")
	WebElement wlanHotspotPasswordTextField;

	public WebElement wlanHotspotPasswordTextField() {
		return wlanHotspotPasswordTextField;
	}

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.View\r\n"
			+ "")
	WebElement step2ConnectButton;

	public WebElement step2ConnectButton() {
		return step2ConnectButton;
	}

	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	WebElement accessDeviceLocationPermission;
	public WebElement accessDeviceLocationPermission() {
		return accessDeviceLocationPermission;
	}

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView\r\n"
			+ "")
	WebElement addChargerButton;
	public WebElement addChargerButton() {
		return addChargerButton;
	}

	@FindBy(xpath = "(//android.widget.EditText)[1]")
	WebElement addChargerChargePointIDTextField;
	public WebElement addChargerChargePointIDTextField() {
		return addChargerChargePointIDTextField;
	}

	@FindBy(xpath="(//android.widget.EditText)[2]")
	WebElement chargePointNameTextField;
	public WebElement chargePointNameTextField() {
		return chargePointNameTextField;
	}
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView\r\n"
			+ "")
	WebElement addChargerSearchButton;
	public WebElement addChargerSearchButton() {
		return addChargerSearchButton;
	}

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[9]/android.view.View\r\n"
			+ "")
	WebElement addChargerNextButton;
	public WebElement addChargerNextButton() {
		return addChargerNextButton;
	}
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText\r\n" + 
			"")
	WebElement addChargerHouseNumberTextField;
	public WebElement addChargerHouseNumberTextField()
	{
		return addChargerHouseNumberTextField;
	}
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText\r\n" + 
			"")
	WebElement addChargerStreetTextField;
	public WebElement addChargerStreetTextField()
	{
		return addChargerStreetTextField;
	}
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText\r\n" + 
			"")
	WebElement addChargerCityTextField;
	public WebElement addChargerCityTextField()
	{
		return addChargerCityTextField;
	}
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.EditText\r\n" + 
			"")
	WebElement addChargerZipCodeTextField;
	public WebElement addChargerZipCodeTextField()
	{
		return addChargerZipCodeTextField;
	}
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.EditText\r\n" + 
			"")
	WebElement addChargerCountryTextField;
	public WebElement addChargerCountryTextField()
	{
		return addChargerCountryTextField;
	}
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[9]/android.view.View\r\n" + 
			"")
	WebElement addChargerSubmitButton;
	public WebElement addChargerSubmitButton()
	{
		return addChargerSubmitButton;
	}
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]/android.view.View\r\n" + 
			"")
	WebElement addChargerBackButton;
	public WebElement addChargerBackButton()
	{
		return addChargerBackButton;
	}
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView\r\n" + 
			"")
	WebElement cpSuccessfulAlertText;
	public WebElement cpSuccessfulAlertText()
	{
		return cpSuccessfulAlertText;
	}
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button\r\n" + 
			"")
	WebElement cpSuccessfulAlertOkButton;
	public ChargingPointsScreen cpSuccessfulAlertOkButton() throws Exception
	{
		cpSuccessfulAlertOkButton.click();
		return new ChargingPointsScreen();
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Charger is already in use. Please contact your admin']")
	WebElement chargerInUseAlertText;
	public WebElement chargerInUseAlertText()
	{
		return chargerInUseAlertText;
	}
	
	@FindBy(xpath="//android.widget.Button[@text='OK']")
	WebElement chargerInUseAlertOkButton;
	public AddYourOwnChargerScreen chargerInUseAlertOkButton() throws Exception
	{
		chargerInUseAlertOkButton.click();
		return new AddYourOwnChargerScreen();
	}
}
