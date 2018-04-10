package Test;

import Library.FileLib;
import Library.Methods;
import PageFactories.ItemsPagePF;
import PageFactories.MainPagePF;
import com.google.gson.internal.LinkedTreeMap;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.*;

/**
 * Created by denys on 4/10/18.
 */
public class Test3 extends Pattern
{
    MainPagePF mainPagePF;
    FileLib fileLib = new FileLib();

    @Test
    public void thirdTest(){
        ItemsPagePF itemsPagePF = new ItemsPagePF(driver);
        Methods methods = new Methods();
        driver.get("https://rozetka.com.ua");
        mainPagePF = new MainPagePF(driver);
        mainPagePF.navigateToSmartphones();

        for (int i=0; i<2; i++){
            methods.loadMore(driver);
        }
        //Save title and price of top items
        List<WebElement> list_top_title = itemsPagePF.top_goods_title_list;
        List<WebElement> list_top_price = itemsPagePF.top_goods_price_list;
        Map collection_top_price = new HashMap();
        Map collection_top_title = new HashMap();
        int positionOfPrice_top = 1;
        for(int i=0; i<list_top_price.size(); i++){
            int price = Integer.parseInt(list_top_price.get(i).getText().substring(0, list_top_price.get(i).getText().length()-4).replace(" ", ""));
            collection_top_price.put(positionOfPrice_top, price);
            collection_top_title.put(positionOfPrice_top, list_top_title.get(i).getText());
            positionOfPrice_top++;
        }
        //Sort top items by price
        Map<Integer, Integer> map = collection_top_price;
        List list = new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return a.getValue() - b.getValue();
            }
        });
        int[] price_index_array = new int[collection_top_price.size()];
        int[] price_value_array = new int[collection_top_price.size()];
        String[] title_array = new String[collection_top_price.size()];

        for (int i=0; i<list.size(); i++){
            price_index_array[i] = Integer.parseInt(list.get(i).toString().split("=")[0]);
            price_value_array[i] = Integer.parseInt(list.get(i).toString().split("=")[1]);
            title_array[i] = collection_top_title.get(price_index_array[i]).toString();
        }
        //Create and write into Excel file
        fileLib.writeExcelcreate(title_array, price_value_array, "Sheet1");


        for (int i=0; i<2; i++){
            methods.loadMore(driver);
        }

        List<WebElement> list_price = itemsPagePF.goods_price_list;
        List<WebElement> list_title = itemsPagePF.goods_title_list;
        Map collection_price = new HashMap();
        Map collection_title = new HashMap();
        int positionOfPrice = 1;
//Select only that items which price >= 3000 || price <= 6000
        for(int i=0; i<list_price.size(); i++){
            int price = Integer.parseInt(list_price.get(i).getText().substring(0, list_price.get(i).getText().length()-4).replace(" ", ""));
            if(price < 3000 || price > 6000)
                continue;

            collection_price.put(positionOfPrice, price);
            collection_title.put(positionOfPrice, list_title.get(i).getText());
            positionOfPrice++;
        }

        Map<Integer, Integer> map2 = collection_price;
        List list2 = new ArrayList(map2.entrySet());
        Collections.sort(list2, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return a.getValue() - b.getValue();
            }
        });
        int[] price_index_array2 = new int[collection_price.size()];
        int[] price_value_array2 = new int[collection_price.size()];
        String[] title_array2 = new String[collection_price.size()];

        for (int i=0; i<list2.size(); i++){
            price_index_array2[i] = Integer.parseInt(list2.get(i).toString().split("=")[0]);
            price_value_array2[i] = Integer.parseInt(list2.get(i).toString().split("=")[1]);
            title_array2[i] = collection_title.get(price_index_array2[i]).toString();
        }
        //Write into Excel file
        fileLib.writeExcelexisted(title_array2, price_value_array2, "Sheet2");

    }

}
