package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.product;

public class connectionDB {

    public static Connection createConnection() {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String password = "1234";

        try {
            System.out.println("Connecting to DAtabase");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection.toString());
            System.out.println("Connection Success");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<product> getAllProducts() {
        try {
            Connection conn = createConnection();
            if (conn == null) {
                System.out.println("Problemas de conexion");
                return null;
            }
            Statement s;
            s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from producto");
            ArrayList<product> products = new ArrayList<product>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String n = rs.getString(2);
                String m = rs.getString(3);
                String d = rs.getString(4);
                double p = rs.getDouble(5);
                product nuevo = new product(id, n, m, d, p);
                products.add(nuevo);
            }
            return products;

        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ArrayList<String> getPhotoByProduct(int id) {
        try {
            Connection conn = createConnection();
            if (conn == null) {
                System.out.println("Problemas de conexion");
                return null;
            }
            Statement s;
            s = conn.createStatement();
            ResultSet rs = s.executeQuery("select FOTO from foto where PRODUCTO_ID='"+id+"'");
            ArrayList<String> images = new ArrayList<String>();
            while (rs.next()) {
                String img = rs.getString(1);
                images.add(img);
            }
            return images;

        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
