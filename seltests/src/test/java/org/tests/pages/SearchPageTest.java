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

	public class SearchPageTest  extends TestBase {
		
		SearchPage searchPage;
		
		@Parameters({ "path" })
		@BeforeClass //(groups = {"Smoke" ,"Integration"})
		public void testInit(String path) {

			// Load the page in the browser
			//webDriver.get(websiteUrl);
			searchPage = PageFactory.initElements(webDriver, SearchPage.class);
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		@Test(groups = {"Smoke" ,"Integration"})
		public void SearchTest() throws InterruptedException{
			searchPage.clickSearch();
			searchPage.enterKey();
			searchPage.clickSearch1();
			String s= searchPage.returnWord();
			Assert.assertEquals(s, "users");
		}
		
		}
		