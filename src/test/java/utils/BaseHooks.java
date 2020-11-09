package utils;


import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;

public class BaseHooks {
    protected static WebDriver driver;
    public static final Logger logger = LogManager.getLogger(BaseHooks.class);

    @BeforeAll
    public static void setDriver (){

    }

}
