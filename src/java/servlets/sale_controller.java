
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import models.product;
import database.connectionDB;
import models.Client;

public class sale_controller extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("name") != null) System.out.println(request.getParameter("name"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone = request.getParameter("phone");
        int nit = Integer.valueOf(request.getParameter("nit"));
        
        if(!connectionDB.userExist(name)){
            int id = connectionDB.getLastClientID() + 1;
            connectionDB.createClient(new Client(id, name, surname, phone, nit));
            connectionDB.createInvoice(connectionDB.getLastID()+1, id);
        }
        else{
            int id = connectionDB.getIdByName(name);
            connectionDB.createInvoice(connectionDB.getLastID()+1, id);
        }
        
        
        else{
            System.out.println("No se pudo obtener nada");
        }
        if(request.getSession().getAttribute("prds_buy") == null){
            System.out.println("No exite este campo lol");
        }
        else{
            ArrayList<product> prds_buy = (ArrayList<product>) request.getSession().getAttribute("prds_buy");
            if(prds_buy != null){
                System.out.println("Tamaño del arreglo: " + prds_buy.size());
            }
        }
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
