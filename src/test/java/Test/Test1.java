package Test;

import Library.*;
import PageFactories.ItemsPagePF;
import PageFactories.CategoriesPages.TelephonesPF;
import PageFactories.MainPagePF;
import PageFactories.CategoriesPages.SmartphoneTVElectronicsPF;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;


/**
 * Created by denys on 4/10/18.
 */
public class Test1 extends Pattern {
//PageFactories
    MainPagePF mainPagePF;
    SmartphoneTVElectronicsPF smartphoneTVElectronicsPF;
    TelephonesPF telephones;
    ItemsPagePF itemsPagePF;
//
    EmailLib elib = new EmailLib();
    FileLib flib = new FileLib();
    Methods meth = new Methods();


    @Test
    public void FirstTask(){
        driver.get(mv.url);

        mainPagePF = new MainPagePF(driver);
        mainPagePF.smartphones_tv_electronics_button_click();


        smartphoneTVElectronicsPF = new SmartphoneTVElectronicsPF(driver);
        smartphoneTVElectronicsPF.telephones_button_click();

        telephones = new TelephonesPF(driver);
        telephones.smartphones_button_click();

        itemsPagePF = new ItemsPagePF(driver);
        List<WebElement> goodsList = itemsPagePF.goods_view_list;
        int goodsListSize = goodsList.size();

        meth.loadMore(driver);
        meth.loadMore(driver);
        List<WebElement> goods_title_list = itemsPagePF.goods_title_list;

//Write all presence title into EmailSending/SmartphoneTitles.txt
        String titlesFilePath = "EmailSending/SmartphoneTitles.txt";
        flib.writeIntoFile(goods_title_list, titlesFilePath);

//Get emails from file
        String[] emails = flib.fileReader("EmailSending/e-mail.txt");
//Send emails
        for (String el: emails){
            elib.emailSender(el, titlesFilePath);
        }
    }



}
