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

public class OwnerRestControllerTest {
	
	public static ExtentReports report;
	public ExtentTest test;
	
	JSONObject owner = new JSONObject();
	JSONObject petType = new JSONObject();
	JSONObject pet = new JSONObject();
	JSONObject visit = new JSONObject();
	
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
	public void ownerRestPostTest() {
		
		RestAssured.baseURI = Constants.ownerRestController_get_URI;
		RequestSpecification request = RestAssured.given();
		request.header("content-Type", "application/json");
		
		owner.put("pets", pets);
		pets.put(pet);
		pets.put(petType);
		visits.put(visit);
		pets.put(visits);
		
		
		
		
		owner.put("address", "real address");
		owner.put("city", "Manny");
		owner.put("firstName", "Jim");
		owner.put("id", 2);
		owner.put("lastName", "Kent");
		owner.put("telephone", "0121 625 8375");
		
		
		visit.put("date", "11/07/2015");
		visit.put("description", "nice pet");
		visit.put("id", 5);
		
		pet.put("birthDate", "2018-09-27T09:10:15.153Z");
		pet.put("id", 2);
		pet.put("name", "Darth");
		
		
		petType.put("id", 5);
		petType.put("name", "Larry");
		
		System.out.println(owner);
		
		Response response;
		
		//response = (Response) request.given().body(owner.toString()).when().post().then().statusCode(201);
		
//		request.given().body(owner.toString()).when().post("/").then().statusCode(201);
		
		RestAssured.given().contentType(ContentType.JSON).body(owner.toString()).when().post("/").then().statusCode(201);
		
		test.log(LogStatus.INFO, "Post test executed");
		
		
	}
	
	@Test
	public void ownerRestGetTest() {
		RestAssured.given().contentType(ContentType.JSON).when().get(Constants.ownerRestController_get_URI).then().statusCode(200);

		
	}
	
	@Test
	public void ownerRestGetByIdTest() {
		RestAssured.given().contentType(ContentType.JSON).when().get(Constants.ownerRestController_get_URI + 2).then().statusCode(200);

	}
	
	@Test
	public void ownerRestGetByLNameTest() {
		String lastName = "Davis";
		RestAssured.given().contentType(ContentType.JSON).when().get(Constants.ownerRestController_getLName_URI + lastName).then().statusCode(200);

	}
	
	@Test
	public void ownerRestDeleteTest() {
		RestAssured.given().contentType(ContentType.JSON).when().delete(Constants.ownerRestController_get_URI + 1).then().statusCode(204);

	}
	
	
	
	
	@After
	public void teardown() throws InterruptedException {
		report.endTest(test);
		report.flush();
	}

}
