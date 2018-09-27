package com.qa.AssessmentSeleniumTests;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestingAssessmentWeek8.OwnerElements;
import com.qa.TestingAssessmentWeek8.VetElements;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ViewInfoTest {
	
	WebDriver driver = null;
	public static ExtentReports report;
	public ExtentTest test;

	
	@BeforeClass
	public static void initial() {
//		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\eclipse\\BingPageTest.html", true);
	}
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Testing/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void viewPetInfoTest() {
		driver.get("http://10.0.10.10:4200/petclinic/welcome");

		OwnerElements page = PageFactory.initElements(driver, OwnerElements.class);
		
		Actions action = new Actions(driver);
		
		action.moveToElement(OwnerElements.ownderNavSelect).click().perform();
		action.moveToElement(OwnerElements.ownerViewAll).click().perform();
		action.moveToElement(OwnerElements.ownerEd).click().perform();
		
		

	}
	
	
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
//		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
