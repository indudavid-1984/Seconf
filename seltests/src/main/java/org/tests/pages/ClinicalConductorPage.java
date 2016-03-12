package org.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ClinicalConductorPage extends Page {

	public ClinicalConductorPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	

	private final String requestDemo = "REQUEST DEMO";
	
	
	@FindBy(how = How.LINK_TEXT, using = requestDemo )
	@CacheLookup
	private WebElement RequestDemo;
	
	public String RequestLink (){
		return RequestDemo.getTextiiiii();
	}
	
}