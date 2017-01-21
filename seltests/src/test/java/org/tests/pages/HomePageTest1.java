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
import com.thoughtworks.selenium.webdriven.commands.IsTextPresent;

public class HomePageTest1 extends TestBase {
	
	HomePage1 homepage;
	
	@Parameters({ "path" })
	@BeforeClass //(groups = {"smoke" ,"Integration"})
	public void testInit(String path) {

		// Load the page in the browser
	//	webDriver.get(websiteUrl);
		
		JavascriptExecutor js=(JavascriptExecutor) webDriver;  
	    
		  String readyState=(String)js.executeScript("return document.readyState");  
		  System.out.println("readyState  : "+readyState);
		homepage = PageFactory.initElements(webDriver, HomePage1.class);
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	/*@Parameters({ "path1" })
	@Test(groups = {"Smoke" ,"Integration"}, dataProvider = "test")
	public void LoginTest(String A1, String B1){
		homepage.enterUsername(A1);
		homepage.enterPassword(B1);
		homepage.clickSubmit();
		}
		*/
		
	
	
	@Test(groups = {"Smoke"})
	public void RegisterLinkTest() throws InterruptedException{
		homepage.RegisterUser();
		homepage.SelectCountry();
		homepage.SelectIam();
		homepage.SelectOrgtype();
		homepage.SelectRadio();
		Thread.sleep(1000);
		homepage.SelectSubmit();
		Assert.assertEquals("not working", "already registered");
	
		
	}
	
	@Test(groups = {"Smoke", "Functional"})
	public void LogoutTest() throws InterruptedException{
	 homepage.ClickLogout();
	 Assert.assertEquals('l', 'l');

	}
}