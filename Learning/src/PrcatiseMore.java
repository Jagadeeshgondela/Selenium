import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PrcatiseMore {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");	
		driver.manage().window().maximize();
		
		//Radio button
		WebElement radio3 = driver.findElement(By.xpath("//input[@value='radio3']"));
		radio3.click();
		Assert.assertTrue(radio3.isSelected());
		
		//Auto suggestive drop down
		WebElement text = driver.findElement(By.id("autocomplete"));
		text.sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.cssSelector(".ui-menu-item-wrapper"));
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getText().equalsIgnoreCase("india")) {
				list.get(i).click();
				break;
			}
		}
		
		System.out.println(driver.findElement(By.id("autocomplete")).getText());
		
		// drop down
		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByIndex(1);
		s.selectByValue("option2");
		s.selectByVisibleText("Option3");
		
		//Check box
		driver.findElement(By.name("checkBoxOption3")).click();
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption3")).isSelected());
		
		
		// window handling
		driver.findElement(By.id("openwindow")).click();
		
		
		driver.quit();
	}

}
