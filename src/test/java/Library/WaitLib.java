package Library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by denys on 4/7/18.
 */
public class WaitLib {

    public WaitLib(WebDriver driver){
        this.driver = driver;
    }
    WebDriver driver;

    public void numElemMoreThan(By list, int moreThan){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(list, moreThan));
    }
}
