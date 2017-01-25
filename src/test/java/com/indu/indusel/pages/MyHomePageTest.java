package com.indu.indusel.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
/*
 *Tests for MyHomePage included here.
 *@author Indu David 
 */
public class MyHomePageTest extends TestBase{
	MyHomePage myHomePage;
	FeaturedPage FeaturedPages ;
	
	@Parameters({ "path" })
	@BeforeMethod
		public void testInit(String path) {

		// Load the page in the browser
		webDriver.get(websiteUrl + path);
		myHomePage= PageFactory.initElements(webDriver, MyHomePage.class);
		FeaturedPages = PageFactory.initElements(webDriver, FeaturedPage.class);
		webDriver.manage().window().maximize();
	}
	
	/*
	 * This test uses findElement method implemented in WebDriverWrapper class which helps in keeping 
	 * implicit and explicit wait separate.
	 */
	@Test
	public void testTimeouts() throws InterruptedException {
		Boolean val = myHomePage.explicitFind();
		Assert.assertTrue(val);
		
	}
	
	/*
	 * This test uses the ClickMamage1 method in MyHomepage class which utilizes different locator repository 
	 * for browser specific locator.
	 */
	@Test
	public void testLocator1() throws InterruptedException {
	    myHomePage.clickManage1(browser.getName());
		FeaturedPages.FromSelect();
		String S1= FeaturedPages.ToEnter();
		String S2 = FeaturedPages.clickSearch();
		
		Assert.assertEquals(S1,S2);
	} 
	
	/*
	 * This test uses the ClickManage2 method in MyHomepage class which utilizes different locators in 
	 * code based on the browser name passed to it.
	 */
	@Test
	public void testLocator2() throws InterruptedException {
	    myHomePage.clickManage2(browser.getName());
		FeaturedPages.FromSelect();
		String S1= FeaturedPages.ToEnter();
		String S2 = FeaturedPages.clickSearch();
		
		Assert.assertEquals(S1,S2);
	} 
	
	/*
	 * This test uses the FPhover method in MyHomepage class which uses jquery-xpath2.0 plugin to make use og regex 
	 * in xpath
	 */
	@Test
	public void testFP() throws InterruptedException {
	    String title =	myHomePage.FPhover();
		
	    Assert.assertEquals(title,"Featured");
	}  

	/*
	 * This test uses the isImageVisible method in MyHomepage class which uses javascript to check if the image
	 * is actually rendered.
	 */
	@Test
	public void testImages() throws InterruptedException {
	
		Assert.assertNull(myHomePage.isImageVisible(browser.getName()));
	}
}
	
