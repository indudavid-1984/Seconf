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

public class HomePage extends Page {

	private final String Domestic = "Domestic";
	private final String OneWay =("/html/body/div[6]/div[1]/div/div/div[1]/div/div[3]/div/div[4]/div[1]/div[1]/a/span"); //"(//span[contains(text(),'                 ONE WAY            ')])";
	private final String RoundTrip = "(//span[contains(text(),'Round Trip')])";
	private final String MutiCity = "(//span[contains(text(),'Multi City / Stop Over')])";
	private final String DomesticCityDeparture = "(//div/div[2]/ul[2]/li[2]/a)" ;//"(div#autocomplete_container li.ui-menu-item)";/html/body/div[4]/div/div/div[2]/ul[2]/li[2]/a
	private final String DomesticCityDest="(/html/body/div[3]/div[2]/ul[6]/li/a)";
	private final String dropDownDest = "(//div[@id='top_content']/div[2]/div/div[2]/div/div[3]/div[3]/span/a)";//div[@id='top_content']/div[2]/div/div[2]/div/div[3]/div[3]/span/a//"(/html/body/div[3]/div[4]/div[1]/div[2]/div/div[2]/div/div[4]/div[3]/span/a)" ;//"(//*[@id='top_content']/div[2]/div/div[2]/div/div[3]/div[2]/span/a/span[1])";//
	private final String dropDownDep ="(/html/body/div[3]/div[4]/div[1]/div[2]/div/div[2]/div/div[3]/div[2]/span[1]/a)";
	private final String Date = "td";
	private final String DestBox = "to_typeahead1" ;//("/html/body/div[3]/div[4]/div[1]/div[2]/div/div[2]/div/div[3]/div[3]/span/input");
	private final String DateRetBox =("/html/body/div[3]/div[4]/div[1]/div[2]/div/div[2]/div/div[5]/span/span[2]/a/span[1]");
	private final String submitButton = ("submit_name");
	private final String flightOnly = ("grenBttn");
	private final String fromBox = "from_typeahead1" ;
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = Domestic)
	@CacheLookup
	private WebElement DomesticElt;
	
	@FindBy(how= How.XPATH, using = OneWay)
	@CacheLookup
	private WebElement OneWayElt;
	
	@FindBy(how= How.XPATH, using = RoundTrip)
	@CacheLookup
	private WebElement RoundTripElt;
	
	@FindBy(how= How.ID, using = fromBox)
	@CacheLookup
	private WebElement FromBoxElt;
	
	@FindBy(how= How.XPATH, using = MutiCity)
	@CacheLookup
	private WebElement MutiCityElt;
	
	
	
	
	
	@FindBy(how= How.TAG_NAME, using = DomesticCityDeparture)
	@CacheLookup
	private List<WebElement> DomesticCityDepartureElts;
	
	//WebDriver driver;
	// List<WebElement> li = driver.findElements( By.xpath("//div/div[2]/ul/li"));
	
	
	@FindBy(how= How.XPATH, using = DestBox)
	@CacheLookup
	private WebElement DestBox1;

	@FindBy(how= How.TAG_NAME, using = Date)
	@CacheLookup
	private List<WebElement> Dates;
	
	@FindBy(how= How.TAG_NAME, using = Date)
	@CacheLookup
	private List<WebElement> DatesRet;
	

	
	@FindBy(how= How.ID_OR_NAME, using = submitButton)
	@CacheLookup
	private WebElement SubmitButton;
	
	@FindBy(how = How.CLASS_NAME, using = flightOnly)
	@CacheLookup
	private WebElement FlightOnlyButton;
	
	public HomePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public String selectDomestic() {
		return DomesticElt.getText();
	}
	
	public void selectOneWay() {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(OneWayElt));
		System.out.println("trying to click");
		OneWayElt.click();
		System.out.println("clicked");
	}

	public void selectRoundTrip() {
		RoundTripElt.click();
	}
	
	public void MutiCity() {
		MutiCityElt.click();
	}
	
	public void DestBoxclick() {
		DestBox1.click();
	}


	
	public void EnterFrom(String a){
		FromBoxElt.sendKeys(a);
		
	}
public void EnterTo(String b){
	DestBox1.sendKeys(b);
}
	


	public List<WebElement> DomesticCityDepartureList() {
		System.out.println("list is"+ DomesticCityDepartureElts.get(0).getText() );
	return	DomesticCityDepartureElts;
	}
	
	public void selectDepartureCity() {
		
		for (WebElement a :DomesticCityDepartureElts ){
			System.out.println("inside for"+  a.getText());

			if ( a.getText().contains("Goa") )
				{a.click();
				
				System.out.println("inside if");
				break;
				}
			else
				System.out.println("no matching city");
				}
				
		}
	
	/*public List<WebElement> DomesticCityDestList() {
		System.out.println("list is"+ DomesticCityDestElts.get(0).getText() );
	return	DomesticCityDestElts;
	}*/
	
		
		/*public void selectDestinationCity() {
			
			for (WebElement a :DomesticCityDestElts ){
				System.out.println("inside dest for"+  a.getText());
				if ( a.getText().contains("Mumbai"))
					{a.click();
				break;
					}	
			}
			
	}*/
		
		public void selectDate(){
			for (WebElement a :Dates ){
				System.out.println("inside date for"+  a.getText()+ a.getAttribute("data-month"));
				if ( a.getText().contains("18")&& a.getAttribute("data-month").contains("8") )
					{
					System.out.println("inside if of dates");
					a.findElement(By.linkText("18")).click();
					
					}
					}
					//a.click();
		}
	
		public void selectDateRet(){
			for (WebElement a :DatesRet ){
				System.out.println("inside date for"+  a.getText()+ a.getAttribute("data-month"));
				if ( a.getText().contains("18")&& a.getAttribute("data-month").contains("8") )
					{
					System.out.println("inside if of dates");
					a.findElement(By.linkText("18")).click();
					
					}
					}
					//a.click();
		}
		
		
		public void SubmitButtonClick(){
			SubmitButton.click();
		}
		
		public FlightListPage FlightOnlyClick(){
			FlightOnlyButton.click();
			return PageFactory.initElements(webDriver, FlightListPage.class);
			
			
		}
	
}

