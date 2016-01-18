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

public class PartnersPage extends Page {

	public PartnersPage(WebDriver webDriver) {
		super(webDriver);
		//PageFactory.initElements(webDriver, this);
		// TODO Auto-generated constructor stub
	}

	private final String partners = "Partners";
	private final String cc = "Clinical Conductor";
	private final String print = "print-page";
	private final String pdf = "print-pdf";
	private final String share = "addthisimage";
	private final String gplus1 = "___plusone_0";
	
	@FindBy(how = How.LINK_TEXT, using = partners)
	@CacheLookup
	private WebElement Partners;
	
	@FindBy(how = How.LINK_TEXT, using = cc)
	@CacheLookup
	private WebElement CC;
	
	@FindBy(how = How.CLASS_NAME, using = print)
	@CacheLookup
	private WebElement Print;
	
	@FindBy(how = How.CLASS_NAME, using = pdf)
	@CacheLookup
	private WebElement Pdf;
	
	@FindBy(how = How.CLASS_NAME, using = share)
	@CacheLookup
	private WebElement Share;
	
	@FindBy(how = How.ID, using = gplus1)
	@CacheLookup
	private WebElement Gplus1;
	
	public void ClickPartners(){
		 Partners.click();
	}
	
	public void clickCC() {
		CC.click();
		
	}
	
	public String[] findSmallButtons(){
		String [] a = new String [10];
		
		a [0]= Print.getAttribute("title");
		a[1]= Pdf.getAttribute("title");
		a[2]= Share.getAttribute("href");
		a[3] =Gplus1.getAttribute("aria-label");
		
		return a;
		
		
	}
	
}
