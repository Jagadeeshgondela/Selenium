import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class InterviewPrep {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		// count the frequency occurrence of particular text in a table
		
		List<WebElement> td = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr"));
		int count=0;
		for(int i=0;i<td.size();i++) {
			String text = td.get(i).getText();
			if(text.contains("3")) {
				for(int j=0;j<td.get(i).getText().length();j++) {
					if(text.charAt(j)=='3') {
				count=count+1;
					}
				}
			}
		}
		System.out.println(count);
		driver.quit();
	}
}
