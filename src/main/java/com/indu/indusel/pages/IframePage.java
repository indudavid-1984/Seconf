package com.indu.indusel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 * Sample page //http://www.littlewebhut.com/articles/html_iframe_example/
 * 
 * @author Sebastiano Armeli-Battana
 */
public class IframePage extends Page {

	private final String H1_TAG = "h1";
	
	@FindBy(how = How.TAG_NAME, using = H1_TAG)
	@CacheLookup
	private WebElement h1Element;
	
	public IframePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public String getH1() {
		return "abc";
		//return h1Element.getText();
	}

}