package com.evProService.repository;

import org.openqa.selenium.support.PageFactory;

import com.evProService.base.TestBaseAppium;

public class AboutScreen extends TestBaseAppium{

	public AboutScreen() throws Exception {
		PageFactory.initElements(driver, this);
	}
}
