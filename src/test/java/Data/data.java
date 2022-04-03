package data;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class data {
    Connection conn = null;

    public static ResultSet loadfromDatabase(){
        java.sql.Connection conn = null;
        ResultSet rs = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/automationdb","root","password");
            String strQuery = "Select * from booking";
            Statement stmt = conn.createStatement();

            rs = stmt.executeQuery(strQuery);

            //rs.next();
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rs;
    }


}
