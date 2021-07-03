package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	
public static WebDriver driver;
public static ExtentReports report;
public static ExtentTest test;
XSSFWorkbook wbook;
XSSFSheet sheet;

	SoftAssert soft =new SoftAssert();
	

	@BeforeTest
	
	 public void Setup() throws IOException {
		
		   System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 
		   driver= new ChromeDriver();
		   
		   driver.get("https://www.saucedemo.com/");
		   
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	       
	       report= new ExtentReports("ExtentReport.html");
	      
	       FileInputStream fis= new FileInputStream("exceldata.xlsx");
	        
	       wbook = new XSSFWorkbook(fis);
	        
	        sheet = wbook.getSheetAt(0);
	}
	
  @AfterTest
  public void teardown() {
	 
	// soft.assertAll(); if we add here , it does not close browser.
	 
	 report.endTest(test);
	 report.flush();
	 
//	driver.quit();
	
	//soft.assertAll();
}

}


