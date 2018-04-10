package Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import Library.Methods;
import Library.SqlLib;
import PageFactories.CategoriesPages.HouseholdChemicalsPF;
import PageFactories.CategoriesPages.HouseholdProductsPF;
import PageFactories.ItemsPagePF;
import PageFactories.MainPagePF;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created by denys on 4/10/18.
 */
public class Test2 extends Pattern {
    SqlLib sqlMethods = new SqlLib();
    Methods methods = new Methods();

    MainPagePF mainPagePF;
    HouseholdChemicalsPF householdChemicalsPF;
    HouseholdProductsPF householdProductsPF;

    @Test
    public void SecondTask(){
        driver.get("https://rozetka.com.ua");

        mainPagePF = new MainPagePF(driver);
        householdChemicalsPF = new HouseholdChemicalsPF(driver);
        householdProductsPF = new HouseholdProductsPF(driver);

        mainPagePF.household_products_click();
        householdProductsPF.household_chemicals_button_click();
        householdChemicalsPF.for_washing_button_click();

        for (int i=0; i<4; i++){
            methods.loadMore(driver);
        }

        /**
         * "перейти в раздел Порошки для стирки" - there is no "Порошки для стирки" button
         */

        ItemsPagePF sm = new ItemsPagePF(driver);
        List<WebElement> list_price =  sm.goods_price_list;
        List<WebElement> list_title = sm.goods_title_list;
        Collection col_title = new ArrayList();
        Collection col_price = new ArrayList();


        for(int i=0; i<list_price.size(); i++){
//Convert price string to int
            String s = list_price.get(i).getText().substring(0, list_price.get(i).getText().length()-4).replace(" ", "");
//Add data to collections
            if(Integer.parseInt(s) < 100 || Integer.parseInt(s) > 300)
                continue;
            col_title.add(list_title.get(i).getText());
            col_price.add(Integer.parseInt(s));
        }

        Iterator it_price = col_price.iterator();
        Iterator it_title = col_title.iterator();


        while(it_price.hasNext()){
            sqlMethods.writeIntoGoodsTable(it_title.next().toString(), Integer.parseInt(it_price.next().toString()));
        }
    }

}
