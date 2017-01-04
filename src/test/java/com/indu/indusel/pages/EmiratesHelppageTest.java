package com.indu.indusel.pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EmiratesHelppageTest extends TestBase{
	EmiratesHelppage EmiratesHelppage;

	//@Parameters({ "path" })
	@BeforeMethod
	public void testInit() {

		// Load the page in the browser
		webDriver.get("https://www.emirates.com/in/english/help/faqs/faqs.aspx");
		EmiratesHelppage= PageFactory.initElements(webDriver, EmiratesHelppage.class);
		
		
	}

	@Test
	public void testLinks() throws InterruptedException {
		List <String> s = EmiratesHelppage.checkLinks();
		
		
		Assert.assertNull(s);
	}

	
	}