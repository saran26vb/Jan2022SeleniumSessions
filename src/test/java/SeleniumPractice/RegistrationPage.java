package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

	public static void main(String[] args) {

		WebDriver driver;

		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By password = By.id("input-password");
		By confirmPassword = By.id("input-confirm");
		By agreeChkBox = By.name("agree");
		By submit = By.xpath("//input[@type='submit']");
        By acctCreationMsg = By.xpath("//div[@id='content']/h1");
        
		BrowserUtils brwUtil = new BrowserUtils();
		driver = brwUtil.launchBrowser("Chrome");
		brwUtil.getUrl("https://demo.opencart.com/index.php?route=account/register");
		System.out.println(brwUtil.getTitle());
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(firstName, "Fiona");
		eleUtil.doSendKeys(lastName, "Tan");
		eleUtil.doSendKeys(email, "test@fiona4.com");
		eleUtil.doSendKeys(telephone, "12345678");
		eleUtil.doSendKeys(password, "Pwd12345678");
		eleUtil.doSendKeys(confirmPassword, "Pwd12345678");
		eleUtil.doClick(agreeChkBox);
		eleUtil.doClick(submit);
		System.out.println(eleUtil.doElementGetText(acctCreationMsg));
		brwUtil.closeBrowser();
	}
}
