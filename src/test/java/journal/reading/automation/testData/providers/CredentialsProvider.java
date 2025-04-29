package journal.reading.automation.testData.providers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CredentialsProvider {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = CredentialsProvider.class
                .getClassLoader()
                .getResourceAsStream("credentials.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find credentials.properties");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load credentials.properties", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}

