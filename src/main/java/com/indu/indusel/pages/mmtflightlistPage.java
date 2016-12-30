package com.indu.indusel.pages;

import org.openqa.selenium.WebDriver;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.indu.indusel.pages.*;
import java.util.Calendar;

public class mmtflightlistPage extends WebDriverWrapper {

	private final String from_id = "hp-widget__sfrom";//commit1
	private final String To_id= "hp-widget__sTo";
	private final String next_text = "Next";
	private final String Prev_text = "Prev";
	private final String Num = "";
	private final String year = "";
	private final String month ="";
	private final String day="";
	private final String search ="";
	private final String FromList = ".//*[@id='ui-id-1']/li";
	
	private final String Fromfield = ".//*[@id='hp-widget__sfrom']";
	
	private final String Btn ="";//Rewards page
	
	private final String trains = "rail_pic";
	
	private final String Dates = ".//*[@id='dp1479608859978']/div/div[1]/table/tbody/tr[2]";
	
	@FindBy(how =How.XPATH, using = FromList)
	@CacheLookup
	private List<WebElement> A;
	
	@FindBy(how =How.CLASS_NAME, using = trains)
	@CacheLookup
	private WebElement train;
	
	@FindBy(how =How.XPATH, using = Fromfield)
	@CacheLookup
	private WebElement FromField;
	
	@FindBy(how =How.ID_OR_NAME , using = from_id)
	@CacheLookup
	private WebElement From;
	
	@FindBy(how =How.ID_OR_NAME , using = To_id)
	@CacheLookup
	private WebElement To;
	
	@FindBy(how =How.LINK_TEXT , using = next_text)
	@CacheLookup
	private WebElement Next;
	
	@FindBy(how =How.LINK_TEXT , using = Prev_text)
	@CacheLookup
	private WebElement Prev;
	
	@FindBy(how = How.XPATH, using = Num)
	@CacheLookup
	private List<WebElement> NoP;
	
	@FindBy(how = How.XPATH, using = year)
	@CacheLookup
	private WebElement year1;
	
	
	@FindBy(how = How.XPATH, using = month)
	@CacheLookup
	private WebElement month1;
	
	@FindBy(how = How.XPATH, using = day)
	@CacheLookup
	private WebElement day1;
	
	@FindBy(how = How.XPATH, using = search)
	@CacheLookup
	private WebElement searchBtn;
	
	@FindBy(how = How.XPATH, using = Btn)
	@CacheLookup
	private WebElement RewardsBtn;
	
	@FindBy(how = How.XPATH, using = Dates)
	@CacheLookup
	private List<WebElement> dates1;
	
	public void trainsClick(){
		
		train.click();
	}
	
	
	public void SelectPass (float NoP1) {
		
		int n = (int) NoP1;
		NoP.get(n).click();
		
	}
		
	public void SelectFrom (String from){
		int i =0;
		FromField.click();
		
	while (A.iterator().hasNext()){
		if (A.get(i).getAttribute("aria-label") == from) {
			A.get(i).click();
		}
	}
		
	}
	
	public void SelectTo (String To1){
		
		
		To.sendKeys(To1);
	}
	
	public mmtflightlistPage Dateselect(float day2, float month2 ,float year2){
		
		if (year2 == Integer.parseInt(year1.getText()) +1 || month2 > Integer.parseInt(month1.getText()))
		{ while (year2 == Integer.parseInt(year1.getText()) +1 || month2 > Integer.parseInt(month1.getText()))
		{ Next.click();
		}
		}
		
		else {
			dates1.get((int) day2).click();
		}
			
		
	return this;
	}
	
	public mmtRewardsPage Rewards()
	{
		RewardsBtn.click();
		return new mmtRewardsPage();
	}


public mmthomepage search()
{
	searchBtn.click();
	return new mmthomepage();
}

public String finalflight()
{
	return month1.getText();
}
}
	
	
	