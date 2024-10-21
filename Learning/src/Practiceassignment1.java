import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Practiceassignment1 
{

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		
		driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]/input")).click();
		String var = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();
		
		WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));
		Select option = new Select(dropDown);
		option.selectByVisibleText(var);
		
		driver.findElement(By.cssSelector("#name")).sendKeys(var);
		driver.findElement(By.id("alertbtn")).click();
		
		Alert a =driver.switchTo().alert();
		String text = a.getText();
		if (text.contains(var))
		{
			System.out.println("Alert msg success");
		}
		else
		{
			System.out.println("Alert msg not ok");
		}
		
		
	}
	
}
