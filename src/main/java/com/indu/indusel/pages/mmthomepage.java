package com.indu.indusel.pages;

import org.openqa.selenium.WebDriver;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.indu.indusel.pages.*;
import java.util.Calendar;

public class mmthomepage extends WebDriverWrapper {

	private final String listofflightsOn = ".//*[@class='ng-scope']/id";
	private final String listofflightsBack= "hp-widget__sTo";
	private final String next_text = "Next";
	private final String Prev_text = "Prev";
	private final String Num = "";
	private final String year = "";
	private final String month ="";
	private final String day="";
	private final String search ="";
	
	private final String Dates = ".//*[@id='dp1479608859978']/div/div[1]/table/tbody/tr[2]";
	
	@FindBy(how =How.ID_OR_NAME , using = listofflightsOn)
	@CacheLookup
	private WebElement From;
	
	
	
	public void depradio (String flight) {
	System.
		
		
	}
		
	public void Fromradio (String flight){
		
	
		
	}
	
	
}