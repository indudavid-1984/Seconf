package org.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FlightListPage extends Page {

	public FlightListPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
		// TODO Auto-generated constructor stub
	}
	
private static final String PriceColumn = ("Price");
private static final String Rewards = ("Rewards");
	
	@FindBy(how = How.LINK_TEXT, using = PriceColumn)
	@CacheLookup
	private static WebElement PriceColumnShow;
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = Rewards)
	@CacheLookup
	private static WebElement RewardsShow;
	
	public static WebElement getPriceColumnShow()
	
	{  PriceColumnShow.click();
		
		return PriceColumnShow;
	}
	
	public static Rewards  ClickRewardsShow()
	
	{  RewardsShow.click();
	//return PageFactory.initElements(webDriver, this);
		
	}
	
}
