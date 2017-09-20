package com.erp.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.erp.TestUtils.BeforeErpTest;
import com.erp.pages.IndexPage;
import com.erp.pages.User_AddorEdit_Page;

import TestData.UserDataFactory;

public class AddorEdit_User_Test extends BeforeErpTest  {
	
	private User_AddorEdit_Page userinfo;
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
		userinfo=new User_AddorEdit_Page(driver);
		
	}
	
	/*
	 * 用户名新增成功测试用例
	 *  
	 */
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="addUser_sucess_test_data")
	public void adduser_sucess_test(String username,String sex,String age,String adress,String phone,int rolenum,String ID,String work,int workNum,String expect) {	
		userinfo.click_adduser();
		userinfo.do_adduser_input(driver,username,sex, age, adress, phone, rolenum, ID, work, workNum);
		userinfo.click_submit_btn();
		userinfo.go_confirm_btn();
		userinfo.assersucessResult(expect);		
	}
	
	/*  
     * 用户名测试用例
     * 1、用户名为空
     *
     **/ 
     
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="UserName_test_data")
	public void add_user_Nametest(String username,String sex,String age,String adress,String phone,int rolenum,String ID,String work,int workNum,String expect) {	
		userinfo.click_adduser();
		userinfo.do_adduser_input(driver,username, sex, age, adress, phone, rolenum, ID, work, workNum);
		userinfo.click_submit_btn();
		userinfo.assertAddUserResult(expect);
	}

	
	/* 手机号码测试用例
	 * 1、手机号码为空
	 * 2、手机格式错误
	 */
	 
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="Phone_test_data")
	public void add_user_Phonetest(String username,String sex,String age,String adress,String phone,int rolenum,String ID,String work,int workNum,String expect) {	
		userinfo.click_adduser();
		userinfo.do_adduser_input(driver, username, sex, age, adress, phone, rolenum, ID, work, workNum);
		userinfo.click_submit_btn();
		userinfo.assertphoneResult(expect);
	}
	
	
	 /* 角色测试用例
	 * 1、角色为空
	 */ 
	 
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="role_test_data")
	public void add_user_Roletest(String username,String sex,String age,String adress,String phone,int rolenum,String ID,String work,int workNum,String expect) {	
		userinfo.click_adduser();
		userinfo.do_adduser_input(driver, username, sex, age, adress, phone, rolenum, ID, work, workNum);
		userinfo.click_submit_btn();
		userinfo.assertRoleResult(expect);
	}
	
	/*
	 * 角色数据是否正确
	 */
	
	@Test
	public void role_data_Test() {
		
	}
	
	/*
	 * 平台账号测试用例
	 * 平台账号已存在
	 */
	
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="ID_test_data")
	public void add_user_IDtest(String username,String sex,String age,String adress,String phone,int rolenum,String ID,String work,int workNum,String expect) {	
		userinfo.click_adduser();
		userinfo.do_adduser_input(driver, username, sex, age, adress, phone, rolenum, ID, work, workNum);
		userinfo.click_submit_btn();
		userinfo.go_confirm_btn();
		userinfo.asserResult(expect);
	}
	
	/*
	 * 返回按钮
	 * 
	 */
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="return_test_data")
	public void add_user_Returntest(String username,String sex,String age,String adress,String phone,int rolenum,String ID,String work,int workNum,String expect) {	
		userinfo.click_adduser();
		userinfo.do_adduser_input(driver, username, sex, age, adress, phone, rolenum, ID, work, workNum);
		userinfo.click_return_btn();
		driver.getCurrentUrl().equals(expect);
	}
	
	/*
	 * 编辑用户
	 * 1、修改成功
	 */
	
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="editSucess_test_data")
	public void user_edit_sucess_test(String username,String e_name,String e_sex,String e_age,String e_adress,String e_phone,int rolenum,String ID,String work,int worknum) {
		userinfo.do_edit(driver,username, e_name,e_sex, e_age, e_adress, e_phone, rolenum, ID, work, worknum);
		userinfo.click_submit_btn();
		userinfo.go_confirm_btn();   
	}
	
	
	/*
	 * 编辑用户
	 * 用户名为空
	 */
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="editnameNull_test_data")
	public void edit_nameNull_test(String username,String e_name,String e_sex,String e_age,String e_adress,String e_phone,int rolenum,String ID,String work,int worknum,String expect) {
		userinfo.do_edit(driver,username, e_name, e_sex,e_age, e_adress, e_phone, rolenum, ID, work, worknum);
		userinfo.click_submit_btn();
		userinfo.assertAddUserResult(expect);
	}
	
	/*
	 * 编辑用户
	 * 手机为空
	 * 手机号码有误
	 */
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="editphoneNull_test_data")
	public void edit_phoneNull_test(String username,String e_name,String e_sex,String e_age,String e_adress,String e_phone,int rolenum,String ID,String work,int worknum,String expect) {
		userinfo.do_edit(driver,username, e_name,e_sex, e_age, e_adress, e_phone, rolenum, ID, work, worknum);
		userinfo.click_submit_btn();
		userinfo.assertphoneResult(expect);
	}
	
	/*
	 * 编辑用户
	 * 角色为空
	 */
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="editroleNull_test_data")
	public void edit_roleNull_test(String username,String e_name,String e_sex,String e_age,String e_adress,String e_phone,int rolenum,String ID,String work,int worknum,String expect) {
		userinfo.do_edit(driver,username, e_name, e_sex,e_age, e_adress, e_phone, rolenum, ID, work, worknum);
		userinfo.click_submit_btn();
		userinfo.assertRoleResult(expect);
	}
	
	/*
	 * 编辑用户
	 * 平台账号重复
	 */
	@Test(dataProviderClass=UserDataFactory.class,dataProvider="editIDRepeat_test_data")
	public void edit_IDRepeat_test(String username,String e_name,String e_sex,String e_age,String e_adress,String e_phone,int rolenum,String ID,String work,int worknum,String expect) {
		userinfo.do_edit(driver,username, e_name,e_sex, e_age, e_adress, e_phone, rolenum, ID, work, worknum);
		userinfo.click_submit_btn();
		userinfo.go_confirm_btn();
		userinfo.asserResult(expect);
	}
	

}
