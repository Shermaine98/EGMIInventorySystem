<%-- 
    Document   : ViewInventoryReport
    Created on : 09 19, 15, 4:05:35 PM
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
        <title>View Inventory Report</title>
    </head>
    <body>  
        <br/><br/><br/>
    <center><h2>View Inventory Report</h2></center>

    <div align="center">
        <table class="table table-bordered" style="width:35%">
            <colgroup>
                <col style="width:40%"/>
            </colgroup>
            <thead>
                <tr>
                    <th>Outlet</th>
                    <td><input type="text" class="input" name="outlet" value="AUTO" readonly/></td>
                </tr><tr>
                    <th>Promo</th>
                    <td><input type="text" class="input" name="promo"  readonly value="AUTO"/></td>  
                </tr><tr>
                    <th>Date Made</th>
                    <td><input type="text" class="input" name="dateMade"  readonly value="auto" /></td>                 
                </tr>
            </thead>
        </table>
    </div>

    <div align="center"><table id="dataTable" class="table width table-bordered">
            <thead>
            <tr>
                <th rowspan="3" style="text-align: center; vertical-align: middle">Product ID</th>
                <th colspan="5" style="text-align: center; vertical-align: middle">Beginning</th>
                <th rowspan="3" style="text-align: center; vertical-align: middle">Pulled Out</th>
                <th rowspan="3" style="text-align: center; vertical-align: middle">Sold Out</th>
                <th colspan="5" style="text-align: center; vertical-align: middle">Ending</th>
            </tr>
            <tr>
                <th colspan="4" style="text-align: center; vertical-align: middle">Size</th>
                <th rowspan="2" style="text-align: center; vertical-align: middle">Total</th>
                <th colspan="4" style="text-align: center; vertical-align: middle">Size</th>
                <th rowspan="2" style="text-align: center; vertical-align: middle">Total</th>
            </tr>
            <tr>
                <th>S</th>
                <th>M</th>
                <th>L</th>
                <th>XL</th>
                <th>S</th>
                <th>M</th>
                <th>L</th>
                <th>XL</th>
            <tr/></thead>
            <tbody>
                <!-- INSERT BODY HERE -->
            </tbody>
        </table></div>
    
    <br/>
    <center><h2>Needs Replenishment</h2></center>
    <div>
        <!-- NOT SURE IF CORRECT POST METHOD?? PLACING -->
        <form method="POST" action="EncodeInventoryReportServlet" >
            <div align="center" class="container">
                <table class="table detailsWidth table-bordered">
                    <thead>
                        <tr>
                            <th rowspan="3" style="text-align: center; vertical-align: middle">Product ID</th>
                            <th colspan="5" style="text-align: center; vertical-align: middle">Request</th>
                        </tr>
                        <tr>
                            <th colspan="4" style="text-align: center; vertical-align: middle">Size</th>
                            <th rowspan="2" style="text-align: center; vertical-align: middle">Total</th>
                        </tr>
                        <tr>
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
            </div>
        </form>
        
        <a href="InventoryReport.jsp">
            <button type="button" class="btn btn-danger">Create Replenishment Request</button></a>
    </div>
    <script>


    </script>
</body>

</html>