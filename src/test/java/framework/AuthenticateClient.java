package framework;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;

public class AuthenticateClient {

    private final Logger logger = LoggerFactory.getLogger(RestClientBase.class);
    private final String token;

    @Inject
    public AuthenticateClient() {
        Response logInResponse = logIn();
        token = logInResponse.getBody().jsonPath().getString("token");
    }

    private Response logIn() {
        JSONObject logInPayload = new JSONObject();
        logInPayload.put("userName", Config.getProperty("auth_username"));
        logInPayload.put("password", Config.getProperty("auth_password"));
        return getResponse(logInPayload);
    }

    private Response getResponse(JSONObject payload)  {
        RequestSpecification requestSpecification = new RequestSpecBuilder().setRelaxedHTTPSValidation().setContentType(ContentType.JSON).build();
        ResponseSpecification responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).build();
        String authEndpoint = "/Account/v1/GenerateToken";
        logger.info("Getting Authorization token");
        Response response = given(requestSpecification)
                .log().ifValidationFails()
                .body(payload.toString())
                .when().post(Config.getProperty("rest_url") + authEndpoint)
                .then()
                .log().ifValidationFails()
                .spec(responseSpecification)
                .extract().response();
        return response;
    }

    public String getToken()    {
        return token;
    }
}
