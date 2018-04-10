package ProjectSetup;

import Library.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Created by denys on 4/7/18.
 */
public class DriverLauncher {

    WebDriver driver;
    private String browserName;

    public WebDriver usebrowser()
    {
        ConfigReader config = new ConfigReader();
        browserName = config.getConfValues("browser");

        String os = System.getProperty("os.name", "");
        if (browserName.equalsIgnoreCase("chrome"))
        {
            if (os.contains("Mac")){
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
            }
            else if (os.contains("Win")){
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            }
            driver = new ChromeDriver();

        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {
            if (os.contains("Mac")){
                System.setProperty("webdriver.gecko.driver", "");
            }
            else if (os.contains("Win")){
                System.setProperty("webdriver.gecko.driver", "");
            }
            driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("opera"))
        {
            if (os.contains("Mac")){
                System.setProperty("webdriver.opera.driver", "");
            }
            else if (os.contains("Win")){
                System.setProperty("webdriver.opera.driver", "");
            }
            driver = new OperaDriver();

        }
        else if (browserName.equalsIgnoreCase("safari"))
        {
            driver = new SafariDriver();
        }
        else if (browserName.equalsIgnoreCase("edge"))
        {
            System.setProperty("webdriver.edge.driver", "");
            driver = new EdgeDriver();
        }
        return driver;
    }
}
