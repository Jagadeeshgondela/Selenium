import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {
    public static void main(String[] args) {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize(); // Maximize window

            // Open the target website
            driver.get("https://www.amazon.in/");

            // Take Screenshot
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String filePath = "C:\\Users\\USER\\Selenium SS\\screenshotjaga.png"; // Save screenshot in project folder
            FileUtils.copyFile(src, new File(filePath));
            
            /* add the below dependency to the pom.xml file to use FileUtils class
             * <dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.11.0</version>  <!-- Latest version -->
</dependency>

             */

            System.out.println("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        } finally {
            driver.quit(); // Close the browser
        }
    }
}
