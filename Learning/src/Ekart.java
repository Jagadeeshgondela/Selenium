import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ekart 
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Implicit Wait - which is applicable globally for all the web elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		// put all product names in the page into a list
		List<WebElement> all_products = driver.findElements(By.cssSelector(".product-name"));
		
		// create an array of needed products
		String[] products_needed = {"Cucumber","Brocolli","Tomato","Banana"};
		
		// convert the array to array list for easy operations
		List list_of_products_needed = Arrays.asList(products_needed);
		
		// calling addItemsToCart method
		addItemsToCart(driver,all_products,list_of_products_needed);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		// Explicit Wait - applying for a specific web element to explicitly mention the wait time
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
		
		}
	
	public static void addItemsToCart(WebDriver driver,List<WebElement> all_products,List list_of_products_needed)
	{
		int j=0;
		
		for(int i=0;i<all_products.size();i++)
		{
			// get name of each product
			String[] name_of_product = all_products.get(i).getText().split("-");
			// remove the spaces in front and back of the name
			String formatted_name = name_of_product[0].trim();
			// check the formatted_name is present in list of products needed
			if(list_of_products_needed.contains(formatted_name))
			{
				// go to the index of the product and click 'ADD TO CART' button
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
	
				if(j==list_of_products_needed.size())
				{
					break;
				}
			}
		}
	}
}


