
package database;

import static database.connectionDB.createConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Carrito;
import models.Categoria;
import models.Sub;

public class secondController {
    public static Connection createConnection() {
        return connectionDB.createConnection();
    }
    
    public static ArrayList<Categoria> getCats() {

        ArrayList<Categoria> pr = new ArrayList<Categoria>();
        try {
            Connection conn = createConnection();
            if (conn == null) {
                System.out.println("Problemas de conexion");
                return null;
            }
            Statement s;
            s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from SUBCATEGORIA");

            while(rs.next()) {
                int id = rs.getInt(1);
                String n = rs.getString(2);
                Categoria sub = new Categoria(id, n);
                pr.add(sub);
            }

            return pr;

        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public static ArrayList<Carrito> getCarrito() {

        ArrayList<Carrito> cr = new ArrayList<Carrito>();
        try {
            Connection conn = createConnection();
            if (conn == null) {
                System.out.println("Problemas de conexion");
                return null;
            }
            Statement s;
            s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from CARRITO");

            while(rs.next()) {
                int id = rs.getInt(1);
                int c = rs.getInt(2);
                double total = rs.getDouble(3);
                int prd = rs.getInt(4);
                Carrito car = new Carrito(id, c, total, prd);
                cr.add(car);
            }

            return cr;

        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
