package org.tests.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends Page {

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	private static final String Login = "Login"	;
	private static final String username = "username";
	private static final String password = "password";
	private static final String loginSubmit = "submit";
	private static final String Here = "here";
	
	@FindBy(how = How.LINK_TEXT, using = Login)
	@CacheLookup
	private WebElement LoginButton;
	
	@FindBy(how = How.NAME, using = username)
	@CacheLookup
	private WebElement Username;
	
	@FindBy(how = How.NAME, using = password)
	@CacheLookup
	private WebElement Password;
	
	@FindBy(how = How.NAME, using = loginSubmit)
	@CacheLookup
	private WebElement LoginSubmit;
	
	@FindBy(how = How.LINK_TEXT, using = Here)
	@CacheLookup
	private WebElement ClickHere;
	
	public void clickLogin (){
		LoginButton.click();
	}
	
	public void enterUsername(){
		Username.sendKeys("indujacob");
		}
	
	public void enterPassword(){
		Password.sendKeys("Allisgr8!");
	}
	
	public void clicksubmit() {
		LoginSubmit.click();
			}

	public void clickhere() {
		ClickHere.click();
		
	}
	
	
}
