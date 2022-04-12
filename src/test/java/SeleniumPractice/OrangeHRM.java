package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OrangeHRM {

	public static void main(String[] args) {
		 WebDriver driver;
		 
	     By requestedName = By.id("Form_submitForm_subdomain");
	     By fullName = By.id("Form_submitForm_Name");
	     By email = By.id("Form_submitForm_Email");
         By phone = By.id("Form_submitForm_Contact");
         By ctry = By.id("Form_submitForm_Country");
         
         BrowserUtils brUtil = new BrowserUtils();
         driver = brUtil.launchBrowser("chrome");
         
         ElementUtil eleUtil = new ElementUtil(driver);
         driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
         eleUtil.doSendKeys(requestedName, "Lloyd26");
         eleUtil.doSendKeys(fullName, "Lloyd Foo1");
         eleUtil.doSendKeys(email, "foo@lloyd.com");
         eleUtil.doSendKeys(phone, "876876");
         eleUtil.doSelectByVisibleText(ctry, "Australia");
         
         brUtil.closeBrowser();
	}

}
