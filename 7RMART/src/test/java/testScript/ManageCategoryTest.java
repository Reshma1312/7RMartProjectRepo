package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageCategoryTest extends Base
{
	ManageCategoryPage managecategorypage;
	LogoutPage logout;
	@Test(groups = {"regression"})
	public void verifyUserIsAbleToAddNewCategory() throws IOException
	{
		String username=ExcelUtility.getStringData(1,0,"login");//the value given in double quotes should be same as the name given in excel sheet
		String password=ExcelUtility.getStringData(1,1,"login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		logout=loginpage.clickSignIn();
		
		//ManageCategoryPage managecategorypage=new ManageCategoryPage(driver);
		managecategorypage=logout.clickMoreInfoCat();
		FakerUtility fakerUtility=new FakerUtility();
		String catName	=fakerUtility.creatARandomFirstName();
		//fakerUtility.creatARandomLastName();
		
		//String catName=ExcelUtility.getStringData(0,0,"managecategory");//the value given in double quotes should be same as the name given in excel sheet
		managecategorypage.clicknewCatBtn().enterCatInfo(catName).clickSelectFld().imageUpload().clickSave();
		//managecategorypage.enterCatInfo(catName);
		
		//managecategorypage.clickSelectFld()
		
		//managecategorypage.imageUpload();
		//managecategorypage.clickSave();
		
		boolean success=managecategorypage.success();
		Assert.assertTrue(success,Constant.NEWCATEGORY);
	}
}
