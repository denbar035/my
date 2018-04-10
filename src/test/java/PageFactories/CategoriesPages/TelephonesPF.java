package PageFactories.CategoriesPages;

import PageFactories.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by denys on 4/10/18.
 */
public class TelephonesPF extends PageObject {

    public TelephonesPF(WebDriver driver){
        super(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @FindBy(xpath = "//li[contains(@param, '63304')]/div/a[1]")
    public WebElement smartphones_button;

    public void smartphones_button_click()
    {
        smartphones_button.click();
    }
}
