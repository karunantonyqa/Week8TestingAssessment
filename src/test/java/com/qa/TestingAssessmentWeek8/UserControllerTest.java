package com.qa.TestingAssessmentWeek8;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class UserControllerTest {
	
	public static ExtentReports report;
	public ExtentTest test;
	
	JSONObject user = new JSONObject();

	JSONObject role = new JSONObject();
	
	JSONArray roles = new JSONArray();

	
	@BeforeClass
	public static void intial() {
		report = new ExtentReports(
				"C:\\Users\\Admin\\eclipse-workspace\\PersonSwagger\\PetClinicTest.html", false);
	}

	@Before
	public void setup() {
		test = report.startTest("Create user test");

	}
	
	@Test
	public void postUserTest() {
		RestAssured.baseURI = Constants.userRestController_post_URI;
		RequestSpecification request1 = RestAssured.given();

		request1.header("content-Type", "application/json");
		
		roles.put(role);
		
		user.put("enabled", true);
		user.put("password", "pass");
		user.put("username", "user");
		
		role.put("id", 1);
		role.put("name", "developer");
		
		user.put("roles", roles);
		
		System.out.println(user);
		
		request1.body(user.toString()).when().post("/").then().statusCode(201);

		test.log(LogStatus.INFO, "User created with status code 201");
		test.log(LogStatus.PASS, "User post SUCCESS");
	}
	
	
	
	@After
	public void teardown() throws InterruptedException {
		report.endTest(test);
		report.flush();
	}

}
