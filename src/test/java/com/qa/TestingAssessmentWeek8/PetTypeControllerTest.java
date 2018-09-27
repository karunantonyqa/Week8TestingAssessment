package com.qa.TestingAssessmentWeek8;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class PetTypeControllerTest {
	
	public static ExtentReports report;
	public ExtentTest test;
	JSONObject petType = new JSONObject();

	
	@BeforeClass
	public static void intial() {
		report = new ExtentReports(
				"C:\\Users\\Admin\\eclipse-workspace\\TestingAssessmentWeek8\\PetClinicPetTypeTest.html", false);
	}

	@Before
	public void setup() {
		test = report.startTest("Create pet type test");
	}
	
	
	@Test
	public void petTypeRestGetTest() {
		RestAssured.given().contentType(ContentType.JSON).when().get(Constants.petTypeRestController_URI).then().statusCode(200);
		test.log(LogStatus.INFO, "Pet Type Get...");
		test.log(LogStatus.PASS, "Pet Type Get PASSED");
	}
	
	@Test
	public void petTypePostTest() {
		
		RestAssured.baseURI = Constants.petTypeRestController_URI;
		RequestSpecification request = RestAssured.given();
		request.header("content-Type", "application/json");
		
		petType.put("id", 1);
		petType.put("name", "Dog");
		
		System.out.println(petType);
		
		request.body(petType.toString()).when().post().then().statusCode(201);
		test.log(LogStatus.INFO, "Pet Type Post...");
		test.log(LogStatus.PASS, "Pet Type Post PASSED");

	}
	
	@Test
	public void petRestGetByIdTest() {
		RestAssured.given().contentType(ContentType.JSON).when().get(Constants.petTypeRestController_URI + 2).then().statusCode(200);
		test.log(LogStatus.INFO, "Pet Type Get by ID...");
		test.log(LogStatus.PASS, "Pet Type GetByID PASSED");

	}
	
	@Test
	public void ownerRestDeleteTest() {
		RestAssured.given().contentType(ContentType.JSON).when().delete(Constants.petTypeRestController_URI + 1).then().statusCode(204);
		test.log(LogStatus.INFO, "Pet Type Delete...");
		test.log(LogStatus.PASS, "Pet Type Delete PASSED");

	}
	
	
	@After
	public void teardown() throws InterruptedException {
		report.endTest(test);
		report.flush();
	}

}
