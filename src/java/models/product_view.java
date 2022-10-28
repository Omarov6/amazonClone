package models;

public class product_view extends product{
    
    public int cantidad;
    public product_view(int id, String name, String m, String description, double price, int cantidad) {
        super(id, name, m, description, price, cantidad);
        this.cantidad = cantidad;
    }
}
