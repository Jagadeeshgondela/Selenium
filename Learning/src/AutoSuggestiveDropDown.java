import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropDown {
    public static void main(String[] args) throws InterruptedException {
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Open target website
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Locate and interact with the auto-suggestive dropdown
        WebElement autoComplete = driver.findElement(By.id("autocomplete"));
        autoComplete.click(); // Ensure focus is on the field
        autoComplete.sendKeys("uni");

        // Wait for the dropdown options to load
        Thread.sleep(1000); // Adjust based on network speed

        // Press down arrow key twice
        autoComplete.sendKeys(Keys.DOWN);
        Thread.sleep(500);
        autoComplete.sendKeys(Keys.DOWN);
        Thread.sleep(500);

        // Press Enter to select
        autoComplete.sendKeys(Keys.ENTER);

        // Print selected value
        System.out.println("Selected value: " + autoComplete.getAttribute("value"));

        // Close the browser
        driver.quit();
    }
}
