package PageFactories.CategoriesPages;

import PageFactories.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by denys on 4/10/18.
 */
public class SmartphoneTVElectronicsPF extends PageObject {


    public SmartphoneTVElectronicsPF(WebDriver driver){
        super(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @FindBy(xpath = "//ul[contains(@id, 'menu_categories_left')]/li/p/a[1]")
    public WebElement telephones_button;

    public void telephones_button_click()
    {
        telephones_button.click();
    }

}
