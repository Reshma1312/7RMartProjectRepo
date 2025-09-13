package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	
	//@FindBy(xpath)WebElement elementname
@FindBy(xpath="//input[@name='username']")WebElement unameField;
	
	@FindBy(xpath="//input[@placeholder='Password']")WebElement pwdField;
	
	@FindBy(xpath="//button[text()='Sign In']")WebElement signin;
	
	@FindBy(xpath="//button[@class='close']")WebElement alertpopup;

	
	public WebDriver driver;

public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

public LoginPage enterUserName(String username)
{
	unameField.sendKeys(username);
	return this;
}

public LoginPage enterPassword(String password)
{
	pwdField.sendKeys(password);
	return this;
}

public LogoutPage clickSignIn()
{
	signin.click();
	return new LogoutPage(driver);
}
public boolean alertPopUp()
{
	return alertpopup.isDisplayed();
}

}


