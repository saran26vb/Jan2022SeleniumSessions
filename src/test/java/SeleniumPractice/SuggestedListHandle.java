package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuggestedListHandle {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		BrowserUtils brwUtil = new BrowserUtils();
		driver = brwUtil.launchBrowser("Chrome");
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		Thread.sleep(6000);
		driver
		.findElement(By.xpath("//div[@class='ac_results']//li[contains(text(),'Casual Dresses > Printed')]"))
		.click();
		
	}

}
