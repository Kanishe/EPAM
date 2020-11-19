package pages;

import config.ServerConfig;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.ByteArrayInputStream;


public class MainPage extends AncestorPage{
    private final ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    @FindBy(xpath = "//a[@class = 'nav-link' and @href = '/events']")
    private static WebElement linkToEventsPage;

    public MainPage(WebDriver driver) {
        super(driver);
    }
    @Step("Main page EPAM app is open")
    public MainPage open (){
        driver.get(cfg.url());
        logger.info("Event EPAM page is open - " + cfg.url());
        Allure.addAttachment("Epam Events page", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        return this;
    }
    @Step("The Events Page is open")
    public EventPage eventPageOpen(){
        linkToEventsPage.click();
        logger.info("Event page is opened - " + driver.getTitle());
        Allure.addAttachment("Epam Events page", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        return new EventPage(driver);
    }
}
