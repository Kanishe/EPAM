package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CardEventDetailsPage extends AncestorPage {
    public CardEventDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button [@class = 'evnt-button btn sky reg-button attend']" )
    public static WebElement regButton;
//    @FindBy(xpath = "//button [@class = 'evnt-button btn sky reg-button attend']" )
//    public static WebElement dateInfo;


    @Step ("check information about Eevnt")
    public void checkInformationEvent(){
        boolean regButtonText = explicitWaitElement(regButton).isDisplayed();
//        boolean dateInfoText = explicitWaitElement(dateInfo).isDisplayed();
//        String languageOfThisWeekEventText = languageOfThisWeekEvent.getText();
//        String nameOfThisWeekEventText = nameOfThisWeekEvent.getText();
//        String placeOfThisWeekEventText = placeOfThisWeekEvent.getText();
//        String statusOfThisWeekEventText = statusOfThisWeekEvent.getText();



        assertThat(regButtonText, equalTo(true));
    }

}
