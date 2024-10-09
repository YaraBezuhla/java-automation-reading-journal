package journal.reading.automation.settings.database;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.ArrayList;

public class GetDateWithMongoDB {
ConnectToDB connectToDB = new ConnectToDB();

    private final ArrayList<String> titles = new ArrayList<>();

    public ArrayList<String> getBookTitlesFromDatabase() {
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
}
