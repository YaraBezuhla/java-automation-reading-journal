package journal.reading.automation.settings.api;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import journal.reading.automation.settings.database.ConnectToDB;
import org.bson.Document;
import org.bson.types.ObjectId;

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

            given().baseUri("http://localhost:5000/api")
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

    public void deleteBookApi() {
        try {

            // Завантаження JSON із файлу
            String json = JsonUtils.readJsonFromFile(BOOKS_JSON_FILE);

            // Парсинг JSON до списку об'єктів
            List<Map<String, Object>> books = JsonUtils.parseJsonToList(json);

            // 3. Для кожної книги з JSON-файлу знайти її ObjectId у базі даних і виконати DELETE-запит
            for (Map<String, Object> book : books) {
                String title = (String) book.get("title"); // Отримати назву книги
                if (title == null || title.isEmpty()) {
                    System.out.println("Книга без назви пропущена");
                    continue;
                }

                // Знайти книгу в базі даних за назвою
                ConnectToDB connectToDB = new ConnectToDB();
                MongoCollection<Document> booksCollection = connectToDB.connectToMongoDB("books");
                Document bookDocument = booksCollection.find(Filters.eq("title", title)).first();

                if (bookDocument == null) {
                    System.out.println("Книга з назвою '" + title + "' не знайдена в базі даних");
                    continue;
                }
                // Отримати ObjectId книги
                ObjectId bookId = bookDocument.getObjectId("_id");

                 given().baseUri("http://localhost:5000/api")
                        .header("Content-Type", "application/json")
                        .when().delete("/books/" + bookId)
                        .then().assertThat().statusCode(200)
                        .extract().response();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Помилка під час обробки JSON або виконання запиту");
        }
    }
}