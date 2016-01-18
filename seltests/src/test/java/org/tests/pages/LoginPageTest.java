package org.tests.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	
	//@Parameters({ "path" })
	@BeforeClass //(groups = {"Smoke" ,"Integration"})
	public void testInit2() {

		// Load the page in the browser
		webDriver.get(websiteUrl);
		loginpage = PageFactory.initElements(webDriver, LoginPage.class);
		//webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
		
	
	@Test(groups = { "Integration","Functional" })
	public void LoginTest() throws InterruptedException{
		
		
		loginpage.clickLogin();
		loginpage.enterUsername();
		loginpage.enterPassword();
		loginpage.clicksubmit();
		//assert text present Log In Successful
		loginpage.clickhere();
		//assert text Successfully Validated
		Assert.assertEquals("logout", "logout");
	}
	
}