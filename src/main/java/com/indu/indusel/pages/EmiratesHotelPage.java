package com.indu.indusel.pages;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.Calendar;
public class EmiratesHotelPage extends WebDriverWrapper{
	
	public EmiratesHotelPage(WebDriver driver){
		
		super(driver);
	}
	
	
	private final String Dest ="//*[tokenize(@class,'\s+')='$classname']";// "//*[matches(@id, '^autoC\d+$')]"; // "//*[@id='autoComplete']";
	
private final String Destlist = "//ul[@class = 'dropdown-menu airport-listbox ng-isolate-scope']/li";



private final String Checkin =  "input[name='lphsdate']";//"lphsdate"; //*[matches(@id, '^js_\d+$')]

private final String Checkout = "lphedate" ;

private final String HotelSearch= "btnHotelSearch" ;

private final String Next= "nextMonth" ;

@FindBy(how = How.XPATH, using = Dest)
private WebElement Dest1 ;

@FindBy(how = How.ID, using = Next)
private WebElement Next1 ;

@FindBy(how = How.CSS, using = Checkin)
private WebElement Checkin1 ;

@FindBy(how = How.XPATH, using = "#{a}")
private List<WebElement> Destlist2;
	
	@FindBy(how = How.XPATH, using = Destlist)
	private List<WebElement> Destlist1;
	
	@FindBy(how = How.NAME, using = Checkout)
	private WebElement Checkout1;
	
	@FindBy(how = How.NAME, using = HotelSearch)
	private WebElement HotelSearch1;
	
	
	public void selectDest ()
	
	{
		
		Dest1.click();
		Dest1.sendKeys("Ba");
		
		for (WebElement i : Destlist1)
			
		{
			
			if (i.findElement(By.xpath(".//a/span")).getText().contains("li, Indonesia, Asia"))
			{	i.click();
			break;
			}
		}
		
	}
	
	
	public void SelectCheckin(int month, int day)
	{ 
		Checkin1.click();
		String date_id = "day-"+day+"-"+month+"-2017";
		
		if (month != Calendar.MONTH || month!= Calendar.MONTH+1)
		{
			Next1.click();
		}
		
		
			
			getDriver().findElement(By.id(date_id)).click();
		
	}
	
	public void SelectCheckout(int month, int day)
	{ 
		Checkout1.click();
		String date_id = "day-"+day+"-"+month+"-2017";
		
		if (month != Calendar.MONTH || month!= Calendar.MONTH+1)
		{
			Next1.click();
		}
		
		
			
			getDriver().findElement(By.id(date_id)).click();
		
	}
	
	

public void SearchHotel()
{

  HotelSearch1.click();



}

}