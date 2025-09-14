package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageFooterTextUpdatePage;
import utilities.ExcelUtility;

public class ManageFooterTextUpdateTest extends Base
{
	ManageFooterTextUpdateTest managefootertextupdatepage;
	LogoutPage logout;

	@Test
	public void verifyWhetherUSerISAbleToUpdateFooterText() throws IOException
	{
		String username=ExcelUtility.getStringData(1,0,"login");
		String password=ExcelUtility.getStringData(1,1,"login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		logout=loginpage.clickSignIn();
		
		ManageFooterTextUpdatePage managefootertextupdatepage=new ManageFooterTextUpdatePage(driver);
		
		managefootertextupdatepage=	logout.clickMoreInfoFooter();

		
		
		String addressFld=ExcelUtility.getStringData(0,0,"managefootertextupdate");
		String emailFld=ExcelUtility.getStringData(1,0,"managefootertextupdate");
		String phoneNo=ExcelUtility.getIntegerData(2,0,"managefootertextupdate");
		
		managefootertextupdatepage.actionClick().updateAddress(addressFld).updateemail(emailFld).upDateFoneno(phoneNo).scrollPage().clickUpdate();

		//managefootertextupdatepage.updateAddress(addressFld);
		//managefootertextupdatepage.updateemail(emailFld);
		///managefootertextupdatepage.upDateFoneno(phoneNo);
		
		//managefootertextupdatepage.scrollPage();
		//managefootertextupdatepage.clickUpdate();
		boolean footertext=managefootertextupdatepage.footertext();
		Assert.assertTrue(footertext,Constant.FOOTERTEXT);

		
	}
	

}
