import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'friends')]")).isSelected());
		driver.findElement(By.xpath("//input[contains(@id,'friends')]")).click();
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'friends')]")).isSelected());

		
		// Finding total no.of check boxes in the page
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
	}
}
