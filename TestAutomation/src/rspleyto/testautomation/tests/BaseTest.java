package rspleyto.testautomation.tests;


import java.util.Map;

import org.testng.asserts.IAssert;
import org.testng.collections.Maps;

import rspleyto.testautomation.BrowserDriver;
import rspleyto.testautomation.BrowserUtils;
import rspleyto.testautomation.assertions.Assertion;
import rspleyto.testautomation.assertions.SoftAssert;

public class BaseTest {

	protected static Assertion hardAssert;
	protected static SoftAssert softAssert;
	public BrowserDriver driver;
	public BrowserUtils browser;
	public final Map<AssertionError, IAssert<?>> m_errors = Maps.newLinkedHashMap();
	
	public static void assertTrue (boolean condition, String message) {
		hardAssert.assertTrue(condition, message);
	}
	
	public static void assertFalse (boolean condition, String message) {
		hardAssert.assertFalse(condition, message);
	}
	
	public static void assertEquals (Object actual, Object expected, String message) {
		hardAssert.assertEquals(actual, expected, message);
	}
	
	public static void assertNotEquals (Object actual, Object expected, String message) {
		hardAssert.assertNotEquals(actual, expected, message);
	}
	
	public static void checkTrue (boolean condition, String message) {
		softAssert.assertTrue(condition, message);
	}
	
	public static void checkFalse (boolean condition, String message) {
		softAssert.assertFalse(condition, message);
	}
	
	public static void checkEquals (Object actual, Object expected, String message) {
		softAssert.assertEquals(actual, expected, message);
	}
	
	public static void checkNotEquals (Object actual, Object expected, String message) {
		softAssert.assertNotEquals(actual, expected, message);
	}
}
