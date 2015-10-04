<%-- 
    Document   : index
    Created on : Dec 2, 2014, 9:39:33 AM
    Author     : Atayan, Lapidario, Sy
--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Evergrowth Garments Manufacturing Incorporated Inventory Management System</title>

        <!-- Bootstrap core CSS -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/signin.css" rel="stylesheet">

        <style>
            .img-responsive{
                max-width: 40%;
            }
            .width{
                width: 100px;
            }
            .width2{
                width: 180px;
            }
        </style>
    </head>

    <body>
    <center><img class="featurette-image img-responsive" src="Images/logo.png" alt="Hammerhead Logo">

        <img src="Images/motto.png" class="featurette-image img-responsive">

        <div class="container">
            <form class="form-signin" role="form" action="Login" method="POST" name="sign-in">
                <input type="text" name="username" placeholder="Email" class="form-control width2"/><br/>
                <input type="password" name="password" placeholder="Password" class="form-control width2"><br/>
                <input type="submit" class="btn btn-danger width" value="Sign-in"/><br/><br/>
                <a href="sign_up.jsp"><button type="button" class="btn btn-danger width"/>Sign-up</button></a><br/>
            </form>
        </div>

    </center>
</body>
</html>
