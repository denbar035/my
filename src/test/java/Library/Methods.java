package Library;

import PageFactories.ItemsPagePF;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by denys on 4/9/18.
 */
public class Methods {
    ItemsPagePF itemsPagePF;
    public void loadMore(WebDriver driver){
        itemsPagePF = new ItemsPagePF(driver);
        WaitLib wait = new WaitLib(driver);
        List<WebElement> goodsList = itemsPagePF.goods_view_list;
        int goodsListSize = goodsList.size();

        //Easter animation
        /**
        try{
            WebElement el = driver.findElement(By.xpath("//span[@class='exponea-close']"));
            if(el.isDisplayed())
                el.click();
        } catch(Exception e){}
        */

        itemsPagePF.load_more_button_click();
        WebDriverWait waitmy = new WebDriverWait(driver, 20);
        waitmy.until(ExpectedConditions.visibilityOf(itemsPagePF.load_more_button));
        waitmy.until(ExpectedConditions.elementToBeClickable(itemsPagePF.load_more_button));
    }
}
