import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Waitassignment 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("#username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("#password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']")).click();
		
		/*System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();*/
		
		driver.findElement(By.cssSelector("#okayBtn")).click();
		
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		dropdown.selectByVisibleText("Student");
		
		driver.findElement(By.cssSelector("#terms")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("#terms")).isSelected());
		
		driver.findElement(By.cssSelector("#signInBtn")).click();
		
		//Explicit wait
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add ']")));
		List<WebElement> items = driver.findElements(By.xpath("//button[text()='Add ']"));
		for(WebElement item : items)
		{
			item.click();
		}
		
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
	
	}
}
