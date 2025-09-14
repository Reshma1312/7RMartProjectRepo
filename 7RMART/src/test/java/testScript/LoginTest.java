package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	@Test(groups = {"regression"})
	public void verifyTheUserIsAbleToLoginUsingValidCredential() throws IOException
	{
		String username=ExcelUtility.getStringData(1,0,"login");//the value given in double quotes should be same as the name given in excel sheet
		String password=ExcelUtility.getStringData(1,1,"login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		
	}
	
	public void verifyTheUserIsAbleToLoginUsingInvalidCredential() throws IOException
	{
		//String username="admin123";
		//String password="admin123";
		String username=ExcelUtility.getStringData(2,0,"login");//t
		String password=ExcelUtility.getStringData(2,1,"login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		boolean popup=loginpage.alertPopUp();
		Assert.assertTrue(popup,Constant.LOGINWITHINVALIDCREDENTIALS);
	}
	public void verifyTheUserIsAbleToLoginUsingInvalidUserName() throws IOException
	{
		//String username="admin123";
		//String password="admin";
		
		String username=ExcelUtility.getStringData(3,0,"login");//t
		String password=ExcelUtility.getStringData(3,1,"login");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		boolean popup=loginpage.alertPopUp();
		Assert.assertTrue(popup,Constant.LOGINWITHINVALIDUSERNAME);
	}
	@Test(dataProvider ="LoginProvider")
	public void verifyTheUserIsAbleToLoginUsingInvalidPassword(String username,String password) throws IOException
	{
		//String username="admin";
		//String password="admin123";
		
		//String username=ExcelUtility.getStringData(4,0,"login");//t
		//String password=ExcelUtility.getStringData(4,1,"login");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		boolean popup=loginpage.alertPopUp();
		Assert.assertTrue(popup,Constant.LOGINWITHINCORRECTPASSWORD);
	}
	@DataProvider(name="LoginProvider")
	public Object[][] getDataFromTestData() throws Exception{
		return new Object[][] {{ExcelUtility.getStringData(4, 0,"login"),ExcelUtility.getStringData(4,1,"login")}};
		
	}	
}
