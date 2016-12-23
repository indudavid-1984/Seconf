package com.indu.indusel.pages;

 


import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.indu.indusel.webdriver.util.excelreader;

public class AlertPageTest extends TestBase {
	
	excelreader n = new excelreader();
	AlertPage Alertpage;
	
	@Parameters({ "path" })
	@BeforeMethod
	public void testInit(String path) {

		// Load the page in the browser
		System.out.println("*********running init in alert page test class*****");
		webDriver.get(websiteUrl + path);
	
		System.out.println("url");
		Alertpage = PageFactory.initElements(webDriver, AlertPage.class);
		Assert.assertEquals(1,1);
	}

	
	@Test
	public void testAlert() throws InterruptedException, NoSuchElementException {
		System.out.println("-----inside alertest---");
		//Alertpage.login();
		//Alertpage.deletecust();
		 // Switching to Alert        
       // Alert alert=webDriver.switchTo().alert();	
		 WebElement p;
		By arg0;
		//webDriver.findElements(arg0).
	//	p.isEnabled();
		
		//webDriver.
		
		//webDriver.
		//Alertpage.custvis()
		//p.getCssValue(arg0)
		//Alertpage.
		
		
		
	    if ( Alertpage.custvis()== true){System.out.println("found elt");};
       WebElement a = Alertpage.findElement(webDriver, By.name("uid"));
       
       if (a!=null){System.out.println("found elt");}
  
       
        
        
        		
        // Capturing alert message.    
      //  String alertMessage=webDriver.switchTo().alert().getText();		
        		
        // Displaying alert message		
     //   System.out.println(alertMessage);			
        		
        // Accepting alert		
     //   alert.accept();	
		
		//Assert.assertTrue(Loginpage.getH2() != null);
	}
	
	

	@Test //( dataProvider = "test1", dataProviderClass=excelreader.class)//By default, the data provider will be looked for in the current test class or one of its base classes. If you want to put your data provider in a different class, it needs to be a static method and you specify the class where it can be found in the dataProviderClass attribute"
	public void testAlert2 (){     //(String A1, double A2)  {
System.out.printf("value A1" +"A1" );
System.out.println("value A2" +"A2" );
}
	
}
