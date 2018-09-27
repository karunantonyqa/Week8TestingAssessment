package com.qa.TestingAssessmentWeek8;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RootRestControllerTest {
	
	public static ExtentReports report;
	public ExtentTest test;
	
	
	JSONArray pets = new JSONArray();
	JSONArray visits = new JSONArray();

	
	@BeforeClass
	public static void intial() {
		report = new ExtentReports(
				"C:\\Users\\Admin\\eclipse-workspace\\TestingAssessmentWeek8\\PetClinicOwnerTest.html", false);
	}

	@Before
	public void setup() {
		test = report.startTest("Create user test");
		

	}
	
	@Test
	public void getRootTest() {
		RestAssured.given().contentType(ContentType.JSON).when().get(Constants.rootRestGet_URI).then().statusCode(200);

	}
	
	@Test
	public void putRootTest() {
		
		RestAssured.baseURI = Constants.ownerRestController_get_URI;
		RequestSpecification request = RestAssured.given();
		request.header("Accept", "*/*");
		
		RestAssured.given().when().post("/").then().statusCode(200);
	}
	
	
	
	
	@After
	public void teardown() throws InterruptedException {
		report.endTest(test);
		report.flush();
	}

}
