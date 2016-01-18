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

public class ClinicalConductorPageTest extends TestBase {
	
	ClinicalConductorPage clinicalConductorPage;
	PartnersPage partnersPage;
	
	@Parameters({ "path" })
	@BeforeClass //(groups = {"Smoke" ,"Integration","functional"})
	public void testInit(String path) {

		// Load the page in the browser
	//	webDriver.get(websiteUrl);
		clinicalConductorPage = PageFactory.initElements(webDriver, ClinicalConductorPage.class);
		partnersPage = PageFactory.initElements(webDriver, PartnersPage.class);
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	

	
	@Test(groups = {"Integration","Functional"})
	public void CCTest() throws InterruptedException {
		partnersPage.ClickPartners();
		
		String Parent_Window = webDriver.getWindowHandle();
System.out.println("\n parent window handles"+Parent_Window);
		
partnersPage.clickCC();
		for (String Child_Window : webDriver.getWindowHandles())
			 { if (Child_Window.equals(Parent_Window)!= true)
			 {
			System.out.println("\n inside for child window handles"+Child_Window +"\n p win = "+Parent_Window);
			 webDriver.switchTo().window(Child_Window);
			// Performing actions on child window
		String s = clinicalConductorPage.RequestLink();
		System.out.println(clinicalConductorPage.RequestLink());
		Assert.assertEquals(s, "RequestDemo");
		
	}
			 }
}}