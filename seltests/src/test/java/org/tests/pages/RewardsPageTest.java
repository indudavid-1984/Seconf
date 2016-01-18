package org.tests.pages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RewardsPageTest {
	
	
	@Test(groups = {"Smoke" ,"Integration"}, dependsOnMethods = "test2")
	public void testR1()
	{
		Assert.assertEquals(1,1);
	}
	
	@Test(groups = {"functional"})
	public void testR2()
	{
	}
	
	@Test(groups = {"functional"})
	public void testR3()
	{
		
	}
	
	@Test(groups = {"functional"})
	public void testR4()
	{
	
	}
	
	@Test(groups = {"functional"})
	public void testR5()
	{
		
	}
}
