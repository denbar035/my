package PageFactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by denys on 4/10/18.
 */
public class PageObject {

    protected WebDriver driver;

    public PageObject(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
}
