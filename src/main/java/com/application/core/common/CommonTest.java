package com.application.core.common;

import com.application.core.util.Properties;
import com.application.core.web.WebTest;

public class CommonTest extends WebTest {
	
	public void loadBrowser(String app){
		String url=Properties.getProperties(app);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(url);
		if(getDriver().getCurrentUrl().isEmpty()){
			getDriver().get(url);
		}		
	}
}
