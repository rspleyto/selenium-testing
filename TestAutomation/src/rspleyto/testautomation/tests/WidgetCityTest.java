package rspleyto.testautomation.tests;

import org.testng.annotations.Test;

import rspleyto.testautomation.BrowserDriver;
import rspleyto.testautomation.BrowserUtils;
import rspleyto.testautomation.assertions.Assertion;
import rspleyto.testautomation.assertions.SoftAssert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class WidgetCityTest extends BaseTest {
	
  @BeforeMethod
  public void beforeMethod() {
	  driver = new BrowserDriver();
	  browser = new BrowserUtils(driver.openBrowser());
	  browser.navigateToWebsite("https://widgetcity.com.ph/");
	  hardAssert = new Assertion(m_errors);
	  softAssert = new SoftAssert(m_errors);
  }
  
  @Test
  public void hoverOnFieldTest() throws InterruptedException {
	  browser.hoverOnElement(browser.findElementById("pt_ver_menu127"));
	  
	  checkTrue(browser.isElementWithIdDisplayed("popup127"), "Mobile phone popup visibility");
	  
	  checkTrue(browser.isElementDisplayed(browser.findElementByClass("itemMenu")), "Apple link visibility");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.closeBrowser();
  }

}
