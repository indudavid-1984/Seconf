package com.indu.indusel.pages;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.indu.indusel.webdriver.util.excelreader;

public class LoginPageTest extends TestBase {
	
	excelreader n = new excelreader();
	LoginPage Loginpage;
	
	@Parameters({ "path" })
	@BeforeClass
	public void testInit(String path) {

		// Load the page in the browser
		System.out.println("running init");
		webDriver.get(websiteUrl + path);
		System.out.println("url");
		Loginpage = PageFactory.initElements(webDriver, LoginPage.class);
	}

	@Test
	public void testH2Existing() throws InterruptedException {
		Assert.assertTrue(Loginpage.getH2() != null);
	}

	@Test( dataProvider = "test", dataProviderClass=excelreader.class)//By default, the data provider will be looked for in the current test class or one of its base classes. If you want to put your data provider in a different class, it needs to be a static method and you specify the class where it can be found in the dataProviderClass attribute"
	public void testH1Existing(String A1, double A2) throws InterruptedException, IOException {

System.out.printf("value A1" +A1 );
//System.out.println("value A2" +A2 );
}
	
}
