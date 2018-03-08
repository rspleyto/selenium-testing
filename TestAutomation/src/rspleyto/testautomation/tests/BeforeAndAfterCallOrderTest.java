package rspleyto.testautomation.tests;

import org.junit.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAndAfterCallOrderTest extends BaseTest {
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}
	
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class");
	}
	
	@BeforeGroups
	public void beforeGroups() {
		System.out.println("before groups");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("after method");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("after test");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("after class");
	}
	
	@AfterGroups
	public void afterGroups() {
		System.out.println("after groups");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite");
	}
	
	@Test
	public void dummyTest() {
		System.out.println("Test");
	}
	
	@Test
	public void dummyTest2() {
		System.out.println("Test 2");
	}
}
