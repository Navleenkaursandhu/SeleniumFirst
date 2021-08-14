package learning2;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	public void test1() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='bSubmit']")).click();
		// driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		Thread.sleep(2000L);
		driver.findElement(By.cssSelector("input[name='QTY_TENTS']")).sendKeys("2");
		// driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		Thread.sleep(2000L);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(1000L);

		// to display the unit price in console
		System.out.println(driver.findElement(By.xpath("//table/tbody/tr[2]/td[4]")).getText());

		String price = driver.findElement(By.xpath("//table/tbody/tr[2]/td[4]")).getText();

		String price2 = price.substring(2);

		// converting string into Float value
		Float floatvalue = Float.parseFloat(price2);

		Float e = floatvalue * 2;
		System.out.println("expected total price: " + e);

		String a = driver.findElement(By.xpath("//table/tbody/tr[2]/td[5]")).getText();

		// converting substring of a into float for comparison

		String a2 = a.substring(2);
		System.out.println("actual total price: " + a2);

		Float actual = Float.parseFloat(a2);
		Assert.assertEquals(actual, e);

	}

	@Test

	// doubt with this test case, it is failing but it shoul dnot fail
	public void test2() {
		driver.navigate().to("https://demoqa.com/alerts");
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();// locating web element

		Alert obj = driver.switchTo().alert();// switching to alert upon clicking web element
		obj.accept();// accepting the alert on pop up

		driver.findElement(By.id("timerAlertButton")).click();// locating second web element
		Alert obj2 = driver.switchTo().alert();// switching to alert
		obj2.accept();// alert accepted

		String expected = obj2.getText();
		System.out.println(expected);
		String actual = "This alert appeared after 5 seconds";

		Assert.assertEquals(actual, expected);
		// dismissing the alert on pop up

	}

	@Test
	public void test3() {
		driver.navigate().to("https://demoqa.com/alerts");
		driver.findElement(By.id("confirmButton")).click();
		Alert obj4 = driver.switchTo().alert();

		String a = obj4.getText();
		System.out.println(a);

		String e = "Do you confirm action?";
		Assert.assertEquals(a, e);
		obj4.dismiss();
	}

	@Test
	public void test4() {
		driver.navigate().to("https://demoqa.com/alerts");
		driver.findElement(By.id("promtButton")).click();// locating web element
		Alert obj5 = driver.switchTo().alert();
		obj5.sendKeys("navleen");
		obj5.accept();

		String a = driver.findElement(By.id("promptResult")).getText();
		System.out.println(a);
		String e = "You entered nav";

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(a, e);
		
		driver.findElement(By.id("confirmButton")).click();
		Alert obj4 = driver.switchTo().alert();

		String ac = obj4.getText();
		System.out.println(ac);

		String ex = "Do you confirm action?";
		Assert.assertEquals(ac, ex);
		obj4.dismiss();

	}

	@Test
	public void test5() {
		
		driver.get("http://demo.automationtesting.in/Frames.html");
		
		
		//in order to locate a frame within a frame we will have to switch to main frame
		driver.switchTo().frame("singleframe");//switching/locating to main/parent frame
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("inside first frame");//typing hello in child frame
		
		//coming out of Frame and switching to default frame
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[contains(text(),'Iframe with in an Iframe')]")).click();
		
		//switching from parent to child frame
		
	    //switching to parent frame
		WebElement parent = driver.findElement(By.xpath("//iframe[@id='singleframe']"));
		driver.switchTo().frame(parent);
		
		//switching to child frame
		WebElement child= driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(child);
		
		
		//locating text box inside child frame
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("inside second frame");
		
		//switching to default content
		driver.switchTo().defaultContent();
				
						
		
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
		driver = new ChromeDriver();
		driver.get("http://demo.borland.com/gmopost/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	}

	@AfterSuite
	public void afterSuite() {
	}

}
