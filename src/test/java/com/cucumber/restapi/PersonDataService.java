package com.cucumber.restapi;

import com.cucumber.definitions.stepdefs.BaseStepDef;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;


public class PersonDataService extends BaseStepDef {

    private Response response;
    public ValidatableResponse json;
    private RequestSpecification request;
    private static String API_ENDPOINT = "http://www.testautomationschool.nl/v1/test/cars.json";


    @Given("a person with the name (.*)")
    public void aPersonWithName(String name){
//        request = given().param("q", "name:" + name);
        request = given();
    }

    @And("a the user is retrieved data in JSON format")
    public void retrieveJsonPersonData(){
        response = request.when().get(API_ENDPOINT);
        System.out.println("response: " + response.prettyPrint());
    }

    @Then("the status code is (\\d+)")
    public void verify_status_code(int statusCode) {
        json = response.then().statusCode(statusCode);
    }

    @Then("^verify that element name has value \"([^\"]*)\"$")
    public void verifyThatElementNameHasValue(String name) {
        response.then().assertThat().body("name", equalTo(name));
    }

    @Then("^verify that element age has value (\\d+)$")
    public void verifyThatElementAgeHasValue(int age) {
        response.then().assertThat().body("age", equalTo(age));
    }

    @Then("^verify that person has (\\d+) cars$")
    public void verifyThatPersonHasCars(int cars) {
        response.then().assertThat().body("cars.car", hasSize(cars));
    }
}
