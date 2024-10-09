package journal.reading.automation.settings.database;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class GetDateWithMongoDB {
ConnectToDB connectToDB = new ConnectToDB();

    private ArrayList<String> titles = new ArrayList<>();;

    public ArrayList<String> loadTitlesFromDatabase() {
        MongoCollection<Document> booksCollection = connectToDB.connectToMongoDB("books");

        FindIterable<Document> iterable = booksCollection.find();  // Отримання всіх документів з колекції books
        for (Document doc : iterable) {
            String title = doc.getString("title");
            if (title != null) {
                titles.add(title);
            }
        }
        System.out.println("Titles from the books collection:");
        for (String title : titles) {
            System.out.println(title);
        }
        return titles;
    }
}
