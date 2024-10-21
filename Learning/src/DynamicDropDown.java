import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DynamicDropDown 
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@value='GOI']")).click();
		//driver.close();
		//driver.findElement(By.xpath("(//a[@value='COK'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='COK']")).click();
		driver.findElement(By.xpath("//a[text()='8']")).click();
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		int i =1;
		while(i<4)
		{
			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
			i++;
		}
		
		driver.findElement(By.id("hrefIncChd")).click();

		
	}
}
