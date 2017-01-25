package com.indu.indusel.pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
/*
 *Tests for MyHelpPage included here.
 *@author Indu David 
 */
public class MyHelpPageTest extends TestBase{
	MyHelppage myHelppage;

	//@Parameters({ "path" })
	@BeforeMethod
	public void testInit() {
        // Load the page in the browser
		webDriver.get("https://url.com");
		myHelppage= PageFactory.initElements(webDriver, MyHelppage.class);
	}
    
	/*
	 * Test to check all links in the page
	 */
	@Test
	public void testLinks() throws InterruptedException {
		List <String> s = myHelppage.checkLinks();
		Assert.assertNull(s);
	}

	
}