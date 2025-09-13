package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class ManageCategoryPage
{
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")WebElement manageCatMoreInfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger' and @href='https://groceryapp.uniqassosiates.com/admin/Category/add']")WebElement newCatBtn;
	@FindBy(xpath="//input[@placeholder='Enter the Category']")WebElement newCatDetails;
	@FindBy(id="134-selectable")WebElement grpField;
	@FindBy(xpath="//input[@id='main_img']")WebElement chooseFile;
	@FindBy(xpath="//button[@type='submit' and @name='create']")WebElement saveBtn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successAlert;
	
	public WebDriver driver;
	public ManageCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public ManageCategoryPage clicknewCatBtn()
	{
		newCatBtn.click();
		return this;
	}
	public ManageCategoryPage enterCatInfo(String catName)
	{
		newCatDetails.sendKeys(catName);
		return this;
	}
	public ManageCategoryPage clickSelectFld()
	{
		grpField.click();
		PageUtility pageUtility = new PageUtility();
		pageUtility.scrollBy(driver);
		return this;
	}
	public ManageCategoryPage imageUpload()
	{
		FileUploadUtility fileuploadutility=new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(chooseFile, Constant.IMAGEUPLOAD);
		return this;
	}
	
	public ManageCategoryPage clickSave() 
	{
		
		PageUtility pageUtility = new PageUtility();
		pageUtility.click(driver, saveBtn);
		//saveBtn.click();
		return this;
	}
	public boolean success() 
	{
		return successAlert.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
