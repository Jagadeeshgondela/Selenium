import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calander 
{
	public static void main(String[] args)
	{
		int expected_year = 2024;
		int expected_month = 03;
		int expected_day = 03;
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.linkText("Top Deals")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		//driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		int Current_year = Integer.parseInt(driver.findElement(By.cssSelector(".react-calendar__navigation__label")).getText());
		if(expected_year<Current_year)
		{
			int difference = Current_year-expected_year;
			while(difference>0)
			{
				driver.findElement(By.cssSelector(".react-calendar__navigation__prev-button")).click();
				difference--;
			}
			
		}
		else if(expected_year>Current_year)
		{
			int difference = expected_year-Current_year;
			while(difference>0)
			{
				driver.findElement(By.cssSelector(".react-calendar__navigation__next-button")).click();
				difference--;
			}
		}
		
		//driver.findElement(By.xpath("//button[text()='"+expected_year+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(expected_month-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+Integer.toString(expected_day)+"']")).click();
		
		
	}
}
