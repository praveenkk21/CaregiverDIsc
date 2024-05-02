package steps;
import org.json.simple.JSONObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.Optional;

public class step3 {
    public RequestSpecification request;
    public Response response;

    @Given("api uri is given")
    public void apiUriIsGiven() {
        RestAssured.baseURI="https://petstore.swagger.io/v2";
        request=RestAssured.given();
        request.header("Content-Type","application/json" )
                .header("Accept","application/json" );
    }

    @When("path file is provided")
    public void pathFileIsProvided() {
        JSONObject jso=new JSONObject();
        jso.put("id",10);
        jso.put("petId",1);
        jso.put("quantity",6);
        jso.put("shipDate","2024-05-02T16:00:36.862+0000");
        jso.put("status","placed");
        jso.put("complete","true");
        request.body(jso.toJSONString());
        response=request.post("/store/order");
        ResponseBody body=response.getBody();
        System.out.println(body.asString());
    }

    @Then("here check response code is {int}")
    public void hereCheckTheResponseCodeIsInt(int i) {
        int k= Integer.parseInt(response.jsonPath().get("id").toString());
        Assert.assertEquals(k,10);
        String j=response.jsonPath().get("status");
        Assert.assertEquals(j,"placed");
        Assert.assertEquals(response.getStatusCode(),i);
    }

}
