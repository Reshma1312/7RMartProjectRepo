package testScript;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.WaitUtility;

public class Base 
{
	WebDriver driver;
	public Properties properties;
	
	
	@BeforeMethod
	@Parameters("browser")
	public void browserInitialisation(String browser) throws Exception
	{
		try
		{
			properties=new Properties();
			FileInputStream fileinputstream=new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileinputstream);
		}
		catch(Exception e)
		{
			System.out.println("File not found");
		}
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver =new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		 
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			throw new Exception("invalid");
		}
		
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize();
		
				
	}
	
	@AfterMethod
	public void quiteAndClose()
	{
		driver.quit();
	}
}
