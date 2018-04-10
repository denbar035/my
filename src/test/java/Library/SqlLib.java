package Library;

import ProjectSetup.MainVariables;

import java.sql.*;

/**
 * Created by denys on 4/10/18.
 */
public class SqlLib {

    MainVariables mv = new MainVariables();

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
}
