import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class dummy
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElements(By.cssSelector(""));
	}
}



/*public class dummy
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("input[id='checkBoxOption1']")).click();
		Assert.assertTrue(driver.findElement(By.id("input[id='checkBoxOption1']")).isSelected());
		driver.findElement(By.id("input[id='checkBoxOption1']")).click();
		Assert.assertFalse(driver.findElement(By.id("input[id='checkBoxOption1']")).isSelected());
		driver.findElements(By.xpath("//input[@type='checkbox']")).size();
	}
}*/


/*public class dummy {
public static void main(String[] args)
{
	int[] i = {1,2,3,4,5,6};
	for(int j : i)
	{
		System.out.println(j);
	}
}

}*/