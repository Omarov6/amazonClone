

<%@page import="database.connectionDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos en el carrito</title>
    </head>
    <body>
        <p>pagina para mostrar carrito</p>
        <%
            ArrayList<product> prds = (ArrayList<product>) request.getSession().getAttribute("prds_buy");
            if (prds == null) {
                out.print("<p>No hay ningun producto agregado al carrito</p>"); 
            } else {
                for (product prd : prds) {
                    out.println("<p>"+ prd.name +"</p>");
                }
            }
        %>

    </body>
</html>
