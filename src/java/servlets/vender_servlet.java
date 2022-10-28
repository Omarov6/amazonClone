
package servlets;

import database.connectionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Proveedor;
import models.Sub;
import models.product;

/**
 *
 * @author alumno
 */
public class vender_servlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        double price = Double.valueOf(request.getParameter("price"));
        String desc = request.getParameter("description");
        String tag = request.getParameter("tag");
        String prov = request.getParameter("proveedor");
        String sub = request.getParameter("sub");
        String links = request.getParameter("image");
        ArrayList<Proveedor> arr_p = connectionDB.getProvedores();
        ArrayList<Sub> arr_s = connectionDB.getSubs();
        int id = 0;
        int id2 = 0;
        for(Proveedor prv : arr_p){
            if(prv.nombre.equalsIgnoreCase(prov)){
                id = prv.id;
            }
        }
        for(Sub s : arr_s){
            if(s.nombre.equalsIgnoreCase(sub)){
                id2 = s.id;
            }
        }
        int prd_id = connectionDB.getLastProductID()+1;
        product prd = new product(prd_id, name, tag, desc, price, id, id2);
        connectionDB.createProduct(prd);
        connectionDB.insertFoto(links, prd_id);
        System.out.println("INsertando producto lol");
        response.sendRedirect("index.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
