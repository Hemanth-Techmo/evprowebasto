package com.evProService.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evProService.base.TestBaseAppium;

public class DashboardScreen extends TestBaseAppium{

	public DashboardScreen() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//android.widget.TextView[@text='Dashboard'])[1]")
	WebElement dashboardHeaderText;
	public WebElement dashboardHeaderText()
	{
		return dashboardHeaderText;
	}
	
	

}
