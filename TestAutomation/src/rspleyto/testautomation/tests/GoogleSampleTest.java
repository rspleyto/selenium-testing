package rspleyto.testautomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rspleyto.testautomation.BrowserDriver;
import rspleyto.testautomation.BrowserUtils;
import rspleyto.testautomation.assertions.Assertion;
import rspleyto.testautomation.assertions.SoftAssert;

public class GoogleSampleTest extends BaseTest {
		
	@BeforeMethod
	public void beforeMethod() {
		driver = new BrowserDriver();
		browser = new BrowserUtils(driver.openBrowser());
		browser.navigateToWebsite("http://www.youtube.com");
		hardAssert = new Assertion(m_errors);
		softAssert = new SoftAssert(m_errors);
	}
	
	@Test (enabled=false)
	public void firstTest() {
		String searchBoxName = "search_query"; 
		
		browser.enterStringToElement(browser.findElementByName(searchBoxName), "test");
		browser.pressEnterOnElementWithId(browser.findElementByName(searchBoxName));
        browser.waitForPageToLoadCompletely();
        
        assertEquals(driver.getTitle(), "test - Google Search", "Window Title");
	}
	
	@Test (enabled=true)
	public void secondTest() {
		String searchBoxName = "search_query"; 
		
		browser.enterStringToElement(browser.findElementByName(searchBoxName), "try");
		browser.pressEnterOnElementWithId(browser.findElementByName(searchBoxName));
        browser.waitForPageToLoadCompletely();
        
        //assertTrue(false, "Home tab visibility");
        checkEquals(driver.getTitle(), "trys - YouTube", "Window Title");
        
        assertTrue(false, "Home tab visibility");

		softAssert.assertAll();
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.closeBrowser();
	}
  
}
