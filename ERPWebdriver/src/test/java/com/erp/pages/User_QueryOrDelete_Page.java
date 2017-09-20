package com.erp.pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_QueryOrDelete_Page {
	public WebDriver driver;
	
	/**
	 * 用户的查询输入框
	 */
	@FindBy(xpath="//input[@class=\"el-input__inner\"]")
	public WebElement  query_input;
	
	/**
	 * 用户查询按钮
	 */
	@FindBy(xpath="//span[text()=\"查询\"]")
	public WebElement  query_button;
	
	/**
	 * 查询结果显示的文本区域
	 */
	@FindBy(xpath="//tr[@class=\"el-table__row\"]/td[3]")
	public List<WebElement> user_list_text;
	
	/**
	 * 编辑登录账号输入框
	 */
	@FindBy(xpath="//form[@class=\"el-form\"]/div[1]/div/div/input")
	private WebElement Logint_Name_input;
	
	/**
	 * 编辑登录密码输入框
	 */
	@FindBy(xpath="//form[@class=\"el-form\"]/div[2]/div/div/input")
	private WebElement Logint_password_input;
	
	/**
	 * 编辑登录提交按钮
	 */
	@FindBy(xpath="//button[@class=\"el-button el-button--primary\"]")
	private WebElement Logint_submit_button;
	
	/**
	 * 编辑登录删除按钮
	 */
	@FindBy(xpath="//form[@class=\"el-form\"]/div[3]/div/button[3]")
	private WebElement Logint_delete_button;
	
	/**
	 * 编辑登录提交之后确认按钮
	 */
	@FindBy(xpath="html/body/div[2]/div/div[3]/button[2]")
	private WebElement Logint_affirm_button;
	
	/**
	 * 用户管理批量删除按钮
	 */
	@FindBy(xpath="//div[@class=\"grid-content bg-purple-light\"]/div[2]/section/div[3]/button")
	private WebElement manyuser_delete_button;
	
	/**
	 * 首页管理员的链接
	 */
	@FindBy(xpath=".//*[@id='app']/div/div[1]/div[3]/div/span")
	private WebElement manager_Link;
	
	/**
	 * 首页退出登录的链接
	 */
	@FindBy(xpath="html/body/ul/li")
	private WebElement quit_Login_Link;
	
	/**
	 * 编辑登录，账号为空提示
	 */
	@FindBy(xpath="//form[@class=\"el-form\"]/div[1]/div/div[2]")
	private WebElement Lusername_null_text;
	
	/**
	 * 编辑登录，密码为空提示
	 */
	@FindBy(xpath="//form[@class=\"el-form\"]/div[2]/div/div[2]")
	private WebElement Lpassword_null_text;
	/**
	 * 编辑登录，账号已存在提示
	 */
	@FindBy(xpath="html/body/div[3]/div")
	private WebElement LuserName_exist_text;
	
	/**
	 * 修改登录账号后，登录该账号，该账号不存在提示
	 */
	@FindBy(xpath="html/body/div[3]/div/p")
	private WebElement Login_alter_text;
	
	/**
	 * 删除登录账号后，登录该账号，该账号不存在
	 */
	@FindBy(xpath="html/body/div[3]/div/div[1]")  
	private WebElement Login_delete_text;
	
	//构造函数
		public User_QueryOrDelete_Page(WebDriver driver) {
			PageFactory.initElements(driver, this);	
		}
	
	
	/**
	 * 执行查询操作，自动输入查询条件，点击查询按钮
	 * @param query_text  输入查询条件
	 */
	public void do_query(String query_text) {
		query_input.sendKeys(query_text);
		query_button.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询条件不为空，对查询结果进行校验，如果一致则测试通过，不一致测试失败
	 * @param expect 其他文本内容
	 */
	public void asserQueryResult(String expect) {
		 for (int i = 0; i < user_list_text.size(); i++) {
	           String name = user_list_text.get(i).getText();
	           System.out.println(name.contains(expect));
	           assertEquals(name.contains(expect), true);
	           }     
		   }
	/**
	 * 查询条件为空，对查询结果进行校验，如果一致则测试通过，不一致测试失败
	 * @param expect 其他文本内容
	 */
	public void asserQueryEroorResult(int expect) {
		assertEquals(user_list_text.size(), expect);
	}
	
	/**
	 * 执行编辑登录操作，根据用户账号，自动输入账号，密码，并点击提交按钮
	 * @param driver	初始化
	 * @param username  查找用户名
	 * @param l_username输入登录账号
	 * @param l_password输入登录密码
	 */
	public void do_editLogin_Test(WebDriver driver,String username,String l_username,String l_password) {
		for (int i = 0; i <user_list_text.size(); i++) {
	           String name =user_list_text.get(i).getText();
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
	                Actions actions=new Actions(driver);
	                actions.doubleClick(Logint_Name_input).sendKeys(Keys.DELETE).perform();
	                Logint_Name_input.sendKeys(l_username); 
	                actions.doubleClick(Logint_password_input).sendKeys(Keys.DELETE).perform();
	                Logint_password_input.sendKeys(l_password);
	           }
		}
	}
	
	/**
	 * 编辑登录，填写完登录信息，点击提交按钮
	 */
	public void go_Lsubmit() {
		
		Logint_submit_button.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 编辑登录，点击删除按钮对登录账号进行删除
	 * @param driver
	 */
	public void go_Ldelete(WebDriver driver) {
		Logint_delete_button.click();
		
	}
	
	/**
	 * 编辑登录，填写完登录信息并点击提交按钮后，点击确认按钮
	 * @param driver
	 */
	public void go_Laffirm(WebDriver driver) {
		((JavascriptExecutor)driver).executeScript("document.getElementsByClassName(\"el-button el-button--default el-button--primary\")[0].click();"); 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 执行退出登录操作，点击管理员，在点击退出登录，最后点击确定按钮
	 */
	public void  do_assertLogin() {
		manager_Link.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		quit_Login_Link.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Logint_affirm_button.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 编辑登录，对登录账号进行登录的url验证，如果一致就测试通过，不一致测试失败
	 * @param driver
	 * @param expect
	 */
	public void assertLogin_sucess(WebDriver driver,String expect) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(driver.getCurrentUrl(), expect);
	}
 
	/**
	 * 编辑登录，对账号为空提示进行验证，如果一致就测试通过，不一致测试失败
	 * @param expect
	 */
	public void asserLUserName_null(String expect) {
		assertEquals(Lusername_null_text.getText(), expect);
	}
	
	/**
	 * 编辑登录，对密码为空提示进行验证，如果一致就测试通过，不一致测试失败
	 * @param expect
	 */
	public void asserLpassword_null(String expect) {
		assertEquals(Lpassword_null_text.getText(), expect);
	}
	
	/**
	 * 编辑登录，对用户名已存在提示进行验证，如果一致就测试通过，不一致测试失败
	 * @param expect
	 */
	public void asserLUserName_exist(String expect) {
		assertEquals(LuserName_exist_text.getText(), expect);
	}
	
	/**
	 * 修改登录账号，对被修改掉的账号不存在提示进行校验，如果一致就测试通过，不一致测试失败
	 * @param expect
	 */
	public void asserLogin_alter(String expect) {
		assertEquals(Login_alter_text.getText(), expect);
	}
	
	
	/**
	 * 删除登录账号，对被删掉的账号不存在提示进行校验，如果一致就测试通过，不一致测试失败
	 * @param expect
	 */
		public void asserLogin_delete(String expect) {
			assertEquals(Login_delete_text.getText(), expect);
		}
		
	/**
	 * 删除用户，点击批量删除对用户进行删除
	 */
	public void go_User_delete() {
		manyuser_delete_button.click();
	}
	
	
}
