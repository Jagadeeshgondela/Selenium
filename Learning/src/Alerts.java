import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts 
{
	public static void main(String[] args)
	{
		String Name = "Jaga";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(Name);
		driver.findElement(By.id("alertbtn")).click();
		
		// To handle alerts, switch to alert
		System.out.println(driver.switchTo().alert().getText());
		
		// If you want click positive(OK,Yes)
		driver.switchTo().alert().accept();
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		
		// If you want to click negative(No)
		driver.switchTo().alert().dismiss();

	}
}
