package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import pages.ManagenewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base
{	
	ManagenewsPage managenewspage;
	LogoutPage logout;

	@Test
	public void verifyWhetherUserIsAbleToAddNews() throws IOException
	{
		String username=ExcelUtility.getStringData(1,0,"login");//t
		String password=ExcelUtility.getStringData(1,1,"login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		logout=loginpage.clickSignIn();
		
		String news=ExcelUtility.getStringData(0,0,"managenewspage");//the value given in double quotes should be same as the name given in excel sheet

		//ManagenewsPage managenewspage=new ManagenewsPage(driver);
		managenewspage=	logout.clickMoreInfo_ManageNewsPage();
		managenewspage.clickNew().enterNews(news).clickSave();
		//managenewspage.enterNews(news);
		//managenewspage.clickSave();
		boolean successpopup=managenewspage.alertpopup();
		Assert.assertTrue(successpopup);;
		
	}
}
