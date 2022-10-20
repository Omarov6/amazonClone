

<%@page import="models.product_view"%>
<%@page import="models.generadorProductos"%>
<%@page import="database.connectionDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos en el carrito</title>
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
                        <a class="nav-link" href="index.jsp">Agregar mas productos</a>
                    </li>
                </ul>

            </div>
        </nav>
        <%
            ArrayList<product> prds = (ArrayList<product>) request.getSession().getAttribute("prds_buy");
            if (prds == null) {
                out.print("<p>No hay ningun producto agregado al carrito</p>");
            } else {
                int total_pagar = 0;
        %>
        <div class="container" style="margin-top: 120px;">
            <div class="row">
                <div class="col">


                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col"></th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Cantidad</th>
                                <th scope="col">Descripcion</th>
                                <th scope="col">Acciones</th>
                                <th scope="col">Precio</th>
                            </tr>
                        </thead>
                        <tbody >
                            <%
                                generadorProductos gp = new generadorProductos();
                                ArrayList<product_view> productos = gp.obtenerVista(prds);
                                for (product_view prd : productos) {
                                    total_pagar += prd.price;
                                    ArrayList<String> images = connectionDB.getPhotoByProduct(prd.id);
                                    out.print("<tr>");
                                    out.print("<th scope='row'><img src='" + images.get(0) + "' width='100' ></th>");
                                    out.print("<th>" + prd.name + "</th>");
                                    out.print("<th>" + prd.cantidad + "</th>");
                                    out.print("<td>" + prd.description + "</td>");
                                    out.print("<td> <a class='btn btn-primary' href='increment?product="+prd.id+"'>+</a> <a class='btn btn-danger' href='decrement?product="+prd.id+"'>-</a></td>");
                                    out.print("<td>Q." + prd.price + "</td>");
                                    out.print("</tr>");
                                }
                                out.print("<tr>");
                                out.print("<th scope='row'> Total a Pagar </th>");
                                out.print("<th> --------------------- </th>");
                                out.print("<td> --------------------- </td>");
                                out.print("<td> --------------------- </td>");
                                out.print("<td> --------------------- </td>");
                                out.print("<td> <b>Q." + total_pagar + "</b></td>");
                                out.print("</tr>");
                            %>
                        </tbody>
                    </table>
                    <%
                        }
                    %>
                    <div class="form-group">
                        <button class="btn btn-success ">Realizar Compra</button>
                    </div>
                </div>
            </div>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    </body>
</html>
