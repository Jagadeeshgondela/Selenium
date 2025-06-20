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
		
		int row_count = driver.findElements(By.xpath("//legend[contains(text(),'header')]/following-sibling::div/table//tr")).size();
		int columns_count = driver.findElements(By.xpath("//legend[contains(text(),'header')]/following-sibling::div/table//tr[1]//th")).size();
		
		System.out.println("No.of Rows : "+row_count);
		System.out.println("No.of Columns : "+columns_count);
		
		// 2. print all cells data
		
		for(int i=1; i<row_count;i++) {
			for(int j=1;j<=columns_count;j++) {
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
		
		String amount = "37";
		List<WebElement> rows = table2.findElements(By.tagName("tr"));
		for(WebElement row : rows) {
			if(row.getText().contains(amount)) {
				System.out.println(row.getText().split(" ")[0]);
				break;
			}
		}
		
		
		// 5. There is a particular Vehicle number present somewhere in the table, need to click the checkbox present in that row
		
		// xpath = //table[@id='myTable']//tr[td[contains(text(),'AP01AB1234')]]//input[@type='checkbox']

		
		}
		finally{
		driver.quit();
		}

	}

}
