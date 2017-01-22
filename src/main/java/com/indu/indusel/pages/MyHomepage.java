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



public class MyHomepage extends commonFeaturePage {
	
	



	public MyHomepage(WebDriver webDriver){
		super(webDriver);
	}
	
	private final String FP = "Featured fares"; //Featured pages 
	
	
 @FindBy(how = How.XPATH, using = "//*[matches(@id,'featuredFare')]/a/span[1]")////*[matches(@id, 'sometext\d+_text')]
 private WebElement FP1;
 
 @FindBy(how = How.ID, using="Browse our fares-link-label")
 private WebElement SearchFlight;
 
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
 
 
 
 public void ClickManage( String Browser){
 
	 
	 
String Manage = PropertyLoader.loadProperty(Browser+".manage");
 
 WebElement manage = getDriver().findElement(By.id(Manage));
 
 manage.click();
 }
 


 
 
 
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
	
	String fileContents;
	try {
		fileContents = Files.toString(new File("C:\\Users\\m1013143\\Downloads\\jquery-xpath-master\\jquery.xpath.js"), Charsets.UTF_8);
		JavascriptExecutor js = (JavascriptExecutor)getDriver();     
		
		js.executeScript(fileContents);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	JavascriptExecutor js = (JavascriptExecutor)getDriver(); 
	 String s= "\"//*[matches(@id,'featuredFare')]/a/span[1]\"";
	String script = "return $(document).xpath("+s+").get(0)";
		
	WebElement FP2= (WebElement)js.executeScript(script);
			
	a.moveToElement(FP2).build().perform();
	 SearchFlight.click();
 }
 
 public String[] isImageVisible( String browser){
	 String []a = null;
	 int i=0;
	 for( WebElement image: images)
	 { 
		 
	 Boolean result = null;
	 if(browser.equalsIgnoreCase("ie")){
	 result = (Boolean) ((JavascriptExecutor)getDriver()).executeScript("return arguments[0].complete;", image);
	 }else{ //other browser types use diff method to check
	 result = (Boolean) ((JavascriptExecutor)getDriver()).executeScript("return (typeof arguments[0].naturalWidth!=\"undefined\" && arguments[0].naturalWidth>0);", image);
	 }
	 if (result.booleanValue())
	 {
		 
		
		//a[i]= image.getAttribute("src");
		//System.out.println(a[i] + "link"+ i);
		 System.out.println(image.getAttribute("src"));
		i++;
		
	 }
	 }
	 return a;
	 }



 }

 
