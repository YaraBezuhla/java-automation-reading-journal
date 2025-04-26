package journal.reading.automation.services.api;

import io.qameta.allure.Step;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiMethods {

    @Step("Add book through API")
    public void addBookApi(Map<String, Object> book, int codeResponse) {
        try {
            // Серіалізуємо книгу в JSON
            String requestBody = new ObjectMapper().writeValueAsString(book);

            given()
                    .baseUri("http://localhost:5000/api")
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                    .when()
                    .post("/books")
                    .then()
                    .assertThat()
                    .statusCode(codeResponse);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Помилка під час додавання книги через API: " + e.getMessage());
        }
    }

    @Step("Delete books through API")
    public void deleteBooksApiByTitle(List<String> bookTitles) {
        try {
            // Видаляємо кожну книгу по тайтлу
            for (String title : bookTitles) {
                if (title == null || title.isEmpty()) {
                    System.out.println("Книга без назви пропущена");
                    continue;
                }

                try {
                    given()
                            .baseUri("http://localhost:5000/api")
                            .header("Content-Type", "application/json")
                            .when()
                            .delete("/books/title/" + title)
                            .then()
                            .assertThat()
                            .statusCode(200); // Очікуємо, що книга буде видалена або вже відсутня
                } catch (AssertionError e) {
                    // Якщо книга не знайдена (наприклад, 404), просто пропускаємо її
                    System.out.println("Книга \"" + title + "\" вже не знайдена. Пропущено.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Помилка під час видалення книг через API: " + e.getMessage());
        }
    }
}
