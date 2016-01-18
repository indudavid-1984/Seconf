package org.tests.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.GetAttribute;

public class ProductEdition extends Page {

	public ProductEdition(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	private final String productEdition = "Product Editions";
	private final String overview = "Overview";
	private final String links = "links";
	private final String columns = (".//*[@class= 'odd']/th/strong");
	private final String compare = "Compare Editions";
	private final String BundledFeatures= (".//*[@class= 'odd']/th");
	private final String heading = (".//*[@id = 'Content']/h1");
	
	@FindBy(how = How.LINK_TEXT, using = productEdition )
	@CacheLookup
	private WebElement ProductEdition;
	
	@FindBy(how = How.LINK_TEXT, using = overview )
	@CacheLookup
	private WebElement Overview;
	
	@FindBy(how = How.CLASS_NAME, using = links )
	@CacheLookup
	private List <WebElement> Links;
	
	@FindBy(how = How.XPATH, using = columns )
	@CacheLookup
	private List <WebElement> Columns;
	
	@FindBy(how = How.LINK_TEXT, using = compare )
	@CacheLookup
	private WebElement Compare;
	
	@FindBy(how = How.XPATH, using = BundledFeatures )
	@CacheLookup
	private List <WebElement> bundledFeatures;
	
	@FindBy(how = How.XPATH, using = heading )
	@CacheLookup
	private WebElement Heading;
	
	
	
	public void HoverProductEdition(){
		Actions builder = new Actions(webDriver);
		builder.moveToElement(ProductEdition).perform();
		
	}
	public ProductEdition OverviewClick(){
	Overview.click();
	return this;
	}
	

	public String GetHeading(){
	return Heading.getText();
	}
	
	
	public int GetLinks(){

		int i =0;
		
		for (WebElement a :Links ){
		

			System.out.println("links are"+ a.getText());
				
	}
		return Links.size();
	}
	
	
	public void CompareClick() {
		Compare.click();
	}
	
	public String[] GetColumns(){

		int i =0;
		String []b = new String [10] ;;
		for (WebElement a :Columns ){
		

			b[i]=  a.getText(); 
			System.out.println("Columns are"+ b[i]);
				i++;
	}
		return b;
	}
		
		public String[] GetBundledFeatures() {
			int i =0;
			String []b = new String [25] ;;
			for (WebElement a : bundledFeatures ){
				
				b[i]=  a.getText(); 
				 
				System.out.println("bundled odd features  are"+ a.getText());
				
		
	}
			return b;
}
}
