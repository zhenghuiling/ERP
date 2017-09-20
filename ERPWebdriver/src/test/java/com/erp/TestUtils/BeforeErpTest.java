package com.erp.TestUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.erp.Webdriver.Utils.WebdriverUtils;
import com.erp.pages.LoginPage;



public class BeforeErpTest {
	public WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		//this.getClass()谁继承谁就是类
		driver=WebdriverUtils.getDriver("chrom",this.getClass());
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.get("http://192.168.1.119");
		LoginPage login=new LoginPage(driver);
		login.doLogin("admin", "123456");//登录
		
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
