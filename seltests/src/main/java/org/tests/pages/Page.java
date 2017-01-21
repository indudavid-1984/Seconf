package org.tests.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.tests.util.PropertyLoader;

/*
 * Abstract class representation of a Page in the UI. Page object pattern
 * 
 * @author Sebastiano Armeli-Battana
 */
public abstract class Page {

	protected  WebDriver webDriver;
	

	/*
	 * Constructor injecting the WebDriver interface
	 * 
	 * @param webDriver
	 */
/*	public Page(WebDriver webDriver) {
		this.webDriver = webDriver;
	}*/

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public String getTitle() {
		return webDriver.getTitle();
	}
	public void waitT(){
	
	webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

}
}
