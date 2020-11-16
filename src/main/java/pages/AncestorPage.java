package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AncestorPage {
    protected WebDriver driver;

    public AncestorPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
