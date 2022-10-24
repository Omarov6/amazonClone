
package models;


public class Client {
    public int id;
    public String name;
    public String surname;
    public String phone;
    public int nit;

    public Client(int id, String name, String surname, String phone, int nit) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.nit = nit;
    }
    
}
