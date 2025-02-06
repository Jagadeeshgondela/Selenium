import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {
	public static void main(String[] args) throws  IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		/*
		 * How to find the broken link without opening the link in new tab
		 * Get the URL of the link
		 * open a connetion with the URL by using openConnection() method in URL class which takes the URL as the input
		 * Return type is HttpURLConnection for this method
		 * Set the request method as 'HEAD' because we need only header not entire body
		 * connect with the URL
		 * get the response code (If response code >400 means, link broken)
		 */
		
		String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int code = conn.getResponseCode();
		System.out.println(code);
	}
	
}
