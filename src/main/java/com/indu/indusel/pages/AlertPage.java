package com.indu.indusel.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.indu.indusel.pages.*;

public class AlertPage extends WebDriverWrapper {

	private final String H2_TAG = "h2 ";//
	private final String name= "uid";
	private final String password = "password";
	
	private String userid = "mngr51438";
	
	private String passwd = "remYteh";
	
	private final String cusid = "cusid";
	
	private final String submit = "AccSubmit";
	
	private final String login = "btnLogin";
	
	private final String delete = "html/body/div[2]/div/ul/li[4]/a";
	
	
	@FindBy(how =How.ID_OR_NAME , using = name)
	@CacheLookup
	private WebElement username;
	
	@FindBy(how =How.ID_OR_NAME , using = password)
	@CacheLookup
	private WebElement userpassword;
	
	@FindBy(how =How.XPATH , using = delete)
	@CacheLookup
	private WebElement deleteC;
	
	@FindBy(how =How.ID_OR_NAME , using = cusid)
	@CacheLookup
	private WebElement cusidenter;
	
	@FindBy(how =How.ID_OR_NAME , using = login)
	@CacheLookup
	private WebElement loginb;

	@FindBy(how =How.ID_OR_NAME , using = submit)
	@CacheLookup
	private WebElement submitid;
	
	public AlertPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public String getH2() {
		
		return "abc";
		//return h1Element.getText();
	}

	
	public void login () {
		username.sendKeys(userid);
		userpassword.sendKeys(passwd);
		loginb.click();
		findElement(loginb, null);
		waitElementIsVisible(loginb);
		
	}
	
	public void deletecust () {
		deleteC.click();
		cusidenter.sendKeys("123");
		submitid.click();
		
	}
	
	public boolean custvis () {
	
	return	username.isDisplayed();
		
	}
}


