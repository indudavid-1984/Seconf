package com.indu.indusel.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EmiratesHomepageTest extends TestBase{
	EmiratesHomepage EmiratesHomepage;
	FeaturedPages FeaturedPages ;
	@Parameters({ "path" })
	@BeforeMethod
	public void testInit(String path) {

		// Load the page in the browser
		webDriver.get(websiteUrl + path);
		EmiratesHomepage= PageFactory.initElements(webDriver, EmiratesHomepage.class);
		FeaturedPages = PageFactory.initElements(webDriver, FeaturedPages.class);
		
	}

	@Test
	public void testFP() throws InterruptedException {
		EmiratesHomepage.FPhover();
		
		FeaturedPages.FromSelect();
		String S1= FeaturedPages.ToEnter();
		String S2 = FeaturedPages.clickSearch();
		
		Assert.assertEquals(S1,S2);
	}

	
	}
