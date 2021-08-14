package learning;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
	
	WebDriver driver = null;
	
  @Test
  public void TestCase1() {
	  
	  String expected = driver.getTitle();
	  System.out.println(expected);
	  String actual = "Welcome to Green Mountain Outpost";
	  Assert.assertEquals(actual, expected);
	  driver.findElement(By.name("bSubmit")).click();
	  
	  
  }
  
  @Test
  public void TestCase2() {
	 
	  String e = driver.findElement(By.xpath("//h1[@align='center']")).getText();
	  System.out.println(e);
	  String a= "OnLine Catalog";
	  Assert.assertEquals(a, e);
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();//to initialise browser 
	  driver.get("http://demo.borland.com/gmopost/");
	  driver.manage().window().maximize();//to maximise the browser web page
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//telling browser
	  //to wait for 30 seconds before interacting with the particular web elements
	  
	  
  }

  @AfterSuite
  public void afterSuite() {
  }

}
