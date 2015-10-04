<%-- 
    Document   : CheckInventory
    Created on : 09 19, 15, 4:08:52 PM
    Author     : Geraldine
--%>

<%@page import="Model.InventoryReport"%>
<%@page import="Model.BoutiqueInventory"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="LevelOFAccess.jsp"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/tableBoarder.css">
        <title>Check Inventory</title>

        <script>
      </script>
    </head>


    <body>  
        <br/><br/><br/>
    <center><h2>Check Inventory</h2></center>
    <div>
        <!-- NOT SURE IF CORRECT POST METHOD?? PLACING -->
        <form method="POST" action="EncodeInventoryReportServlet" >
            <div align="center" class="container">
                <table class="table detailsWidth table-bordered">
                    <thead>
                        <tr>
                            <th rowspan="3" style="text-align: center; vertical-align: middle">Product ID</th>
                            <th colspan="5" style="text-align: center; vertical-align: middle">Stock</th>
                            <th colspan="5" style="text-align: center; vertical-align: middle">Requested</th>
                        </tr>
                        <tr>
                            <th colspan="4" style="text-align: center; vertical-align: middle">Size</th>
                            <th rowspan="2" style="text-align: center; vertical-align: middle">Total</th>
                            <th colspan="4" style="text-align: center; vertical-align: middle">Size</th>
                            <th rowspan="2" style="text-align: center; vertical-align: middle">Total</th>
                        </tr>
                        <tr>
                            <th style="text-align: center; vertical-align: middle">S</th>
                            <th style="text-align: center; vertical-align: middle">M</th>
                            <th style="text-align: center; vertical-align: middle">L</th>
                            <th style="text-align: center; vertical-align: middle">XL</th>
                            <th style="text-align: center; vertical-align: middle">S</th>
                            <th style="text-align: center; vertical-align: middle">M</th>
                            <th style="text-align: center; vertical-align: middle">L</th>
                            <th style="text-align: center; vertical-align: middle">XL</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                    </tbody>
                </table>

                <br/><br/>
                <input type="submit" style="width:77px; height:34px" class="btn btn-danger" value="Create Picking Form">
                <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
            </div>
        </form>
    </div>
    <script>


    </script>
</body>

</html>