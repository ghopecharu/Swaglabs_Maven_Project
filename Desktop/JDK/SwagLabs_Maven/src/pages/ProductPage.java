package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import test.BaseClass;

public class ProductPage {

WebDriver driver;
ExtentReports  report;
ExtentTest test;

public ProductPage() {
	
	driver = BaseClass.driver;
	report = BaseClass.report;
	test = BaseClass.test;
	PageFactory.initElements(driver,this);
	
}
//====WebElements====

/*@FindBy(name="add-to-cart-sauce-labs-backpack")
WebElement AddToCart;

@FindBy(className="shopping_cart_container")
WebElement CartContainer;

@FindBy(className="cart_quantity")
WebElement CartQuantity;
@FindBy(className="inventory_item_name")
WebElement ItemName;
@FindBy(className="inventory_item_desc")
WebElement ItemDesc;*/

@FindBy(xpath="//buttton[@id='add-to-cart-sauce-labs-backpack")
WebElement AddToCart;

//====Methods==================
/*public void SelectItem(){
	 test=report.startTest("Login Test Case");
		
	  test.log(LogStatus.PASS, "Successfully clicked on the login button");
	 
	  AddToCart.click();;
	  test.log(LogStatus.PASS, "Successfully added product to the cart");
	  
	  CartContainer.click();
	  test.log(LogStatus.PASS, "Successfully switched to cart container");
	  
	  String cartitem1 = CartQuantity.getText();
	   System.out.println("No of items added in cart:  " +cartitem1);
	   
	   String cartitem2 = ItemName.getText();
	   System.out.println("Item name:  " +cartitem2);
	   String cartitem3 = ItemDesc.getText();
	   System.out.println("Item Description:  "+cartitem3);
	   
}*/


public void addToCart(String Product){
	WebElement buttonProductSelect = driver.findElement(By.xpath("//*[text()= '" + Product + "']//following::button[1]"));
	buttonProductSelect.click();

}
}