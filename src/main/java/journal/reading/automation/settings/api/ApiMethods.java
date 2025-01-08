package journal.reading.automation.settings.api;

import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiMethods {

    private static final String BOOKS_JSON_FILE = "C:/Users/Ярослава/Projects/java-automation-reading-journal/src/test/resources/testData/books.json";

    public void addBookApi(int bookIndex, int codeResponse) {
        try {

            // Завантаження JSON із файлу
            String json = JsonUtils.readJsonFromFile(BOOKS_JSON_FILE);

            // Парсинг JSON до списку об'єктів
            List<Map<String, Object>> books = JsonUtils.parseJsonToList(json);

            // Вибір книги за індексом
            if (bookIndex < 0 || bookIndex >= books.size()) {
                throw new IllegalArgumentException("Неправильний індекс книги: " + bookIndex);
            }
            String jsonBody = JsonUtils.convertObjectToJson(books.get(bookIndex));

            Response response = given().baseUri("http://localhost:5000/api")
                    .header("Content-Type", "application/json")
                    .body(jsonBody)
                    .when().post("/books")
                    .then().assertThat().statusCode(codeResponse)
                    .extract().response();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Помилка під час обробки JSON або виконання запиту");
        }
    }
}
