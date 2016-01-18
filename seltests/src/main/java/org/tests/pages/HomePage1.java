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

public class HomePage1 extends Page {

	public HomePage1(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	private final String Register = "Register";
	private final String name = "name";
	private final String mail = "mail";
	private final String conf_mail = "conf_mail";
	private final String password = "pass[pass1]";
	private final String confPassword ="pass[pass2]";
	private final String firstname = "field_first_name[0][value]";
	private final String lastname = "field_last_name[0][value]";
	private final String org = "field_affiliation[0][value]";
	private final String CountryDropDown = "edit-field-location-0-country";
	private final String Iam = "edit-taxonomy-4";
	private final String orgtype = "edit-taxonomy-5";
	private final String Noradio = "edit-field-organization-edc-value-No";
	private final String submit = "edit-submit";
	private final String logout = "Logout";
	
	@FindBy(how = How.LINK_TEXT, using = Register)
	@CacheLookup
	private WebElement RegisterLink;
	
	@FindBy(how = How.NAME, using = name)
	@CacheLookup
	private WebElement UsernameReg;
	
	@FindBy(how = How.NAME, using = mail)
	@CacheLookup
	private WebElement mailfield;
	
	@FindBy(how = How.NAME, using = conf_mail)
	@CacheLookup
	private WebElement conf_mail_field;
	
	@FindBy(how = How.NAME, using = password)
	@CacheLookup
	private WebElement Password;
	
	@FindBy(how = How.NAME, using = confPassword)
	@CacheLookup
	private WebElement ConfPassword;
	
	@FindBy(how = How.NAME, using = firstname)
	@CacheLookup
	private WebElement Firstname;
	
	@FindBy(how = How.NAME, using = lastname)
	@CacheLookup
	private WebElement LastName;
	
	@FindBy(how = How.NAME, using = org)
	@CacheLookup
	private WebElement Org;
	
	@FindBy(how = How.ID, using = CountryDropDown)
	@CacheLookup
	private WebElement countryDropDown;
	
	@FindBy(how = How.ID, using = Iam)
	@CacheLookup
	private WebElement iam;
	
	@FindBy(how = How.ID, using = orgtype)
	@CacheLookup
	private WebElement Orgtype;
	
	@FindBy(how = How.ID, using = Noradio)
	@CacheLookup
	private WebElement noradio;
	
	@FindBy(how = How.ID, using = submit)
	@CacheLookup
	private WebElement Submit;
	
	@FindBy(how = How.LINK_TEXT, using = logout)
	@CacheLookup
	private WebElement Logout;
	

	
	public void RegisterUser() {
		RegisterLink.click();
		UsernameReg.sendKeys("indu");
		mailfield.sendKeys("indudavid@gmail.com");
		conf_mail_field.sendKeys("indudavid@gmail.com");
		Password.sendKeys("Alliswell1!");
		ConfPassword.sendKeys("Alliswell1!");
		Firstname.sendKeys("Indu");
		LastName.sendKeys("David");
		Org.sendKeys("Individual");
		
		
		
		
	}
	
	public void SelectCountry() {
		Select drop = new Select(countryDropDown) ;
		drop.selectByValue("in");
		
		
	}
	
	public void SelectIam() {
		Select drop = new Select(iam) ;
		drop.selectByValue("4");
		
		
	}
	public void SelectOrgtype() {
		Select drop = new Select(Orgtype) ;
		drop.selectByValue("9");
		
		
	}
	
	public void SelectRadio() {
		
		noradio.click();
	
}
public void SelectSubmit() {
		
		Submit.click();
	
}

public void ClickLogout (){
	Logout.click();
}

}