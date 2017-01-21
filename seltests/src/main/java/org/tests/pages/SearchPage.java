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

public class SearchPage extends Page {

	public SearchPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	private final String Search = "op";
	private final String Keyword = "keys";
	private final String word = "first last";
	private final String Search1 = "edit-submit";
	
	@FindBy(how = How.NAME, using = Search)
	@CacheLookup
	private WebElement search;
	
	@FindBy(how = How.NAME, using = Keyword)
	@CacheLookup
	private WebElement keyword;
	
	@FindBy(how = How.CLASS_NAME, using = word)
	@CacheLookup
	private WebElement Word;
	
	@FindBy(how = How.ID, using = Search1)
	@CacheLookup
	private WebElement search1;
	
	public void clickSearch(){
		search.click();
	}
	
	public void enterKey(){
		keyword.sendKeys("users");
	}
	
	public String returnWord(){
		
		return Word.getText();
	}

	public void clickSearch1() {
		search1.click();
	}
}
