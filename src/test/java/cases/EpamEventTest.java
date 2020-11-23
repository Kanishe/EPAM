package cases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.EventPage;
import pages.MainPage;
import utils.WebDriverFactory;
import utils.WebDriverType;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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

    @Order(1)
    @Test
    @Epic("Extend business EPAM")
    @Feature("EventsEPAM")
    @Story("Extend events EPAM")
    @Description("This case verifying The page displays cards for upcoming events and the number of cards is equal to the counter on the 'Upcoming Events' button")
    public void viewingUpcomingActivities() {
        EventPage eventPage = new EventPage(driver);
        mainPage.eventPageOpen()
                .clickToUpcomingEventButton();
        int numberOfUpcomingEventsOnButton = eventPage.countNumberOfUpcomingEventsOnButton();
        int numberOfUpcomingEventsOnPage = eventPage.countNumberOfUpcomingEventsOnPage();
        assertEquals(numberOfUpcomingEventsOnPage,numberOfUpcomingEventsOnButton);
        logger.info("Number of cards is equal to the counter on the Upcoming Events button. Test viewingUpcomingActivities is passed" );
    }

    @Order(2)
    @Test
    @Epic("Extend business EPAM")
    @Feature("EventsEPAM")
    @Story("Extend events EPAM")
    @Description("This case verifying that the card contains information (venue • language • name of event • date of event • registration information • list of speakers) about the event")
    public void viewingEventCards() {
        EventPage eventPage = new EventPage(driver);
        mainPage.eventPageOpen()
                .clickToUpcomingEventButton();
        assertNotNull(eventPage.getCardLocation());
        assertNotNull(eventPage.getLanguageOfEvent());
        assertNotNull(eventPage.getEventTitle());
        assertNotNull(eventPage.getDateOfEvent());
        assertNotNull(eventPage.getRegStatusOfEvent());
        assertNotNull(eventPage.getListOfSpeakers());
        logger.info("Card contains all necessary information. Test viewingEventCards is passed");

    }
    @Order(3)
    @Test
    @Epic("Extend business EPAM")
    @Feature("EventsEPAM")
    @Story("Extend events EPAM")
    @Description("This case verifying dates for upcoming events")
    public void verifyingDatesForUpcomingEvents() throws ParseException {
        EventPage eventPage = new EventPage(driver);
        mainPage.eventPageOpen()
                .clickToUpcomingEventButton();
        eventPage.comperingDateInUpcomingEvent();
//        Date eventCardDate=eventPage.comperingDateInUpcomingEvent2();
//        assertThat(eventCardDate, before(Moments.today()));
        logger.info("Dates of the events are less than the current date");


    }

    @Order(4)
    @Test
    @Epic("Extend business EPAM")
    @Feature("EventsEPAM")
    @Story("Extend events EPAM")
    @Description("This case verifying The page displays cards of past events. The number of cards is equal to the counter on the Past Events button")
    public void viewPastEventsInCanada(){
        EventPage eventPage = new EventPage(driver);
        mainPage.eventPageOpen()
                .clickToPastEventButton();

    }






    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}