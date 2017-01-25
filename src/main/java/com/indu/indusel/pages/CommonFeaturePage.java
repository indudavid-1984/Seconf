package com.indu.indusel.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 * Page class modeling features common across pages.
 * 
 * @author Indu David
 */
public class CommonFeaturePage extends WebDriverWrapper{
	public CommonFeaturePage(WebDriver driver){
		super(driver);
	}
	
	//List of elements on the page.
	private final String links = "//*[@id='column1']/div/div/ul/li";
	
	@FindBy(how = How.CLASS_NAME, using = "qubit-VisitorPulse-questionName")
	@CacheLookup
	private static WebElement question;
	
	@FindBy(how = How.CLASS_NAME, using = "qubit-VisitorPulse-questionName")
	@CacheLookup
	private List<WebElement> score;
	
	/*
	 * Method modeling the common feature 'user feedback'. This user feedback component appears in all
	 * the pages.
	 */
	public static boolean QuestionVisible(){
	   return (question.getText().equalsIgnoreCase("How would you rate your satisfaction with this website?"));	
	}
}