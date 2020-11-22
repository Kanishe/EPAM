package cases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.EventPage;
import pages.MainPage;
import utils.WebDriverFactory;
import utils.WebDriverType;

import java.util.concurrent.TimeUnit;

public class EpamEventTest {
    private static MainPage mainPage;
    WebDriver driver;
    public static final Logger logger = LogManager.getLogger(EpamEventTest.class);

    @SneakyThrows
    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.createDriver(WebDriverType.CHROME);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    @Epic("Extend business EPAM")
    @Feature("EventsEPAM")
    @Story("Extend events EPAM")
    @Description("This case verifying The page displays cards for upcoming events and the number of cards is equal to the counter on the 'Upcoming Events' button")
    public void viewingUpcomingActivities() {
        EventPage eventPage = new EventPage(driver);
        mainPage.eventPageOpen();
        eventPage.ClickToUpcomingEventButton();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}