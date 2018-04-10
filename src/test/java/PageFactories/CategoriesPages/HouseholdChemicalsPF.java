package PageFactories.CategoriesPages;

import PageFactories.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

/**
 * Created by denys on 4/9/18.
 */
public class HouseholdChemicalsPF extends PageObject {
    public HouseholdChemicalsPF(WebDriver driver){
        super(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @FindBy(xpath = ".//*[@id='menu_categories_left']/li[2]/p/a")
    public WebElement for_washing_button;

    public void for_washing_button_click()
    {
        for_washing_button.click();
    }
}
