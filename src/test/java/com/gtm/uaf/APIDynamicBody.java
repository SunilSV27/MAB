package test.java.com.gtm.uaf.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;

public class APIDynamicBody {
    private Response response;
    private String dynamicBody;

    @Given("I have a dynamic request body {string}")
    public void iHaveDynamicRequestBody(String num) throws JSONException {
        dynamicBody = generateDynamicBody(num);
    }

    @When("I make a POST request to the API endpoint")
    public void makePostRequest() {
        RequestSpecification request = RestAssured.given().body(dynamicBody);
        response = request.post("API_ENDPOINT_URL");
    }

    @Then("the API responds with a success status code")
    public void apiRespondsWithSuccessStatusCode() {
        response.then().statusCode(200);
    }

    private String generateDynamicBody(String equipNum) throws JSONException {
        JSONObject requestBody = new JSONObject();
        requestBody.put("equipNum", equipNum);
        return requestBody.toString();
    }
}