import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Total no.of links in the page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		// Total no.of links in the footer section of the page
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		// get the count of links from first column of footer section
		WebElement firstColumnFooterDriver = footerDriver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]"));
		List<WebElement> links = firstColumnFooterDriver.findElements(By.tagName("a"));
		int noOfLinks = firstColumnFooterDriver.findElements(By.tagName("a")).size();
		System.out.println(noOfLinks);
		
		// click on each link and get the title of each page
		for(int i=1;i<noOfLinks;i++)
		{
			String clickOnLink = Keys.chord(Keys.CONTROL,Keys.ENTER); //CTRL+Enter opens the link in new tab
			links.get(i).sendKeys(clickOnLink); // clicks on link one by one
		}
		
		// To get titles of each tab, we have to switch to tabs
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
