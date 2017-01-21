package org.tests.pages;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.*;
import org.testng.asserts.*;
import org.openqa.selenium.support.ui.*;

public class FlightListPageTest {
	
	@Test(groups = {"Smoke" ,"Integration"}, dependsOnMethods = "test2")
	public void testF1()
	{
		Assert.assertEquals(1,1);
	}
	
	@Test(groups = {"functional"})
	public void testF2()
	{
	}
	
	@Test(groups = {"functional"})
	public void testF3()
	{
		
	}
	
	@Test(groups = {"functional"})
	public void testF4()
	{
	
	}
	
	@Test(groups = {"functional"})
	public void testF5()
	{
		
	}

}
