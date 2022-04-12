package SeleniumPractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowIterator {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");// parent window
         
		By facebookLink = By.xpath("//img[@alt='OrangeHRM on Facebook']");
		By linkedIn = By.xpath("//img[@alt='LinkedIn OrangeHRM group']");
		By twitter = By.xpath("//img[@alt='OrangeHRM on twitter']");
		By youTube = By.xpath("//img[@alt='OrangeHRM on twitter']");
		
		handleChildWindow(facebookLink);
		handleChildWindow(linkedIn);
		handleChildWindow(twitter);
		handleChildWindow(youTube);
		
		//driver.close();

	}
	
	public static void handleChildWindow(By locator) throws InterruptedException
	{
		driver.findElement(locator).click();
		Set<String> windowHandler = driver.getWindowHandles();
		Iterator<String> iterator = windowHandler.iterator();
		String parentWindowId = iterator.next();
		String childWindowId = iterator.next();
		driver.switchTo().window(childWindowId);
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindowId);
		//System.out.println(driver.getTitle());
	}



}

