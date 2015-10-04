<%-- 
    Document   : sign_up
    Created on : 10 2, 15, 8:13:06 PM
    Author     : Geraldine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/signin.css" rel="stylesheet">
        <title>Sign Up</title>

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
        <div align="center">
            <img class="featurette-image img-responsive" src="Images/logo.png" alt="Hammerhead Logo">
            <h2 style="font-family: Calibri Light">Sign Up</h2><br/>

            <form class="form-inline" role="form" action="SignUp" method="POST" name="sign-up">
                <input type="text" name="firstName" placeholder="First Name" class="form-control width2"/>
                <input type="text" name="lastName" placeholder="Last Name" class="form-control width2"/><br/><br/>
                <input type="text" name="email" placeholder="Email Address" class="form-control width2"/>
                <input type="password" name="newPassword" placeholder="Password" class="form-control width2"><br/><br/>
                <input type="date" name="birthDate" class="form-control" style="width:205px"/><br/><br/>
                <input type="text" name="verCode" placeholder="Verification Code" class="form-control" style="height:50px"/><br/>
                <i>Please input a valid verification <br/>
                    code given to you.</i><br/><br/>
                <input type="submit" class="btn btn-danger width" value="Sign-up"/><br/><br/>
                <a href="index.jsp"><button type="button" class="btn btn-danger width"/>Cancel</button></a><br/>
            </form>
        </div>


    </body>
</html>
