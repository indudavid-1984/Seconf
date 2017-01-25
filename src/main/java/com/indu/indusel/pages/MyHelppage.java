package com.indu.indusel.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
/*
 * This class models the services offered by MyHelppage.
 * @author Indu David
 */
public class MyHelppage extends WebDriverWrapper{	
	public MyHelppage(WebDriver driver){
		super(driver);
	}
	
	private final String links = "//*[@id='column1']/div/div/ul/li";
	
	@FindBy(how = How.XPATH, using = links)
	@CacheLookup
	private List<WebElement> links1;
	
	public List<String> checkLinks(){ 
	   int t;
	   List <String> s  = new ArrayList<String>();
	   String href1 = links1.get(0).findElement(By.tagName("a")).getAttribute("href");
	   for( WebElement i : links1){
		   String href = i.findElement(By.tagName("a")).getAttribute("href");
		   i.findElement(By.tagName("a")).click(); 
		   String title = getDriver().getCurrentUrl();
		   if (!title.equalsIgnoreCase(href)){ 
		   s.add(href);
	   }
	   getDriver().navigate().to(href1);
	}
	return s;
    }
}


