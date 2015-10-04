<%-- 
    Document   : Supplier Purchase Order
    Created on : 08 20, 15, 6:43:37 PM
    Author     : Geraldine
--%>

<%@page import="Model.SupplierPurchaseOrder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="LevelOFAccess.jsp"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/tableBoarder.css">
        <link rel="stylesheet" href="bootstrap/css/jquery-ui-datePicker.css">
        <script type="text/javascript" src="bootstrap/js/jquery.autocomplete.js"></script>
        <script src="bootstrap/js/jquery-ui.js"></script>
        <title>Encode Supplier Purchase Order</title>
    </head>
    <body>  
        <br/><br/><br/>

    <center><h2>Encode Supplier Purchase Order</h2></center><br/>
    <form method="POST" action="EncodeSupplierPurchaseOrderServlet">
        <div align="center" class="container">
            <table class="table table-bordered" style="width:40%">
                <colgroup>
                    <col style="width:40%"/>
                </colgroup>
                <thead>
                    <tr>
                        <th>Purchase Order number</th>
                        <td class="value"><input class="input" type="text" name="poNumber" value="AUTO" /></td>
                    </tr><tr>
                        <th>Prepared By</th>
                        <td><input type="hidden" value="<%= user.getEmployeeNumber()%>"/><%= user.getFirstName()%></td>
                    </tr><tr>
                        <th>Date Made</th>
                        <td><input type="text" class="input" name="dateMade"  readonly value="AUTO"/></td>  
                    </tr><tr>
                        <th>Delivery </th>
                        <td><input type="text" class="input" name="deliveryDate" id="datepicker"></td>                 
                    </tr><tr>
                        <th>Supplier</th>
                        <td><input type="text" class="input" name="dateMade"  readonly value="AUTO" /></td>                 
                    </tr>
                </thead>

            </table>
            <br/><br/>
            <table class="table table-bordered width">
                <thead>
                    <tr>
                        <th></th>
                        <th>Item Code</th>
                        <th>Unit Price</th>
                        <th>Quantity</th>
                        <th>Total Quantity Price</th>
                    </tr>
                </thead>
                <tbody id="dataTable">
                    <tr>
                        <td><input type="checkbox" name="chk"/></td>
                <input type="text" name="itemName" id="ItemName" style="width:40%; height:30px" onkeydown="autoComplete()" placeholder="Search Item"/>
                <input type="hidden" name="itemName" id="ItemName" disabled="disabled" style="color: #CCC; position: absolute; background: transparent;"/>
                
                <br/><br/>
                <td><input type="text" class="input" name="unitPrice"></td>
                <td><input type="text" class="input" name="qty"/></td>
                <td><input type="text" class="input" name="Total Price" value ="unitPrice*Qty"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <th>TOTAL:</th>
                    <td><input type="text" class="input" name="Total" value ="TOTAL"/></td>
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
    <script>
        function autoComplete() {
            $("#ItemName").devbridgeAutocomplete({
                serviceUrl: 'SearchItem',
                type: 'POST',
                showNoSuggestionNotice: true,
                noSuggestionNotice: 'No Exsiting Item',
            });
        }
        ;
        $(function () {
            $("#datepicker").datepicker({minDate: 1, maxDate: "+4M +10D", dateFormat: 'yy-mm-dd'});

        });
    </script>
</body>
</html>
