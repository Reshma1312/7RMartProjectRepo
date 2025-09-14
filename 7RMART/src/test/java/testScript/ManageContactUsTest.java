package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageContactUsPage;
import utilities.ExcelUtility;

public class ManageContactUsTest extends Base
{
	ManageContactUsPage managecontactuspage;
	LogoutPage logout;

	@Test(retryAnalyzer=retry.Retry.class)
	public void verifyWhetherUserIsAbleToUpdateContactUsInfo() throws IOException
	{
		String username=ExcelUtility.getStringData(1,0,"login");//the value given in double quotes should be same as the name given in excel sheet
		String password=ExcelUtility.getStringData(1,1,"login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		logout=loginpage.clickSignIn();
		
		ManageContactUsPage managecontactuspage=new ManageContactUsPage(driver);
		
		
		managecontactuspage=logout.clickMoreInfo();
		
		
		
		String phonenumber=ExcelUtility.getIntegerData(0,0,"managecontactus");
		String emailFld=ExcelUtility.getStringData(0,1,"managecontactus");
		String addressFld=ExcelUtility.getStringData(0,2,"managecontactus");
		String time=ExcelUtility.getIntegerData(0,3,"managecontactus");
		String chargeLimit=ExcelUtility.getIntegerData(0,4,"managecontactus");
		
		managecontactuspage.clickActionBtn().clearAllfields().upDateAllFields(phonenumber, emailFld, addressFld, time, chargeLimit).saveAll();
		//managecontactuspage.clearAllfields();
		//managecontactuspage.upDateAllFields(phonenumber, emailFld, addressFld, time, chargeLimit);
		
		//managecontactuspage.saveAll();
		
		boolean contact= managecontactuspage.contactus();
		Assert.assertTrue(contact,Constant.CONTACTUS);
		
		
		
		
		
		
		
		
		
		
	}
}
