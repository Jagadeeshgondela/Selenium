

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actionsdemo 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Actions a = new Actions(driver);
		WebElement element = driver.findElement(By.id("nav-link-accountList"));
		
		// hover on anything
		a.moveToElement(element).build().perform();
		
		// Right click
		a.contextClick(element).build().perform();
		
		// move to an element, click and enter some text
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().sendKeys("mixer").build().perform();
		
		//Entering text in capital by holding shift key and select the text by double click
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("mixer").doubleClick().build().perform();
		
		driver.close();
		}
	
}

