package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;


public class step2 {
    RequestSpecification request;
    Response response;

    @Given("API base uri is given caregiver")
    public void api_base_uri_is_given_caregiver() {
        RestAssured.baseURI="http://192.168.1.106:31605/";
        request = RestAssured.given()
                .header("hha","1")
                .header("user","1")
                .header("instance_code","working");
    }

    @When("executed with {int}")
    public void executed_With(int arg0) {
        response=request.get("/api/clinicianservicertb/v1/clinicians/"+arg0);
        ResponseBody body=response.body();
        System.out.println( response.getBody().asString());
    }

    @Then("here check the response code is {int}")
    public void here_Check_The_Response_Code_Is(int arg0) {
        int statusCode=response.getStatusCode();
        JsonPath json=response.jsonPath();
        String t=json.get("caregivers[0].first_name");
        System.out.println(t);
        Assert.assertEquals(statusCode,arg0);
    }
}