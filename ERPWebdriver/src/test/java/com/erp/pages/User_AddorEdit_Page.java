package com.erp.pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_AddorEdit_Page {
	public WebDriver driver;

	/**
	 * 用户新增链接按钮
	 */
	@FindBy(xpath="//button/span[text()=\"新增\"]")
	private WebElement Add_user_Button;
	
	/**
	 * 用户界面 用户名输入框
	 */
	@FindBy(xpath="//form[@class=\"el-form\"]/div[1]/div/div/input")
	private WebElement add_userName_input;
	
	/**
	 * 用户 性别男的选择框
	 */
	@FindBy(xpath="//form[@class=\"el-form\"]/div[2]/div/div/label[1]/span[1]/input")
	private WebElement userSex_nan_select;
	/**
	 * 用户 性别女的选择框
	 */
	@FindBy(xpath="//form[@class=\"el-form\"]/div[2]/div/div/label[2]/span[1]/input")
	private WebElement userSex_nv_select;
	
	/**
	 * 用户界面 年龄输入框
	 */
	@FindBy(xpath="//form[@class=\"el-form\"]/div[3]/div/div/div/input")
	private WebElement add_userAge_input;

	/**
	 * 用户界面 地址输入框
	 */
	@FindBy(xpath="//form[@class=\"el-form\"]/div[4]/div/div/textarea")
	private WebElement add_userAddress_textarea;
	
	/**
	 * 用户界面 手机号码输入框
	 */
	@FindBy(xpath="//form[@class=\"el-form\"]/div[5]/div/div/input")
	private WebElement add_userphone_input;
	/**
	 * 用户界面 角色下拉框
	 */
	@FindBy(xpath="//i[@class='el-input__icon el-icon-caret-top']")
	private WebElement add_userRole_button;
	
	/**
	 * 用户界面 角色选择框
	 */
	@FindBy(xpath="html/body/div[2]/div/div[1]/ul/li")
	private List<WebElement> role_list;
	
	/**
	 * 用户界面 角色选择框收起
	 */
	@FindBy(xpath="//i[@class=\"el-input__icon el-icon-caret-top is-reverse\"]")
	private WebElement close_drop_down_button;
	
	
//	@FindBy(xpath="//form[@class=\"el-form\"]/div[6]/div/div/div[1]/span")
//	private List<WebElement> role_List;
	
	/**
	 * 修改用户  角色删除
	 */
	@FindBy(xpath="//form[@class=\"el-form\"]/div[6]/div/div/div[1]/span/span[last()]/i")
	private WebElement role_delete;
	
	/**
	 * 用户界面 平台账号输入框
	 */
	@FindBy(xpath="//form[@class=\"el-form\"]/div[7]/div/div/input")
	private WebElement add_account_input;
	
	/**
	 * 用户界面 工作区选择框
	 */
	@FindBy(xpath="//div[@class=\"el-transfer\"]/div/div/div/label")
	private List<WebElement> WeokArea_select;
	
	/**
	 * 用户界面  全选未选工作区按键
	 */
	@FindBy(xpath="//div[@class=\"el-transfer\"]/div[1]/p[2]/label/span[1]/span")
	private WebElement work_all_button;
	
	/**
	 * 用户界面  全选已选工作区按键
	 */
	@FindBy(xpath="//div[@class=\"el-transfer\"]/div[3]/p[2]/label/span[1]/span")
	private WebElement work_all_seleted;
	
	/**
	 * 用户界面  把已选工作区移动到未选工作区按键
	 */
	@FindBy(xpath="//div[@class=\"el-transfer\"]/div[2]/button[1]")
	private WebElement move_button1;
	
	/**
	 * 用户界面  把未选工作区移动到已选工作区按键
	 */
	@FindBy(xpath="//div[@class=\"el-transfer\"]/div[2]/button[2]")
	private WebElement move_button;
	
	/**
	 * 用户界面  返回用户管理界面按钮
	 */
	@FindBy(xpath="//span[text()=\"返回\"]")
	private WebElement return_Button;
	
	/**
	 * 用户界面  新增用户或者编辑用户提交按钮
	 */
	@FindBy(xpath="//span[text()=\"提交\"]")
	private WebElement submit_btn; 
	
	/**
	 * 用户界面  提交后的确认按钮
	 */
	@FindBy(css=".el-button.el-button--default.el-button--primary")
	private WebElement confirm_btn;
	
	
	
	/**
	 * 新增用户提交后跳转结果显示的文本区域
	 */
	@FindBy(xpath="//tr[@class=\"el-table__row\"]/td[3]")
	public List<WebElement> user_list_text;
	/**
	 * 用户的用户名为空提示
	 */
	@FindBy(xpath="//div[text()=\"请输入姓名\"]")
	private WebElement Usernull_result_text; 
	/**
	 * 用户的手机号码为空提示
	 */
	@FindBy(xpath="//form[@class=\"el-form\"]/div[5]/div/div[2]")
	private WebElement phoneerorr_result_text;
	/**
	 *  用户的角色为空提示
	 */
	@FindBy(xpath="//form[@class=\"el-form\"]/div[6]/div/div[2]")
	private WebElement roleerorr_result_text;
	/**
	 *  用户的平台账号重复提示
	 */
	@FindBy(xpath="html/body/div[4]/div/p")
	private WebElement Erorr_result_tetx;
	

	
	//构造函数
	public User_AddorEdit_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}

	/**
	 * 新增用户名，点击新增按钮
	 */
	public void click_adduser() {
		Add_user_Button.click();
	}
		
	
	/**
	 * 执行新增用户操作， 自动填入用户名，性别，年龄，地址，手机号，角色，平台账号，工作区
	 * @param driver  初始化
	 * @param username	输入用户名
	 * @param sex		选择年龄
	 * @param age		输入年龄
	 * @param adress	输入地址
	 * @param phone		输入手机号
	 * @param Rolenum	选择角色
	 * @param accoutID	输入平台账号
	 * @param work		选择全选工作区
	 * @param workAreaNum选择指定工作区
	 */
	public void do_adduser_input(WebDriver driver,String username,String sex,String age,String adress,String phone,int Rolenum,
		String accoutID,String work,int workAreaNum) {
		add_userName_input.sendKeys(username);
		if(sex.equals("男")) {
		((JavascriptExecutor)driver).executeScript("document.getElementsByClassName(\"el-radio radio\")[0].click()");			
		}else {
		((JavascriptExecutor)driver).executeScript("document.getElementsByClassName(\"el-radio radio\")[1].click()");
		}  
		add_userAge_input.sendKeys(age);
		add_userAddress_textarea.sendKeys(adress);
		add_userphone_input.sendKeys(phone);
		add_userRole_button.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Random random = new Random();
		for(int i=0;i<Rolenum;i++) {
			int Index=random.nextInt(role_list.size());
			role_list.get(Index).click();
		}
		close_drop_down_button.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		add_account_input.sendKeys(accoutID);
		if(work.equals("all")) {
			work_all_button.click();
		}else {
			Random random_work = new Random();
			for(int j=0;j<workAreaNum;j++) {
			WeokArea_select.get(random_work.nextInt(WeokArea_select.size())).click();
		}
	}
		move_button.click();
	}

	/**
	* 新增用户，填写完用户信息，点击提交按钮
	*/
	public void click_submit_btn() {
		submit_btn.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
	/**
	* 新增用户，填写完用户信息提交按钮后，点击确认按钮
	*/
	public void go_confirm_btn() {
		confirm_btn.click(); 
	}
		
	/**
	* 用户界面，点击返回按钮
	*/
	public void click_return_btn() {
		return_Button.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	* 对新增用户提交之后的文本进行验证，如果一致则新增成功，不一致测试失败
	* @param expect  其他文本内容
	*/
	public void assersucessResult(String expect) {
		for (int i = 0; i < user_list_text.size(); i++) {
		      String name = user_list_text.get(i).getText();
		      if(name.equals(expect)) {
		         continue;
		         }     
		 }	 
	}
		
	/**
	* 新增或者编辑用户，对用户名不输入提示文本进行验证，如果一致则新增成功，不一致测试失败
	* @param expect  其他文本内容
	*/
	public void assertAddUserResult(String expect) {
	 assertEquals(Usernull_result_text.getText(), expect);	
	}
		
	
	/**
	* 新增或者编辑用户，对手机号码不输入提示文本进行验证，如果一致则测试通过，不一致测试失败
	* @param expect	其他文本内容
	*/
	public void assertphoneResult(String expect) {
		assertEquals(phoneerorr_result_text.getText(), expect);
	}
		
	/**
	* 新增或者编辑用户，对角色不选择提示文本进行验证，如果一致则测试通过，不一致测试失败
	* @param expect 其他文本内容
	*/
	public void assertRoleResult(String expect) {
		assertEquals(roleerorr_result_text.getText(), expect);
	}

	/**
	* 新增或者编辑用户，对平台账号重复提示文本进行验证，如果一致则测试通过，不一致测试失败
	* @param expect
	*/
	public void asserResult(String expect) {
		assertEquals(Erorr_result_tetx.getText(), expect);
	}
		
	
	/**
	* 执行修改用户操作， 自动修改用户名，性别，年龄，地址，手机号，角色，平台账号，工作区
	* @param driver
	* @param username	选择要修改的用户
	* @param edit_name	修改用户名
	* @param edit_sex	修改性别
	* @param edit_age	修改年龄
	* @param edit_adress修改地址
	* @param edit_phone	修改手机号
	* @param Rolenum	修改角色
	* @param edit_accoutID修改平台账号
	* @param work		修改全部选择工作区
	* @param workAreaNum修改选择多个工作区
	*/
	public void do_edit(WebDriver driver,String username,String edit_name,String edit_sex,String edit_age,String edit_adress,String edit_phone,int Rolenum,
				String edit_accoutID,String work,int workAreaNum) {
			 for (int i = 0; i <user_list_text.size(); i++) {
		           String name =user_list_text.get(i).getText();
		           if(name.equals(username)) {
		                Actions builder = new Actions(driver);
		                builder.moveToElement(driver.findElement(By.xpath("//div[text()='"+username+"']/following::td/div/button/span[text()=\"编辑用户\"]")))
		                .pause(Duration.ofSeconds(2L))
		                .click().pause(Duration.ofSeconds(2L))
		                .perform();
		                try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
		                Actions actions=new Actions(driver);
		                actions.doubleClick(add_userName_input).sendKeys(Keys.DELETE).perform();
		            	add_userName_input.sendKeys(edit_name);
		            	if(edit_sex.equals("男")) {
		        			((JavascriptExecutor)driver).executeScript("document.getElementsByClassName(\"el-radio radio\")[0].click()");			
		        			}else {
		        			((JavascriptExecutor)driver).executeScript("document.getElementsByClassName(\"el-radio radio\")[1].click()");
		        			} 
		            	actions.doubleClick(add_userAge_input).sendKeys(Keys.DELETE).perform();
		            	add_userAge_input.sendKeys(edit_age);
		            	actions.doubleClick(add_userAddress_textarea).sendKeys(Keys.DELETE).perform();
		            	add_userAddress_textarea.sendKeys(edit_adress);
		            	actions.doubleClick(add_userphone_input).sendKeys(Keys.DELETE).perform();
		        		add_userphone_input.sendKeys(edit_phone);//修改手机号码
		        		role_delete.click();
		        		add_userRole_button.click();
		        		try {
		        			Thread.sleep(1000);
		        		} catch (InterruptedException e) {
		        			e.printStackTrace();
		        		}
		        		Random random = new Random();
		        		for(int edit_i=0;edit_i<Rolenum;edit_i++) {
		        			int Index=random.nextInt(role_list.size());
		        			role_list.get(Index).click();  //修改角色
		        		}
		        		close_drop_down_button.click();
		        		actions.doubleClick(add_account_input).sendKeys(Keys.DELETE).perform();
		        		add_account_input.sendKeys(edit_accoutID);//修改平台账号
		        		work_all_seleted.click();
		        		move_button1.click();  
		        		if(work.equals("all")) {
		        			work_all_button.click();
		        		}else {
		        			Random random_work = new Random();
		        			for(int j=0;j<workAreaNum;j++) {
		        				WeokArea_select.get(random_work.nextInt(WeokArea_select.size())).click();//���ѡ������
		        			}
		        		}
		        		move_button.click();
		           } 
			
		}	
		
	  }

	

		
	
}
