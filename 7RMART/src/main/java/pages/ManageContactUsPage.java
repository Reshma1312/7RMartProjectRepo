package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactUsPage
{
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")WebElement contactMoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1' and @class='btn btn-sm btn btn-primary btncss']")WebElement actionBtn;
	@FindBy(xpath="//input[@id='phone']")WebElement phoneNoField;
	@FindBy(xpath="//input[@id='email']")WebElement email;
	@FindBy(xpath="//textarea[@placeholder='Enter the Address']")WebElement address;
	@FindBy(xpath="//textarea[@placeholder='Enter Delivery Time']")WebElement deliveryTime;
	@FindBy(xpath="//input[@id='del_limit']")WebElement deliveryChargeLimit;
	@FindBy(xpath="//button[@name='Update']")WebElement update;
	@FindBy(xpath="//h1[text()='Contact Us']")WebElement contactUs;
	
	 WebDriver driver;
	
	public ManageContactUsPage(	 WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	
	public ManageContactUsPage clickActionBtn()
	{
		actionBtn.click();
		return this;
	}
	public ManageContactUsPage clearAllfields()
	{
		phoneNoField.clear();
		email.clear();
		address.clear();
		deliveryTime.clear();
		deliveryChargeLimit.clear();
		return this;
	}
	public ManageContactUsPage upDateAllFields(String phonenumber,String emailFld,String addressFld,String time,String chargeLimit) 
	{
		phoneNoField.sendKeys(phonenumber);
		email.sendKeys(emailFld);
		address.sendKeys(addressFld);
		deliveryTime.sendKeys(time);
		deliveryChargeLimit.sendKeys(chargeLimit);
		return this;
	}
	public ManageContactUsPage saveAll()
	{
		PageUtility pageUtility=new PageUtility();
		pageUtility.click(driver, update);
		//update.click();
		return this;
	}
	
	public boolean contactus()
	{
		return contactUs.isDisplayed();
	}
	
}
