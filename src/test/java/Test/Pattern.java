package Test;

import ProjectSetup.DriverLauncher;
import ProjectSetup.MainVariables;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by denys on 4/10/18.
 */
public abstract class Pattern {

    DriverLauncher dl = new DriverLauncher();
    MainVariables mv = new MainVariables();

    WebDriver driver;

    @BeforeMethod
    public void launching(){
        driver = dl.usebrowser();
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void closing(){
        driver.close();
    }

}
