package com.indu.indusel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends Page {

	private final String H2_TAG = "h2";
	
	@FindBy(how = How.TAG_NAME, using = H2_TAG)
	@CacheLookup
	private WebElement h1Element;
	
	public LoginPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public String getH2() {
		
		return "abc";
		//return h1Element.getText();
	}

}