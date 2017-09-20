package com.erp.TestUtils;

import org.testng.annotations.AfterSuite;

import com.erp.Webdriver.Utils.WebdriverUtils;

public class AftestErpTest {
	@AfterSuite
	public  void stopService() {
		WebdriverUtils.stopService();
	}

}
