package com.indu.indusel.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
//import com.sun.istack.NotNull;


/**
 * Wraps important operations of {@link WebDriver}. Inherited by Page objects.
 * 
 */
public  class WebDriverWrapper {
 	//private static final Logger log = LoggerFactory.getLogger(WebDriverWrapper.class);
	 
    /**
     * Default value of the wait timeout as obtained from configuration.
     */
    public static final long IMPLICITLY_WAIT_TIMEOUT = 3000; //EnvironmentProperties.IMPLICITLY_WAIT_TIMEOUT;
    private static final long INTERVAL_SECONDS = 1;

    private WebDriver driver;

    public WebDriverWrapper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * After using this constructor, a child class must initiate {@code driver} explicitly
     */
    public WebDriverWrapper() {
        this(null);
    }

    /**
     * Set implicitly wait timeout for the {@link WebDriver}
     * 
     * @param seconds timeout measured in seconds
     */
    public void setTimeout(long seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    /**
     * Set implicitly wait timeout for the {@link WebDriver} to the default value
     */
    public void setTimeout() {
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS);
    }

    /**
     * Finds {@link WebElement} in the given context; unlike {@link WebDriver#findElement(By)}, does not throw exceptions. Sample usage:
     * 
     * <pre>
     * WebElement a = findElement(driver, By.className("a"), 20) ;
     * if (a != null) { String txt = a.getText(); ... } else { ...}
     * </pre>
     * 
     * @param context Search context ( {@link WebDriver}, {@link WebElement} etc.)
     * @param by locator, see {@link org.openqa.selenium.By}
     * @param timeoutSeconds wait timeout in seconds; must be >=0
     * @return found element; null if not found; does not throw exceptions
     */
    public WebElement findElement(SearchContext context, By by, long timeoutSeconds) {
        setTimeout(0);
        FluentWait<SearchContext> wait = new FluentWait<SearchContext>(context).withTimeout(timeoutSeconds, TimeUnit.SECONDS).ignoring(NotFoundException.class);
        WebElement element;
        try {
            element = wait.until(elementLocated(by));
        } catch (Exception e) {
            element = null;
        } finally {
            setTimeout();
        }
        return element;
    }

    /**
     * Calls {@link #findElement(SearchContext context, By by, long timeoutSeconds)} with the default timeout {@code timeoutSeconds=implicitlyWaitTimeout}
     * 
     */
    public WebElement findElement(SearchContext context, By by) {
    	 System.out.println("ha ha ha ");
        return findElement(context, by, IMPLICITLY_WAIT_TIMEOUT);
       
    }

    /**
     * Waits until WebElement becomes visible not longer than timeOutSeconds. Sample:
     * 
     * <code><pre>
     * goToPagePartWithButton.click();
     * boolean visible = waitElementIsVisible(driver, By.className(&quot;button&quot;), 20);
     * if (visible) {
     *     System.out.println(&quot;We see the button, so we are on the correct page&quot;);
     * } else {
     *     System.out.println(&quot;Something is rotten in the state of Denmark.&quot;);
     * }
     * </code></pre>
     * 
     * @param context search context (can be {@link WebDriver}, some {@link WebElement})
     * @param by The locating mechanism
     * @param timeoutSeconds time in seconds, must be >=0
     * @return true if WebElement is visible or becomes visible during timeoutSeconds; false if the element has not become visible during given time period or cannot be found
     */
    public boolean waitElementIsVisible(SearchContext context, By by, long timeoutSeconds) {
        boolean visible = false;
        setTimeout(0);
        FluentWait<SearchContext> wait = new FluentWait<SearchContext>(context).withTimeout(timeoutSeconds, TimeUnit.SECONDS).ignoring(NotFoundException.class);
        try {
            visible = wait.until(elementVisible(by));
        } catch (TimeoutException e) {
            visible = false;
        } finally {
            setTimeout();
        }
        return visible;
    }

    /**
     * Calls {@link #waitElementIsVisible(SearchContext context, By by, long timeoutSeconds)} with the default timeout {@code timeoutSeconds=implicitlyWaitTimeout}
     */
    public boolean waitElementIsVisible(SearchContext context, By by) {
        return waitElementIsVisible(context, by, IMPLICITLY_WAIT_TIMEOUT);
    }

    /**
     * Waits until WebElement becomes not visible; waiting time is not longer than timeOutSeconds. Sample: <code><pre>
     * removeButtonFromPage();
     * boolean notVisible = waitElementIsNotVisible(driver, By.className(&quot;button&quot;), 20);
     * if (notVisible) {
     *     System.out.println(&quot;The button disappeared within 20 seconds - just what we need&quot;);
     * } else {
     *     System.out.println(&quot;The button has not disappeared - bad luck! &quot;);
     * }
     * </code></pre>
     * 
     * @param context search context (can be {@link WebDriver}, some {@link WebElement})
     * @param by The locating mechanism
     * @param timeoutSeconds time in seconds, must be >=0
     * @return true if the element is not visible or does not exist; false if the element still is visible during given time period
     */
    public boolean waitElementIsNotVisible(SearchContext context, By by, long timeoutSeconds) {
        boolean notVisible = false;
        setTimeout(0);
        FluentWait<SearchContext> wait = new FluentWait<SearchContext>(context).withTimeout(timeoutSeconds, TimeUnit.SECONDS);
        try {
            notVisible = wait.until(elementNotVisible(by));
        } catch (StaleElementReferenceException e2) {
            notVisible = true;
        } catch (NotFoundException e1) {
            notVisible = true;
        } catch (TimeoutException e) {
            notVisible = false;
        } finally {
            setTimeout();

        }
        return notVisible;
    }

    /**
     * Waits until element change state to invisible or is removed from DOM
     * @param {@link WebElement}
     */
    public boolean waitElementIsNotVisible(final WebElement element) {
        setTimeout(0);
        try {
            new WebDriverWait(driver, IMPLICITLY_WAIT_TIMEOUT).until(new ExpectedCondition<Boolean>() {
              
                public Boolean apply(WebDriver driver) {
                    try {
                        return !element.isDisplayed();
                    } catch (Exception e) {
                        return true;
                    }
                }
            });
            setTimeout();
        //   log.info("Element is not visible");
            return true;
        } catch (Exception e) {
          // log.info("In waitElementIsNotVisible() catch block");
         //  log.info(e.getLocalizedMessage());
        	System.out.println("In waitElementIsNotVisible() catch block");
        	System.out.println(e.getLocalizedMessage());
        }
        setTimeout();
       // log.info("Element is visible");
        System.out.println("Element is visible");
        return false;
    }

    /**
     * Waits until element change state to visible
     * @param {@link WebElement}
     */
    public boolean waitElementIsVisible(final WebElement element) {
        try {
        	
            new WebDriverWait(driver, IMPLICITLY_WAIT_TIMEOUT).until(new ExpectedCondition<Boolean>() {
              
                public Boolean apply(WebDriver driver) {
                    try {
                        return element.isDisplayed();
                    } catch (Exception e) {
                        return false;
                    }
                }
            });
          //  log.info("Element is visible");
            System.out.println("Element is visible");
            return true;
        } catch (Exception e) {
        	System.out.println("Element is not visible");
           //log.info("Element is not visible");
            return false;
        }
    }

    /**
     * Waits for information being loaded from Back end to element, the wait intervals is the default {@link IMPLICITLY_WAIT_TIMEOUT}
     * @return {@link DashboardPage}
     */
   /* private void waitElementTextIsLoadedExpected(final WebElement element) {
    	 setTimeout(0);
        new WebDriverWait(getDriver(), IMPLICITLY_WAIT_TIMEOUT).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return !element.getText().equalsIgnoreCase("");
                } catch (Exception e) {
                    return false;
                }
                setTimeout(0);
            }
        });
    }*/

    /**
     * Waits for information being loaded from Back end to element, the wait intervals is the default {@link IMPLICITLY_WAIT_TIMEOUT}
     * @return {@link DashboardPage}
     */
/*	public void waitElementTextIsLoaded(final WebElement element) {
		try {
			waitElementTextIsLoadedExpected(element);
		}catch(Exception e){
			getDriver().navigate().refresh();
			waitElementTextIsLoadedExpected(element);
		}
	}
    /**
     * Waits for information being loaded from Back end, the wait intervals is the default {@link IMPLICITLY_WAIT_TIMEOUT}
     * @return {@link DashboardPage}
     */
    public void waitElementTextToBeExpected(final WebElement element, final String expected) {
    	//log.info("---------The implicict wait is -------- "+IMPLICITLY_WAIT_TIMEOUT);
    	System.out.println("---------The implicict wait is -------- "+IMPLICITLY_WAIT_TIMEOUT);
        new WebDriverWait(getDriver(), IMPLICITLY_WAIT_TIMEOUT).until(new ExpectedCondition<Boolean>() {        	
          
            public Boolean apply(WebDriver driver) {
                try {
                	System.out.println("Current element text {} "+element.getText());
                //	log.info("Current element text {} ",element.getText());
                    return element.getText().equalsIgnoreCase(expected);
                } catch (Exception e) {
                    return false;
                }
            }
        });
    }

    /**
     * Waits for element text to be not as expected, the wait interval is the default {@link IMPLICITLY_WAIT_TIMEOUT}
     * @return {@link DashboardPage}
     */
    public void waitElementTextToBeNotAsExpected(final WebElement element, final String expected) {
        new WebDriverWait(getDriver(), IMPLICITLY_WAIT_TIMEOUT).until(new ExpectedCondition<Boolean>() {
          
            public Boolean apply(WebDriver driver) {
                try {
                    return !element.getText().equalsIgnoreCase(expected);
                } catch (Exception e) {
                    return false;
                }
            }
        });
    } 

    /**
     * Calls {@link #waitElementIsNotVisible(SearchContext context, By by, long timeoutSeconds)} with the default timeout {@code timeoutSeconds=implicitlyWaitTimeout}
     */
    public boolean waitElementIsNotVisible(SearchContext context, By by) {
        return waitElementIsNotVisible(context, by, IMPLICITLY_WAIT_TIMEOUT);
    }

    /**
     * @param element {@link WebElement}
     * @return true if {@link WebElement} is present in DOM, false if it is null, stale (not present in DOM), does not exist
     */
    public boolean isElementPresent(WebElement element) {
        boolean isPresent = true;
        try {
            element.isDisplayed();
        } catch (Exception e) {
            isPresent = false;
        }
        return isPresent;
    }

    /**
     * @param element {@link WebElement}
     * @return true if {@link WebElement} is displayed; false if it is not displayed, null, absent in DOM, does not exist
     */
    public boolean isVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Similar to {@link #isVisible(WebElement)}, but sets implicitly wait timeout to 0 before check, and restores it to default after check, so no wait is necessary
     * @param element {@link WebElement}
     * @return true if {@link WebElement} is displayed; false if it is not displayed, null, absent in DOM, does not exist
     */
    public boolean isDisplayedNow(WebElement element) {
        setTimeout(0);
        boolean displayed = isVisible(element);
        setTimeout();
        return displayed;
    }

    /**
     * Waits for {@link WebElement} to change state from hidden to visible.
     * @param element {@link WebElement}
     * @return true if {@link WebElement} is became visible;false if it is not displayed in given time frame (IMPLICITLY_WAIT_TIMEOUT environment parameter)
     */
    public boolean waitForElementToAppear(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, IMPLICITLY_WAIT_TIMEOUT);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Waits not longer than timeOutSeconds until one of WebElement becomes visible. The method takes locators from the array in consecutive order and runs
     * {@link #waitElementIsVisible(context, by, INTERVAL_SECONDS)} until a visible element is found, or time is up. Useful when we expect that only one of the elements should be visible. Sample:
     * 
     * <code><pre>
     * clickButton();
     * WebElement result = waitElementIsVisible(driver, 20, By.id("id_on_First_Page", "id_on_Second_Page"); 
     * if (result == -1) {throw ... // We expect either First or Second page } else {
     *     if (result == 0) {// we are on First page }
     *   }
     * </code></pre>
     * 
     * @param context search context (can be {@link WebDriver} or {@link WebElement})
     * @param timeoutSeconds time in seconds, must be >=0
     * @param by locators
     * @return index of first found visible WebElement, starting from 0. Returns -1 if all elements are invisible or do not exist within given timeout.
     */
    public int waitElementIsVisible(SearchContext context, long timeoutSeconds, By... by) {
        for (long time = 0; time <= timeoutSeconds; time += INTERVAL_SECONDS * by.length) {
            for (int index = 0; index < by.length; index++) {
                if (waitElementIsVisible(context, by[index], INTERVAL_SECONDS)) {
                    try {
                        findElement(context, by[index]);
                        return index;
                    } catch (StaleElementReferenceException e) {
                        // Element has disappeared from DOM. Try again.
                    } catch (NotFoundException e1) {
                        // Page has changed, element is not present. Try again.
                    }
                }
            }
        }
        return -1;
    }

    /**
     * The same as {@link #waitElementIsVisible(SearchContext context, long timeoutSeconds, By... by)}, with timeoutSeconds = IMPLICITLY_WAIT_TIMEOUT
     * @param context search context
     * @param by locators
     * @return index of first found visible WebElement, starting from 0. Returns -1 if all elements are invisible or do not exist within default timeout.
     */
    public int waitElementIsVisible(SearchContext context, By... by) {
        return waitElementIsVisible(context, IMPLICITLY_WAIT_TIMEOUT, by);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Switches to last tab/window
     */
    protected void switchToLastWindow() {
        for (String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
        }
    }

    private Function<SearchContext, WebElement> elementLocated(final By by) {
        return new Function<SearchContext, WebElement>() {
            public WebElement apply( SearchContext context) {
                return context.findElement(by);
            }
        };
    }

    private static Function<SearchContext, Boolean> elementVisible(final By by) {
        return new Function<SearchContext, Boolean>() {
            public Boolean apply( SearchContext context) {
                return context != null ? context.findElement(by).isDisplayed() : false;
            }
        };
    }

    private static Function<SearchContext, Boolean> elementNotVisible(final By by) {
        return new Function<SearchContext, Boolean>() {
            public Boolean apply( SearchContext context) {
                return context != null ? !context.findElement(by).isDisplayed() : false;
            }
        };
    }

}
