
package models;

public class product {
    public int id;
    public String name;
    public String tag;
    public String description;
    public double price;
    public int sub_category;
    public int suplier_id;
    public int season_id;
    public int cantidad;

    public product(int id, String name, String tag, String description, double price, int sub_category, int suplier_id, int cant) {
        this.id = id;
        this.name = name;
        this.tag = tag;
        this.description = description;
        this.price = price;
        this.sub_category = sub_category;
        this.suplier_id = suplier_id;
        this.season_id = season_id;
        this.cantidad = cant;
    }
    
    public product(int id, String name, String tag, String description, double price, int sub_category, int suplier_id) {
        this.id = id;
        this.name = name;
        this.tag = tag;
        this.description = description;
        this.price = price;
        this.sub_category = sub_category;
        this.suplier_id = suplier_id;
    }

    public product(int id, String name, String m,String description, double price, int cant) {
        this.id = id;
        this.tag = m;
        this.name = name;
        this.description = description;
        this.price = price;
        this.cantidad = cant;
    }
    
    
}
