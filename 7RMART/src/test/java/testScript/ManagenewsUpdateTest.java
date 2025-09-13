package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManagenewsPage;
import pages.ManagenewsUpdatePage;
import utilities.ExcelUtility;

public class ManagenewsUpdateTest extends Base
{
	@Test
	public void verifyWhetherUserIsAbleToUpdateNews() throws IOException
	{
		String username=ExcelUtility.getStringData(1,0,"login");//the value given in double quotes should be same as the name given in excel sheet
		String password=ExcelUtility.getStringData(1,1,"login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		
		
		ManagenewsPage managenewspage=new ManagenewsPage(driver);

		managenewspage.clickMoreInfo();


		ManagenewsUpdatePage managenewsupdatepage=new ManagenewsUpdatePage(driver);
		managenewsupdatepage.clickEdit();
		managenewsupdatepage.clearText();
		
		String updatedText=ExcelUtility.getStringData(0,0,"managenewsupdate");//the value given in double quotes shouheet
		managenewsupdatepage.enterNewText(updatedText);
		managenewsupdatepage.clickUpdate();
		boolean msg=managenewsupdatepage.message();
		Assert.assertTrue(msg);
	}
}
