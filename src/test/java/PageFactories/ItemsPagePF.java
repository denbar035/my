package PageFactories;

import PageFactories.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by denys on 4/7/18.
 */
public class ItemsPagePF extends PageObject {


    public ItemsPagePF(WebDriver driver){
        super(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @FindBy(xpath = ".//img[contains (@alt, 'Загрузка')]")
    public WebElement load_more_button;

    public void load_more_button_click()
    {
        load_more_button.click();
    }

    private final String goods_view = ".//div[contains (@data-view_type, 'catalog_with_hover')]";
    public By goods_view_By = By.xpath(goods_view);
    @FindBy(xpath = goods_view)
    public List<WebElement> goods_view_list;

    @FindBy(xpath = ".//div[@class='g-i-tile-i-title clearfix']/a[1]")
    public List<WebElement> goods_title_list;

    @FindBy(xpath = ".//div[@class='g-price-uah']")
    public List<WebElement> goods_price_list;
}
