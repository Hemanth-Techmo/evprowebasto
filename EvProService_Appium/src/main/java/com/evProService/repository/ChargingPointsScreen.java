package com.evProService.repository;

import org.openqa.selenium.support.PageFactory;

import com.evProService.base.TestBaseAppium;

public class ChargingPointsScreen extends TestBaseAppium {
	
	public ChargingPointsScreen() throws Exception {
		PageFactory.initElements(driver, this);
	}
	

}
