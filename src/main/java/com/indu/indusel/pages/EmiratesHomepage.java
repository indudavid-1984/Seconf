package com.indu.indusel.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EmiratesHomepage extends WebDriverWrapper {
	
	public EmiratesHomepage(WebDriver webDriver){
		super(webDriver);
	}
	
	private final String FP = "Featured fares"; //Featured pages 

	
 @FindBy(how = How.XPATH, using = "//*[@id='featuredFare']/a/span[1]")
 private WebElement FP1;
 
 @FindBy(how = How.ID, using="Browse our fares-link-label")
 private WebElement SearchFlight;
 
 public void FPhover(){
	 
	 Actions a = new Actions(getDriver());
	 File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
	// Now you can do whatever you need to do with it, for example copy somewhere
	try {
		FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 a.moveToElement(FP1).build().perform();
	 SearchFlight.click();
 }
 
 

}
