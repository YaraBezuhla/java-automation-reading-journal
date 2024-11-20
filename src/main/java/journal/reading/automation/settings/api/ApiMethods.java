package journal.reading.automation.settings.api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class ApiMethods {

    public void addBookApi(){
        String jsonBody = "{\"title\":\"Депеш моб\",\"author\":\"Сергій Жадан\",\"genre\":\"Роман\",\"coverImage\":\"\",\"top\":true}";

        Response response = given().baseUri("http://localhost:5000/api")
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when().post("/books")
                .then().assertThat().statusCode(201)
                .extract().response();
    }
}
