
package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionDB {
    public static Connection createConnection(){
       String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user ="system";
        String password = "1234";
        
        try {
            System.out.println("Connecting to DAtabase");
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println( connection.toString());
            System.out.println("Connection Success");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
   }
}
