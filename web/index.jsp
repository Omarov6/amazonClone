
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlets.init"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style><%@include file="/WEB-INF/css/init.css"%></style>
    </head>
    <body>
        <form method="POST" action="init">
            <div class="container mt-4">
                <div class="row">
                    <div class="col-md-4 mx-auto">
                        <button class="btn btn-primary">Solicutar Tarjeta de Vacunacion</button>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
