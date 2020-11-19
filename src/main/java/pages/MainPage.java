package pages;

import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;


public class MainPage extends AncestorPage{
    private final ServerConfig cfg = ConfigFactory.create(ServerConfig.class);


    public MainPage(WebDriver driver) {
        super(driver);
    }
    public MainPage open (){
        driver.get(cfg.url());
        logger.info("Event EPAM page is open" + cfg.url());
        return this;
    }
}
