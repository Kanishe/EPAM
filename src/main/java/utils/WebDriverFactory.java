package utils;

import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class WebDriverFactory {
    @SneakyThrows
    public static RemoteWebDriver createDriver(WebDriverType webDriverType) {
        String slenoidURL = "http://localhost:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (webDriverType) {
            case CHROME: {
                capabilities.setBrowserName("chrome");
                capabilities.setVersion("85.0");
                break;
            }
            case FIREFOX: {
                capabilities.setBrowserName("firefox");
                capabilities.setVersion("82.0");
                break;
            }
            case OPERA:{
                    capabilities.setBrowserName("opera");
                    capabilities.setVersion("70.0");
                break;
            }
            default:{
                return null;
            }

        }
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("screenResolution", "1280x1024");
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("enableLog", true);
        return new RemoteWebDriver(new URL(slenoidURL), capabilities);
    }
}
