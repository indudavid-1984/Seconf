package org.tests.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.*;

import com.thoughtworks.selenium.webdriven.commands.GetAttribute;

public class HomePageTest extends TestBase {
	
	HomePage homepage;
	
	@Parameters({ "path" })
	@BeforeMethod(groups = {"Smoke" ,"Integration"})
	public void testInit(String path) {

		// Load the page in the browser
		webDriver.get(websiteUrl);
		 JavascriptExecutor js=(JavascriptExecutor) webDriver;  
		    
		  String readyState=(String)js.executeScript("return document.readyState");  
		  System.out.println("readyState  : "+readyState); 
		
		//homepage = PageFactory.initElements(webDriver, HomePage.class);
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Parameters({ "path1" })
	@Test(groups = {"Smoke" ,"Integration"}, dataProvider = "test")
	public void testH1Existing(String A1, String A2) throws InterruptedException, IOException {
String B1 = "Goa, India (GOI)";
		windowMaximise();
		//waitForPageToLoad();
		
		
		
		//homepage.selectDomestic();
		homepage.selectOneWay();
		//homepage.selectDropDownDep();
		//homepage.DomesticCityDepartureList();
		//homepage.selectDropDownDep();
		//new WebDriverWait(webDriver, TimeSpan.FromSeconds(timeOut)).Until(ExpectedConditions.ElementExists((By.Id(login))));
		//homepage.selectDepartureCity();
       // homepage.DestBoxclick();
		//homepage.selectDropDownDest();
		//homepage.DomesticCityDestList();
		//homepage.selectDestinationCity();
		System.out.println("oneway selected");
		homepage.EnterFrom(A1);
		homepage.EnterTo(B1);
		homepage.selectDate();
		
	
		homepage.SubmitButtonClick();
		homepage.FlightOnlyClick();
		Thread.sleep(2000);
		FlightListPage.getPriceColumnShow();
		System.out.println(" price"+ FlightListPage.getPriceColumnShow().getText() );
		//Assert.assertEquals(true, FlightListPage.getPriceColumnShow().isDisplayed());
		String Parent_Window = webDriver.getWindowHandle();
		System.out.println("\n parent window handles"+Parent_Window);
		
		FlightListPage.ClickRewardsShow();
		for (String Child_Window : webDriver.getWindowHandles())
			 { if (Child_Window.equals(Parent_Window)!= true)
			 {
			System.out.println("\n inside for child window handles"+Child_Window +"\n p win = "+Parent_Window);
			 webDriver.switchTo().window(Child_Window);
			// Performing actions on child window
			 Rewards.ClickBenefitLink();
			 System.out.println("clicked on benefit");
			 Thread.sleep(2000);
			 break;
			 }
				 } 
		

		/*Set <String>b=  webDriver.getWindowHandles();
		Set <String>a=  new LinkedHashSet <String>(b);
		for (String Child_Window : a)
		 { if (Child_Window.equals(Parent_Window)!= true)
		 {
		System.out.println("\n inside for child window handles"+Child_Window +"\n p win = "+Parent_Window);
		 webDriver.switchTo().window(Child_Window);
		// Performing actions on child window
		 Rewards.ClickBenefitLink();
		 System.out.println("clicked on benefit");
		 Thread.sleep(2000);
		 break;
		 }
			 } */
		
		Thread.sleep(2000);
				 //Switching back to Parent Window
				webDriver.switchTo().window(Parent_Window);
				System.out.println("switched to parent");
				System.out.println(" price"+ FlightListPage.getPriceColumnShow().getText() );
				//Performing some actions on Parent Window
				Assert.assertEquals(true, FlightListPage.getPriceColumnShow().isDisplayed());
				
		

		
		
		log.debug("Hello this is an debug message");
	     log.info("Hello this is an info message");
	
	
	} 
	

	@Test
	public void test2() throws InterruptedException {
		Assert.assertTrue(true);
	}
	
/*	@Test(dataProvider = "test", groups = {"Smoke" ,"Integration"})
	public void test3(String A1) throws IOException, InterruptedException {
		windowMaximise();
		waitForPageToLoad();
		System.out.println("here");
		homepage.selectDomestic();
		System.out.println("btw");
		Thread.sleep(2000);
		homepage.selectOneWay();
		
		System.out.println("there");
		homepage.EnterFrom(A1);
		//homepage.selectDropDownDep();
	/* List<WebElement> S =	homepage.DomesticCityDepartureList();
	//int i =0;
	System.out.println("outside loop");
	for (WebElement s: S){
		System.out.println("inside loop");
		if (s.getText()== A1){
			System.out.println("its thr");
			System.out.println(s.getText()+ "this is wat i am trying to find");
			//break;
		}
		else{
			System.out.println(s.getText()+ "this is wat i am trying to find");
		System.out.println("not thr");
	}
		System.out.println("loop over");
	
	}
	}*/

	

	
	
		
	     @Test(groups = {"Smoke" ,"Integration"}, dependsOnMethods = "testH2")
	 	public void testH1()
	 	{
	 		Assert.assertEquals(1,1);
	 	}
	 	
	 	@Test(groups = {"Integration"})
	 	public void testH2()
	 	{

			log.debug("Hello this is an debug message");
		     log.info("Hello this is an info message");
	 	}
	 	
	 	@Test(groups = {"functional"})
	 	public void testH3()
	 	{
	 		
	 	}
	 	
	 	@Test(groups = {"functional"})
	 	public void testH4()
	 	{
	 	
	 	}
	 	
	 	@Test(groups = {"functional"})
	 	public void testH5()
	 	{
	 		
	 	}
	}
	
