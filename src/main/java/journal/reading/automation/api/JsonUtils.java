package journal.reading.automation.api;

import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    // Метод для читання JSON із файлу
    public static String readJsonFromFile(String filePath) throws Exception {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    // Метод для парсингу JSON до списку об'єктів
    public static List<Map<String, Object>> parseJsonToList(String json) throws Exception {
        return mapper.readValue(json, new TypeReference<List<Map<String, Object>>>() {});
    }

    // Метод для перетворення об'єкта назад у JSON
    public static String convertObjectToJson(Object object) throws Exception {
        return mapper.writeValueAsString(object);
    }
}
