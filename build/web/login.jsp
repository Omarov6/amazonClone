
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlets.Login"%>
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
                        <h1 class="text-center mb-4">Login</h1>
                        <form action="Login" method="POST">
                            <div class="form-group">
                                <input name="email" type="email" placeholder="example@gmail.com" class="form-control" /> 
                            </div>
                            <div class="form-group">
                                <input name="pass" type="password" placeholder="********" class="form-control" /> 
                            </div>
                            <button class="btn btn-primary btn-block">Login</button>
                        </form>
                        <div class="form-group mt-4">
                            <a href="registrar.jsp" class="stretched-link text-primary mt-4">Registrarme</a>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
