import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;



public class Revision {
	public static void main(String[] args) throws InterruptedException {
		
		//maximizing window
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//try {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
		
		// Implicit wait - global
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));	
		
		//Radio Button
		WebElement radio1 = driver.findElement(By.xpath("//input[@value='radio1']"));
		radio1.click();
		Assert.assertTrue(radio1.isSelected());
		
		
		// Dynamic dropdowns
		WebElement dynamicdrop = driver.findElement(By.id("autocomplete"));
		dynamicdrop.sendKeys("ind");
		Thread.sleep(5); // waiting time to load searched items
		List<WebElement> countries = driver.findElements(By.className("ui-menu-item"));
		for(WebElement country : countries) {
			if(country.getText().equalsIgnoreCase("India")) {
				country.click();
				return;
			}
		}
		Assert.assertTrue(dynamicdrop.getText().equalsIgnoreCase("India"));
		System.out.println(dynamicdrop.getText());
		
		
		//drop down
				Select dropDown = new Select(driver.findElement(By.id("dropdown-class-example")));
				dropDown.selectByValue("option1");
				Thread.sleep(1000);
				dropDown.selectByIndex(2);
				Thread.sleep(1000);
				dropDown.selectByVisibleText("Option3");
				System.out.println(driver.findElement(By.id("dropdown-class-example")).getAttribute("value"));
		
		SoftAssert sa  = new SoftAssert();
		sa.assertTrue(driver.findElement(By.id("dropdown-class-example")).getText().equals("Option3"));
		sa.assertAll();
		
		//}
		
	
		
		/*finally {
			Thread.sleep(20);
			driver.quit();
			}*/
	}
}
