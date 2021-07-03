package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.BaseClass;

public class LoginUser {
	
WebDriver driver;
ExtentReports  report;
ExtentTest test;

//WebElements========

/* @FindBy(name="user-name")
WebElement UserName;

@FindBy(name="password")
WebElement password;

@FindBy(name="login-button")
WebElement Login;*/

@FindBy(xpath="//input[@id='user-name']")
WebElement UserName;

@FindBy(xpath="//input[@id='password']")
WebElement password;

@FindBy(xpath="//input[@id='login-button']")
WebElement Login;

//=========Constructor===================

public LoginUser() {
	
	driver = BaseClass.driver;
	report = BaseClass.report;
	test = BaseClass.test;
	PageFactory.initElements(driver,this);
	
}
//	===Methods================
public void Login(String uname, String upass) {


  test=report.startTest("Login Test Case");
	
  test.log(LogStatus.PASS, "Successfully clicked on the login button");
  
  WebDriverWait wait = new WebDriverWait(driver,30);
  wait.until(ExpectedConditions.elementToBeClickable(UserName));

  UserName.sendKeys(uname);
  test.log(LogStatus.PASS, "Successfully entered on the username");
  
  password.sendKeys(upass);
  test.log(LogStatus.PASS, "Successfully entered password");
  
  Login.click();
  test.log(LogStatus.PASS, "Successfully clicked on the login link");
  

  
}

}