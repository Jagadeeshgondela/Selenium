import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {
	public static void main(String[] args) throws IOException{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver .get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> Links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		
		SoftAssert sa = new SoftAssert(); 
		
		/*
		 * SoftAssert does not stop execution on failure.
		 * If assertTrue() fails, the message won't print immediately.
		 * Only when sa.assertAll(); is called will TestNG report failures.
		 */
		
		for(WebElement link : Links) {
			String url = link.getAttribute("href");
			 if (url == null || url.isEmpty()) {
	                System.out.println("URL is empty or null for link: " + link.getText());
	                continue;
	            }

			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int  code = conn.getResponseCode();
			System.out.println(link.getText()+" : "+ code);
			sa.assertTrue(code<400,"The Link : "+link.getText() + " is broken with the response code : "+ code );
			
		}
		sa.assertAll();
		driver.quit();
	}
}
