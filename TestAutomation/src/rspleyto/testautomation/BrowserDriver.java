package rspleyto.testautomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class BrowserDriver {

    private WebDriver driver;
    public JavaScriptExecutor jse;

    private String BROWSER;
    private String BROWSER_DRIVER_PATH;

    private final String PROPERTIES_FILENAME = "testautomation.properties";
    private final String PROPERTIES_BROWSER_ID = "browserToUse";
    private final String PROPERTIES_BROWSER_DRIVER_PATH = "browserPath";

    public BrowserDriver() {
            BROWSER = getProperty(PROPERTIES_BROWSER_ID);
            BROWSER_DRIVER_PATH = getProperty(PROPERTIES_BROWSER_DRIVER_PATH);
    }

    public WebDriver openBrowser() {
        switch(BROWSER) {
            case "chrome" :
                System.setProperty("webdriver.chrome.driver", BROWSER_DRIVER_PATH);
                driver = new ChromeDriver();
                break;
            case "firefox" :
                System.setProperty("webdriver.gecko.driver", BROWSER_DRIVER_PATH);
                driver = new FirefoxDriver();
                break;
            case "edge" :
            	System.setProperty("webdriver.edge.driver", BROWSER_DRIVER_PATH);
            	driver = new EdgeDriver();
            	break;
            case "ie" :
            	System.setProperty("webdriver.ie.driver", BROWSER_DRIVER_PATH);
            	driver = new InternetExplorerDriver();
                break;
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        System.out.println("Browser opened");
        return driver;
    }
    
    public WebDriver getDriver() {
    	return driver;
    }
    
    public String getTitle() {
    		return driver.getTitle();
    }

    public String getProperty(String propertyId) {
        String propertyValue = null;

        try {
            Properties prop = new Properties();
            FileInputStream in = new FileInputStream(PROPERTIES_FILENAME);
            prop.load(in);
            in.close();

            propertyValue = prop.getProperty(propertyId);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return propertyValue;
    }

    public void closeBrowser() {
        driver.close();;
    }
}
