package journal.reading.automation.services.database;

import io.qameta.allure.Step;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;

public class DataManipulation {

    @Step("Порівняти між собою масиви данних з бази і з сайту")
    public void compareDataFromWebsiteAndDatabase(ArrayList<String> dbData, ArrayList<String> webData) {
        // Сортування масивів
        List<String> sortedDbData = dbData.stream().sorted().toList();
        List<String> sortedWebData = webData.stream().sorted().toList();

        // Перевірка на відповідність
        if (!sortedDbData.equals(sortedWebData)) {
            // Логіка перевірки розбіжностей
            List<String> missingOnWebsite = sortedDbData.stream()
                    .filter(title -> !sortedWebData.contains(title))
                    .toList();
            List<String> missingInDatabase = sortedWebData.stream()
                    .filter(title -> !sortedDbData.contains(title))
                    .toList();

            // Формування повідомлення про помилку
            StringBuilder errorMessage = new StringBuilder("Дані не співпадають:").append("\n");
            if (!missingOnWebsite.isEmpty()) {
                errorMessage.append("Дані є в базі даних, але відсутні на сайті: ").append(missingOnWebsite).append("\n");
            }
            if (!missingInDatabase.isEmpty()) {
                errorMessage.append("Дані на сайті, але відсутні в базі даних: ").append(missingInDatabase).append("\n");
            }

            Assert.fail(errorMessage.toString());
        }
    }
}
