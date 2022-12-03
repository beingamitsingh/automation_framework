package framework;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestClientBase {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final AuthenticateClient authenticateClient;

    public RestClientBase(AuthenticateClient authenticateClient) {
        this.authenticateClient = authenticateClient;
        RestAssured.defaultParser = Parser.JSON;
    }

    public static JsonNode buildJson(Object object)  {
        return MAPPER.convertValue(object, JsonNode.class);
    }

    public Response createGetRequest(String apiPath, String payload)  {
        return given()
            .header("Content-Type", "application/json")
            .header("Accept", "application/json")
            .header("Authorization", "Bearer " + authenticateClient.getToken())
            .body(payload)
            .when().get(Config.getProperty("rest_url") + apiPath)
            .then().log().all()
            .extract().response();
    }

    public Response createPostRequest(String apiPath, String payload)   {
        return given()
            .header("Content-Type", "application/json")
            .header("Accept", "application/json")
            .header("Authorization", "Bearer " + authenticateClient.getToken())
            .body(payload)
            .when().post(Config.getProperty("rest_url") + apiPath)
            .then().log().all()
            .extract().response();
    }

    public Response createPutRequest(String apiPath, String payload)   {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + authenticateClient.getToken())
                .body(payload)
                .when().put(Config.getProperty("rest_url") + apiPath)
                .then().log().all()
                .extract().response();
    }
}
