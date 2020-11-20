package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.ByteArrayInputStream;
import java.time.temporal.WeekFields;

public class EventPage extends AncestorPage {
    @FindBy(xpath = "//span[@class = 'evnt-tab-text desktop' and text () = 'Upcoming events']")
    public static WebElement upcomingEventButton;

    public EventPage(WebDriver driver) {
        super(driver);
    }
    @Step("click to Upcoming EventButton")
    public EventPage ClickToUpcomingEventButton() {
        upcomingEventButton.click();
        logger.info("click to Upcoming EventButton");
        return this;
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
