package SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtils {
	
	private WebDriver driver;

	
	public WebDriver launchBrowser(String browser)
	{
		System.out.println(System.getProperty("user.dir"));
		if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else
			System.out.println("Enter the right browser Name");
		
		return driver;
	}
	
	public void getUrl(String Url)
	{
		if(Url==null)
		{
			System.out.println("Enter the right url");
			return;
		}
		if(Url.contains("http") || Url.contains("https"))
		{
			driver.get(Url);
		}
		else
		{
			driver.close();
			try
			{
				throw new Exception("INVALIDURLEXCEPTION- Pass the right url");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public void getPageUrl()
	{
		driver.getCurrentUrl();
	}
	
	public void closeBrowser()
	{
		driver.close();
	}
	
	public void quitBrowser()
	{
		driver.quit();
	}

}
