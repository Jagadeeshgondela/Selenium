

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scrolling {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Scrolling can be done through javascript
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		// validate sum of all values in a table column matching with the total count or not
		List<WebElement> Amount = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int TotalAmount=0;
		for(int i=0;i<Amount.size();i++) {
			int c = Integer.parseInt(Amount.get(i).getText());
			TotalAmount+=c;
		}
		System.out.println("Sum of Amounts : "+TotalAmount);
		 String [] s =driver.findElement( By.cssSelector(".totalAmount")).getText().split(":");
		
		 int T = Integer.parseInt(s[1].trim());
		 Assert.assertEquals(TotalAmount, T);
		/*if(TotalAmount== T)
				{
			System.out.println("sum is matching with total count");
		}*/

		Thread.sleep(5000);
		driver.quit();
		
	}

}
