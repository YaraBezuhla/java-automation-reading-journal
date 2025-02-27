package journal.reading.automation.database;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import io.qameta.allure.Step;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class GetDataWithMongoDB {
    ConnectToDB connectToDB = new ConnectToDB();

    @Step("Отримати всі назви книг з бази данних")
    public ArrayList<String> getBookTitlesFromDatabase() {
        ArrayList<String> titles = new ArrayList<>();
        MongoCollection<Document> booksCollection = connectToDB.connectToMongoDB("books");

        FindIterable<Document> iterable = booksCollection.find();  // Отримання всіх документів з колекції books
        for (Document doc : iterable) {
            String title = doc.getString("title");
            boolean top = doc.getBoolean("top");
            if (title != null && top) {
                titles.add(title);
            }
        }
        return titles;
    }

    @Step("Отримати назви книг одного автора")
    public ArrayList<String> getBookTitlesOneAuthorFromDatabase(String authorName) {
        ArrayList<String> bookTitles = new ArrayList<>();

        try {
            // 1. Отримуємо колекцію авторів
            MongoCollection<Document> authorsCollection = connectToDB.connectToMongoDB("authors");

            // 2. Знаходимо автора за іменем
            Document authorDoc = authorsCollection.find(new Document("name", authorName)).first();
            if (authorDoc == null) {
                throw new RuntimeException("Автор не знайдений: " + authorName);
            }

            // 3. Отримуємо ObjectId автора
            ObjectId authorId = authorDoc.getObjectId("_id");

            // 4. Отримуємо колекцію книг
            MongoCollection<Document> booksCollection = connectToDB.connectToMongoDB("books");

            // 5. Знаходимо книги цього автора
            FindIterable<Document> booksIterable = booksCollection.find(new Document("author", authorId));

            // 6. Збираємо назви книг
            for (Document bookDoc : booksIterable) {
                String title = bookDoc.getString("title");
                if (title != null) {
                    bookTitles.add(title);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Помилка під час отримання книг автора: " + authorName, e);
        }

        return bookTitles;
    }
}
