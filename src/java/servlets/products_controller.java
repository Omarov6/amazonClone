
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


public class products_controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String id = request.getParameter("product");
            ArrayList<product> prds = (ArrayList<product>) request.getSession().getAttribute("products");
            ArrayList<product> prds_buy;
            if(request.getSession().getAttribute("prds_buy") == null){
                prds_buy = new ArrayList<product>();
            }
            else{
                prds_buy = (ArrayList<product>) request.getSession().getAttribute("prds_buy");
            }
            if(prds != null){
                for(product prd : prds){
                    if(Integer.valueOf(id) == prd.id){
                        prds_buy.add(prd);
                    }
                }
            }
            
            System.out.println("Tamaño del nuevo arreglo: " + prds_buy.size());
            request.getSession().invalidate();
            request.getSession().setAttribute("prds_buy", prds_buy);
            RequestDispatcher rd =  request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            //request.setAttribute("prd_buy", prds_buy);
            //response.sendRedirect("index.jsp");
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
