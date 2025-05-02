import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		/*if you want to locate a web element where there is no attribute present except tag name
		 * That's where relative locators helps
		 * Have to import static org.openqa.selenium.support.locators.RelativeLocator.*; manually it won't auto suggest because it's static
		 */
		try {
		
		WebElement Name = driver.findElement(By.cssSelector("[name='name']"));
		System.out.println( driver.findElement(with(By.tagName("label")).above(Name)).getText());
		
		WebElement email = driver.findElement(By.name("email"));
		driver.findElement(with(By.tagName("input")).below(email)).sendKeys("password");
		System.out.println(driver.findElement(By.cssSelector("[type='password']")).getAttribute("value"));
		
		WebElement checkBoxText = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkBoxText)).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='exampleCheck1']")).isSelected());
		
		}
		finally {
		Thread.sleep(3000);
		driver.quit();
		}
		
	}

}
