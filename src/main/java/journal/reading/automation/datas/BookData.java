package journal.reading.automation.datas;

public enum BookData {
    HARRY_POTTER("Гаррі Поттер і таємна кімната", "Дж. К. Ролінг"),
    MOBY_DICK("Мобі Дік", "Герман Мелвілл"),
    THE_ALCHEMIST("Алхімік", "Пауло Коельо");

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
