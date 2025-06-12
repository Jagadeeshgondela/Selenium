import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.amazon.com");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		By searchBox = By.xpath("//input[@placeholder = 'Search Amazon']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).sendKeys("shorts");
		
		
		By suggestionsLocator = By.xpath("//div[starts-with(text(),'shorts')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionsLocator));
		List<WebElement> suggestions = driver.findElements(By.xpath("//div[starts-with(text(),'shorts')]"));
		System.out.println(suggestions.size());
		for(WebElement suggestion : suggestions) {
			//System.out.println(suggestion.getText());
			String[] words = suggestion.getText().toLowerCase().split(" ");
			String lastWord = words[words.length-1];
		
			if(lastWord.equals("men")) {
				suggestion.click();
				break;
			}
			}
		
		driver.findElement(By.xpath("//h2[contains(@aria-label,'Gym')]")).click();
		WebElement numSize = driver.findElement(By.xpath("//span[text()=' 32 ']"));
		WebElement charSize = driver.findElement(By.xpath("//span[text()=' Small ']"));
		if(numSize.isDisplayed())
		numSize.click();
		else
			charSize.click();
		
		driver.findElement(By.id("add-to-cart-button")).click();
		
			
	}

}

