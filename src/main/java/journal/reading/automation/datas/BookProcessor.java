package journal.reading.automation.datas;

import io.qameta.allure.Step;

import java.util.Random;

public class BookProcessor {

    @Step("Метод для отримання рандомного тайтлу")
    public String getRandomTitle() {
        BookData[] books = BookData.values();
        int randomIndex = new Random().nextInt(books.length); // Генерація випадкового індексу
        return books[randomIndex].getTitle(); // Повернення тайтлу
    }

}
