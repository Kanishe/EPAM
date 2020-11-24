package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardEventDetailsPage extends AncestorPage {
    public CardEventDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button [@class = 'evnt-button btn sky reg-button attend']" )
    public static WebElement regButton;
    @FindBy(xpath = "//div[@class = 'evnt-agenda-days-tabs-nav']" )
    public static WebElement dateInfo;
    @FindBy(xpath = "//div[@class = 'evnt-card-wrapper']" )
    public static List <WebElement> talkDetails;




    @Step ("check information about Eevnt")
    public void checkInformationEvent(){
        boolean regButtonText = explicitWaitElement(regButton).isDisplayed();
        boolean dateInfoText = explicitWaitElement( dateInfo).isDisplayed();
        int talks = Integer.parseInt(String.valueOf(talkDetails.size()));


        assertThat(regButtonText, equalTo(true));
        assertThat(dateInfoText, equalTo(true));
        assertEquals(talks,talks);
//        assertThat(talkDetailsText, equalTo(true));
    }

}
