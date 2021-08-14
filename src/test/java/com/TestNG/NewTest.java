package com.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
  @Test(priority=2)
  public void TestCase1() {
	  System.out.println("test case 1");
  }
  
  @Test(invocationCount=4) //default priority is 0
  public void TestCase2() {
	  System.out.println("test case 2");
  }
  
  @Test(priority=-3, invocationCount=3)
  public void TestCase3() {
	  System.out.println("test case 3");
  }
  
  @Test(priority=1)
  public void TestCase4() {
	  System.out.println("test case 4");
  }
  
  @Test(invocationCount=2, dependsOnMethods= {"TestCase4"}) 
  public void TestCase5() {
	  System.out.println("test case 5");
  }
  
  @Test(enabled=false)
  public void TestCase6() {
	  System.out.println("test case 6");
  }
  
  @Test //default priority is 0
  public void abcTestCase7() {
	  System.out.println("test case 7");
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("after method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("after test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("before suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("after suite");
  }

}
