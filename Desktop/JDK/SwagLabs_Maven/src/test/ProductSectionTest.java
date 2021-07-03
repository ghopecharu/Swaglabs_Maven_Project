package test;

import org.testng.annotations.Test;

import pages.CartPage;
import pages.LoginUser;
import pages.ProductPage;

public class ProductSectionTest extends BaseClass {

@Test	

 public void Login() {
	
 LoginUser Loginobj= new LoginUser();
 String uname=sheet.getRow(1).getCell(0).getStringCellValue();
 String pass=sheet.getRow(1).getCell(1).getStringCellValue();
 Loginobj.Login(uname,pass);
}

 @Test(dependsOnMethods="Login")
 public void ProductSelction() {
	 ProductPage product1= new ProductPage();
	    String product = sheet.getRow(1).getCell(2).getStringCellValue();
	    product1.addToCart(product);
}
 @Test(dependsOnMethods="ProductSelction")
 public void Cart() {
	 CartPage cartPageObj = new CartPage();
		String product = sheet.getRow(1).getCell(2).getStringCellValue();
		cartPageObj.verifyProduct(product);
 }

}
