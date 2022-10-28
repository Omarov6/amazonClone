
<%@page import="models.Categoria"%>
<%@page import="database.connectionDB"%>
<%@page import="database.secondController"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlets.init"%>
<%@page import="models.product"%>
<%@page import="servlets.Login"%>
<%@page import="servlets.filter_page"%>
<%@page import="servlets.filterProduct"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RapiCompras</title>
        <style><%@include file="/WEB-INF/css/init.css"%></style>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <%request.getRequestDispatcher("init").include(request, response);%>
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
            <form class="form-inline my-2 my-lg-0" action="filterProduct" method="POST">
                <input class="form-control" name="name" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success ml-1" >Search</button>
            </form>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Productos
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <%
                                ArrayList<Categoria> arr_c = secondController.getCats();
                                for (Categoria cat : arr_c) {
                                    out.println("<a class='dropdown-item' href='filter_page?id=" + cat.id + "'>" + cat.nombre + "</a>");
                                }
                            %>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Admin</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Vender</a>
                    </li>
                    <li class="nav-item">
                        <%
                            if (null != request.getSession().getAttribute("prds_buy")) {
                                ArrayList<product> b_prd = (ArrayList<product>) request.getSession().getAttribute("prds_buy");
                                out.println("<a class='nav-link' href='carrito.jsp'>Carrito " + b_prd.size() + " </a>");
                            } else {
                                out.println("<a class='nav-link' href='carrito.jsp'>Carrito</a>");
                            }
                        %>
                    </li>
                </ul>

            </div>
        </nav>

        <div class="container">

            <div class="row">
                <%
                    ArrayList<product> prds = (ArrayList<product>) request.getSession().getAttribute("products");
                    if (request.getSession().getAttribute("id") != null) {
                        ArrayList<product> aux = prds;
                        int cat_id = (int) request.getSession().getAttribute("id");
                        int index = 0;
                        for (product x : prds) {
                            if (x.sub_category != cat_id) {
                                aux.remove(index);
                            }
                            index++;
                        }
                        prds = aux;
                    }
                    

                    if (prds != null) {
                        for (product prd : prds) {
                            ArrayList<String> images = connectionDB.getPhotoByProduct(prd.id);
                %>


                <div class="col">
                    <div id="carouselExampleControls<% out.print(prd.id); %>" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <%
                                int cont = 0;
                                for (String img : images) {
                                    if (cont == 0) {
                            %>

                            <div class="carousel-item active">
                                <div class="card">
                                    <img src="<% out.println(img); %>" class="card-img-top w-100 bg-dark img" alt="...">
                                    <div class="card-body">
                                        <h5 class="card-title"><% out.println(prd.name); %></h5>
                                        <p class="card-text"><% out.println(prd.description); %></p>
                                        <p class="card-text price"> <b>Q.<% out.println(prd.price);%></b> </p>
                                        <a class="btn btn-success btn-block" href="products_controller?product=<%=prd.id%>">Agregar al Carrito</a>
                                    </div>
                                </div>
                            </div>
                            <%
                                cont++;
                            } else {
                            %>  
                            <div class="carousel-item">
                                <div class="card">
                                    <img src="<% out.println(img); %>" class="card-img-top w-100 bg-dark img" alt="...">
                                    <div class="card-body">
                                        <h5 class="card-title"><% out.println(prd.name); %></h5>
                                        <p class="card-text"><% out.println(prd.description); %></p>
                                        <p class="card-text price"> <b>Q.<% out.println(prd.price);%></b> </p>
                                        <a class="btn btn-success btn-block" href="products_controller?product=<%=prd.id%>">Agregar al Carrito</a>
                                    </div>
                                </div>
                            </div>
                            <%
                                    }
                                }
                            %>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleControls<% out.print(prd.id); %>" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleControls<% out.print(prd.id); %>" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>




                <%
                        }
                    } else {
                        out.println("<p> No se mostraron los productos </p>");
                    }
                %>
            </div>
        </div>













        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    </body>
</html>
