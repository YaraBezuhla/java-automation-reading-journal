package journal.reading.automation.settings.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class ApiMethods {

    public void addBookApi(){
        String jsonBody = "{\"title\":\"Депеш моб\",\"author\":\"Сергій Жадан\",\"genre\":\"Роман\",\"coverImage\":\"\",\"top\":true}";

        Response response = given().baseUri("http://localhost:5000/api")
                .body(jsonBody)
                .when().post("/books")
                .then().assertThat().statusCode(201)
                .extract().response();
    }
}
