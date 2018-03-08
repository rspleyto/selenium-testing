package rspleyto.testautomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rspleyto.testautomation.BrowserDriver;
import rspleyto.testautomation.BrowserUtils;
import rspleyto.testautomation.assertions.Assertion;
import rspleyto.testautomation.assertions.SoftAssert;
import rspleyto.testautomation.excelreader.ExcelFileReader;

public class TeamTreehouseLoginTest extends BaseTest {

	private final String TEAMTREEHOUSE_CREDENTIALS = "teamtreehouse.credentials.file";
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new BrowserDriver();
		browser = new BrowserUtils(driver.openBrowser());
		browser.navigateToWebsite("https://teamtreehouse.com/signin");
		hardAssert = new Assertion(m_errors);
		softAssert = new SoftAssert(m_errors);
	}
	
	@Test (enabled=true, dataProvider="credentials")
	public void teamTreehouseLoginTest(String username, String password) {
		String usernameTextBoxId = "user_session_email";
		String passwordTextBoxId = "user_session_password";
		String signInButtonXpath = "//*[@id=\"new_user_session\"]/button";
		String aspLink = "ASP.NET Web Development";
		
		browser.enterStringInElementWithId(usernameTextBoxId, username);
		browser.enterStringInElementWithId(passwordTextBoxId, password);
		browser.clickElement(browser.findElementByXPath(signInButtonXpath));
		browser.waitForPageToLoadCompletely();
		
		assertTrue(browser.findElementByPartialLinkText(aspLink).isDisplayed(), "ASP.NET Web Development Link");
	}
	
	@AfterMethod
	public void afterTest() {
		driver.closeBrowser();
	}
	
	@DataProvider(name="credentials")
	public Object[][] provideCredentials() {
		driver = new BrowserDriver();
		ExcelFileReader excelReader = new ExcelFileReader(driver.getProperty(TEAMTREEHOUSE_CREDENTIALS));
		
		int rowCount = excelReader.getRowCount(0);
		
		Object[][] creds = new Object[rowCount][2];
		
		for(int row = 0; row < rowCount; row++) {
			creds[row][0] = excelReader.getCellValue(0, row, 0);
			creds[row][1] = excelReader.getCellValue(0,  row, 1);
		}
		
		return creds;
	}
}
