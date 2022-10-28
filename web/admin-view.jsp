

<%@page import="models.product"%>
<%@page import="database.connectionDB"%>
<%@page import="database.connectionDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Carrito"%>
<%@page import="database.secondController"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style><%@include file="/WEB-INF/css/init.css"%></style>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">
                <img src="https://cdn-icons-png.flaticon.com/512/181/181591.png" width="30" height="30" class="d-inline-block align-top" alt="">
                RapiCompras
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success ml-1" type="submit">Search</button>
            </form>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp">Volver</a>
                    </li>
                </ul>

            </div>
        </nav>




        <div class="container" style="margin-top: 80px;">
            <div class="row">
                <div class="col-md-8  mx-auto">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Producto ID</th>
                                <th scope="col">Producto</th>
                                <th scope="col">Vendidos</th>
                                <th scope="col">Stock</th>
                                <th scope="col">Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Carrito> c = secondController.getCarrito();
                                ArrayList<product> pr = connectionDB.getAllProducts();
                                for (Carrito car : c) {
                                    out.println("<tr>");
                                    out.println("<th scope='row'>" + car.id + "</th>");
                                    out.println("<td>" + car.id_prd + "</td>");
                                    for (product p : pr) {
                                        if (p.id == car.id_prd) {
                                            out.println("<td>" + p.name + "</td>");
                                            out.println("<td>" + car.cantidad + "</td>");
                                            out.println("<td>" + p.cantidad + "</td>");
                                        }
                                    }
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
