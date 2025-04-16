package journal.reading.automation.config.utilities;

import java.time.Duration;

public class Config {
    public enum BrowserType {
        CHROME,
        FIREFOX
    }
    public static class Domains {
        public static final String LOCALE = "http://localhost:8080/";
    }

    public static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

}
