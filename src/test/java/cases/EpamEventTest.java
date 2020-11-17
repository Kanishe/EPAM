package cases;

import config.ServerConfig;
import io.qameta.allure.*;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.AncestorPage;
import pages.MainPage;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class EpamEventTest  {
    WebDriver driver;
    public static final Logger logger = LogManager.getLogger(EpamEventTest.class);



    @SneakyThrows
    @BeforeEach
    public void setUp() {
//        String browser = System.getProperty("browser");
//        logger.info(browser);
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        String slenoidURL = "http://localhost:4444/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        caps.setVersion("85.0");
        caps.setCapability("enableVNC", true);
        caps.setCapability("screenResolution", "1280x1024");
        caps.setCapability("enableVideo", true);
        caps.setCapability("enableLog", true);


        driver = new RemoteWebDriver(new URL(slenoidURL), caps);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    @Epic("YandexMarket_Comparing_OS_XiaomiAndHuawei_01")
    @Feature("Comparing_OS")
    @Story("Comparing_OS_XiaomiAndHuawei")
    @Description("Test OS Xiaomi VS Huawei")
    @Step("Start Test - Open Yandex Market")
    public void Open(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        logger.info("dd");

    }
}
