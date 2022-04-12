package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SvgHandler {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.className("_2doB4z")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("mobile");
		WebElement search = driver.findElement(By.xpath("//*[local-name()='svg']//*[name()='g' and @fill-rule='evenodd']"));
		Actions act =new Actions(driver);
		act.moveToElement(search).click().perform();
		
	}

}
