package journal.reading.automation.testData.enums;

public enum BookData {
    INTERNAT("Інтернат", "Сергій Жадан"),
    TIGERS("Тигролови", "Іван Багряний"),
    INTERMEZZO("Intermezzo", "Михайло Коцюбинський"),
    YOUAREINTERESTEDDARKNESS("Я бачу вас цікавить пітьма", "Ілларіон Павлюк");

    private final String title;
    private final String author;

    // Конструктор
    BookData(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Геттери
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
