package com.indu.indusel.pages;

import java.util.Set;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmiratesHotelPageTest extends TestBase{
	
	protected static final Logger log = LoggerFactory.getLogger(EmiratesHotelPageTest.class);
	EmiratesHotelPage EmiratesHotelPage;
	FeaturedPages FeaturedPages ;
	@Parameters({ "path" })
	@BeforeMethod
	public void testInit(String path) {

		// Load the page in the browser
		webDriver.get("https://www.emirates.com/in/english/plan_book/book-hotel/book-a-hotel.aspx");
		
		EmiratesHotelPage= PageFactory.initElements(webDriver, EmiratesHotelPage.class);
		FeaturedPages = PageFactory.initElements(webDriver, FeaturedPages.class);
		
	}

	/*@Test
	public void testHotelBook() throws InterruptedException {
		EmiratesHotelPage.selectDest();
		EmiratesHotelPage.SelectCheckin(1, 2);
		EmiratesHotelPage.SelectCheckout(2, 4);
		EmiratesHotelPage.SearchHotel();
		log.info(" current window"+ webDriver.getWindowHandle());
		String s1 = null ;
		Set <String> s = webDriver.getWindowHandles();
		for ( String i : s)
		{
			
			log.info("inside for");
		webDriver.switchTo().window(i);
		 s1 = webDriver.getCurrentUrl();
		System.out.println("url"+s1);
		
		}
		Assert.assertTrue(s1.contains("booking.com"));
	

	
	} */
	
}
