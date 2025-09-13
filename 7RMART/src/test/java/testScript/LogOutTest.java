package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogOutTest extends Base
{
	@Test
	public void verifyWhetherUserIsableToLogOut() throws IOException
	{
		
		String username=ExcelUtility.getStringData(1,0,"login");//the value given in double quotes should be same as the name given in excel sheet
		String password=ExcelUtility.getStringData(1,1,"login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		
		LogoutPage logoutpage=new LogoutPage(driver);
		logoutpage.clickadmin();
		logoutpage.clicklogout();
		boolean success=logoutpage.alertpopup();
		Assert.assertTrue(success);;
		
	}
}
