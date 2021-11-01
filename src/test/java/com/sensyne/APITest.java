package com.sensyne;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;


public class APITest {

	
		
	@Before
	public void setURL()
	{
		baseURI = "http://localhost:5000/v1";
	}

	

	@Test
	public void sampleGetRequest() {
		
		Response response = given()
		.when()
		.get("/products")
		.then()
		.extract()
		.response();
		Assertions.assertEquals(200,response.statusCode());

		
	}

	
	@Test
	public void anotherGetRequestSample() {
		
		Response response = given()
			.param("","")
			.header("Accept","application/json")
		.when()
			.get("/product/3")
		.then()
		.extract()
		.response();
		Assertions.assertEquals(200,response.statusCode());

		
	}
	
	@Test
	public void postRequestExample() {
		
		
		JSONObject  jsonObject = new JSONObject();
		
		jsonObject.put("name", "Dark Chocolate");
		jsonObject.put("price", 7.3);
		
		System.out.println(jsonObject.toString());
		
		Response response = given()
		.header("Content-Type","application/json")
		.header("Accept","application/json")
		.body(jsonObject.toJSONString())
		.log()
		.all()
		.post("/product")
		.then()
		.extract()
		.response();
		Assertions.assertEquals(204,response.statusCode());

		
		
	}
	
	@Test
	public void putRequestSample() {
		
		JSONObject jsonobject = new JSONObject();
		
		jsonobject.put("name", "White Chocolate");
		jsonobject.put("price", 8.7);	
		
		
		Response response = given()
		.header("Content-Type","application/json")
		.header("Accept","application/json")
		.body(jsonobject.toJSONString())
		.log()
		.all()
		.put("/product/3")
		
		.then()
		.extract()
		.response();
		Assertions.assertEquals(204,response.statusCode());
		}
	
	@Test
	public void deleteRequestSamle() {		
		Response response = given()
		.header("Content-Type","application/json")
		.header("Accept","application/json")
		.log()
		.all()
		.when()
		.delete("/product/23")
		.then()
		.extract()
		.response();
		Assertions.assertEquals(204,response.statusCode());
		}
	
	
	
	}

 
	
	


