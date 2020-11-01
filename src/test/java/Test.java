import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {
    private static final Logger logger = LogManager.getLogger(Test.class);
    @Epic("YandexMarket_Comparing_OS_XiaomiAndHuawei_01")
    @Step("Iinit allure")
    public static void main(String[] args) {

        System.out.println("test log4j2 and junit5");
        logger.info("Logtest log4j2 and junit5");



    }
}
