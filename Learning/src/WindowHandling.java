import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		// click on the link which will take you to new tab/window
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		// getWindowHandles put all the windows opened by selenium in one set
		Set<String> windows = driver.getWindowHandles();
		
		// iterator allows us to iterate through each window present in the set
		java.util.Iterator<String> it= windows.iterator();
		
		// prentWindow
		String parentWindow = it.next();
		// next child window
		String childWindow = it.next();
		
		// switch to child window to get the email id
		driver.switchTo().window(childWindow);
		System.out.println(driver.findElement(By.xpath("//div/p[2]")).getText());
		
		// getting required emailId from para
		String emailId = driver.findElement(By.xpath("//div/p[2]")).getText().split("at")[1].trim().split(" ")[0];
		
		// once we get the required emailId, switch to parent window
		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("username")).sendKeys(emailId);

	}

}
