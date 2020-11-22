package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.io.ByteArrayInputStream;
import java.util.List;

public class EventPage extends AncestorPage {
    @FindBy(xpath = "//span[@class = 'evnt-tab-text desktop' and text () = 'Upcoming events']")
    public static WebElement upcomingEventButton;

    @FindBy(xpath = "//a[@class = 'evnt-tab-link nav-link active']//span[@class ='evnt-tab-counter evnt-label small white']")
    public static WebElement quantityUpcomingEventOnButton;

    @FindBy(xpath = "//div[@class='evnt-events-column cell-3']")
    public static List<WebElement> quantityUpcomingEventOnPage;

    @FindBy(xpath = "//div[@class='evnt-event-details-table']/div[@class='evnt-details-cell online-cell']")
    public static WebElement venue;

    @FindBy(xpath = "//p[@class = 'language']")
    public static WebElement languageOfEvent;

    @FindBy(xpath = "//div[@class = 'evnt-card-body']//h1")
    public static WebElement eventTitle;

    @FindBy(xpath = "//div[@class = 'evnt-dates-cell dates']")
    public static WebElement dateOfEvent;

    @FindBy(xpath = "//span[@class = 'status free-attend']")
    public static WebElement regStatus;

    @FindBy(xpath = "//div[@class = 'evnt-card-footer']//div[@class = 'evnt-people-cell speakers']")
    public static WebElement listOfSpeakers;


    public EventPage(WebDriver driver) {
        super(driver);
    }
    @Step("click to Upcoming EventButton")
    public EventPage clickToUpcomingEventButton() {
        upcomingEventButton.click();
        logger.info("click to Upcoming EventButton");
        return this;
    }

    @Step("Count upcoming event on the 'label small white'")
    public int countNumberOfUpcomingEventsOnButton(){
        String  numberOfUpcomingEventsOnButtonStr = quantityUpcomingEventOnButton.getText();
        int numberOfUpcomingEventsOnButton = Integer.parseInt(numberOfUpcomingEventsOnButtonStr);
        Allure.addAttachment("Number of elements on the counter 'label small white", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        logger.info("Number of elements on the counter 'label small white' = " + numberOfUpcomingEventsOnButton);
        return  numberOfUpcomingEventsOnButton ;
    }

    @Step("Count upcoming event on Page Upcoming Events")
    public int countNumberOfUpcomingEventsOnPage(){
        int numberOfUpcomingEventsOnPage = quantityUpcomingEventOnPage.size();
        Allure.addAttachment("Number of elements on Page Upcoming Events", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        logger.info("Number of elements on Page Upcoming Events = " + numberOfUpcomingEventsOnPage);
        return numberOfUpcomingEventsOnPage;
    }
    @Step("Get the location of the event from the card")
    public WebElement getCardLocation(){
        venue.getText();
        logger.info(venue.getText());
        logger.info("Location of the event from the card is - "+venue.getText() );
        return venue;
    }
    @Step("Get the language of the event from the card")
    public WebElement getLanguageOfEvent(){
        languageOfEvent.getText();
        logger.info("Language of the event from the card is - "+ languageOfEvent.getText());
        return languageOfEvent;
    }
    @Step("Get the event title of the event from the card")
    public WebElement getEventTitle(){
        eventTitle.getText();
        logger.info("Event Title of the event from the card is - "+ eventTitle.getText());
        return eventTitle;
    }

    @Step("Get date of the event from the card")
    public WebElement getDateOfEvent(){
        dateOfEvent.getText();
        logger.info("Event date of the event from the car event is - "+ dateOfEvent.getText());
        return dateOfEvent;
    }

    @Step("Get registration status information of the event from the card")
    public WebElement getRegStatusOfEvent(){
        regStatus.getText();
        logger.info("Event date of the event from the car event is - "+ regStatus.getText());
        return regStatus;
    }

    @Step("Get list of speakers of the event from the card")
    public WebElement getListOfSpeakers(){
        listOfSpeakers.getText();
        logger.info("List of speakers of the event from the car event is - "+ listOfSpeakers.getText());
        return listOfSpeakers;
    }







//    @Step
//    public void
//
//    @Step("Get the card number value of Upcoming Events")
//    public int cardNumberOfUpcomingEvents(){
//        int actualNumberOfCards=numberUpcomingEventsCard.size();
//        logger.info("Get actual number of cards on the page");
//        assertThat(actualNumberOfCards,greaterThan(0));
//        logger.info("Assert that page displays cards for upcoming events");
//        Allure.addAttachment("Upcoming Events cards on Events page", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
//        return actualNumberOfCards;


}
