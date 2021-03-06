package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static java.time.DayOfWeek.MONDAY;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EventPage extends AncestorPage {

    @FindBy(xpath = "//span[@class = 'evnt-tab-text desktop' and text () = 'Upcoming events']")
    public static WebElement upcomingEventButton;

    @FindBy(xpath = "//a[@class = 'evnt-tab-link nav-link active']//span[@class ='evnt-tab-counter evnt-label small white']")
    public static WebElement quantityUpcomingEventOnButton;


    @FindBy(xpath="//a[@class = 'evnt-tab-link nav-link active']//span[@class ='evnt-tab-counter evnt-label small white']")
    public static WebElement quantityPastEventOnButton;

    @FindBy(xpath = "//div[@class='evnt-events-column cell-3']")
    public static List<WebElement> quantityUpcomingEventOnPage;

    @FindBy(xpath="//div[@class='evnt-events-column cell-3']")
    public static List<WebElement> quantityPastEventsOnPage;


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

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/section[3]/div/div/div[2]/div/div[1]/div/div/div/a/div/div[2]/div/div[2]/div/div/p/span[1]")
    public static WebElement dateOnCardUpcomingEventInBlockThisWeek;

    @FindBy(xpath = "//span[@class = 'evnt-tab-text desktop' and text () = 'Past Events']")
    public static WebElement pastEventButton;

    @FindBy(xpath = "//div[@class = 'evnt-filter-button evnt-button btn dropdown-toggle']/span[contains(text(),'Location')]")
    public static WebElement locationFilter;

    @FindBy(xpath = "//label[@data-value = 'Canada' ]")
    public static WebElement checkBoxCanada;


    @FindBy(xpath ="//div[@class = 'evnt-events-column cell-3']" )
    public static WebElement bodyEvent;









    public EventPage(WebDriver driver) {
        super(driver);
    }
    @Step("click to Upcoming EventButton")
    public EventPage clickToUpcomingEventButton() {
        upcomingEventButton.click();
        logger.info("clicked to Upcoming EventButton");
        return this;
    }
    @Step("clicked to Location Filter")
    public EventPage clickToLocationFilter() {
        locationFilter.click();
        logger.info("clicked to Location Filter");
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
        logger.info("Event registration status from the car event is - "+ regStatus.getText());
        return regStatus;
    }

    @Step("Get list of speakers of the event from the card")
    public WebElement getListOfSpeakers(){
        listOfSpeakers.getText();
        logger.info("List of speakers of the event from the car event is - "+ listOfSpeakers.getText());
        return listOfSpeakers;
    }

    @Step("Check date in card on Page UpcomingEvent ")/////<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<??????????????
    public void comperingDateInUpcomingEvent(){
        String dateOfThisWeekEventText = dateOnCardUpcomingEventInBlockThisWeek.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy", Locale.ENGLISH);
        LocalDate dateOfThisWeekEvent = LocalDate.parse(dateOfThisWeekEventText, formatter);
        LocalDate today = LocalDate.now();
        LocalDate mondayOfThisWeek = today.with(previousOrSame(MONDAY));
        LocalDate sundayOfThisWeek = today.with(nextOrSame(DayOfWeek.SUNDAY));
        boolean isAfterMondayOfThisWeek = dateOfThisWeekEvent.isAfter(mondayOfThisWeek);
        boolean isBeforeMondayOfThisWeek = dateOfThisWeekEvent.isBefore(sundayOfThisWeek);
        assertTrue(isAfterMondayOfThisWeek);
        assertTrue(isBeforeMondayOfThisWeek);
    }

    @Step("Check date in card on Page UpcomingEvent ")/////<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<??????????????
    public Date comperingDateInUpcomingEvent2() throws ParseException {
        return new SimpleDateFormat("dd MM yyyy").parse(dateOnCardUpcomingEventInBlockThisWeek.getText());
    }

    @Step("click to Past EventButton")
    public EventPage clickToPastEventButton(WebElement webElement) {
        new WebDriverWait(driver, 40).
                until(ExpectedConditions.elementToBeClickable(pastEventButton)).click();
//        pastEventButton.click();
        logger.info("clicked to Past EventButton");
        return this;
    }

    @Step("Clicked to check box Canada")
    public EventPage clickToCheckBoxCanada(WebElement checkBoxCanada){
        new WebDriverWait(driver, 40).
                until(ExpectedConditions.elementToBeClickable(checkBoxCanada)).click();
        logger.info("Clicked to check box Canada - "+ listOfSpeakers.getText());
        return this;
    }

    @Step("Count Past event on Page Events")
    public int countNumberOfPastEventsOnPage() {
        int numberPastEventsOnPage = quantityPastEventsOnPage.size();
        Allure.addAttachment("Number of elements on Page Past Events", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        logger.info("Number of elements on Page Past Events = " + numberPastEventsOnPage);
        return numberPastEventsOnPage;
    }

    @Step("Count past event on the 'label small white'")
    public int countNumberOfPastEventsOnButton(){
        Allure.addAttachment("Number of elements on the counter 'label small white", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        logger.info("Number of elements on the counter 'label small white' = " + quantityPastEventOnButton.getText());
        return Integer.parseInt(quantityPastEventOnButton.getText());
    }

    @FindBy(xpath = "//div[@class = 'evnt-dates-cell dates']")
    public static WebElement dateOnCardPassEventInBlockThisWeek;

//    @Step("ddd")//TODO подумать над сравниенем
//    public Date sysDay(){
//        DateFormat dateFormat = new SimpleDateFormat("dd - dd MMM yyyy");
//        Date sysDate = new Date();
//        dateFormat.format(sysDate);
//        logger.info(sysDate);
//        return sysDate;
//    }

    @Step("Take data venue in card ")
    public Date dateOfEvent() throws ParseException {
        String strDate  = dateOnCardPassEventInBlockThisWeek.getText();
        Date cardDate = new SimpleDateFormat("dd - dd MMM yyyy").parse(strDate);
        logger.info(cardDate);
        return cardDate;
    }

    @SneakyThrows
    @Step("Open detailed information about event")
    public CardEventDetailsPage clickToEvent(){
        JavascriptExecutor jsscroll = (JavascriptExecutor) driver;
        jsscroll.executeScript("window.scrollBy(0,1000)");
        Allure.addAttachment("Click to any Event", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
//        logger.info(explicitWaitElement(bodyEvent).getText());
        explicitWaitElement(bodyEvent).click();
//        bodyEvent.getText()
        return new CardEventDetailsPage(driver);
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
