package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;


public class step {
    RequestSpecification request;
    Response response;
    @Given("API base uri is given")
    public void api_base_uri_is_given() {
        RestAssured.baseURI="https://fakestoreapi.com/";
        request = RestAssured.given();

    }

    @When("executed")
    public void executed() {
        response=request.get("products");
    }

    @Then("check the response code is {int}")
    public void check_the_response_code_is(int arg0) {
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,arg0);
    }
}