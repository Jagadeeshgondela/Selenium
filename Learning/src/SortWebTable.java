
import java.util.List;
import java.util.stream.Collectors;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortWebTable {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//span[text()='Veg/fruit name']")).click();
		
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(sortedList.equals(originalList));
		
		/*
		 * Let's get the price of a particular item from the table
		 * get all the web elements of items in the page to a list
		 * put the price of required item into a list(create a method to get the price)
		 * if the item that we are looking for is not available in the current page then click next until found
		 * print the price
		 */
		String item = "rice";
		List<String> Price;
		do {
		List<WebElement> itemsList = driver.findElements(By.xpath("//tr/td[1]"));
		Price = itemsList.stream().filter(s->s.getText().equalsIgnoreCase(item)).map(s->getItemPrice(s)).collect(Collectors.toList());
		if(Price.size()<1) {
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}while(Price.size()<1);
		Price.forEach(s->System.out.println("The Price of item "+"'"+item.toUpperCase()+"'"+ " is : "+s));
		
		Thread.sleep(5000);
		driver.quit();
	}

	private static String getItemPrice(WebElement s) {
		// TODO Auto-generated method stub
		String itemValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return itemValue;
	}

	

}
