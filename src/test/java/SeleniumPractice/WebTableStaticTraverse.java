package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableStaticTraverse {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		By rows = By.xpath("//table[@id='customers']//tr");
		By cols = By.xpath("//table[@id='customers']//th");
		
		String before_xpath = "//table[@id=\"customers\"]/tbody/tr[" ;
		String company = "]/td[";
		String after_xpath = "]";
		String contact_after_xpath = "]/td[2]";
		String country_after_xpath = "]/td[3]";
		getrowColumnData(before_xpath, company, after_xpath, rows, cols);
		/*
		 * getColumnData(before_xpath, contact_after_xpath, rows);
		 * getColumnData(before_xpath, country_after_xpath, rows);
		 */

	}
	
	public static void getrowColumnData(String before_xpath, String company, String after_xpath,By rows,By cols)
	{
		for(int row =2;row<=getRowCount(rows);row++)
		{
			for(int col= 1; col<=getColCount(cols); col++)
			{
				String xpath = before_xpath + row +company+ col+ after_xpath;
				String text = driver.findElement(By.xpath(xpath)).getText();
				System.out.println(text);
			}
		}
	}

	public static void getColumnData(String before_xpath, String after_xpath, By rows) {
		for (int row = 2; row <= getRowCount(rows); row++) {
			String xpath = before_xpath + row + after_xpath;
			String text = driver.findElement(By.xpath(xpath)).getText();
			System.out.println(text);
		}
	}

	public static int getColCount(By locator) {
		return driver.findElements(locator).size();
	}

	public static int getRowCount(By locator) {
		return driver.findElements(locator).size();
	}

}