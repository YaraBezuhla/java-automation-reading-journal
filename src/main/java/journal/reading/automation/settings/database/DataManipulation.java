package journal.reading.automation.settings.database;

import io.qameta.allure.Step;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;

public class DataManipulation {

    @Step("Порівняти між собою масиви данниз з бази і з сайту")
    public void compareDataFromWebsiteAndDatabase(ArrayList<String> dbData, ArrayList<String> webData) {
        // Перевірка на повну відповідність
        boolean areEqual = dbData.stream().sorted().toList()
                .equals(webData.stream().sorted().toList());
        Assert.assertTrue(areEqual, "Данні не співпадають");
/*        if (areEqual) {
            System.out.println("Lists are identical. All data from the database match those on the website.");
        } else {
            System.out.println("Lists are not identical.");

            // Виведення данних, яких не вистачає на сайті
            List<String> missingOnWebsite = dbData.stream()
                    .filter(title -> !webData.contains(title)).toList();
            System.out.println("Data in the database but missing on the website: " + missingOnWebsite);

            // Виведення данних, яких не вистачає в базі даних
            List<String> missingInDatabase = webData.stream()
                    .filter(title -> !dbData.contains(title)).toList();
            System.out.println("Data on the website but missing in the database: " + missingInDatabase);
        }*/
    }
}
