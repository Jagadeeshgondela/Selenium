
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Excelops {

	public static void main(String[] args) throws IOException {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://rahulshettyacademy.com/");
		 driver.findElement(By.xpath("//a[text()='JOIN NOW']")).click();
		 
		 FileInputStream fis = new FileInputStream("C:\\Users\\USER\\git\\New_Selenium\\Selenium\\Learning\\src\\Resources\\TestData\\Creadentials.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheet("Sheet1");
		 String name = sheet.getRow(0).getCell(1).getStringCellValue();
		 String mail = sheet.getRow(1).getCell(1).getStringCellValue();
		 
		 driver.findElement(By.id("name")).sendKeys(name);
		 driver.findElement(By.id("email")).sendKeys(mail);
		 driver.findElement(By.xpath("//span[text()='Send code']")).click();
		 workbook.close();
		 fis.close();
		 
	}

}