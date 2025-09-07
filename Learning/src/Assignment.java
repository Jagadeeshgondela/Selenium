import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		 driver.manage().window().maximize();
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 
		 WebElement autoDrop = driver.findElement(By.id("autocomplete"));
		 autoDrop.sendKeys("ind");
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-menu-item-wrapper")));
		 List<WebElement> countries = driver.findElements(By.className("ui-menu-item-wrapper"));
		 Actions a = new Actions(driver);
		 for(WebElement country : countries) {
			 
			 if(country.getText().equalsIgnoreCase("india")) {
				a.moveToElement(country).click().perform();
				break;
			 }
		 }
		
		 Assert.assertEquals(autoDrop.getAttribute("value"),"India");
		 driver.quit();
	}

}
