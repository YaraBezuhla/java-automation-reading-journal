package journal.reading.automation.api;

import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.qameta.allure.internal.shadowed.jackson.databind.JsonNode;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiMethods {

    private static final String BOOKS_JSON_FILE = "C:/Users/Ярослава/Projects/java-automation-reading-journal/src/test/resources/testData/books.json";

    public void addBookApi(int bookIndex, int codeResponse) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode books = objectMapper.readTree(new File(BOOKS_JSON_FILE));

            // Вибір книги за індексом
            if (bookIndex < 0 || bookIndex >= books.size()) {
                throw new IllegalArgumentException("Неправильний індекс книги: " + bookIndex);
            }

            JsonNode selectedBook = books.get(bookIndex);
            String requestBody = objectMapper.writeValueAsString(selectedBook);

            given().baseUri("http://localhost:5000/api")
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                    .when().post("/books")
                    .then().assertThat().statusCode(codeResponse)
                    .extract().response();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Помилка під час обробки JSON або виконання запиту");
        }
    }

    public void deleteBookApiByTitle() {
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File(BOOKS_JSON_FILE));
            List<Map<String, Object>> books = objectMapper.convertValue(jsonNode, new TypeReference<>() {
            });

            for (Map<String, Object> book : books) {
                String title = (String) book.get("title"); // Отримати назву книги
                if (title == null || title.isEmpty()) {
                    System.out.println("Книга без назви пропущена");
                    continue;
                }

                try {
                    given().baseUri("http://localhost:5000/api")
                            .header("Content-Type", "application/json")
                            .when().delete("/books/title/" + title)
                            .then().assertThat().statusCode(200)
                            .extract().response();
                } catch (AssertionError e) {
                    System.out.println("Книга \"" + title + "\" не знайдена в базі даних. Пропущено.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Помилка під час обробки JSON або виконання запиту");
        }
    }
}