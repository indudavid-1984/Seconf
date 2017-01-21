package org.tests.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProductEditionsTest extends TestBase {
	
	ProductEdition PEpage=PageFactory.initElements(webDriver, ProductEdition.class);;
	
	//@Parameters({ "path" })
	//@BeforeClass(alwaysRun = true) //(groups = {"Smoke" ,"Integration"})
//	public void testInit1(String path) {
	@BeforeClass //(alwaysRun = true)
	public void testInit1() {

		// Load the page in the browser
		//webDriver.get(websiteUrl);
		System.out.println("runnnnnnnnnnnnnnnnig");
		 JavascriptExecutor js=(JavascriptExecutor) webDriver;  
		    
		 //String readyState=(String)js.executeScript("return document.readyState");  
		 // System.out.println("readyState  : "+readyState); 
		//PEpage = PageFactory.initElements(webDriver, ProductEdition.class);
		//webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
		
	
	@Test(groups = {"Integration"})
	public void PETest() throws InterruptedException{
		PEpage.HoverProductEdition();
	//	String s = PEpage.OverviewClick().GetHeading();
	//	Assert.assertEquals(s, "Product Editions Overview");
		
	}
	@Test(groups = {"Functional"}, dependsOnMethods = "PETest")
	public void LinkTest() throws InterruptedException{
		int n = PEpage.GetLinks();
		System.out.println("got the links");
		Assert.assertEquals(n, 6);
		
	}
	
	@Test(groups = {"Integration"},dependsOnMethods = "PETest")
	public void ColumnsTest() throws InterruptedException{
		PEpage.CompareClick();
		String s [] =PEpage.GetColumns();
		System.out.println("got the columns");
		Assert.assertEquals(s.length, 3);
		
	}
	@Test(groups = {"Functional"},dependsOnMethods = "ColumnsTest")
	public void BundledFeaturesTest( ) throws InterruptedException{
	
		String b1[] = PEpage.GetBundledFeatures();
		System.out.println("got the bundled features");
		for (String b : b1) {
		if (b.equals("Professional-Grade Support"))
		{ //check if column is checked
		}
		}
		Assert.assertEquals(b1[0], "Professional-Grade Support");
}
}