package com.application.core.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.application.core.base.Page;
import com.application.core.common.Constents;

public class WebPage implements Page<WebDriver> {
	
	private final WebDriver driver;
	private static final int EXPLICIT_TIMEOUT=Integer.parseInt(Constents.EXPLICIT_TIMEOUT);
	private static final int POLLING_TIME=Integer.parseInt(Constents.POLLING_TIME);
	
	public WebPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {		
		return driver;
	}

	public <T> T waitFor(ExpectedCondition<T> waitCondition, long timeOut) {		
		return new WebDriverWait(driver, timeOut, POLLING_TIME).until(waitCondition);
	}

	public <T> T waitFor(ExpectedCondition<T> waitCondition) {	
		return new WebDriverWait(driver, EXPLICIT_TIMEOUT, EXPLICIT_TIMEOUT).until(waitCondition);
	}

}
