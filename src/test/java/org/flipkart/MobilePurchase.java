package org.flipkart;

import java.io.File;  
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobilePurchase {
	static WebDriver driver;
	
	@BeforeClass
	public static void before () {
	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}
		@AfterClass
		public static void after () {
			System.out.println("Aftertest");
	}
		@Before
		public void beforeTest () {
			System.out.println("Beforetest");
	}
		@After
		public void afterTest() {
		  System.out.println("Aftertest");
	}		
		@Test
		public void test1() {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();	
	}	
		@Test
		public void test2() {	
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Redmi mobiles");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
		@Test
		public void test3() throws IOException, InterruptedException {	
			Thread.sleep(3000);
		File f = new File("C:\\Users\\Windows\\Ramesh\\Junit\\Ramesh.xlsx");
		FileOutputStream f1 = new FileOutputStream(f);
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("Mlist");
		List<WebElement> data = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		for(int i=0; i<data.size();i++) {
		WebElement name = data.get(i);
		String text = name.getText();
		Row r = s.createRow(i);
		Cell c = r.createCell(0);
		c.setCellValue(text);
		}
		{
		 	w.write(f1);
		}
		}
		@Test
		public void test4()throws IOException, InterruptedException {
			Thread.sleep(3000);
		WebElement redmi = driver.findElement(By.xpath("//div[@class='_4rR01T'][1]"));
		redmi.click();
		String parent = driver.getWindowHandle();
		Set<String>child = driver.getWindowHandles();
		for(String x:child) {
		if(!parent.equals(child)) {
		driver.switchTo().window(x);
		  }
		}
	}	
		@Test
		public void test5() throws IOException {
			String s1 = driver.findElement(By.xpath("//span[@class='B_NuCI']")).getText();
			System.out.println(s1);
			File d = new File("C:\\Users\\Windows\\Ramesh\\Junit\\Ramesh.xlsx");
			FileInputStream g = new FileInputStream(d);
			Workbook t = new XSSFWorkbook(g);
			Sheet s2 = t.getSheet("Mlist");
			Row r1=s2.getRow(1);
			Cell c1=r1.getCell(0);
			String cc=c1.getStringCellValue();
		    System.out.println(cc);
		    Assert.assertEquals(cc,s1);
		}	
}		
		


