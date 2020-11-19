package pages;

import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AncestorPage {
    public static final Logger logger = LogManager.getLogger(AncestorPage.class);
    protected WebDriver driver;

    public AncestorPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
//
    protected boolean ExplicitWaitElement(WebElement element) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.invisibilityOf(element));
    }
}
