package TestData;

import org.testng.annotations.DataProvider;

public class UserDataFactory {
	
	  //用户名新增成功数据
	   @DataProvider(name="addUser_sucess_test_data")
	   public static Object[][] adduserTestData(){
			Object[][] objs=new Object[][] {
				{"zhenghl01","女","20","地址001","15859182404",1,"zhenghl","",1,"zhenghl01"},
				{"zhenghl02","男","30","地址002","15859182400",3,"","",1,"zhenghl02"},
				{"zhenghl03","女","20","地址003","15859182400",3,"","",1,"zhenghl02"},
				{"zhenghl04","女","20","地址004","15859182400",3,"","",1,"zhenghl02"}
		};
		return objs;
		}
	   //用户名为空数据
		@DataProvider(name="UserName_test_data")
		public static Object[][] UserNameTestData(){
			Object[][] objs=new Object[][] {
				{"","男","20","地址","15859182404",3,"zhenghl","",2,"请输入姓名"}
		};
		return objs;
		}
		//手机号码数据
		@DataProvider(name="Phone_test_data")
		public static Object[][] PhoneTestData(){
			Object[][] objs=new Object[][] {
				{"zhenghl","女","20","地址","",3,"zhenghl","",2,"请输入手机号"},
				{"zhenghl","女","20","地址","158591",3,"zhenghl","",2,"手机号码有误，请重填"}
		};
		return objs;
		}
		//角色数据
		@DataProvider(name="role_test_data")
		public static Object[][] RoleTestData(){
			Object[][] objs=new Object[][] {
				{"zhenghl","女","20","地址","15859182404",0,"zhenghl","",2,"请选择角色"}
			};
			return objs;
		}
		
		//平台账号已存在
		@DataProvider(name="ID_test_data")
		public static Object[][] IDTestData(){
			Object[][] objs=new Object[][] {
				{"zhenghl","女","20","地址","15859182404",3,"xief","",2,"平台账号重复"}
			};
			return objs;
		}
		
		//返回按钮
		@DataProvider(name="return_test_data")
		public static Object[][] returnTestData(){
			Object[][] objs=new Object[][] {
				{"zhenghl","男","20","地址","15859182404",3,"","",2,"http://192.168.1.250:7000/#/user"}
			};
			return objs;
		}
		
		//查询正确的数据
		@DataProvider(name="query_test_data")
		public static Object[][] queryTestData(){
			Object[][] objs=new Object[][] {
				{"zhenghl01","zhenghl01"},
				{"zhenghl","zhenghl"},
				{"上海",""}
			};
			return objs;
		}
		
		//查询错误的数据
		@DataProvider(name="queryerorr_test_data")
		public static Object[][] queryErorrTestData(){
			Object[][] objs=new Object[][] {
				{"上海",0}
			};
			return objs;
		}
		
		//修改数据
		@DataProvider(name="editSucess_test_data")
		public static Object[][] editSucess_test_data(){
			Object[][] objs=new Object[][] {
				{"zhenghl02","玲玲","女","10","鼓楼区","15859182409",1,"","all",0},
				{"玲玲","zhenghl02","男","30","地址02","15859182400",1,"","",1}
			};
			return objs;
		}
		
		@DataProvider(name="editnameNull_test_data")
		public static Object[][] editnameNull_test_data(){
			Object[][] objs=new Object[][] {
				{"zhenghl03","","女","10","鼓楼区","15859182409",1,"","all",0,"请输入姓名"},
			};
			return objs;
		}
		

		@DataProvider(name="editphoneNull_test_data")
		public static Object[][] editphoneNull_test_data(){
			Object[][] objs=new Object[][] {
				{"zhenghl03","zhenghl003","女","10","鼓楼区","",1,"","all",0,"请输入手机号"},
				{"zhenghl03","zhenghl004","女","10","鼓楼区","158591",1,"","all",0,"手机号码有误，请重填"}
			};
			return objs;
		}
		
		@DataProvider(name="editroleNull_test_data")
		public static Object[][] editroleNull_test_data(){
			Object[][] objs=new Object[][] {
				{"zhenghl03","zhenghl003","女","10","鼓楼区","15859182403",0,"","all",0,"请选择角色"},
			};
			return objs;
		}
		
		@DataProvider(name="editIDRepeat_test_data")
		public static Object[][] editIDRepeat_test_data(){
			Object[][] objs=new Object[][] {
				{"zhenghl03","zhenghl003","女","10","鼓楼区","15859182403",1,"zhenghl","all",0,"平台账号重复"},
			};
			return objs;
		}
		
		//登录数据
		@DataProvider(name="editLogin_sucess_test_data")
		public static Object[][] editLogin_sucess_test_data(){
			Object[][] objs=new Object[][] {
				{"zhenghl01","zhenghl","123456","http://192.168.1.250:7000/#/dashboard"}
			};
			return objs;
		}
		
		@DataProvider(name="Lusername_Null_test_data")
		public static Object[][] Lusername_Null_test_data(){
			Object[][] objs=new Object[][] {
				{"zhenghl04","","123456","请输入账号"}
			};
			return objs;
		}
		@DataProvider(name="LPassword_Null_test_data")
		public static Object[][] LPassword_Null_test_data(){
			Object[][] objs=new Object[][] {
				{"zhenghl04","zhenghl","","请输入密码"}
			};
			return objs;
		}
		
		@DataProvider(name="LuserName_exist_test_data")
		public static Object[][] LuserName_exist_test_data(){
			Object[][] objs=new Object[][] {
				{"zhenghl04","admin","123456","账号名称重复"}
			};
			return objs;
		}
		
		@DataProvider(name="editLogin_alter_test_data")
		public static Object[][] editLogin_alter_test_data(){
			Object[][] objs=new Object[][] {
				{"zhenghl01","zhenghl01","123456","zhenghl","123456","账号或密码错误"}
			};
			return objs;
		}
		
		@DataProvider(name="editLogin_delete_test_data")
		public static Object[][] editLogin_delete_test_data(){
			Object[][] objs=new Object[][] {
				{"zhenghl01","删除成功"}
			};
			return objs;
		}
		
	//用户单个删除结果
		@DataProvider(name="user_delete_test_data")
		public static Object[][] user_delete_test_data(){
			Object[][] objs=new Object[][] {
				{"zhenghl04","删除成功"}
			};
			return objs;
		}
		
		@DataProvider(name="manyuser_delete_test_data")
		public static Object[][] manyuser_delete_test_data(){
			Object[][] objs=new Object[][] {
				{"zhenghl01","zhenghl02","zhenghl03","删除成功"}
			};
			return objs;
		}
		
		
}
