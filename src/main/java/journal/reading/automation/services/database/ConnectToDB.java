package journal.reading.automation.services.database;

import com.mongodb.client.*;
import org.bson.Document;

public class ConnectToDB {
    MongoClient mongoClient;
    MongoDatabase database;

    public MongoCollection<Document> connectToMongoDB(String nameCollection){
        mongoClient = MongoClients.create("mongodb://localhost:27017"); // Підключення до MongoDB
        database = mongoClient.getDatabase("automationreadingjournal"); // Отримання об'єкта бази даних
        // Отримання колекції
        return database.getCollection(nameCollection);
    }
}
