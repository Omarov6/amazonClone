package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import models.product;
import database.connectionDB;
import models.Client;
import models.Venta;

public class sale_controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("name") != null) {
            System.out.println(request.getParameter("name"));
        }
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone = request.getParameter("phone");
        String nit = (String)request.getParameter("nit");

        if (!connectionDB.userExist(name)) {
            int id = connectionDB.getLastClientID() + 1;
            int invoice_id = connectionDB.getLastID() + 1;
            connectionDB.createClient(new Client(id, name, surname, phone, nit));
            connectionDB.createInvoice(invoice_id, id);
            ArrayList<product> prds_buy = (ArrayList<product>) request.getSession().getAttribute("prds_buy");
            System.out.println("prdocutos: " + prds_buy.size());
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            for (product prd : prds_buy) {
                connectionDB.createSale(new Venta(connectionDB.getLastSaleID()+1,  prd.id, invoice_id));
                double pr = prd.price;
                if(connectionDB.getPrice(prd.id) != 0){
                    pr = (float) (prd.price - (connectionDB.getPrice(prd.id)*prd.price));
                }
                connectionDB.createCarrito(connectionDB.getLastCarritotID()+1,1, (float) pr, prd.id);
            }
        } else {
            int id = connectionDB.getIdByName(name);
            int invoice_id = connectionDB.getLastID() + 1;
            connectionDB.createInvoice(invoice_id, id);
            ArrayList<product> prds_buy = (ArrayList<product>) request.getSession().getAttribute("prds_buy");
            System.out.println("prdocutos: " + prds_buy.size());
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            for (product prd : prds_buy) {
                connectionDB.createSale(new Venta(connectionDB.getLastSaleID()+1,  prd.id, invoice_id));
                double pr = prd.price;
                if(connectionDB.getPrice(prd.id) != 0){
                    System.out.println("Descuento: " + connectionDB.getPrice(prd.id));
                    pr = (float) (prd.price - (connectionDB.getPrice(prd.id)*prd.price));
                }
                connectionDB.createCarrito(connectionDB.getLastCarritotID()+1,1, (float) pr, prd.id);
            }
        }
        request.getSession().removeAttribute("prds_buy");
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
