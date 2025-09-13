package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagenewsPage 
{
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement manageNews_moreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add' and @onclick='click_button(1)']")WebElement newbutton;
	@FindBy(xpath="//textarea[@placeholder='Enter the news']")WebElement enternews;
	@FindBy(xpath="//button[text()='Save']")WebElement savenews;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successAlert;
	
	public WebDriver driver;

	public ManagenewsPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	
	
	public ManagenewsPage clickNew()
	{
		newbutton.click();
		return this;
	}
	public ManagenewsPage enterNews(String news)
	{
		enternews.sendKeys(news);
		return this;
	}
	
	public ManagenewsPage clickSave()
	{
		savenews.click();
		return this;
	}
	public boolean alertpopup()
	{
		return successAlert.isDisplayed();
	}
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

