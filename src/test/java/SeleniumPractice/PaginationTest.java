package SeleniumPractice;

import org.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi.withSha224;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationTest {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		int pageCount= 1;
		while(true)
		{
			if(driver.findElements(By.xpath("//td[text()='Indore']")).size()>0)
			{
				//selectCity("Indore");
				selectCityWithRelative("Indore");
				System.out.println(pageCount);
				break;
			}
			else
			{
				WebElement ele = driver.findElement(By.linkText("Next"));
				if(ele.isEnabled())
				{
					ele.click();
					Thread.sleep(1000);
					++pageCount;
				}
				else
				{
					System.out.println("Pagination is not over..record not found");
					break;
				}
					
				 
			}
		}
		

	}
	
	public static void selectCity(String cityName)
	{
		driver
		.findElement(By.xpath("//td[text()='"+cityName+"']//parent::tr/td[1]/input[@type='checkbox']"))
		.click();
	}
	
	public static void selectCityWithRelative(String cityName)
	{
		WebElement ele = driver
				         .findElement(By.xpath("//td[text()='"+cityName+"']"));
		driver
		.findElement(with(By.xpath("//input[@type='checkbox']"))
		.toLeftOf(ele)).click();		
				
	}

}
