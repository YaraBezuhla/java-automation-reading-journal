package journal.reading.automation.testData.providers;

import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookDataProvider {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Зчитування книг з JSON
    public static List<Map<String, Object>> getBooks() {
        try (InputStream is = BookDataProvider.class.getClassLoader().getResourceAsStream("testData/books.json")) {
            if (is == null) {
                throw new RuntimeException("The books.json file could not be found in the resources");
            }
            return objectMapper.readValue(is, new TypeReference<List<Map<String, Object>>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read books.json", e);
        }
    }

    public static Map<String, Object> getBook(int index) {
        List<Map<String, Object>> books = getBooks();
        if (index < 0 || index >= books.size()) {
            throw new IllegalArgumentException("Incorrect book index: " + index);
        }
        return books.get(index);
    }

    public static List<String> getBookTitles() {
        List<String> titles = new ArrayList<>();
        try {
            List<Map<String, Object>> books = getBooks();
            for (Map<String, Object> book : books) {
                String title = (String) book.get("title");
                if (title != null && !title.isEmpty()) {
                    titles.add(title);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to read books from a file: ", e);
        }
        return titles;
    }
}
