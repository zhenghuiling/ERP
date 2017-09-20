package com.erp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

	/**
	 *首页系统管理的链接
	 */
	@FindBy(xpath="//ul[@class='el-menu left-menu el-menu--dark']/li[1]/div")
	private WebElement System_link;
	
	/**
	 * 首页用户管理的链接
	 */
	@FindBy(xpath="//li[text()=\"用户管理\"]")
	private WebElement user_link;
	
	/**
	 * 首页角色管理链接
	 * @param driver
	 */
	@FindBy(xpath="//li[text()=\"角色管理\"]")
	private WebElement role_link;
	
	/**
	 * 生产配置管理链接
	 * @param driver
	 */
	@FindBy(xpath="//ul[@class='el-menu left-menu el-menu--dark']/li[5]/div")
	private WebElement  production_configuration_Link;
	
	/**
	 * 工作区管理链接
	 * @param driver
	 */
	@FindBy(xpath="//li[text()=\"工作区管理\"]")
	private WebElement Workspace_Link;
	
	
	public IndexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	/**
	 * 点击系统管理链接
	 */
	public void click_System() {
		System_link.click();	
	}
	
	/**
	 * 点击用户管理链接
	 */
	public void click_UserManagement() {
		user_link.click();
	}
	
	/**
	 * 点击角色管理连接
	 */
	public void click_RoleManagement() {
		role_link.clear();
	}
	
	/**
	 * 点击生产配置管理链接
	 */
	public void click_ProductionConfiguration() {
		production_configuration_Link.clear();
	}
	
	/**
	 * 点击工作区管理链接
	 */
	public void click_WorkspaceManagement() {
		Workspace_Link.clear();
	}
	
	
	
	
	
	
}
