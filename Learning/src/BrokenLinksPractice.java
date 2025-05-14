import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrokenLinksPractice {

	public static void main(String[] args) throws MalformedURLException, IOException,NullPointerException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links = driver.findElements(By.className("gf-t"));
		
		for(WebElement link : links) {
			String url = link.getAttribute("href");
			
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int code = conn.getResponseCode();
			System.out.println(link.getText()+":"+code);
			
		}
		driver.quit();

	}

}
