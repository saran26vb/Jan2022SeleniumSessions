package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverConcept_BigBasket {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.bigbasket.com");
		By shopByCategory = By.className("meganav-shop");
		
		By childMenu1 = By.linkText("Beverages");		
		By childMenu2 = By.linkText("Tea");
		By subchildMenu3 = By.linkText("Tea Bags");
		
		selectSubMenu(shopByCategory, childMenu1,childMenu2,subchildMenu3);
		
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void selectSubMenu(By parentMenu, By childMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		getElement(childMenu).click();
	}

	public static void selectSubMenu(By parentMenu, By childMenu, By subChildMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(childMenu)).perform();
		Thread.sleep(2000);
		getElement(subChildMenu).click();
	}

	public static void selectSubMenu(By parentMenu, By childMenu1, By subChildMenu2, By subChildMenu3)
			throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(childMenu1)).perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(subChildMenu2)).perform();
		Thread.sleep(2000);
		getElement(subChildMenu3).click();
	}

}