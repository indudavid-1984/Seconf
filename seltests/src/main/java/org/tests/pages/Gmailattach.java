package org.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Gmailattach extends Page {

	/*public Gmailattach(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}*/

	
	private final String email = "Email";
	private final String passsword = "Passwd";
	private final String submit = "signIn";
	private final String next = "next";
	private final String compose = "z0";
	private final String Attach = "/html/body/div[14]/div/div/div/div[1]/div[2]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/div/div/div[4]/table/tbody/tr/td[4]/div/div[1]/div/div/div"; //":ta"	;	
	
	@FindBy(how = How.ID, using = email )
	private WebElement emailField;
	
	@FindBy(how = How.ID, using = passsword )
	@CacheLookup
	private WebElement passswordField;
	
	@FindBy(how = How.XPATH, using = Attach )
	@CacheLookup
	private WebElement AttachFile;
	
	
	@FindBy(how = How.CLASS_NAME, using = compose )
	@CacheLookup
	private WebElement composeclick;
	
	@FindBy(how = How.ID, using = submit )
	@CacheLookup
	private WebElement submitclick;
	
	@FindBy(how = How.ID, using = next )
	@CacheLookup
	private WebElement nextclick;
	
	
	public void submitClick (){
		emailField.sendKeys("indudavid@gmail.com");
		nextclick.click();
		passswordField.sendKeys("Alliswell2@");
		submitclick.click();
		composeclick.click();
		AttachFile.click();
	}
	
}
	
