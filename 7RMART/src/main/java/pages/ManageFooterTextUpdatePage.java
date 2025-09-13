package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageFooterTextUpdatePage 
{
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")WebElement footerTextMoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1' and @role='button']")WebElement actionBtn;
	@FindBy(id="content")WebElement address;
	@FindBy(id="email")WebElement email;
	@FindBy(id="phone")WebElement phoneno;
	@FindBy(xpath="//button[@name='Update']")WebElement updateBtn;
	@FindBy(xpath="//h1[text()='Footer Text']")WebElement footerText;
	
	
	WebDriver driver;
	public ManageFooterTextUpdatePage(	WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public ManageFooterTextUpdatePage actionClick()
	{
		actionBtn.click();
		return this;
	}
	public ManageFooterTextUpdatePage updateAddress(String addressFld)
	{
		address.clear();
		address.sendKeys(addressFld);
		return this;
		
	}
	public ManageFooterTextUpdatePage updateemail( String emailFld)
	{
		email.clear();

		email.sendKeys(emailFld);
		return this;
	}
	public ManageFooterTextUpdatePage upDateFoneno(String phoneNo) {
		
		phoneno.clear();

		phoneno.sendKeys(phoneNo);
		return this;
	}
	public ManageFooterTextUpdatePage scrollPage() 
	{
		PageUtility pageutility=new PageUtility();
		pageutility.scrollFromTop(driver);
		return this;
	}
	public ManageFooterTextUpdatePage clickUpdate()
	{
		updateBtn.click();
		return this;
	}
	public boolean footertext()
	{
		return footerText.isDisplayed(); 
	}
	
	
	
	
	
	
	
	
}
