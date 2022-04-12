package SeleniumPractice;

import org.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi.withSha224;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		WebElement Yes = driver.findElement(By.xpath("(//label[@class='radio-inline'])[1]"));
		WebElement No = driver.findElement(By.xpath("(//label[@class='radio-inline'])[2]"));
		Actions a = new Actions(driver);
	    a.moveToElement(Yes).perform();
	    Thread.sleep(4000);
		driver.findElement(with(By.xpath("(//input[@name='newsletter'])[1]")).toLeftOf(Yes)).click();
		      
		// TODO Auto-generated method stub

	}

}
