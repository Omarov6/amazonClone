package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Client;
import models.Proveedor;
import models.Sub;
import models.Venta;
import models.product;

public class connectionDB {

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
            ResultSet rs = s.executeQuery("select FOTO from foto where PRODUCTO_ID='" + id + "'");
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

    public static int getLastClientID() {
        try {
            Connection conn = createConnection();
            if (conn == null) {
                System.out.println("Problemas de conexion");
                return -1;
            }
            Statement s;
            s = conn.createStatement();
            ResultSet rs = s.executeQuery("select CLIENTE.ID from CLIENTE ORDER BY ID DESC FETCH FIRST 1 ROWS ONLY");
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            return id;

        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public static int getLastUserID() {
        try {
            Connection conn = createConnection();
            if (conn == null) {
                System.out.println("Problemas de conexion");
                return -1;
            }
            Statement s;
            s = conn.createStatement();
            ResultSet rs = s.executeQuery("select USUARIO.ID from USUARIO ORDER BY ID DESC FETCH FIRST 1 ROWS ONLY");
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            return id;

        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int getLastID() {

        try {
            Connection conn = createConnection();
            if (conn == null) {
                System.out.println("Problemas de conexion");
                return -1;
            }
            Statement s;
            s = conn.createStatement();
            ResultSet rs = s.executeQuery("select FACTURA.ID from FACTURA ORDER BY ID DESC FETCH FIRST 1 ROWS ONLY");
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            return id;

        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static int getLastSaleID() {

        try {
            Connection conn = createConnection();
            if (conn == null) {
                System.out.println("Problemas de conexion");
                return -1;
            }
            Statement s;
            s = conn.createStatement();
            ResultSet rs = s.executeQuery("select VENTA.ID from VENTA ORDER BY ID DESC FETCH FIRST 1 ROWS ONLY");
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            return id;

        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static boolean userExist(String ref) {
        try {
            Connection conn = createConnection();
            if (conn == null) {
                System.out.println("Problemas de conexion");
                return false;
            }
            Statement s;
            s = conn.createStatement();
            ResultSet rs = s.executeQuery("select CLIENTE.NOMBRE from CLIENTE");

            while (rs.next()) {
                String name = rs.getString(1);
                if (name.equalsIgnoreCase(ref)) {
                    return true;
                }
            }

            return false;

        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static int getIdByName(String ref) {
        try {
            Connection conn = createConnection();
            if (conn == null) {
                System.out.println("Problemas de conexion");
                return -1;
            }
            Statement s;
            s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from CLIENTE");

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                if (name.equalsIgnoreCase(ref)) {
                    return id;
                }
            }

            return -1;

        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static void createInvoice(int id, int client) {

        try {
            Connection conn = createConnection();
            Statement stmt;
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO FACTURA(ID, CLIENTE_ID)values('" + id + "', '" + client + "')";
            stmt.executeUpdate(query1);
        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void createClient(Client client) {

        try {
            Connection conn = createConnection();
            Statement stmt;
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO CLIENTES(ID, NOMBRE, APELLIDO, TELEFONO, NIT)values";
            query1 += "('" + client.id + "', '" + client.name + "', '" + client.surname + "', '" + client.phone + "', '" + client.nit + "');";
            stmt.executeUpdate(query1);
        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static float getPrice(int id) {

        try {
            Connection conn = createConnection();
            if (conn == null) {
                System.out.println("Problemas de conexion");
                return 0;
            }
            Statement s;
            s = conn.createStatement();
            ResultSet rs = s.executeQuery("select DESCUENTO.PORCENTAJE from DESCUENTO WHERE id_producto='"+id+"' and f_inicio >=SYSDATE and f_final <= SYSDATE");

            if(rs.next()) {
                return rs.getFloat(1);
            }

            return 0;

        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void createSale(Venta sale) {
        try {
            Connection conn = createConnection();
            Statement stmt;
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO VENTA(ID, PRODUCTO_ID, FACTURA_ID, FECHA_VENTA)values ('" + sale.id + "', '" + sale.id_producto + "', '" + sale.id_factura + "', SYSDATE)";
            stmt.executeUpdate(query1);
        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void createCarrito(int id, int c, float t, int p_id) {
        try {
            Connection conn = createConnection();
            Statement stmt;
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO CARRITO(ID, CANTIDAD, TOTAL, PRODUCTO_ID)values ('"+id+"', '"+c+"', '"+t+"', '"+p_id+"')";
            stmt.executeUpdate(query1);
        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    

    public static boolean userExist(String email, String pass) {

        try {
            Connection conn = createConnection();
            if (conn == null) {
                System.out.println("Problemas de conexion");
                return false;
            }
            Statement s;
            s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from USUARIO WHERE MAIL='"+email+"' AND CONTRASENIA='"+pass+"'");

            if(rs.next()) {
                return true;
            }

            return false;

        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static void createUser(int id, String name, String surname, String phone, String email, String pass) {

        try {
            Connection conn = createConnection();
            Statement stmt;
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO USUARIO(ID, NOMBRE, APELLIDO, TELEFONO, MAIL, CONTRASENIA)values";
            query1 += "('"+id+"', '"+name+"', '"+surname+"', '"+phone+"', '"+email+"', '"+pass+"')";
            stmt.executeUpdate(query1);
        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<Proveedor> getProvedores() {

        ArrayList<Proveedor> pr = new ArrayList<Proveedor>();
        try {
            Connection conn = createConnection();
            if (conn == null) {
                System.out.println("Problemas de conexion");
                return null;
            }
            Statement s;
            s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from PROVEEDOR");

            while(rs.next()) {
                int id = rs.getInt(1);
                String n = rs.getString(2);
                String t = rs.getString(3);
                String c = rs.getString(4);
                Proveedor p = new Proveedor(id, n, t , c);
                pr.add(p);
            }

            return pr;

        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ArrayList<Sub> getSubs() {

        ArrayList<Sub> pr = new ArrayList<Sub>();
        try {
            Connection conn = createConnection();
            if (conn == null) {
                System.out.println("Problemas de conexion");
                return null;
            }
            Statement s;
            s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from SUBCATEGORIA ");

            while(rs.next()) {
                int id = rs.getInt(1);
                String n = rs.getString(2);
                int t = rs.getInt(3);
                Sub sub = new Sub(id, n, t);
                pr.add(sub);
            }

            return pr;

        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static int getLastCarritotID() {

        try {
            Connection conn = createConnection();
            if (conn == null) {
                System.out.println("Problemas de conexion");
                return -1;
            }
            Statement s;
            s = conn.createStatement();
            ResultSet rs = s.executeQuery("select CARRITO.ID from CARRITO ORDER BY ID DESC FETCH FIRST 1 ROWS ONLY");
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            return id;

        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public static int getLastProductID() {

        try {
            Connection conn = createConnection();
            if (conn == null) {
                System.out.println("Problemas de conexion");
                return -1;
            }
            Statement s;
            s = conn.createStatement();
            ResultSet rs = s.executeQuery("select PRODUCT.ID from PRODUCT ORDER BY ID DESC FETCH FIRST 1 ROWS ONLY");
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            return id;

        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public static int getLastFOTOID() {

        try {
            Connection conn = createConnection();
            if (conn == null) {
                System.out.println("Problemas de conexion");
                return -1;
            }
            Statement s;
            s = conn.createStatement();
            ResultSet rs = s.executeQuery("select FOTO.ID from FOTO ORDER BY ID DESC FETCH FIRST 1 ROWS ONLY");
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            return id;

        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public static void createProduct(product p) {

        try {
            Connection conn = createConnection();
            Statement stmt;
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO PRODUCTO(ID, NOMBRE, MARCA, DESCRIPCION, PRECIO, SUBCATEGORIAID, PROVEEDOR_ID)values";
            query1 += "('"+p.id+"', '"+p.name+"', '"+p.tag+"', '"+p.description+"', '"+p.price+"', '"+p.sub_category+"', '"+p.suplier_id+"')";
            stmt.executeUpdate(query1);
        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insertFoto(String link, int ID) {

        try {
            Connection conn = createConnection();
            Statement stmt;
            stmt = (Statement) conn.createStatement();
            int id = getLastFOTOID() + 1;
            String query1 = "INSERT INTO FOTO(ID, FOTO, PRODUCTO_ID)VALUES('"+id+"','"+link+"', '"+ID+"')";
            stmt.executeUpdate(query1);
        } catch (SQLException ex) {
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
