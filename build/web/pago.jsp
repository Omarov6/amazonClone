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
                            <input type="tel" id="card" onkeypress='return formats(this, event)' onkeyup="return numberValidation(event)" class="form-control" placeholder="0000 0000 0000 0000" />
                        </div>
                        <label htmlFor="">Fecha</label>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="09/10" onkeyup="formatString(event);"  maxlength="5"/>
                        </div>
                        <label htmlFor="">CCV</label>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="658"  maxlength="3"/>
                        </div>
                        <button class='btn btn-success btn-block' onclick="confirmCard()" >Realizar Pago</button>
                    </div>
                </div>
            </div>

        </div>

        <script>
            
            function confirmCard(){
                var number = document.getElementById("card").value
                number = number.replace(/\s/g, '');
                if(!validateCardNumber(number)){
                    alert("No es valido lol");
                    document.getElementById("card").value = ""
                }
            }
            
            function formats(ele, e) {
                if (ele.value.length < 19) {
                    ele.value = ele.value.replace(/\W/gi, '').replace(/(.{4})/g, '$1 ');
                    return true;
                } else {
                    return false;
                }
            }

            function numberValidation(e) {
                e.target.value = e.target.value.replace(/[^\d ]/g, '');
                return false;
            }

            function formatString(e) {
                var inputChar = String.fromCharCode(event.keyCode);
                var code = event.keyCode;
                var allowedKeys = [8];
                if (allowedKeys.indexOf(code) !== -1) {
                    return;
                }

                event.target.value = event.target.value.replace(
                        /^([1-9]\/|[2-9])$/g, '0$1/' // 3 > 03/
                        ).replace(
                        /^(0[1-9]|1[0-2])$/g, '$1/' // 11 > 11/
                        ).replace(
                        /^([0-1])([3-9])$/g, '0$1/$2' // 13 > 01/3
                        ).replace(
                        /^(0?[1-9]|1[0-2])([0-9]{2})$/g, '$1/$2' // 141 > 01/41
                        ).replace(
                        /^([0]+)\/|[0]+$/g, '0' // 0/ > 0 and 00 > 0
                        ).replace(
                        /[^\d\/]|^[\/]*$/g, '' // To allow only digits and `/`
                        ).replace(
                        /\/\//g, '/' // Prevent entering more than 1 `/`
                        );
            }


            const validateCardNumber = number => {
                //Check if the number contains only numeric value  
                //and is of between 13 to 19 digits
                const regex = new RegExp("^[0-9]{13,19}$");
                if (!regex.test(number)) {
                    return false;
                }

                return luhnCheck(number);
            }

            const luhnCheck = val => {
                let checksum = 0; // running checksum total
                let j = 1; // takes value of 1 or 2

                // Process each digit one by one starting from the last
                for (let i = val.length - 1; i >= 0; i--) {
                    let calc = 0;
                    // Extract the next digit and multiply by 1 or 2 on alternative digits.
                    calc = Number(val.charAt(i)) * j;

                    // If the result is in two digits add 1 to the checksum total
                    if (calc > 9) {
                        checksum = checksum + 1;
                        calc = calc - 10;
                    }

                    // Add the units element to the checksum total
                    checksum = checksum + calc;

                    // Switch the value of j
                    if (j == 1) {
                        j = 2;
                    } else {
                        j = 1;
                    }
                }

                //Check if it is divisible by 10 or not.
                return (checksum % 10) == 0;
            }
        </script>
    </body>
</html>
