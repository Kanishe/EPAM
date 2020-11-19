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
import utils.WebDriverFactory;
import utils.WebDriverType;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class EpamEventTest  {
    WebDriver driver;
    public static final Logger logger = LogManager.getLogger(EpamEventTest.class);



    @SneakyThrows
    @BeforeEach
    public void setUp() {
        driver=WebDriverFactory.createDriver(WebDriverType.CHROME);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    @Epic("YandexMarket_Comparing_OS_XiaomiAndHuawei_01")
    @Feature("Comparing_OS")
    @Story("Comparing_OS_XiaomiAndHuawei")
    @Description("Test OS Xiaomi VS Huawei")
    @Step("Start Test - Open Yandex Market")
    public void Open(){


    }
}
