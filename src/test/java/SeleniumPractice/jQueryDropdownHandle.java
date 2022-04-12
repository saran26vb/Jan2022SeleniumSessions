package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class jQueryDropdownHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		BrowserUtils brwUtil = new BrowserUtils();
		driver = brwUtil.launchBrowser("Chrome");
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		/*
		 * driver.findElement(By.id("justAnInputBox")).click(); By choices =
		 * By.xpath("//span[@class='comboTreeItemTitle']");
		 * selectDropdownChoices(choices, "choice 1", "choice 2", "choice 3");
		 */
		//selectDropdownChoices(choices, "All");
        Thread.sleep(5000);
        Actions action = new Actions(driver);
        action.contextClick().perform();
        
		/*
		 * driver.findElement(By.id("justAnotherInputBox")).click(); Thread.sleep(3000);
		 * By singleChoice = By.id("comboTree633639DropDownContainer"); By
		 * singleCHoiceList = singleChoice.xpath("//span[@class='comboTreeItemTitle']");
		 * selectDropdownChoices(singleCHoiceList, "choice 6");
		 */
        
        driver.findElement(By.id("justAnInputBox1")).click();
        Thread.sleep(3000);
		/*
		 * By multiChoice = By.id("comboTree503416DropDownContainer"); By
		 * multiChoiceList = multiChoice.xpath("//span[@class='comboTreeItemTitle']");
		 * selectDropdownChoices(multiChoiceList, "choice 6 2","choice 6 2 1");
		 */
        
        By multiSelection = By.xpath("//h3[contains(text(),'Cascade Option')]");
        By multiSelectionChildList=multiSelection.xpath("/parent::div/child::div//li[@class='ComboTreeItemChlid']");
        By multiChoiceChildList = multiSelectionChildList.xpath("//span[@class='comboTreeItemTitle']");
		selectDropdownChoices(multiChoiceChildList, "choice 1");
        //By multiSelectionParentList=multiSelection.xpath("/parent::div/child::div//li[@class='ComboTreeItemParent']");
        
		
	}
	
	public static void selectDropdownChoices(By locator, String... value)
	{
		List<WebElement> dropdownList = driver.findElements(locator);
		if(!value[0].equalsIgnoreCase("All"))
		{
			for(WebElement e : dropdownList)
			{
				for(int i=0;i<value.length;i++)
				{
					if(e.getText().equalsIgnoreCase(value[i]))
					{
						e.click();
						break;
					}
				}
				
			}
		}
		else
		{
			try {
				for(WebElement e: dropdownList)
					e.click();
			}
			catch(ElementNotInteractableException e)
			{
				System.out.println("All choices are over");
			}
			
		}
		
	}

}
