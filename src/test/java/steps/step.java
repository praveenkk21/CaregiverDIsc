package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;


public class step {
    RequestSpecification request;
    Response response;
    @Given("API base uri is given")
    public void api_base_uri_is_given() {
        RestAssured.baseURI="http://192.168.1.106:31605/";
        request = RestAssured.given()
                .header("hha","1")
                .header("user","1")
                .header("instance_code","working");
    }

    @When("executed")
    public void executed() {
        response=request.get("/api/clinicianservicertb/v1/clinicians/disciplines");
        ResponseBody body=response.body();
        System.out.println(body);
        response.getBody();
        System.out.println( response.getBody().toString());
    }

    @Then("check the response code is {int}")
    public void check_the_response_code_is(int arg0) {
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,arg0);
    }
}