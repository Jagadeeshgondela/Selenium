import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		try {
			
		//Radio Button
		WebElement radioButton1 = driver.findElement(By.xpath("//input[@value='radio1']"));
		radioButton1.click();
		System.out.println(radioButton1.isSelected());
		
		//Auto Suggestions
		WebElement Auto = driver.findElement(By.id("autocomplete"));
		Auto.sendKeys("ind");
		Thread.sleep(1000); // wait for elements to load and show up in the page
		List<WebElement> sugList = driver.findElements(By.cssSelector(".ui-menu-item"));
		for(int i=0;i<sugList.size();i++) {
			if(sugList.get(i).getText().equalsIgnoreCase("India")) {
				sugList.get(i).click();
				break;
			}
		}
		System.out.println(Auto.getAttribute("value"));
		
		
		//drop down
		Select dropDown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropDown.selectByValue("option1");
		Thread.sleep(1000);
		dropDown.selectByIndex(2);
		Thread.sleep(1000);
		dropDown.selectByVisibleText("Option3");
		System.out.println(driver.findElement(By.id("dropdown-class-example")).getAttribute("value"));
		
		
		//CheckBox
		WebElement checkBox = driver.findElement(By.id("checkBoxOption2"));
		checkBox.click();
		System.out.println(checkBox.isSelected());
		
		
		//Windows
		driver.findElement(By.xpath("//button[@id='openwindow']")).click();
		Thread.sleep(5000);
		
		
		Set<String> windows = driver.getWindowHandles();
		java.util.Iterator<String> it =  windows.iterator();
		
		String parentWindow = it.next();
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		driver.close();
		
		
		
		
		//New Tab
		driver.switchTo().window(parentWindow);
		
		driver.findElement(By.linkText("Open Tab")).click();
		Thread.sleep(5000);
		
		Set<String> windows1 = driver.getWindowHandles();
		java.util.Iterator<String> it1 =  windows1.iterator();
		
		String parentWindow1 = it1.next();
		String childWindow1 = it1.next();
		
		driver.switchTo().window(childWindow1);
		driver.findElement(By.linkText("Access all our Courses")).click();
		System.out.println(driver.getTitle());
		
		
		//Alerts
		driver.switchTo().window(parentWindow1);
		driver.findElement(By.cssSelector("[id='name']")).sendKeys("Rao Ramesh");
		driver.findElement(By.id("alertbtn")).click();
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert.getText());
		alert.accept();
		
		driver.findElement(By.cssSelector("[id='confirmbtn']")).click();
		System.out.println(alert.getText());
		alert.dismiss();
		
		
		// scrolling window
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		
		// scrolling a table
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		//screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String filePath = "D:\\QA\\new screenshot.png";
		FileUtils.copyFile(src, new File(filePath));
		
		
		}
		
		
		finally {
		Thread.sleep(3000);
		driver.quit();
		}
	}

}
