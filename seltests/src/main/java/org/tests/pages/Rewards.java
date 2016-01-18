package org.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Rewards extends Page {
	public Rewards(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);

}
	
private static final String BenefitLink = ("view_benefit_link");
	
	@FindBy(how = How.CLASS_NAME, using = BenefitLink)
	@CacheLookup
	private static WebElement BenefitLinkShow;


public static void ClickBenefitLink() {
	
	BenefitLinkShow.click();
	
}
}


