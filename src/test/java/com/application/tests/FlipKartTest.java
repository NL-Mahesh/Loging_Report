package com.application.tests;

import org.testng.annotations.Test;

import com.application.core.common.CommonTest;
import com.application.core.common.Constents;

public class FlipKartTest extends CommonTest{
	
	@Test
	public void verifyRam(){
		loadBrowser(Constents.APPLICATION_URL_FLIPKART);
	}
	

}
