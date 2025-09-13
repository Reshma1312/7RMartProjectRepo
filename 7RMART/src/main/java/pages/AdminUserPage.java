package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUserPage 
{
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminuser_moreinfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newbtn;
	@FindBy(xpath="//input[@id='username']")WebElement username;
	@FindBy(xpath="//input[@id='password']")WebElement password;
	@FindBy(xpath="//select[@name='user_type']")WebElement usertype;
	@FindBy(xpath="//button[@name='Create']")WebElement saveAdminUserInfo;
	@FindBy(xpath="//h1[text()='Admin Users']")WebElement AdminUser;
	
	public WebDriver driver;
	public AdminUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public AdminUserPage clickNewBtn()
	{
		newbtn.click();
		return this;
	}
	public AdminUserPage enterUserType(String usertypevalue)
	{
		username.sendKeys(usertypevalue);
		return this;
	}
	public AdminUserPage enterPassword(String passwordvalue)
	{
		password.sendKeys(passwordvalue);
		return this;
		
	}
	
	public AdminUserPage clickUserTypeDropdown()
	{
		PageUtility pageutility=new PageUtility();
		pageutility.selectByVisibleText(usertype, "Partner");
		usertype.click();
		return this;
	}
	public AdminUserPage clickSave()
	{
		saveAdminUserInfo.click();
		return this;
	}
	public boolean alertMessage()
	{
		return AdminUser.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
}


