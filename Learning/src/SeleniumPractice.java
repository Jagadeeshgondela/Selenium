import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumPractice {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		try {
			
		//--- Alerts---
		driver.findElement(By.id("name")).sendKeys("jaga");
		driver.findElement(By.id("alertbtn")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	// better to wait for alert to be present
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		//alert.dismiss();
		//alert.sendKeys("i entered text in alert")
		
		//---Frames & iframes---
		WebElement frame1 = driver.findElement(By.id("courses-iframe"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//a[text()='JOIN NOW']")).click();
		Thread.sleep(100);
		driver.switchTo().defaultContent();
		
		// ---FullScreenshot---
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = "E:\\SeleniumScreenshots\\FullScreen.png";
		FileHandler.copy(src, new File(path));
		
		//---Particular element screenshot---
		WebElement table = driver.findElement(By.xpath("(//table[@id = 'product']/tbody)"));
		
		//Sometimes Selenium may not capture the full element if it's not in view. Use JavaScript to scroll it into view:
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", table);

		File src1 = table.getScreenshotAs(OutputType.FILE);
		String path1 = "E:\\SeleniumScreenshots\\TableScreen.png";
		FileHandler.copy(src1, new File(path1));
		
		// ---Particular section screenshot---
		WebElement footerSection = driver.findElement(By.id("gf-BIG"));
		File section = footerSection.getScreenshotAs(OutputType.FILE);
		String path3 = "E:\\SeleniumScreenshots\\SectionScreen.png";
		FileHandler.copy(section, new File(path3));
		
		
		// ---Find which links are working in the footer section---
		
		List<WebElement> footerLinks = footerSection.findElements(By.tagName("a"));
		System.out.println("No.of links present in footer section : "+footerLinks.size());
		for(WebElement link : footerLinks) {
			String url = link.getAttribute("href");
			 if (url == null || url.isEmpty()) {
	                System.out.println("URL is empty or null for link: " + link.getText());
	                continue;
	            }

			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int code = conn.getResponseCode();
			if(code>=400)
			System.out.println("Broken link :"+link.getText()+" = "+code);
			else
				System.out.println("Working link :"+link.getText()+" = "+code);
			}
		
		
			//--- Find no.of 7s present in the table---
			
			int count = 0;
			WebElement table2 = driver.findElement(By.xpath("(//table[@id='product'])[2]"));
			List<WebElement> cells = table2.findElements(By.tagName("td"));
			for(WebElement cell : cells) {
				char[] letters = cell.getText().toCharArray();
				for(char c : letters) {
					if(c=='7') {
						count++;
					}
				}
			}
			System.out.println("No.of 7s present in table2 : "+count);
		
		}finally {
			driver.quit();
		}
		
	
	}

}
