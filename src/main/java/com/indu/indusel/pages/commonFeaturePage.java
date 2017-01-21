package com.indu.indusel.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class commonFeaturePage extends WebDriverWrapper{
	
	public commonFeaturePage(WebDriver driver){
		
		super(driver);
	}
	
	
	private final String links = "//*[@id='column1']/div/div/ul/li";
	
	@FindBy(how = How.CLASS_NAME, using = "qubit-VisitorPulse-questionName")
	@CacheLookup
	private static WebElement question;
	
	@FindBy(how = How.CLASS_NAME, using = "qubit-VisitorPulse-questionName")
	@CacheLookup
	private List<WebElement> Score;
	
	public static boolean QuestionVisible()
	{
 //waitElementTextToBeExpected(question, "How would you rate your satisfaction with this website? ");
		System.out.println(question.getText());
	return (question.getText().equalsIgnoreCase("How would you rate your satisfaction with this website?"));	
	}
	
	public int Scores()
	{
		return (Score.size());
	}
	
}