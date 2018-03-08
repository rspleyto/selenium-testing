package rspleyto.testautomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowserUtils {

    private WebDriver driver;
    private JavascriptExecutor jse;
    private final int WAIT_TIME = 30;
    private Actions actions;

    public BrowserUtils(WebDriver driver) {
        this.driver = driver;
        this.jse = (JavascriptExecutor) this.driver;
        this.actions = new Actions(driver);
    }
    
    /* BROWSER WINDOW METHODS */
    
    public String getPageTitle() {
    	return driver.getTitle();
    }
    
    public String getCurrentUrl() {
    	return driver.getCurrentUrl();
    }

    /* BROWSER NAVIGATION METHODS */
    
    public void navigateToWebsite(String url) {
        driver.navigate().to(url);
        waitForPageToLoadCompletely();
    }

    public void browserBack() {
        driver.navigate().back();
    }

    public void browserForward() {
        driver.navigate().forward();
    }

    public void browserRefresh() {
        driver.navigate().refresh();
    }

    
    /* ELEMENT FINDER METHODS */
    
    public WebElement findElementById(String id) {
        try {
			return driver.findElement(By.id(id));
		} catch (NullPointerException npe) {
			System.out.println("Element with " + id + " not found or null");
			System.out.println(npe.getStackTrace());
		}
        
        return null;
    }

    public WebElement findElementByName(String name) {
    	try {
			return driver.findElement(By.name(name));
		} catch (NullPointerException npe) {
			System.out.println("Element with " + name + " not found or null");
			System.out.println(npe.getStackTrace());
		}
        
        return null;
    }

    public WebElement findElementByClass(String className) {
    	try {
			return driver.findElement(By.className(className));
		} catch (NullPointerException npe) {
			System.out.println("Element with " + className + " not found or null");
			System.out.println(npe.getStackTrace());
		}
        
        return null;
    }

    public WebElement findElementByTagName(String tagName) {
    	try {
			return driver.findElement(By.tagName(tagName));
		} catch (NullPointerException npe) {
			System.out.println("Element with " + tagName + " not found or null");
			System.out.println(npe.getStackTrace());
		}
        
        return null;
    }

    public WebElement findElementByCssSelector(String css) {
    	try {
			return driver.findElement(By.cssSelector(css));
		} catch (NullPointerException npe) {
			System.out.println("Element with " + css + " not found or null");
			System.out.println(npe.getStackTrace());
		}
        
        return null;
    }

    public WebElement findElementByLinkText (String linkText) {
    	try {
			return driver.findElement(By.linkText(linkText));
		} catch (NullPointerException npe) {
			System.out.println("Element with " + linkText + " not found or null");
			System.out.println(npe.getStackTrace());
		}
        
        return null;
    }

    public WebElement findElementByPartialLinkText (String partialLinkText) {
    	try {
			return driver.findElement(By.partialLinkText(partialLinkText));
		} catch (NullPointerException npe) {
			System.out.println("Element with " + partialLinkText + " not found or null");
			System.out.println(npe.getStackTrace());
		}
        
        return null;
    }

    public WebElement findElementByXPath(String xpath) {
    	try {
			return driver.findElement(By.xpath(xpath));
		} catch (NullPointerException npe) {
			System.out.println("Element with " + xpath + " not found or null");
			System.out.println(npe.getStackTrace());
		}
        
        return null;
    }
    
    /* TEXT INPUT METHODS */
    
    public boolean enterStringInElementWithId(String id, String inputString) {
    	WebElement element = findElementById(id);
    	
    	if (element != null) {
    		enterStringToElement(element, inputString);
    		return true;
		}
    	
    	return false;
    }
    
    public boolean enterStringToElement (WebElement element, String text) {
    	if (element != null) {
    		element.sendKeys(text);
    		return true;
		}
    	
    	return false;
    }
    
    public boolean pressEnterOnElementWithId (WebElement element) {
    	if (element != null) {
    		element.sendKeys(Keys.ENTER);
    		return true;
		}
    	
    	return false;
    }
    
    /* CLICK METHODS */
    
    public boolean clickElementWithId(String id) {
    	WebElement element = findElementById(id);
    	
    	if (element != null) {
    		element.click();
    		return true;
		}
    	
    	return false;
    }
    
    public boolean clickElement (WebElement element) {
    	if (element != null) {
    		element.click();
    		return true;
		}
    	
    	return false;
    }
    
    /* ALERT METHODS */
    
    public void acceptWebAlert() {
    	driver.switchTo().alert().accept();
    }
    
    public void dismissWebAlert() {
    	driver.switchTo().alert().dismiss();
    }
    
    public void getWebAlertMessage() {
    	driver.switchTo().alert().getText();
    }
    
    public void sendTextToWebAlert(String text) {
    	driver.switchTo().alert().sendKeys(text);
    }
    
    /* ELEMENT VISIBILITY/AVAILABILITY METHODS */
    
    public boolean isElementWithIdDisplayed(String id) {
    	try {
    		return findElementById(id).isDisplayed();
    	} catch (NullPointerException npe) {
    		System.out.println("Element with " + id + " not found or null.");
    		System.out.println(npe.getStackTrace());
    	} 
    	
    	return false;
    }
    
    public boolean isElementDisplayed (WebElement element) {
    	if (element != null && element.isDisplayed()) {
			return true;
		}
    	
    	return false;
    }
    
    /* HOVER METHODS */
    
    public boolean hoverOnElement(WebElement element) {
    	if (element != null) {
    		actions.moveToElement(element).build().perform();
    		return true;
		}
    	
    	return false;
    }
    
    /* WAIT METHODS */

    public void waitForPageToLoadCompletely() {
    	try {
    		driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(WAIT_TIME, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void waitForElementToAppear(WebElement element) {
    	try {
    		(new WebDriverWait(driver, WAIT_TIME)).until(ExpectedConditions.visibilityOf(element));
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void waitForElementToDisappear(WebElement element) {
    	try {
    		(new WebDriverWait(driver, WAIT_TIME)).until(ExpectedConditions.invisibilityOf(element));
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    /* JAVASCRIPT EXECUTION METHODS */
    
    public String executeScript(String script) {
    		String result = (String) jse.executeScript(script);
    		return result;
    }
}
