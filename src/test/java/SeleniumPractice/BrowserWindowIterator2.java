package SeleniumPractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowIterator2 {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");// parent window
		String parentId = driver.getWindowHandle();
         
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		
		Set<String> windowHandler = driver.getWindowHandles();
		Iterator<String> it = windowHandler.iterator();
		while(it.hasNext())
		{
			String childWindowId = it.next();
			driver.switchTo().window(childWindowId);
			System.out.println(driver.getTitle());
			if(!parentId.equals(childWindowId))
			{
				driver.close();
			}			   
		}
		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());
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

