package PageFactories.CategoriesPages;

import PageFactories.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

/**
 * Created by denys on 4/10/18.
 */
public class HouseholdProductsPF extends PageObject {
    public HouseholdProductsPF(WebDriver driver){
        super(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @FindBy(xpath = ".//li[@param='31761']/div/a[1]")
    public WebElement household_chemicals_button;

    public void household_chemicals_button_click()
    {
        household_chemicals_button.click();
    }
}
