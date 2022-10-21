<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de pago</title>
        <style><%@include file="/WEB-INF/css/init.css"%></style>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    </head>
    <body>
        <div>
            
            <div class="container" style="margin-top: 180px;">
                <div class="row">
                    <div class="col-md-5 mx-auto">
                        <label htmlFor="">Numero de la tarjeta</label>
                        <div class="form-group">
                            <input type="tel" class="form-control" placeholder="0000 0000 0000 0000" />
                        </div>
                        <label htmlFor="">Numero de la tarjeta</label>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Fecha de Expiracion" />
                        </div>
                        <label htmlFor="">Numero de la tarjeta</label>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="CVV"/>
                        </div>
                        <button class='btn btn-success btn-block'>Realizar Pago</button>
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>
