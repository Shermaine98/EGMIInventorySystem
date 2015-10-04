<%-- 
    Document   : Supplier Purchase Order
    Created on : 08 20, 15, 6:43:37 PM
    Author     : Geraldine
--%>

<%@page import="Model.SupplierPurchaseOrder"%>
<%@page import="Model.ConsumptionReport"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="LevelOFAccess.jsp"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
          <link rel="stylesheet" type="text/css" href="bootstrap/tableBoarder.css">
        <title>>Encode Supplier Delivery Receipt</title>

    </head>
    <body>  
        <br/><br/><br/>
    <center><h2>Encode Supplier Delivery Receipt</h2></center>
    <form method="POST" action="EncodeSupplierDeliveryReceiptServlet">
        <div align="center" class="container">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Delivery Receipt Number</th>
                        <th>Purchase Order number</th>
                        <th>Item Code</th>
                        <th>Date Received</th>
                        <th>Quantity</th>
                        <th>Received By</th>
                        <th>approved by Status</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody id="dataTable">
                    <tr>
                        <td><input type="text" name="drNumber" size="12"/></td>
                        <td><input type="text" name="poNumber" size="12"/></td>
                        <td><input type="text" name="itemCode" size="12"/></td>
                        <td><input type="text" name="dateReceived" size="12"/></td>
                        <td ><input type="text" name="qty" size="12"/></td>
                        <td><input type="text" name="receivedBy" size="12"/></td>
                        <td><input type="text" name="approvedBy" size="12"/></td>
                        <td> <select name="status">
                                <option value="Complete">Complete</option>
                                <option value=""></option>
                                <option value=""></option>
                            </select></td>
                    </tr>
                </tbody>
            </table>

            <br/><br/>
            <input type="button" class="btn btn-danger" value="Add Row" onclick="addRow('dataTable')" />
            <input type="button" class="btn btn-danger" value="Delete Row" onclick="deleteRow('dataTable')" />
            <input type="submit" style="width:77px; height:34px" class="btn btn-danger" value="Submit">
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
        </div>
    </form>
</body>
</html>
