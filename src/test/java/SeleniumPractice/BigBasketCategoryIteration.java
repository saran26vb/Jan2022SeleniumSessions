package SeleniumPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BigBasketCategoryIteration {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.bigbasket.com");
		By shopByCategory = By.className("meganav-shop");
		
		By parentMenuOptions = By.xpath("(//ul[@id='navBarMegaNav']//a)");
		
		By childMenu2 = By.linkText("Tea");
		By subchildMenu3 = By.linkText("Tea Bags");
		getElementsOnMouseHover(shopByCategory,parentMenuOptions);
		//selectSubMenu(shopByCategory, childMenu1,childMenu2,subchildMenu3);
		
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void getElementsOnMouseHover(By parentMenu, By parentMenuOptions) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		List<WebElement> parentOptionsList = driver.findElements(parentMenuOptions);
		Thread.sleep(3000);
		List<String> parentOptionsText =new ArrayList<String>();
		List<String> childOptionsText =new ArrayList<String>();
		
		for(WebElement e: parentOptionsList)
		{
			System.out.println("Parent "+e.getText());
			act.moveToElement(e).perform();
			Thread.sleep(2000);
			List<WebElement> childOptionsList = driver.findElements(By.xpath("(//ul[@class='nav nav-pills nav-stacked'])[last()]//a"));			
			for(WebElement e1: childOptionsList)
			{
				System.out.println("child 1 "+e1.getText());
				act.moveToElement(e1).perform();
				Thread.sleep(2000);
				List<WebElement> subChildList = driver.findElements(By.xpath("(//ul[@class='list-unstyled'])[3]"));
				for(WebElement e2 : subChildList)
				{
					System.out.println("child 2"+e2.getText());
					act.moveToElement(e2).perform(); 
					Thread.sleep(2000);
					List<WebElement> popularSearchList = driver.findElements(By.xpath("(//ul[@class='list-unstyled'])[4]"));
					for(WebElement e3 : popularSearchList)
					{
						System.out.println("child 3"+e3.getText());
					}
					
					
				}
			}
		}
		//System.out.println(childOptionsText);
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