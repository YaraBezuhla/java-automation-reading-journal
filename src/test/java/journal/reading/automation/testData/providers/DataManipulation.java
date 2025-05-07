package journal.reading.automation.testData.providers;

import io.qameta.allure.Step;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;

public class DataManipulation {

    @Step("Compare two arrays with each other")
    public void compareTwoArrays(ArrayList<String> firstArray, ArrayList<String> secondArray) {
        List<String> sortedDbData = firstArray.stream().sorted().toList();
        List<String> sortedWebData = secondArray.stream().sorted().toList();

        if (!sortedDbData.equals(sortedWebData)) {
            List<String> missingOnWebsite = sortedDbData.stream()
                    .filter(title -> !sortedWebData.contains(title))
                    .toList();
            List<String> missingInDatabase = sortedWebData.stream()
                    .filter(title -> !sortedDbData.contains(title))
                    .toList();

            StringBuilder errorMessage = new StringBuilder("The data does not match:").append("\n");
            if (!missingOnWebsite.isEmpty()) {
                errorMessage.append("The data is available in the database but not on the website: ").append(missingOnWebsite).append("\n");
            }
            if (!missingInDatabase.isEmpty()) {
                errorMessage.append("Data on the website but not in the database: ").append(missingInDatabase).append("\n");
            }

            Assert.fail(errorMessage.toString());
        }
    }
}
