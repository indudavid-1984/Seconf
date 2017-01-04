package com.indu.indusel.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EmiratesHelppage extends WebDriverWrapper{
	
	public EmiratesHelppage(WebDriver driver){
		
		super(driver);
	}
	
	
	private final String links = "//*[@id='column1']/div/div/ul/li";
	
	@FindBy(how = How.XPATH, using = links)
	@CacheLookup
	private List<WebElement> links1;
	
	public List<String> checkLinks()
	{ int t;
	List <String> s  = new ArrayList<String>();
	String href1 = links1.get(0).findElement(By.tagName("a")).getAttribute("href");
		
		for( WebElement i : links1){
						String href = i.findElement(By.tagName("a")).getAttribute("href");

			System.out.println("string i"+ href);
			i.findElement(By.tagName("a")).click(); //i.click();
			System.out.println("clicked on i");
			String title = getDriver().getCurrentUrl();//.replace("https://www.emirates.com","");
			System.out.println("after clicking get title" + title);
			if (!title.equalsIgnoreCase(href))
			{ 
			  s.add(href);
			}
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			getDriver().navigate().to(href1);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			return s;
		}
	}


