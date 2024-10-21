
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Simplecalander 
{
	public static void main(String[] args)
	{
		int expected_year = 2027;
		int expected_month = 03;
		int expected_day = 03;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='"+expected_year+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(expected_month-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+Integer.toString(expected_day)+"']")).click();
		
		
	}
}

