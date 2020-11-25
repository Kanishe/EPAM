package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.ByteArrayInputStream;

public class VideoPage  extends AncestorPage{

    public VideoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//div[@class = 'evnt-toogle-filters-text show-more']")
    public static WebElement moreButtonFilters;

    @Step("Click to More Filters")
    public void clickMoreFilters(){
        explicitWaitElement(moreButtonFilters).click();
        logger.info(moreButtonFilters.getText());
        Allure.addAttachment("clickMoreFilters", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
}
