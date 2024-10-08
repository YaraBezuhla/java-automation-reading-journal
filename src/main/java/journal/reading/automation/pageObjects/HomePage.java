package journal.reading.automation.pageObjects;

import org.openqa.selenium.By;

public class HomePage {

    By bookName = By.xpath("//h3[@name]");
    By loadMoreButton = By.xpath("//button[@data-test='load-more-button']");
}
