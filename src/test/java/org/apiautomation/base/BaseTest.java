package org.apiautomation.base;

//Common to all Test Case
//  Base Test Father -> Testcase - Son - Single Inheritance

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apiautomation.asserts.AssertActions;
import org.apiautomation.endpoints.APIConstants;
import org.apiautomation.modules.PayloadManager;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;

    // TC - Header

    @BeforeTest
    public void setUp(){

        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build().log().all();

        /*requestSpecification = RestAssured.given()
                .baseUri(APIConstants.BASE_URL)
                .contentType(ContentType.JSON)
                .log().all();*/

    }

    public String getToken(){
        requestSpecification = RestAssured.given()
                .baseUri(APIConstants.BASE_URL)
                .basePath(APIConstants.AUTH_URL);

        //Setting the Payload
        String payload = payloadManager.setAuthPayload();

        //Get the Token
        response = requestSpecification.contentType(ContentType.JSON).log().all()
                .body(payload).when().post();

        //String Token Extraction
        String token = payloadManager.getTokenFromJSON(response.asString());
        return token;

    }

}
