package com.cucumber.restapi;

import com.cucumber.definitions.stepdefs.BaseStepDef;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public class PersonDataService extends BaseStepDef {

    private Response response;
    public ValidatableResponse json;
    private RequestSpecification request;
    private static String API_ENDPOINT = "http://www.testautomationschool.nl/test/test.xml";


    @Given("a person with the name (.*)")
    public void aPersonWithName(String name){
        request = given().param("q", "name:" + name);
    }

    @When("a user retrieves the name by xml")
    public void retreiveXmlPersonData(){
        response = request.when().get(API_ENDPOINT);
        System.out.println("response: " + response.prettyPrint());
    }

    @Then("the status code is (\\d+)")
    public void verify_status_code(int statusCode){
        json = response.then().statusCode(statusCode);
    }
}
