package org.apiautomation.tests.crud;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.apiautomation.base.BaseTest;
import org.apiautomation.endpoints.APIConstants;
import org.apiautomation.pojos.BookingResponse;
import org.apiautomation.utils.PropertyReader;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class testCreateBookingPOST extends BaseTest {

    @Link(name = "Link to TC", url = "https://bugz.atlassian.net/browse/RBT-4")
    @Issue("JIRA_RBT-4")
    @TmsLink("RBT-4")
    @Owner("Promode")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that POST Request is working fine.")
    @Test
    public void testVerifyCreateBookingPOST01(){

        requestSpecification
                .basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured.given(requestSpecification)
                        .when().body(payloadManager.createPayloadBookingAsString())
                        .post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(Integer.parseInt(PropertyReader.readKey("booking.post.statuscode.success")));

        //Default Rest Assured Assertion
        validatableResponse.body("booking.firstname", Matchers.equalTo("James"));

        //DeSerialization
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        //AssertJ
        assertThat(bookingResponse.getBooking()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("James");
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo(PropertyReader.readKey("booking.post.firstname"));

        //TestNG Assertions
        Assert.assertEquals(true,true);

    }
}
