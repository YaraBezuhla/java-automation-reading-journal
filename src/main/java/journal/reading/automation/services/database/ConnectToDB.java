package journal.reading.automation.services.database;

import com.mongodb.client.*;
import journal.reading.automation.core.utilities.ConfigReader;
import org.bson.Document;

public class ConnectToDB {
    MongoClient mongoClient;
    MongoDatabase database;

    public MongoCollection<Document> connectToMongoDB(String nameCollection){
        mongoClient = MongoClients.create(ConfigReader.get("mongodb.uri"));
        database = mongoClient.getDatabase(ConfigReader.get("mongodb.database"));
        return database.getCollection(nameCollection);
    }
}
