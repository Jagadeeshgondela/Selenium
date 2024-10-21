import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoginPage 
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Rahul");
		driver.findElement(By.name("email")).sendKeys("rahul@gmail.com");
		driver.findElement(By.cssSelector("#exampleInputPassword1")).sendKeys("password");
		driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='exampleCheck1']")).isSelected());
		Select dropdown = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		Thread.sleep(2000);
		dropdown.selectByVisibleText("Male");
		driver.findElement(By.cssSelector("#inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("12/09/2001");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		System.out.println( driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
		driver.close();
		
	}
}