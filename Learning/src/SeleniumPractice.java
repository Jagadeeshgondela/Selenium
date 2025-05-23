import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.openqa.selenium.support.locators.RelativeLocator.with;


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
		
		//--- DropDowns---
		
		Select dropDown = new Select(driver.findElement(By.name("dropdown-class-example")));
		dropDown.selectByIndex(0);
		dropDown.selectByValue("option2");
		dropDown.selectByVisibleText("Option3");
		
		//---Mouse & KeyBoard Actions---
				WebElement hoverTitle = driver.findElement(By.xpath("//legend[text()='Mouse Hover Example']"));
				WebElement hoverButton = driver.findElement(with(By.tagName("button")).below(hoverTitle));	// using relative locator
				WebElement reload = driver.findElement(By.xpath("//a[text()='Reload']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",hoverButton);
				Thread.sleep(100);
				
				Actions actions  = new Actions(driver);
				actions.moveToElement(hoverButton).click(reload).build().perform();
				
				
		
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
		
		
		// ---Scenario-1 : Broken links find which links are working in the footer section---
		
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
		
		
			//--- Scenario-2: Find no.of 7s present in the table---
			
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
			

			//---Scenario-3 : Handling multiple windows(go to 3rd window and fill the form with the data present in .properties file)---
			
			driver.findElement(By.id("openwindow")).click();
			String parent = driver.getWindowHandle();
			Set<String> windows = driver.getWindowHandles();
			if(windows.size()>0) {
			for(String window : windows) {
				if(!window.equals(parent)) {
				driver.switchTo().window(window);
				System.out.println(driver.getTitle());
				}
			}
			}
			driver.switchTo().window(parent);
			System.out.println(driver.getTitle());

			
		driver.findElement(By.id("openwindow")).click();
		String parentWindow = driver.getWindowHandle();

		
		Set<String> handles1 = driver.getWindowHandles();
		for(String handle : handles1) {
			if(!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Access')]")).click();
		
		Set<String> handles2 = driver.getWindowHandles();
		for(String handle : handles2) {
			if(!handle.equals(parentWindow)&& !handle.contains(handle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		
		driver.close();
		
		driver.switchTo().window(parentWindow);
		
		// Reading data from .properties file
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\USER\\git\\New_Selenium\\Selenium\\Learning\\src\\Resources\\ConfigProperties.properties");
		prop.load(fis);
		String user_name = prop.getProperty("UserName");	// get UserName value
		String mail = prop.getProperty("Email");			// get Email value
		
		driver.navigate().to("https://rahulshettyacademy.com/");
		driver.findElement(By.xpath("//a[text()='JOIN NOW']")).click();
		driver.findElement(By.id("name")).sendKeys(user_name);
		driver.findElement(By.id("email")).sendKeys(mail);
		
		//---Scenario-4 : Validate all options in the dropdown
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		Select dropDown1 = new Select(driver.findElement(By.id("dropdown-class-example")));
		List<WebElement> allOptions = dropDown1.getOptions();
		List<String> actual = allOptions.stream().map(WebElement::getText).collect(Collectors.toList());
		List<String> expected = Arrays.asList("Select","Option1","Option2","Option3");
		Assert.assertEquals(actual, expected);
		}
		finally {
			Thread.sleep(10000);
			driver.quit();
		}
		
	
	}

}
