package com.application.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.application.core.web.WebPage;

public class FlipkartHomePage extends WebPage{

	public FlipkartHomePage(WebDriver driver) {
		super(driver);		
	}
	
	@FindBy (css=(".LM6RPg"))
	private WebElement textBoxSearch;
	
	public void search(String search){
		waitFor(ExpectedConditions.visibilityOf(textBoxSearch),30);
		textBoxSearch.sendKeys(search);
	}

}
