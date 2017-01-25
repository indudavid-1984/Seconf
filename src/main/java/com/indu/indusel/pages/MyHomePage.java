package com.indu.indusel.pages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.indu.indusel.webdriver.util.Browser;
import com.indu.indusel.webdriver.util.PropertyLoader;
import com.indu.indusel.pages.WebDriverWrapper;

/*
 * Page class modeling the services offered by Homepage
 */
public class MyHomePage extends CommonFeaturePage {
   public MyHomePage(WebDriver webDriver){
      super(webDriver);
      }

   private final String FP = "Featured fares"; //Featured pages 
	
   @FindBy(how = How.XPATH, using = "//*[matches(@id,'featuredFare')]/a/span[1]")////*[matches(@id, 'sometext\d+_text')]
   private WebElement FP1;
 
   @FindBy(how = How.ID, using="Browse our fares-link-label")
   private WebElement searchFlight;
 
   @FindBy(how = How.TAG_NAME, using="img")
   private List<WebElement> images;
 
   /*
    *  Method to demonstrate usage of findElement method implemented in WebDriverWrapper class to avoid mixing
    *  implicit and explicit wait.
    */
   public boolean explicitFind() {
		if((findElement(getDriver(), By.id("Submit"), 5000))!=null){
		return true;
	    } else 
		return false;
   }
  
   /*
    * Method to demonstrate Using Separate locator repository
    */
   public void clickManage1( String Browser){
      String manage = PropertyLoader.loadProperty(Browser+".manage");
      WebElement manageElt = getDriver().findElement(By.id(manage));
      manageElt.click();
   }
 
   /*
    * Method to demonstrate Using Browser specific code
    */
   public void clickManage2( String Browser){
      WebElement manage;
	  if(Browser.equalsIgnoreCase("ie")){
	     manage= getDriver().findElement(By.id("trips3"));
	  } else {
		manage = getDriver().findElement(By.id("trips")); 
	  }
      manage.click();
   }
  
    /*
	 * The FPhover method  uses jquery-xpath2.0 plugin to make use of regex in xpath
	 */ 
   public String FPhover(){
      Actions a = new Actions(getDriver());
      
      //Taking screenshot for debugging
	  File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
	  try {
	     FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
	  } catch (IOException e) {
		// TODO Auto-generated catch block
	  e.printStackTrace();
	  }
	  
	  //Applying the jquery xpath 2.0 plugin using JavascriptExecutor
	  String fileContents;
	  try {
		fileContents = Files.toString(new File("C:\\Users\\m1013143\\Downloads\\jquery-xpath-master\\jquery.xpath.js"), Charsets.UTF_8);
		JavascriptExecutor js = (JavascriptExecutor)getDriver();     
		js.executeScript(fileContents);
	  } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
      
	  //xpath is built using String s by using regex. 
	  JavascriptExecutor js = (JavascriptExecutor)getDriver(); 
	  String s= "\"//*[matches(@id,'featuredFare')]/a/span[1]\"";
	  String script = "return $(document).xpath("+s+").get(0)";
	  //WebElement is found using JavascriptExecutor using the xpath having regex
	  WebElement FP2= (WebElement)js.executeScript(script);
	  a.moveToElement(FP2).build().perform();
	  searchFlight.click();
	  return (getDriver().getTitle());
      }

   /*
	* The isImageVisible method in MyHomepage class uses javascript to check if the image is actually rendered.
	*/
   public String[] isImageVisible( String browser){
      String []a = null;
	  int i=0;
	  for( WebElement image: images){ 
	     Boolean result = null;
	     if(browser.equalsIgnoreCase("ie")){
	        result = (Boolean) ((JavascriptExecutor)getDriver()).executeScript("return arguments[0].complete;", image);
	     }else{ 
	    	//other browser types use different method to check
	        result = (Boolean) ((JavascriptExecutor)getDriver()).executeScript("return (typeof arguments[0].naturalWidth!=\"undefined\" && arguments[0].naturalWidth>0);", image);
	     }
	     if (result.booleanValue()) {
	     System.out.println(image.getAttribute("src"));
		 i++;
	     }
      }
	  return a;
   }
}

 
