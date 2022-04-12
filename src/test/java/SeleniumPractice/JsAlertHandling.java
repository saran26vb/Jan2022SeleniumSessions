package SeleniumPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class JsAlertHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		/*
		 * driver.findElement(By.xpath("//button[contains(text(),'JS Alert')]")).click()
		 * ; Alert alert = driver.switchTo().alert();
		 * System.out.println(alert.getText()); alert.accept();
		 */

		// JS COnfirm
		driver.findElement(By.xpath("//button[contains(text(),'JS Confirm')]")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		String resultText = driver.findElement(By.id("result")).getText();
		Assert.assertEquals("You clicked: Ok", resultText);
		
        //JS prompt
		driver.findElement(By.xpath("//button[contains(text(),'JS Prompt')]")).click();
		alert.sendKeys("JS Prompt");
		alert.accept();
		System.out.println(resultText);
		driver.close();
		
		

	}

}
