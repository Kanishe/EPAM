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
