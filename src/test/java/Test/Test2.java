package Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import Library.Methods;
import PageFactories.CategoriesPages.HouseholdChemicalsPF;
import PageFactories.CategoriesPages.HouseholdProductsPF;
import PageFactories.CategoriesPages.SmartphoneTVElectronicsPF;
import PageFactories.CategoriesPages.TelephonesPF;
import PageFactories.ItemsPagePF;
import PageFactories.MainPagePF;
import ProjectSetup.MainVariables;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created by denys on 4/7/18.
 */
public class Test2 extends Pattern {
    MainVariables mv = new MainVariables();
    Methods meth = new Methods();

    MainPagePF mainPagePF;
    HouseholdChemicalsPF householdChemicalsPF;
    HouseholdProductsPF householdProductsPF;
    ItemsPagePF itemsPagePF;

    ///@Test
    public void SecondTask() throws SQLException {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rozetka?" +
                    "user=den&password=1234");


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Pro");
            System.out.println(rs.getArray(0));

            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...

            if (stmt.execute("SELECT * FROM Pro")) {
                rs = stmt.getResultSet();
            }

            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }

        }
    }

    //@Test
    public void SecondTask2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Connection con = null;
        ResultSet rs = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
        }
        try {
            con = DriverManager.getConnection(mv.dbUrl, "root", "035");
            statement = con.createStatement();
            System.out.println("OK");
            String ProductName = "po";
            int Price = 1233;
            statement.executeUpdate("insert into Goods (ProductName, Price) values ('" + ProductName + "' ," + Price + ")");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    public void writeIntoGoodsTable(String ProductName, int Price) {
        Connection con = null;
        ResultSet rs = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
        }
        try {
            con = DriverManager.getConnection(mv.dbUrl, "root", "035");
            statement = con.createStatement();
            statement.executeUpdate("insert into Goods (ProductName, Price) values ('" + ProductName + "' ," + Price + ")");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public void writeIntoGoodsTable(Collection ProductNameArray, Collection PriceArray) {
        Connection con = null;
        ResultSet rs = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
        }

        try {
            con = DriverManager.getConnection(mv.dbUrl, "root", "035");
            statement = con.createStatement();
            //statement.executeUpdate("insert into Goods (ProductName, Price) values ('" + ProductName + "' ," + Price + ")");


            System.out.println(ProductNameArray.size());
            System.out.println(PriceArray.size());
            Iterator it_price = PriceArray.iterator();
            Iterator it_title = ProductNameArray.iterator();
            while (it_price.hasNext()) {
                String name =it_title.next().toString();
                int price = Integer.parseInt(it_price.next().toString());

                statement.executeUpdate("insert into Goods (ProductName, Price) values ('" + name + "' ," + price + ")");
                System.out.println(it_title.next().toString());
                System.out.println(Integer.parseInt(it_price.next().toString()));

            }
        }
        catch(SQLException ex){
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        }



    @Test
    public void re(){
        driver.get("https://rozetka.com.ua");

        mainPagePF = new MainPagePF(driver);
        householdChemicalsPF = new HouseholdChemicalsPF(driver);
        householdProductsPF = new HouseholdProductsPF(driver);

        mainPagePF.household_products_click();
        householdProductsPF.household_chemicals_button_click();
        householdChemicalsPF.for_washing_button_click();

        for (int i=0; i<4; i++){
            meth.loadMore(driver);
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
//Covert price string to int
            String s = list_price.get(i).getText().substring(0, list_price.get(i).getText().length()-4);
//Add data to collections
            if(Integer.parseInt(s) < 100 || Integer.parseInt(s) > 300)
                continue;
            col_title.add(list_title.get(i).getText());
            col_price.add(Integer.parseInt(s));
        }
        writeIntoGoodsTable(col_title, col_price);
        /**
        Iterator it_price = col_price.iterator();
        Iterator it_title = col_title.iterator();


        while(it_price.hasNext()){
            writeIntoGoodsTable(it_title.next().toString(), Integer.parseInt(it_price.next().toString()));
            System.out.println(it_title.next().toString());
            System.out.println(Integer.parseInt(it_price.next().toString()));

        }
         */





    }

}
