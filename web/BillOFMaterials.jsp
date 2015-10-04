<%-- 
    Document   : Bill of Materials
    Created on : 08 20, 15, 6:43:37 PM
    Author     : Geraldine
--%>

<%@page import="Model.BillOfMaterials"%>
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
        <link rel="stylesheet" type="text/css" href="bootstrap/css/searchInput.css">
        <%-- Source DevBridge and StockOverflow--%>
        <script src="bootstrap/js/addRow.js"></script>
        <script src="bootstrap/js/deleteRow.js"></script>
        <script type="text/javascript" src="bootstrap/js/jquery.autocomplete.js"></script>
        <title>Encode Bill of Materials</title>
    </head>
    <body> 
        <%
         Integer x = (Integer) request.getAttribute("BoMPrNumber");
        %>
        <br/><br/><br/>
    <center><h2>Encode Bill of Materials</h2></center>
    <br/><br/>
    <form method="POST" action="EncodeBillOfMaterialsServlet">
        <div align="center" class="container">
            <table class="table width35 table-bordered">
                <thead>
                    <tr>
                        <th>Product ID</th>
                        <td><input type="text" class="input" name="productID" value="<%=x%>"/></td>
                    </tr>
                    <tr>
                        <th>Product Name</th>
                        <td><input type="text" class="input" name="productName"/></td>
                    </tr>
                    <tr>
                        <th>Size Type</th>
                        <td> 
                            <select name="sizeName">
                                <option value="Pants">Pants</option>
                                <option value="Shirt">Shirt</option>
                            </select>
                        </td>
                    </tr>
                </thead>
            </table>
            <input type="text" style="width:35%; height:35px" name="itemName" id="ItemName" onkeydown="autoComplete()" placeholder="Search Item"/>
            <input type="hidden" name="itemName" id="ItemName" disabled="disabled" style="color: #CCC; position: absolute; background: transparent;"/>
            <input type="Button" onClick="getItem()" style="height:34px" class="btn btn-danger" value="ADD ITEM">

            <br/><br/>
            <table  class="table table-bordered" style="width:47%">
                <colgroup>
                    <col style="width:3%" />
                </colgroup>

                <tbody id="dataTable">
                </tbody>
            </table>
            <br/>
            <input type="button" class="btn btn-danger" value="Delete Row" onclick="deleteRow('dataTable')" />
            <br/><br/>
            <input type="submit" style="width:77px; height:34px" class="btn btn-danger" value="Create">
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
        </div>
    </form>
    <script type="text/javascript">
        var i = 1;
        function autoComplete() {
            $("#ItemName").devbridgeAutocomplete({
                serviceUrl: 'SearchItem',
                type: 'POST',
                showNoSuggestionNotice: true,
                noSuggestionNotice: 'No Exsiting Item',
            });
        }
        ;
        function getItem() {

            var itemName = document.getElementById('ItemName').value;
            console.log(itemName);
            $.ajax({
                url: "setItemServlet",
                type: 'POST',
                dataType: "json",
                data: {
                    itemName: itemName
                },
                success: function (data) {
                    if (i == 1) {
                        $('#dataTable').append('<tr> <th ></th>  <th style="text-align: center; vertical-align: middle">Item Name</th> <th style="text-align: center; vertical-align: middle" class="input">Consumption</th><th style="text-align: center">Unit Measurement</th></tr>');
                    }

                    $('#dataTable').append('<tr> <td><input type="checkbox" name="chk" />\n\
                                                        </td>\n\
                                                        <td>\n\
                                                            <input type="hidden" name = "itemCode" value="' + data[0].ItemCode + '"/>'
                            + data[0].itemName + '</td> <td><input  class="input" type="number" name="itemConsumption"  onkeypress="return event.charCode >= 48 && event.charCode <= 57"  /></td> <td><select name="unitMeasurement"> <option value="kg">kg</option><option value="cm">cm</option> </select> </td>'
                            + '</tr>');
                    i++;
                },
                error: function (XMLHttpRequest, textStatus, exception) {
                    alert(XMLHttpRequest.responseText);
                }
            });
        };
    </script>
</body>
</html>
