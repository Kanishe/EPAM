package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VideoPage  extends AncestorPage{

    public VideoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//div[@class = 'evnt-toogle-filters-text show-more']")
    public static WebElement moreButtonFilters;

    @FindBy (xpath = "//div[@class = 'evnt-more-filters collapse show']")
    public static WebElement collapseButtonFilters;

    @FindBy (xpath = "//div [@id = 'filter_category']")
    public static WebElement categoryFilter;

    @FindBy (xpath = "//input[@type = 'text']//ancestor::div[@class ='evnt-filters-heading-cell cell-1']//span[contains(text(),'Category') ]")
    public static WebElement categoryInput;

    @FindBy (xpath = "//label[@for= 'filter_category_15']")
    public static WebElement boxTest;

    @FindBy(xpath = "//input[@type = 'text']//ancestor::div[@class ='evnt-filters-heading-cell cell-1']//span[contains(text(),'Location') ]")
    public WebElement locationFilter;

    @FindBy (xpath = "//label[@for ='filter_location_1']")
    public static WebElement boxBelarus;

    @FindBy(xpath = "//div[@class ='evnt-filter-button evnt-button btn dropdown-toggle' and @id='filter_language']")
    public WebElement languageFilter;

    @FindBy (xpath = "//label[@for ='filter_language_1']")
    public static WebElement boxEnglish;

    @FindBy (xpath = "//div[@class ='evnt-tag evnt-filters-tags with-delete-elem']/label[contains(text(),'ENG')]")
    public static WebElement selectedLanguage;

    @FindBy (xpath = "//div[@class ='evnt-tag evnt-filters-tags with-delete-elem']/label[contains(text(),'Bela')]")
    public static WebElement selectedLocation;

    @FindBy (xpath = "//div[@class ='evnt-tag evnt-filters-tags with-delete-elem']/label[contains(text(),'Testing')]")
    public static WebElement selectedCategory;

    @FindBy (xpath = "//div[@class='evnt-search-filter']/input")
    public static WebElement inputKeywords;


    @FindBy (xpath = "//div[@class='evnt-talks-column cell-6']")
    public static WebElement videosWithKeyWordQA;








    @Step("Click to More Filters")
    public void clickMoreFilters(){
        explicitWaitElement(moreButtonFilters).click();
        logger.info(moreButtonFilters.getText());
        Allure.addAttachment("clickMoreFilters", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Click to filter Category")
    public void clickToCollapseCategory(){
        explicitWaitElement(collapseButtonFilters).isDisplayed();
        logger.info(collapseButtonFilters.getText());
        Allure.addAttachment("Click to filter Category", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Click to filter on Page Video")
    public void clickAndCheckInputToFilter() throws InterruptedException {
        explicitWaitElement(categoryFilter).click();
        explicitWaitElement(boxTest).click();
        logger.info(boxTest.getText());
        Allure.addAttachment("Send Keys to filter Category", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        explicitWaitElement(locationFilter).click();
        explicitWaitElement(boxBelarus).click();
        explicitWaitElement(languageFilter).click();
        explicitWaitElement(boxEnglish).click();
        logger.info(boxEnglish.getText());
        Allure.addAttachment("All  necessary selected ", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        String language = explicitWaitElement(selectedLanguage).getText();
        String location = explicitWaitElement(selectedLocation).getText();
        String category = explicitWaitElement(selectedCategory).getText();
        assertEquals(language,"ENGLISH");
        assertEquals(location,"Belarus");
        assertEquals(category,"Testing");
    }

    @Step("input Keywords QA")
    public void inputKeyWordsInSearchField() throws InterruptedException {
        explicitWaitElement(inputKeywords).click();
        logger.info("input Keywords QA");
        explicitWaitElement(inputKeywords).sendKeys("QA");
        explicitWaitElement(inputKeywords).getSize();
//        Thread.sleep(2000);
        Allure.addAttachment("input Keywords QA", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

    }
    @Step("check Keywords QA in Event Crad")
    public void checkKeyWordInEventVideo(String keywordInVideo) throws InterruptedException {
        explicitWaitElement(videosWithKeyWordQA).isEnabled();
        String video = explicitWaitElement(videosWithKeyWordQA).getText();
        logger.info("check Keywords QA in Event Crad");
        assertThat(video,containsString(keywordInVideo));
        Allure.addAttachment("input Keywords QA", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

    }
}
