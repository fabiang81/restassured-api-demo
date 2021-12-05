package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.runner.RunWith;
import pojo.GoogleApiRequest;
import resources.ApiResourcesEnum;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@RunWith(Cucumber.class)
public class StepDefinition extends Utils {

    private Response response;

    private TestDataBuild data;

    @Given("Add place payload with {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address) throws IOException{
        GoogleApiRequest request = data.addPlacePayLoad(name, language, address);
        requestSpecification = given().spec(requestSpecification())
                .body(request);
    }

    @When("User calls {string} with post http request")
    public void user_calls_with_post_http_request(String resource) {
        ApiResourcesEnum apiResourcesEnum = ApiResourcesEnum.valueOf(resource);
        response = requestSpecification.when().post(apiResourcesEnum.getResource());

    }

    @Then("The API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(Integer code) {
        response.then().assertThat().statusCode(code).extract().response();
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue) {
        String res = response.asString();
        JsonPath js = new JsonPath(res);
        assertEquals(js.get(keyValue).toString(), expectedValue);
    }

}
