package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		System.out.println(System.getProperty("user.dir"));
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.file-upload.com/?op=upload_form");
		Thread.sleep(5000);
		driver.findElement(By.id("file_0"))
		.sendKeys("C:\\Users\\vbsar\\OneDrive\\Desktop\\Saranya\\ElementNotInteractableError.JPG");
	}

}
