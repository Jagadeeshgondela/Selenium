import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		// Selenium can't recognise the element present in a frame,so swith to frame
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		/*Different ways to switch to frames
		 * 1. By Index : driver.switchTo().frame(0); // Switches to the first iframe on the page
		 * 2. By Attribute : driver.switchTo().frame("iframeName"); // If <iframe name="iframeName">
		 * 3. By WebElement : WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='contentFrame']"));
								driver.switchTo().frame(frameElement);
			4. Nested Frames (Switching One Inside Another) : driver.switchTo().frame("outerFrame");
																driver.switchTo().frame("innerFrame");
			5. Switch Back to Main Page (Default Content)	: driver.switchTo().defaultContent();
			6. Switch Back to Parent Frame (One Level Up)	: driver.switchTo().parentFrame();
		*/
		
		// to drag & Drp we use Actions class
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		
		//once we are done with the frame elements, have to come out of frame and switch to normal driver
		driver.switchTo().defaultContent();

	}

}
