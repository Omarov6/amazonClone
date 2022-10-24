package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.product;

public class increment extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("product");
        System.out.println("ID recibido: " + id);
        ArrayList<product> prds = (ArrayList<product>) request.getSession().getAttribute("products");
        ArrayList<product> prds_buy = (ArrayList<product>) request.getSession().getAttribute("prds_buy");
        if (prds != null) {
            System.out.println("entramos al if");
            for (product prd : prds) {
                System.out.println("entramos al for");
                if (Integer.valueOf(id) == prd.id) {
                    System.out.println("entramos al if de agregar");
                    prds_buy.add(prd);
                }
            }
        }
        else{
            System.out.println("No se pudo entrar ptm");
        }
        request.getSession().invalidate();
        request.getSession().setAttribute("prds_buy", prds_buy);
        request.getSession().setAttribute("products", prds);
        RequestDispatcher rd = request.getRequestDispatcher("carrito.jsp");
        rd.forward(request, response);
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
