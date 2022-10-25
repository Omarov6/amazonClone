
package models;

import java.sql.Date;


public class Venta{
    public int id;
    public Date fecha;
    public int id_producto;
    public int id_factura;
    public int id_usuario;

    public Venta(int id, int id_producto, int id_factura) {
        this.id = id;
        this.fecha = fecha;
        this.id_producto = id_producto;
        this.id_factura = id_factura;
        this.id_usuario = id_usuario;
    }
    
}