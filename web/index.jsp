
<%@page import="database.connectionDB"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlets.init"%>
<%@page import="models.product"%>
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
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success ml-1" type="submit">Search</button>
            </form>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Registrarse</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/carrito">Carrito</a>
                    </li>
                </ul>

            </div>
        </nav>


        <%
            ArrayList<product> prds = (ArrayList<product>) request.getSession().getAttribute("products");

            if (prds != null) {
                for (product prd : prds) {
                    ArrayList<String> images = connectionDB.getPhotoByProduct(prd.id);
        %>
        <div class="container my-4 w-50">

            <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                <!-- Diapositivas -->
                <div class="carousel-inner">
                    <%
                        int cont = 0;
                        for (String img : images) {
                        if(cont == 0){
                    %>
                       
                        <div class="carousel-item active">
                            <div class="card h-100">
                                <img src="<% out.println(img); %>" class="card-img-top w-100 bg-dark" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title"><% out.println(prd.name); %></h5>
                                    <p class="card-text"><% out.println(prd.description); %></p>
                                    <p class="card-text price"> <b>Q.<% out.println(prd.price); %></b> </p>
                                    <button class="btn btn-success btn-block">Comprar</button>
                                </div>
                            </div>
                        </div>
                    <%
                        cont++;
                        }else{
                    %>  
                        <div class="carousel-item">
                            <div class="card h-100">
                                <img src="<% out.println(img); %>" class="card-img-top w-100 bg-dark" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title"><% out.println(prd.name); %></h5>
                                    <p class="card-text"><% out.println(prd.description); %></p>
                                    <p class="card-text price"> <b>Q.<% out.println(prd.price); %></b> </p>
                                    <button class="btn btn-success btn-block">Comprar</button>
                                </div>
                            </div>
                        </div>
                    <% 
                        }
                       }
                    %>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>

        </div>
        <%
            }

            }else{
                out.println("<p> No se mostraron los productos </p>");
            }
           
        %>















        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    </body>
</html>
