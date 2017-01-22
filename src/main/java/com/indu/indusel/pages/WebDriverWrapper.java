package com.indu.indusel.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.base.Function;

/**
 * Wraps important operations of {@link WebDriver}. Inherited by Page objects.
 * 
 */
public  class WebDriverWrapper {
	private static final Logger log = LoggerFactory.getLogger(WebDriverWrapper.class);
	    
    //Setting a default value of the wait timeout.
    public static final long IMPLICITLY_WAIT_TIMEOUT = 3000;
    private WebDriver driver;

    public WebDriverWrapper(WebDriver driver) {
        this.driver = driver;
    }
    
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * Set implicitly wait timeout for the {@link WebDriver}
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
     * Finds {@link WebElement} in the given context; does not throw exceptions. 
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
            return findElement(context, by, IMPLICITLY_WAIT_TIMEOUT);
       
    }

    /**
     * Waits until WebElement becomes visible not longer than timeOutSeconds. 
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
     * Waits until WebElement becomes not visible; waiting time is not longer than timeOutSeconds. 
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
            return true;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        setTimeout();
        return false;
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
