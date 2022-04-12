package SeleniumPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleList {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");// parent window
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handlesList = new ArrayList<String>(windowHandles);
		
		String parentWindowId = handlesList.get(0);
		String childWindowId = handlesList.get(1);
		
		driver.switchTo().window(childWindowId);
		System.out.println(driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
