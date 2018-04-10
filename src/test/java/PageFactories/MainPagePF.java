package PageFactories;

import PageFactories.CategoriesPages.SmartphoneTVElectronicsPF;
import PageFactories.CategoriesPages.TelephonesPF;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by denys on 4/10/18.
 */
public class MainPagePF extends PageObject {


    public MainPagePF(WebDriver driver){
        super(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

//Product catalog
    @FindBy(xpath = ".//*[@id='3361']/a")
    public WebElement smartphones_tv_electronics_button;

    @FindBy(xpath = ".//*[@id='5300']/a")
    public WebElement household_products_button;

    public void smartphones_tv_electronics_button_click()
    {
        smartphones_tv_electronics_button.click();
    }

    public void household_products_click(){
        household_products_button.click();
    }

    public void navigateToSmartphones(){
        smartphones_tv_electronics_button_click();


        SmartphoneTVElectronicsPF smartphoneTVElectronicsPF = new SmartphoneTVElectronicsPF(driver);
        smartphoneTVElectronicsPF.telephones_button_click();

        TelephonesPF telephones = new TelephonesPF(driver);
        telephones.smartphones_button_click();
    }
}
