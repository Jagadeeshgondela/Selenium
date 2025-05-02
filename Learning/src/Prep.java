import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Prep {
	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		WebElement searchBox = driver.findElement(By.cssSelector("[id='APjFqb']"));
		searchBox.sendKeys("Amazon");
		searchBox.submit();
		driver.findElement(By.xpath("//*[text()='Shop online at Amazon India']")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("pen");
		
	}
}
