import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowOperations 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.navigate().to("https://rahulshettyacademy.com");  // navigate().to is same as get(), but it works when the browser is already opened by the driver. And it won't wait till all the elements of the web page loaded fully unlike get(). 
		driver.navigate().back();
		driver.navigate().forward();
	}
}
