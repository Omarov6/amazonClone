

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="database.connectionDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Proveedor"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

    </head>
    <body>
        <div class="container" style="margin-top: 80px;">
            <div classs="row">
                <div class="col-md-5 mx-auto">
                    <div class="card-body">
                        <h1 class="text-center mb-4">Formulario de Venta</h1>
                        <form action="/reg_servlet" method="POST">
                            <div class="form-group">
                                <input name="name" type="text" placeholder="Nombre del Producto" class="form-control" /> 
                            </div>
                            <div class="form-group">
                                <textarea name="description" placeholder="Descripcion" class="form-control"></textarea> 
                            </div>
                            <div class="form-group">
                                <input name="price" type="text" placeholder="Precio" class="form-control" /> 
                            </div>
                            <div class="form-group">
                                <input name="tag" type="text" placeholder="Marca" class="form-control" /> 
                            </div>
                            <div class="form-group">
                                <label class="control-label">Proveedor</label>
                                <select class="form-control">
                                    <%
                                        ArrayList<Proveedor> proveedores = connectionDB.getProvedores();
                                        for(Proveedor p : proveedores){
                                            out.println("<option>"+p.nombre+"</option>");
                                        }
                                    %>
                                </select>
                            </div>
                            <button class="btn btn-success btn-block">Registrar Producto</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
