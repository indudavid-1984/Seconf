package com.indu.indusel.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyHomepageTest extends TestBase{
	MyHomepage MyHomepage;
	FeaturedPages FeaturedPages ;
	@Parameters({ "path" })
	@BeforeMethod
	public void testInit(String path) {

		// Load the page in the browser
		webDriver.get(websiteUrl + path);
		MyHomepage= PageFactory.initElements(webDriver, MyHomepage.class);
		FeaturedPages = PageFactory.initElements(webDriver, FeaturedPages.class);
		webDriver.manage().window().maximize();
	}
	
	/*
	 * This test uses findElement method implemented in WebDriverWrapper class which helps in keeping 
	 * implicit and explicit wait separate.
	 */
	@Test
	public void testTimeouts() throws InterruptedException {
		Boolean val = MyHomepage.explicitFind();
		Assert.assertTrue(val);
		
	}
	

	@Test
	public void testFP() throws InterruptedException {
	
		MyHomepage.FPhover();
		/*	MyHomepage.ClickManage(browser.getName());
		FeaturedPages.FromSelect();
		String S1= FeaturedPages.ToEnter();
		String S2 = FeaturedPages.clickSearch();
		
		Assert.assertEquals(S1,S2);
	}  */


}
	@Test
	public void testImages() throws InterruptedException {
	
		Assert.assertNull(MyHomepage.isImageVisible(browser.getName()));
		/*	MyHomepage.ClickManage(browser.getName());
		FeaturedPages.FromSelect();
		String S1= FeaturedPages.ToEnter();
		String S2 = FeaturedPages.clickSearch();
		
		Assert.assertEquals(S1,S2);
	}  */

}
}
	
