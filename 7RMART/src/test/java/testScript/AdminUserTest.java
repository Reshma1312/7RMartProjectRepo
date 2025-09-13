package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;
import utilities.PageUtility;

public class AdminUserTest extends Base
{
	AdminUserPage adminuserpage;
	LogoutPage logout;
	@Test
	public void verifyWhetherUserIsAbleToAddNewAdminUser() throws IOException
	{
		String username=ExcelUtility.getStringData(1,0,"login");//the value given in double quotes should be same as the name given in excel sheet
		String password=ExcelUtility.getStringData(1,1,"login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		logout=loginpage.clickSignIn();
		
		//AdminUserPage adminuserpage=new AdminUserPage(driver);
		adminuserpage=	logout.clickAdminUser();
		
		
		String usertypevalue=ExcelUtility.getStringData(0, 0, "newadminuser");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "newadminuser");
		adminuserpage.clickNewBtn().enterUserType(usertypevalue).enterPassword(passwordvalue);
		//adminuserpage.enterUserType(usertypevalue);
		//adminuserpage.enterPassword(passwordvalue);
		
		adminuserpage.clickUserTypeDropdown();
		
		
		adminuserpage.clickSave();
		
		 boolean alertmsg=adminuserpage.alertMessage();
		 Assert.assertTrue(alertmsg);
		
		
		
		
		
		
		
	}
}
