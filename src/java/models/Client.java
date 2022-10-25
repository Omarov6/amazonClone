
package models;


public class Client {
    public int id;
    public String name;
    public String surname;
    public String phone;
    public String nit;

    public Client(int id, String name, String surname, String phone, String nit) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.nit = nit;
    }
    
}
