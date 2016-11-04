package com.application.core.web;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.application.core.common.Constents;

public class WebTest {
	
	private static WebDriver driver;
	
	static{
		System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
		System.setProperty("webdriver.firefox.marionette", "src/main/resources/drivers/geckodriver.exe");
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	@BeforeClass(alwaysRun=true)
	@Parameters("browser")
	public void launchBrowser(String browser){
		if(browser.equalsIgnoreCase("Firefox")){
			driver=new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("chrome")){
			driver=new ChromeDriver();
		} else if(browser.equalsIgnoreCase("ie")){
			driver=new InternetExplorerDriver();
		}
		System.out.println("Launched: "+browser+ " browser");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void applySettings(){
		
		int pageLoadTimeOut=Integer.parseInt(Constents.PAGELOAD_TIMEOUT);
		int scriptTimeOut=Integer.parseInt(Constents.SCRIPT_TIMEOUT);
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(scriptTimeOut, TimeUnit.SECONDS);
		System.out.println("Applied Browser Settings");
	}
	
	@AfterMethod(alwaysRun=true)
	public void endTest(ITestResult result){
		if(result.getStatus()==ITestResult.SUCCESS){
			System.out.println("Test Case: Passed");
		} else if(result.getStatus()==ITestResult.FAILURE){
			System.out.println("Test Case: Failed");
		} else if(result.getStatus()==ITestResult.SKIP){
			System.out.println("Test Case: Skipped");
		}
		driver.close();
	}
}
