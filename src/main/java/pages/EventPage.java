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



    public EventPage(WebDriver driver) {
        super(driver);
    }


//    @Step("Get the card quantity of Upcoming Events")
//    public int quantityOfCardNumberUpcomingEvents(){
//        linkToEventsPage.click();
//        logger.info("Page Event is open - " + linkToEventsPage);
//        return quantityOfCardNumberUpcomingEvents();
//    }
}
