package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    public static WebDriver createDriver(WebDriverType webDriverType) {
        switch (webDriverType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
            case OPERA:
                WebDriverManager.operadriver().setup();
            default:
                throw  new IllegalStateException("browser name must be specified");
        }
    }
}