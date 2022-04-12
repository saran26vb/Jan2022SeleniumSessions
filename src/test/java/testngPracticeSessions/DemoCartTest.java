package testngPracticeSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoCartTest extends BaseTest {
	WebDriver driver;

	@Test(description = "verifying title test of demo cart application....")
	public void titleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Account Login11");
	}

	@Test(enabled = true, description = "url test....")
	public void urlTest() {
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("account/login"));
	}

	@Test(description = "this is search test.....")
	public void searchTest() {
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		Assert.assertTrue(driver.findElement(By.name("search")).isDisplayed());
	}


}
