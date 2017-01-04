package com.indu.indusel.pages;

 


import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.indu.indusel.webdriver.util.excelreader;
import org.testng.asserts.SoftAssert;

public class mmtflightlistPageTest extends TestBase {
	
	excelreader n = new excelreader();
	
	SoftAssert s_asert = new SoftAssert();
	mmtflightlistPage mmtflightlistPage;
	
	mmthomepage mmthomepage;
	
	@Parameters({ "path" })
	@BeforeMethod
	public void testInit(String path) {

		// Load the page in the browser
		System.out.println("running init");
		webDriver.get(websiteUrl + path);
	
		System.out.println("url");
		mmtflightlistPage = PageFactory.initElements(webDriver, mmtflightlistPage.class);
		mmthomepage= PageFactory.initElements(webDriver, mmthomepage.class);
		
	}

	
	@Test(dataProvider = "test", dataProviderClass= excelreader.class, groups = "A")
	
	public void testflightbook( String A, String B,float day, float month, float year, float nofp,  String f1, String f2) throws InterruptedException, NoSuchElementException {
		System.out.println("-----inside testflightbook---");//
		mmtflightlistPage.SelectFrom(A);
		//findElement(webDriver,By.xpath("l"), 0);
	//	mmtflightlistPage.SelectTo(B);
	//	mmtflightlistPage.Dateselect(day, month, year).SelectPass(nofp);
	//	mmtflightlistPage.search().depradio(f1);
	//	
	//	mmthomepage.Fromradio(f2);
		mmtflightlistPage.finalflight();
		
	//	s_asert.assertEquals(mmtflightlistPage.finalflight(), f1);
		
	}
	
	/*
	@Test
	public void rewardsTest( String flight){
		
	try {	mmtflightlistPage.Rewards();//depradio(flight);
		
		Set<String> a = webDriver.getWindowHandles();
		for (String i : a){
			webDriver.switchTo().window(i);
		{
			
		}
			}
		//webDriver.switchTo().window(a.);
		
		Assert.assertEquals(webDriver.getTitle(), "rewards");
	} catch ( Exception e)
	{ System.out.println(e.getMessage());
	
}
	
	} 
	
	@Test
	public void trainsTest( ){
		
		String s= webDriver.getCurrentUrl();
		mmtflightlistPage.trainsClick();
		String s2 = webDriver.getCurrentUrl();
		webDriver.navigate().back();
		 String s3 = webDriver.getCurrentUrl();
		Assert.assertEquals(s, s3) ;
		
		 
		
	} */
}
