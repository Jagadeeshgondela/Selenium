import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FlipKart {
	public static void main(String[] args) throws MalformedURLException, IOException {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		try {
		
		//System.setProperty("webdriver.chrome.driver","C:/");
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Radio button
		
		WebElement radioButton2 = driver.findElement(By.xpath("//input[@value='radio2']"));
		System.out.println(radioButton2.isEnabled());
		if(!radioButton2.isSelected())
			radioButton2.click();
		System.out.println(radioButton2.isSelected());		
		
		
		//Auto
		WebElement autoSuggestive = driver.findElement(By.id("autocomplete"));
		autoSuggestive.clear();
		autoSuggestive.sendKeys(Keys.SHIFT,"ind");
		
		List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ui-menu-item-wrapper']")));
		
		for(WebElement suggestion : suggestions) {
			if(suggestion.getText().equalsIgnoreCase("india")) {
				suggestion.click();
				break;
			}
		}
		
		Assert.assertEquals(autoSuggestive.getAttribute("value"), "India");
		System.out.println("Selected value : "+autoSuggestive.getAttribute("value"));
		
		//DropDown
		WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));
		
		Select select = new Select(dropDown);
		List<WebElement> allOptions = select.getOptions();
		select.selectByIndex(1);
		Assert.assertEquals(dropDown.getAttribute("value"), "option1");
		select.selectByValue("option2");
		Assert.assertEquals(dropDown.getAttribute("value"), "option2");
		select.selectByVisibleText("Option3");
		Assert.assertEquals(dropDown.getAttribute("value"), "option3");
		
		//CHeckBox
		WebElement checkBox3 = driver.findElement(By.id("checkBoxOption3"));
		if(!checkBox3.isSelected()) {
			checkBox3.click();
		}
		Assert.assertEquals(checkBox3.isSelected(), true);
		
		// window handling
		WebElement windowButton = driver.findElement(By.id("openwindow"));
		windowButton.click();
		
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for(String window : windows) {
			if(!window.equals(parentWindow)) {
			driver.switchTo().window(window);
			System.out.println(driver.getTitle());
			WebElement APICourse = driver.findElement(By.xpath("//h4[contains(text(),'API')]"));
			APICourse.click();
			Set<String> newWindows = driver.getWindowHandles();
			for(String newWindow : newWindows) {
				if(!newWindow.equals(parentWindow) && ! newWindow.equals(window)) {
					driver.switchTo().window(newWindow);
					System.out.println(driver.getTitle());
					driver.close();
				}
			}
			
			driver.switchTo().window(window);
			driver.close();
			}
		}
		
		driver.switchTo().window(parentWindow);
		
		//Alerts
		WebElement alertName = driver.findElement(By.xpath("//input[@id='name']"));
		alertName.sendKeys("Jagadeesh");
		WebElement alertButton = driver.findElement(By.id("alertbtn"));
		alertButton.click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		//alert.dismiss();
		
		//Tables
		WebElement table1 = driver.findElement(By.xpath("//legend[text()='Web Table Example']/following-sibling::table"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",table1);
		String curseWithZeroCost = table1.findElement(By.xpath("//tr[td='0']/td[2]")).getText();
		System.out.println("curseWithZeroCost : "+curseWithZeroCost);
		
		WebElement table2 = driver.findElement(By.xpath("//div[@class='tableFixHead']/table"));
		List<WebElement> prices = table2.findElements(By.xpath(".//td[4]"));
		int sum=0;
		for(WebElement price : prices) {
				sum+=Integer.parseInt(price.getText().trim());
		}
		
		int totalAmount = Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
		System.out.println(totalAmount);
		Assert.assertEquals(sum,totalAmount );
		
		// Broken links
		WebElement footerSection = driver.findElement(By.xpath("//table[@class='gf-t']"));
		List<WebElement> links = footerSection.findElements(By.tagName("a"));
		for(WebElement link : links) {
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			if(responseCode>=400) {
				System.out.println("broken link : "+link.getText() + "-"+responseCode);
			}
		}
		}
		finally {
			driver.quit();
		}
		
	}

}
