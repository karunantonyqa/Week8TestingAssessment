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
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VisitRestControllerTest {
	
	public static ExtentReports report;
	public ExtentTest test;
	JSONObject visit = new JSONObject();
	JSONObject pet = new JSONObject();
	JSONObject owner = new JSONObject();
	JSONObject petType = new JSONObject();
	
	JSONArray visits = new JSONArray();
	JSONArray pets = new JSONArray();



	
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
	public void getVisitRestControllerTest() {
		RestAssured.given().contentType(ContentType.JSON).when().get(Constants.visitRestController_URI).then().statusCode(200);
		test.log(LogStatus.INFO, "Visit Get...");
		test.log(LogStatus.PASS, "Visit Get PASSED");
	}
	
	@Test
	public void postVisitRestControllerTest() {
		RestAssured.baseURI = Constants.petTypeRestController_URI;
		RequestSpecification request = RestAssured.given();
		request.header("content-Type", "application/json");		
		
		owner.put("pets", pets);
		pets.put(pet);
		pets.put(petType);
		visits.put(visit);
		pets.put(visits);
		
		visit.put("date", "11/07/2015");
		visit.put("description", "nice pet");
		visit.put("id", 5);


		
		pet.put("birthDate", "11/09/1756");
		pet.put("id", 2);
		pet.put("name", "Darth");
		
	

		owner.put("address", "real address");
		owner.put("city", "Manny");
		owner.put("firstName", "Jim");
		owner.put("id", 2);
		owner.put("lastName", "Kent");
		owner.put("telephone", "0121 625 8375");
		owner.put("pets", pets);
		
		petType.put("id", 5);
		petType.put("name", "Larry");
		
	
		
		Response response = (Response) request.given().body(visit.toString()).when().post("/").then().statusCode(201);

		System.out.println(response.prettyPrint());
		
		
	}
	
	
	@After
	public void teardown() throws InterruptedException {
		report.endTest(test);
		report.flush();
	}

}
