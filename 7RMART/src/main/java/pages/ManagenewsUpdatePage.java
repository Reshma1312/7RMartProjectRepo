package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagenewsUpdatePage 
{
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/edit?edit=7972&page_ad=1']")WebElement editbtn;
	@FindBy(xpath="//textarea[@id='news' and @placeholder='Enter the news']")WebElement textarea;
	@FindBy(xpath="//button[text()='Update']")WebElement updatebtn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement newsInfo;
	
	public WebDriver driver;

	public ManagenewsUpdatePage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	
	public void clickEdit()
	{
		editbtn.click();
	}
	public void clearText()
	{
		textarea.clear();
	}
	
	public void enterNewText(String updatedText)
	{
		textarea.sendKeys(updatedText);
	}
	
	public void clickUpdate()
	{
		updatebtn.click();
	}
	public boolean message()
	{
		return newsInfo.isDisplayed();
	}
}
