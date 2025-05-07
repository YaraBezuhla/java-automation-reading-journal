package journal.reading.automation.services.database;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import io.qameta.allure.Step;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class GetDataWithMongoDB {
    ConnectToDB connectToDB = new ConnectToDB();

    @Step("Get all book titles from the database")
    public ArrayList<String> getBookTitlesFromDatabase() {
        ArrayList<String> titles = new ArrayList<>();
        MongoCollection<Document> booksCollection = connectToDB.connectToMongoDB("books");

        FindIterable<Document> iterable = booksCollection.find();
        for (Document doc : iterable) {
            String title = doc.getString("title");
            boolean top = doc.getBoolean("top");
            if (title != null && top) {
                titles.add(title);
            }
        }
        return titles;
    }

    @Step("Get titles of books by the same author")
    public ArrayList<String> getBookTitlesOneAuthorFromDatabase(String authorName) {
        ArrayList<String> bookTitles = new ArrayList<>();

        try {
            // 1. Отримуємо колекцію авторів
            MongoCollection<Document> authorsCollection = connectToDB.connectToMongoDB("authors");

            // 2. Знаходимо автора за іменем
            Document authorDoc = authorsCollection.find(new Document("name", authorName)).first();
            if (authorDoc == null) {
                throw new RuntimeException("Author not found: " + authorName);
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
            throw new RuntimeException("Error while receiving the author's books: " + authorName, e);
        }

        return bookTitles;
    }
}
