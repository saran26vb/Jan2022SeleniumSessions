package SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleBrowsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         WebDriverManager.chromedriver().setup();
         WebDriver driver= new ChromeDriver();
         driver.get("https://www.amazon.com");
         String parentWindowId = driver.getWindowHandle();
         System.out.println(driver.getTitle());
         
         //driver.switchTo().newWindow(WindowType.WINDOW);
         driver.switchTo().newWindow(WindowType.TAB);
         driver.get("https://WWW.google.com");
         System.out.println(driver.getTitle());
         driver.close();
         
         driver.switchTo().window(parentWindowId);
         System.out.println(driver.getTitle());
	}

}
