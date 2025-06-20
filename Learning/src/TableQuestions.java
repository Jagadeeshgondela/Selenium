import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class TableQuestions {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		try {
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// 1. No.of rows & columns in a web table
		
		int rows = driver.findElements(By.xpath("//legend[contains(text(),'header')]/following-sibling::div/table//tr")).size();
		int columns = driver.findElements(By.xpath("//legend[contains(text(),'header')]/following-sibling::div/table//tr[1]//th")).size();
		
		System.out.println("No.of Rows : "+rows);
		System.out.println("No.of Columns : "+columns);
		
		// 2. print all cells data
		
		for(int i=1; i<rows;i++) {
			for(int j=1;j<=columns;j++) {
				WebElement cell = driver.findElement(By.xpath("//legend[contains(text(),'header')]/following-sibling::div/table//tr["+i+"]//td["+j+"]"));
				System.out.print(cell.getText()+" ");
			}
			System.out.println();
		}
		
		// 3. Find the count of occurance of letter 'a' in the table
		
		int count = 0;
		WebElement table2 = driver.findElement(By.xpath("(//table[@id='product'])[2]"));
		List<WebElement> cells = table2.findElements(By.tagName("td"));
		for(WebElement cell : cells) {
			char[] letters = cell.getText().toCharArray();
			for(char c : letters) {
				if(c=='a') {
					count++;
				}
			}
		}
		System.out.println("No.of A's present in table2 : "+count);
		
		
		// 4.  How do you click a link/button present in a specific row? (Print name where amount=37)
		
		//System.out.println();
		}
		finally{
		driver.quit();
		}

	}

}
