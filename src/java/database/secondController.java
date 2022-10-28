
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
import models.Categoria;
import models.Sub;

public class secondController {
    public static Connection createConnection() {
        String url = "jdbc:oracle:thin:@localhost:1521:umg";
        String user = "system";
        String password = "Umg$19";

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
            ResultSet rs = s.executeQuery("select * from CATEGORIA");

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
}
