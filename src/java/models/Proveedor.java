
package models;


public class Proveedor {
    public int id;
    public String nombre;
    public String telefono;
    public String correo;

    public Proveedor(int id, String nombre, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }
    
}
