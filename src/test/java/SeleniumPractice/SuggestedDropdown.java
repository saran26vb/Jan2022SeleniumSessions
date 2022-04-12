package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuggestedDropdown {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		BrowserUtils brwUtil = new BrowserUtils();
		driver = brwUtil.launchBrowser("Chrome");
		driver.get("https://www.google.com/");
		
		By searchBox = By.name("q");
		By suggestedList = By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']/span");
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(searchBox, "Naveen Automation Labs");
		Thread.sleep(2000);
		List<WebElement> responseList = eleUtil.getElements(suggestedList);
		for(WebElement e:responseList)
		{
			System.out.println(e.getText());
			if(e.getText().contains("interview"))
			{
				e.click();
				break;
			}
				
		}
		

	}

}
