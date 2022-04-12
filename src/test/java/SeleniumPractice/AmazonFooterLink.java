package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonFooterLink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		String lastColumnText = driver.findElement(By.xpath("((//div[@class='navFooterLinkCol navAccessibility'])[last()]//a)[last()]")).getText();
        if(lastColumnText.equals("Help"))
        {
        	System.out.println("Pass");
        }
	}

}
