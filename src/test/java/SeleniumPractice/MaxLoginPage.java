package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MaxLoginPage {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		//By ctry = By.xpath("//div[@data-country='Singapore']");
		By firstName = By.className("form-control.account-info-firstname");
		
		BrowserUtils brUtil = new BrowserUtils();
		driver = brUtil.launchBrowser("Chrome");
		driver.get("https://qa.max.com/shop/create-account/");
		driver.manage().window().maximize();
		ElementUtil eleUtil = new ElementUtil(driver);
		By ctry = eleUtil.getBy("xpath", "//div[@data-country='Singapore']");
		eleUtil.doClick(ctry);
		Thread.sleep(3000);
		eleUtil.doSendKeys(firstName, "testabc");
	}

}
