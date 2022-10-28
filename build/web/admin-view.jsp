

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Carrito"%>
<%@page import="database.secondController"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    </head>
    <body>
        <div class="container" style="margin-top: 80px;">
            <div class="row">
                <div class="col-md-8  mx-auto">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Producto ID</th>
                                <th scope="col">Cantidad</th>
                                <th scope="col">Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Carrito> c = secondController.getCarrito();
                                for (Carrito car : c) {
                                    out.println("<tr>");
                                    out.println("<th scope='row'>" + car.id + "</th>");
                                    out.println("<td>" + car.id_prd + "</td>");
                                    out.println("<td>" + car.cantidad + "</td>");
                                    out.println("<td>" + car.total + "</td>");
                                    out.println("</tr>");
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
