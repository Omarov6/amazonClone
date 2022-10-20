package models;

import java.util.ArrayList;

public class generadorProductos {

    public ArrayList<product_view> obtenerVista(ArrayList<product> prds) {
        ArrayList<product_view> resultado = new ArrayList<product_view>();
        ArrayList<product> aux = new ArrayList<product>();
        for (product prd : prds) {
            if (!existe(aux, prd.id)) {
                System.out.println("No existe");
                product_view prd_view = new product_view(prd.id, prd.name, prd.tag, prd.description, prd.price, contar(prds, prd.id));
                resultado.add(prd_view);
                aux.add(prd);
            }
        }
        return resultado;
    }

    public int contar(ArrayList<product> prds, int id) {
        int c = 0;
        for (product prd : prds) {
            if (prd.id == id) {
                c++;
            }
        }
        return c;
    }

    public boolean existe(ArrayList<product> prds, int id) {
        for(product p : prds){
            if(id == p.id) return true;
        }
        return false;
    }
}
