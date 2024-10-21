import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Locators 
{
	public static void main(String[] args) throws InterruptedException
	{
		// Open a browser and goto login page
		
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new EdgeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String Name = "Jagadeesh";
		driver.findElement(By.id("inputUsername")).sendKeys(Name);
		driver.findElement(By.name("inputPassword")).sendKeys("Random password");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		// Reset password
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys(Name);
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("jaga@gmail.com");	
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("8794987654");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		System.out.println(driver.findElement(By.xpath("//p[@class='infoMsg']")).getText());
		String password = GetPassword(driver);
		System.out.println(password);
		
		// Login With Reseted Password
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys(Name);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		System.out.println(driver.findElement(By.xpath("//p[contains(@style,'color')]")).getText());  // xpath-Reg.expression
		Assert.assertEquals(driver.findElement(By.cssSelector("p")).getText(),"You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.xpath("//div/h2")).getText(),"Hello "+Name+",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		// Parent-Child-Sibling traversal
		
		//driver.close();
		
	}
	
	public static String GetPassword(WebDriver driver)
	{
		String pwdText = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
		String[] pwdArray1 = pwdText.split("'"); 
		String password = pwdArray1[1].split("'")[0];
		return password;
	}

}

