package journal.reading.automation.testData.processor;

import io.qameta.allure.Step;
import journal.reading.automation.testData.enums.BookData;

import java.util.Random;

public class BookProcessor {

    @Step("Метод для отримання рандомної назви книги наявних в enum файлі")
    public String getRandomTitle() {
        BookData[] books = BookData.values();
        int randomIndex = new Random().nextInt(books.length); // Генерація випадкового індексу
        return books[randomIndex].getTitle(); // Повернення тайтлу
    }

    @Step("Метод для отримання рандомного автора книги наявних в enum файлі")
    public String getRandomAuthor() {
        BookData[] books = BookData.values();
        int randomIndex = new Random().nextInt(books.length);
        return books[randomIndex].getAuthor();
    }
}
