package org.tests.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import org.tests.util.PropertyLoader;
import org.tests.util.Browser;
import org.tests.webdriver.WebDriverFactory;

public class TestBase {
	
	static Logger log = Logger.getLogger(TestBase.class.getName());

	private static final String SCREENSHOT_FOLDER = "target/screenshots/";
	private static final String SCREENSHOT_FORMAT = ".png";
    protected WebDriver webDriver;
    protected String gridHubUrl;
    protected String websiteUrl;
    protected Browser browser;

	@BeforeMethod(groups = {"Smoke" ,"Integration", "Functional"}, alwaysRun = true)
	public  void init() {
		System.out.println("inside init");
		websiteUrl = PropertyLoader.loadProperty("site.url");
		gridHubUrl = PropertyLoader.loadProperty("grid2.hub");
		log.info("got url"+gridHubUrl+ " " +websiteUrl);
		browser = new Browser();
		browser.setName(PropertyLoader.loadProperty("browser.name"));
		log.info("browser in prop is" +browser.getName());
		browser.setVersion(PropertyLoader.loadProperty("browser.version"));
		log.info("\n browser version in prop is" +browser.getVersion());
		browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));
		log.info("\n browser platform  in prop is" +browser.getPlatform());
		String username = PropertyLoader.loadProperty("user.username");
		String password = PropertyLoader.loadProperty("user.password");
		log.info("\n user n pswd" + username + " "+ password);
		System.out.println("\n user n pswd" + username + " "+ password);
		//System.setProperty("webdriver.chrome.driver","D://Takeaway//Java//seltests//seltests//src//main//resources//drivers//chrome//chromedriver.exe");
		webDriver = WebDriverFactory.getInstance(gridHubUrl, browser, username,password);
		System.out.println("\n got instance" +webDriver);
		log.info("\n got instance");
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("timeout set?????");
		webDriver.get(websiteUrl);
		log.info("got url-------" + websiteUrl );
		System.out.println("got url-------" + websiteUrl);
		
	}

/*	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		if (webDriver != null) {
			webDriver.quit();
		}
		}*/
	

	@AfterMethod
	public void setScreenshot(ITestResult result) {
		if (!result.isSuccess()) {
		try {
			WebDriver returned = new Augmenter().augment(webDriver);
				if (returned != null) {
					File f = ((TakesScreenshot) returned)
							.getScreenshotAs(OutputType.FILE);
					try {
						String failureImageFileName = result.getMethod().getMethodName()+ new SimpleDateFormat("MM-dd-yyyy_HH-ss")
			             .format(new GregorianCalendar().getTime());
						FileUtils.copyFile(f, new File(SCREENSHOT_FOLDER
								+ result.getName() + failureImageFileName+ SCREENSHOT_FORMAT));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (ScreenshotException se) {
				se.printStackTrace();
			}
		
		}
		}
	/*@AfterMethod
	public void closeBrowser(ITestResult result)throws IOException {
		if (result.isSuccess()){
			File imageFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
			String failureImageFileName = result.getMethod().getMethodName()+ new SimpleDateFormat("MM-dd-yyyy_HH-ss")
			             .format(new GregorianCalendar().getTime())+".png";
			File failureImageFile = new File(failureImageFileName);
			FileUtils.moveFile(imageFile,failureImageFile);
			
			
		}
	}*/
	
	@DataProvider(name = "test1")
    public static Object[][] CityListData() {
		String []a = {"abc","2","3"};
        return new Object[][] {  { a[0], "asd" },
        		{ a[1], false }, { 19, true },
        	{ 22, false }, { 23, true }  };
    }
	
	
	  

	  
	
	public void windowMaximise() throws IOException
	  {
	    try
	    {
	  
	    	webDriver.manage().window().maximize();
	 
	    }
	    catch (Exception e)
	    {
	     log.info("Issue in maximizing the window");
	     log.info(e.getMessage()); 
	    }
	  
	  }
	
	 public  void waitForPageToLoad() throws IOException
	  {
	   // page load    
	Object  Result = ((JavascriptExecutor)webDriver)
	      .executeScript("function pageloadingtime(){return 'Page has completely loaded'}return (window.onload=pageloadingtime());", new Object[0]);
	    
log.info("did it load???"+Result);
}
	 
	 /*@Parameters ({"ExcelPath"})
	 @DataProvider(name="test")
     public Object[][] createdata1(String Path1 )throws Exception
     {
         Object[][] retobj = ReadExcelDemo(Path1);
         return retobj; */
	 
	 @DataProvider(name="test")
     public Object[][] createdata1( )throws Exception
     {
         Object[][] retobj = ReadExcelDemo();
         return retobj;

     }
 

	     public static Object[][] ReadExcelDemo() 
	     {
	    	 {log.info("inside excel dataprovider");
	    	    String [][]a = new String [1][2];
	         try
	         {
	             FileInputStream file = new FileInputStream(new File("D:/Takeaway/Java/seltests/src/main/java/HF.xlsx"));
	  
	             //Create Workbook instance holding reference to .xlsx file
	             XSSFWorkbook workbook = new XSSFWorkbook(file);
	  
	             //Get first/desired sheet from the workbook
	             XSSFSheet sheet = workbook.getSheetAt(0);
	  
	             //Iterate through each rows one by one
	             Iterator<Row> rowIterator = sheet.iterator();
	             
	         
	             while (rowIterator.hasNext()) 
	             {{System.out.println("inside while of row iterator");
	                 Row row = rowIterator.next();
	                 //For each row, iterate through all the columns
	                 Iterator<Cell> cellIterator = row.cellIterator();
	                  int i=0, j=0;
	                 while (cellIterator.hasNext()) 
	                 { 
	                	 System.out.println("inside while of iterator");
	                     Cell cell = cellIterator.next();
	                     //Check the cell type and format accordingly
	                     switch (cell.getCellType()) 
	                     {
	                         case Cell.CELL_TYPE_NUMERIC:
	                             System.out.print(cell.getNumericCellValue() + "t");
	                             break;
	                         case Cell.CELL_TYPE_STRING:
	                             System.out.print(cell.getStringCellValue() + "t");
	                             a[i][j]= cell.getStringCellValue();
	                             System.out.println("inside case");
	                             break;
	                     }
	                     j++;
	                 }
	                     i++;
	                 }
	                 System.out.println("");
	             }
	           
	             file.close();
	         } 
	         catch (Exception e) 
	         {
	             e.printStackTrace();
	         }
	         return a;
	     
	 
	    	 }
	    }
	     
	     @DataProvider(name="Share")
	     public Object[][] createSharedata1()throws Exception
	     {
	         Object[][] retobj = ReadExcelDemo1();
	         return retobj;

	     }
	 

		     public static Object[][] ReadExcelDemo1() 
		     {
		    	 {log.info("inside excel dataprovider");
		    	    String [][]a = new String [1][4];
		         try
		         {
		             FileInputStream file = new FileInputStream(new File("D:/Takeaway/Java/seltests/src/main/java/HF1.xlsx"));
		  
		             //Create Workbook instance holding reference to .xlsx file
		             XSSFWorkbook workbook = new XSSFWorkbook(file);
		  
		             //Get first/desired sheet from the workbook
		             XSSFSheet sheet = workbook.getSheetAt(0);
		  
		             //Iterate through each rows one by one
		             Iterator<Row> rowIterator = sheet.iterator();
		             
		         
		             while (rowIterator.hasNext()) 
		             {{System.out.println("inside while of row iterator");
		                 Row row = rowIterator.next();
		                 //For each row, iterate through all the columns
		                 Iterator<Cell> cellIterator = row.cellIterator();
		                  int i=0, j=0;
		                 while (cellIterator.hasNext()) 
		                 { 
		                	 System.out.println("inside while of iterator");
		                     Cell cell = cellIterator.next();
		                     //Check the cell type and format accordingly
		                     switch (cell.getCellType()) 
		                     {
		                         case Cell.CELL_TYPE_NUMERIC:
		                             System.out.print(cell.getNumericCellValue() + "t");
		                             break;
		                         case Cell.CELL_TYPE_STRING:
		                             System.out.print(cell.getStringCellValue() + "t");
		                             a[i][j]= cell.getStringCellValue();
		                             System.out.println("inside case");
		                             break;
		                     }
		                     j++;
		                 }
		                     i++;
		                 }
		                 System.out.println("");
		             }
		           
		             file.close();
		         } 
		         catch (Exception e) 
		         {
		             e.printStackTrace();
		         }
		         return a;
		     
		 
		    	 }
		    	 
		    	 
  }
}





