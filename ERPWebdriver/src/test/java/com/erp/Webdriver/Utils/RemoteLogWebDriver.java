package com.erp.Webdriver.Utils;

import java.net.URL;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;


public class RemoteLogWebDriver  extends RemoteWebDriver{
	private Logger logger;
	 
	public RemoteLogWebDriver(URL url,Capabilities caps,Class<?> clazz) {
		super(url,caps);
		logger=LogManager.getLogger(clazz);
	}
	
	@Override
	public WebElement findElementByXPath(String using) {
		try {
			WebElement element=super.findElementByXPath(using);
			logger.info(using+"定位已找到元素");
			return element;
		}catch(NoSuchElementException e) {
			logger.error(using+"定位未找到元素");
			throw e;
		}
		
	}

}
