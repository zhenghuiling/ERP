package com.erp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	/**
	 * 登录用户名输入框
	 */
	@FindBy(xpath="//div[@id='app']/form/div[1]/div/div/input")
	private WebElement  uesrname_input;
	
	/**
	 * 登录密码输入框
	 */
	@FindBy(xpath="//div[@id='app']/form/div[2]/div/div/input")
	private WebElement  password_input;
	
	/**
	 * 登录提交按钮
	 */
	@FindBy(xpath="//div[@class='el-form-item']/div/button")
	private WebElement login_button;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	/**
	 * 执行登录操作，自动填入用户名和密码，并点击登录提交按钮
	 * @param userName   输入登录用户名
	 * @param password	  输入登录密码
	 */
	public void doLogin(String userName,String password) {
		uesrname_input.sendKeys(userName);
		password_input.sendKeys(password);
		login_button.click();
	}

	
	
}

