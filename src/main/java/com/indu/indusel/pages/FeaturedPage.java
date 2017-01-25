package com.indu.indusel.pages;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 * Page class modeling the services offered by Features Page
 * 
 * @author Indu David
 */
public class FeaturedPage extends WebDriverWrapper {
	public FeaturedPage(WebDriver webDriver){
	   super(webDriver);
	}
	
	private final String FP = "Featured fares"; //Featured pages 
	
    @FindBy(how = How.ID, using = "from")
    private WebElement from1;
 
    @FindBy(how = How.XPATH, using="//select-fly-out/div/ul/li")
    private List<WebElement> selectFrom;
 
    @FindBy(how = How.NAME, using="to")
    private WebElement to1 ;
 
    @FindBy(how = How.LINK_TEXT, using="Search")
    private WebElement search;
 
    @FindBy(how = How.ID, using="special_trip_to_0")
    private WebElement special0;
 
    /*
     * Method models selecting the From city
     */
    public void FromSelect(){
	   from1.click();
	   for ( WebElement i : selectFrom) {
	      if ( i.getText().equalsIgnoreCase("Bengaluru (BLR)"))
		     i.click();
	   }
    }
    
    /*
     * Method models selecting the From city
     */ 
   public String ToEnter(){
      to1.sendKeys("London All Airports (LON)");
      to1.sendKeys(Keys.ENTER);
	  try {
	     Thread.sleep(3000);
	  } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	  String s1 = "London All Airports (LON)";
	  return s1 ;
   }
  
   /*
    * Method models selecting the From city
    */
   public String clickSearch() {
      search.click();
      String s = special0.getText();
      return s;
      }
}
