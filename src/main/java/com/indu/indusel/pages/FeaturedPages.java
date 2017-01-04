package com.indu.indusel.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FeaturedPages extends WebDriverWrapper {
	
	public FeaturedPages(WebDriver webDriver){
		super(webDriver);
	}
	
	private final String FP = "Featured fares"; //Featured pages 

	
 @FindBy(how = How.ID, using = "from")
 private WebElement from1;
 
 @FindBy(how = How.XPATH, using="//select-fly-out/div/ul/li")
 private List<WebElement> SelectFrom;
 
 @FindBy(how = How.NAME, using="to")
 private WebElement To1 ;
 
 @FindBy(how = How.LINK_TEXT, using="Search")
 private WebElement Search;
 
 
 @FindBy(how = How.ID, using="special_trip_to_0")
 private WebElement special0;
 
 public void FromSelect(){
	 
	 from1.click();
	 for ( WebElement i : SelectFrom) {
		  if ( i.getText().equalsIgnoreCase("Bengaluru (BLR)"))
				i.click();
		  
		 
	 }
	 
	
 }
 
 public String ToEnter(){
	 
	 To1.sendKeys("London All Airports (LON)");
	 To1.sendKeys(Keys.ENTER);
	 try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 String S1 = "London All Airports (LON)";
	 return S1 ;
 }
 
 
public String clickSearch() {
	Search.click();
	String S = special0.getText();
	return S;
	
}
}
