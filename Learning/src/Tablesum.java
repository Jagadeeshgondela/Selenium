import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tablesum {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		List<WebElement> prices = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));
		int sumOfPrices = 0;
		for(int i=0; i<prices.size();i++) {
			sumOfPrices+=Integer.parseInt(prices.get(i).getText());
		}
	System.out.println("Sum of all the prices : "+sumOfPrices);
	
	// No.of rows & Columns in the table
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr"));
	System.out.println("no.of rows : "+rows.size());
	
	List<WebElement> columns = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr/th"));
	System.out.println("no.of columns : "+columns.size());
	
	System.out.println( rows.get(2).getText()); // printing 3rd row in the table
	driver.quit();

}}
