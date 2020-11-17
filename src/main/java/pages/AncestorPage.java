package pages;

import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AncestorPage {
    public static final Logger logger = LogManager.getLogger(AncestorPage.class);

    protected WebDriver driver;

    public AncestorPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
