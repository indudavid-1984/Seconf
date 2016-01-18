package org.tests.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GmailAttachTest extends TestBase {
	
	Gmailattach gmailattach;
	
	@Parameters({ "path" })
	@BeforeMethod(alwaysRun = true)
	public void testInit() { System.out.println("running init");

		// Load the page in the browser
		//webDriver.get(websiteUrl);
		gmailattach = PageFactory.initElements(webDriver, Gmailattach.class);
		
		//webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	

	@Test  (groups = {"Integration","Functional"})
	public void gmailTest() throws InterruptedException {
		gmailattach.submitClick();
		
	}
}