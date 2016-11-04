package com.application.tests;

import org.testng.annotations.Test;

import com.application.core.common.CommonTest;
import com.application.core.common.Constents;
import com.application.core.util.ExcelUtil;
import com.application.pages.FlipkartHomePage;

public class FlipKartTest extends CommonTest{	
	
	@Test
	public void verifyRam(){
		String search=ExcelUtil.getExcelData("sheet1", 0, 0);
		loadBrowser(Constents.APPLICATION_URL_FLIPKART);
		FlipkartHomePage fhm=new FlipkartHomePage(getDriver());
		fhm.search(search);
	}
	

}
