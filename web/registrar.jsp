

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlets.reg_servlet"%>
<%@page import="servlets.prueba"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

    </head>
    <body>
        <div class="container" style="margin-top: 80px;">
            <div classs="row">
                <div class="col-md-5 mx-auto">
                    <div class="card-body">
                        <h1 class="text-center mb-4">Registro</h1>
                        <form action="reg_servlet" method="POST">
                            <div class="form-group">
                                <input name="name" type="text" placeholder="Fulanito" class="form-control" /> 
                            </div>
                            <div class="form-group">
                                <input name="surname" type="text" placeholder="De Tal" class="form-control" /> 
                            </div>
                            <div class="form-group">
                                <input name="phone" type="tel" placeholder="59622879" class="form-control" /> 
                            </div>
                            <div class="form-group">
                                <input name="email" type="email" placeholder="example@gmail.com" class="form-control" /> 
                            </div>
                            <div class="form-group">
                                <input name="pass" type="password" placeholder="********" class="form-control" /> 
                            </div>
                            <button class="btn btn-primary btn-block">Registrarme</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
