package journal.reading.automation.testData.processor;

import io.qameta.allure.Step;
import journal.reading.automation.testData.enums.BookData;

import java.util.Random;

public class BookProcessor {

    @Step("Method for getting a random book title available in an enum file")
    public String getRandomTitle() {
        BookData[] books = BookData.values();
        int randomIndex = new Random().nextInt(books.length);
        return books[randomIndex].getTitle();
    }

    @Step("Method for getting a random author of a book available in an enum file")
    public String getRandomAuthor() {
        BookData[] books = BookData.values();
        int randomIndex = new Random().nextInt(books.length);
        return books[randomIndex].getAuthor();
    }
}
