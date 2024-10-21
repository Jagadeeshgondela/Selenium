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
		
		// to drag & Drp we use Actions class
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		
		//once we are done with the frame elements, have to come out of frame and switch to normal driver
		driver.switchTo().defaultContent();

	}

}
