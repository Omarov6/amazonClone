
package models;


public class Carrito {
    public int id;
    public int cantidad;
    public double total;
    public int id_prd;

    public Carrito(int id, int cantidad, double total, int id_prd) {
        this.id = id;
        this.cantidad = cantidad;
        this.total = total;
        this.id_prd = id_prd;
    }
    
}
