package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage 
{
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement admin;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")WebElement logout;
		@FindBy(xpath="//button[text()='Sign In']")WebElement signin;

		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminuser_moreinfo;
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")WebElement manageCatMoreInfo;
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")WebElement contactMoreInfo;
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")WebElement footerTextMoreinfo;
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement manageNews_moreinfo;



public WebDriver driver;

public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

public AdminUserPage clickAdminUser()
{
	//return this;
	adminuser_moreinfo.click();
	return new  AdminUserPage(driver);
}

public ManageCategoryPage clickMoreInfoCat()
{
	manageCatMoreInfo.click();
	return new  ManageCategoryPage(driver);

}
public ManageContactUsPage clickMoreInfo()
{
	contactMoreInfo.click();
	return new  ManageContactUsPage(driver);
}

public ManageFooterTextUpdatePage clickMoreInfoFooter() 
{
	footerTextMoreinfo.click();
	return new  ManageFooterTextUpdatePage(driver);

}

	public ManageNewsPage clickingMoreInfoOfManageNews()
	{
	manageNews_moreinfo.click();
	return new  ManageNewsPage(driver);

	}
	/*public ManagenewsUpdatePage clickMore_infoUpdate() 
	{
		
	}*/
	public void clickadmin()
	{
		admin.click();
	}
	public void clicklogout()
	{
		logout.click();
	}
	public boolean alertpopup()
	{
		return signin.isDisplayed();
	}
}
