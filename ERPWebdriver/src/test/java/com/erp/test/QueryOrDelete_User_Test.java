package com.erp.test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.erp.TestUtils.BeforeErpTest;
import com.erp.pages.IndexPage;
import com.erp.pages.LoginPage;
import com.erp.pages.User_QueryOrDelete_Page;

import TestData.UserDataFactory;

public class QueryOrDelete_User_Test extends BeforeErpTest {
	
	private User_QueryOrDelete_Page userinfo;
	@BeforeMethod
	public void user() {
		IndexPage index=new IndexPage(driver);
		index.click_System();//点击系统管理
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		index.click_UserManagement();//点击用户管理连接
		userinfo=new User_QueryOrDelete_Page(driver);	
	}

	/*
	 * 查询测试用例
	 * 1、输入完整姓名进行查询
	 * 2、输入模糊的姓名进行查询
	 * 
	 */
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="query_test_data")
	public void query_test(String text,String expect) {
		userinfo.do_query(text);
		userinfo.asserQueryResult(expect);
	}
	//查询不存在的姓名
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="queryerorr_test_data")
	public void query_test2(String text,int expect) {
		userinfo.do_query(text);
		userinfo.asserQueryEroorResult(expect);
	}
	
	//查询文本框为空
	@Test
	public void query_test3() {
		int testBefore= userinfo.user_list_text.size();
		Actions actions=new Actions(driver);
		actions.click(userinfo.query_input).sendKeys("zhenghl").perform();
		actions.doubleClick(userinfo.query_input).perform();
		actions.sendKeys(Keys.DELETE).perform();
		userinfo.query_button.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int testResult=userinfo.user_list_text.size();
		assertEquals(testResult, testBefore);
	}
	
	//编辑登录账号成功
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="editLogin_sucess_test_data")
	public void editLogin_test(String username,String Loginname,String LoginPassword,String expect) {
		userinfo.do_editLogin_Test(driver,username,Loginname,LoginPassword);
		userinfo.go_Lsubmit();
		userinfo.go_Laffirm(driver);
		userinfo.do_assertLogin();
		LoginPage login=new LoginPage(driver);
		login.doLogin(Loginname,LoginPassword);
		userinfo.assertLogin_sucess(driver,expect);
	}
	
	//编辑登录账号为空
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="Lusername_Null_test_data")
	public void editLUserName_Null_test(String username,String Loginname,String LoginPassword,String expect) {
		userinfo.do_editLogin_Test(driver,username,Loginname,LoginPassword);
		userinfo.go_Lsubmit();
		userinfo.asserLUserName_null(expect);
	}
	
	//编辑登录密码为空
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="LPassword_Null_test_data")
	public void editLpassword_Null_test(String username,String Loginname,String LoginPassword,String expect) {
		userinfo.do_editLogin_Test(driver,username,Loginname,LoginPassword);
		userinfo.go_Lsubmit();
		userinfo.asserLpassword_null(expect);
	}
	
	//编辑登录账号已存在
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="LuserName_exist_test_data")
	public void editLuserName_exist_test(String username,String Loginname,String LoginPassword,String expect) {
		userinfo.do_editLogin_Test(driver,username,Loginname,LoginPassword);
		userinfo.go_Lsubmit();
		userinfo.go_Laffirm(driver);
		userinfo.asserLUserName_exist(expect);
		
	}
	
	//修改登录账号
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="editLogin_alter_test_data")
	public void editLogin_alter_test(String username,String alter_username,String alter_pwd,String Loginname,String LoginPassword,String expect) {
		userinfo.do_editLogin_Test(driver,username,alter_username,alter_pwd);
		userinfo.go_Lsubmit();
		userinfo.go_Laffirm(driver);
		userinfo.do_assertLogin();
		LoginPage login=new LoginPage(driver);
		login.doLogin(Loginname,LoginPassword);
		userinfo.asserLogin_alter(expect);
	}
	
	//删除登录账号
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="editLogin_delete_test_data")
	public void editLogin_delete_test(String username,String expect) {
		for (int i = 0; i <userinfo.user_list_text.size(); i++) {
	           String name =userinfo.user_list_text.get(i).getText();
	           if(name.equals(username)) {
	                Actions builder = new Actions(driver);
	                builder.moveToElement(driver.findElement(By.xpath("//div[text()='"+username+"']/following::td/div/button[2]/span[text()=\"编辑登录账号\"]")))
	                .pause(Duration.ofSeconds(2L))
	                .click().pause(Duration.ofSeconds(2L))
	                .perform();
	                try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	           }
		}
		userinfo.go_Ldelete(driver);
		userinfo.go_Laffirm(driver);
		userinfo.asserLogin_delete(expect);
	}
	
	//删除单个用户
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="user_delete_test_data")
	public void user_delete_test(String username,String expect) {
		for (int i = 0; i <userinfo.user_list_text.size(); i++) {
	           String name =userinfo.user_list_text.get(i).getText();
	           if(name.equals(username)) {
	                Actions builder = new Actions(driver);
	                builder.moveToElement(driver.findElement(By.xpath("//div[text()='"+username+"']/following::td/div/button[3]/span[text()=\"删除\"]")))
	                .pause(Duration.ofSeconds(2L))
	                .click().pause(Duration.ofSeconds(2L))
	                .perform();
	           }
		}
		userinfo.go_Laffirm(driver);
		userinfo.asserLogin_delete(expect);
	}
	
	//批量删除用户
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="manyuser_delete_test_data")
	public void manyuser_delete_test(String username,String username2,String username3,String expect) {
		  Actions builder = new Actions(driver);
          builder.moveToElement(driver.findElement(By.xpath("//div[text()='"+username+"']/preceding::td[2]/div/label/span/span")))
          .pause(Duration.ofSeconds(2L))
          .click().pause(Duration.ofSeconds(2L))
          .perform();
          builder.moveToElement(driver.findElement(By.xpath("//div[text()='"+username2+"']/preceding::td[2]/div/label/span/span")))
          .pause(Duration.ofSeconds(2L))
          .click().pause(Duration.ofSeconds(2L))
          .perform();
          builder.moveToElement(driver.findElement(By.xpath("//div[text()='"+username3+"']/preceding::td[2]/div/label/span/span")))
          .pause(Duration.ofSeconds(2L))
          .click().pause(Duration.ofSeconds(2L))
          .perform();
		 userinfo.go_User_delete();
	     userinfo.go_Laffirm(driver);
		 for (int i = 0; i < userinfo.user_list_text.size(); i++) {
	           String name = userinfo.user_list_text.get(i).getText();
	           if(name!=username && name!=username2 &&  name!=username3) {
	        	 System.out.println("校验成功");
	           }     
		   }
	}
	
}
