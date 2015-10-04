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
        <title>Encode Subcontractor Purchase Order</title>
        <script src="/bootstrap/js/addRow.js"></script>
        <script src="/bootstrap/js/deleteRow.js"></script>
        <link rel="stylesheet" href="bootstrap/css/jquery-ui-datePicker.css">
        <script src="bootstrap/js/jquery-ui.js"></script>
       
    </head>

    <body>  
        <br/><br/><br/>

    <center><h2>Search Subcontractor Purchase Order</h2><br/>

        <div id="custom-search-input" class="input-group" style="width:30%">
            <input type="text" class="search-query form-control" placeholder="Search" />
            <span class="input-group-btn">
                <button class="btn btn-danger" type="button">
                    <span class=" glyphicon glyphicon-search"></span>
                </button>
            </span>
        </div>

        <table class="table table-bordered" style="width:30%">
            <colgroup>
                <col style="width:20%"/>
                <col style="width:80%"/>
            </colgroup>
            <thead>
            <th>Filter</th>
            <td><select name="Filter">
                    <option value="Complete">Date Made</option>
                    <option value="Product">Product Name</option>
                    <option value=""></option>
                </select></td>
            </thead>
        </table><br/>


        <div>
            <table class="table detailsWidth table-bordered">
                <th>Results here</th>
                <th>Results here</th>
            </table>
        </div>

        <br/>
        <h2>Encode Supplier Purchase Order</h2><br/>
        <form method="POST" action="EncodeSubcontractorPurchaseOrderServlet">
            <div align="center" class="container">
                <table class="table table-bordered" style="width:30%">
                    <thead><tr>
                            <th>Purchase Order No.</th>
                            <td class="value"><input type="text" class="input" name="poNumber"/></td>
                        </tr><tr>
                            <th>Production No.</th>
                            <td><input type="text" class="input" name="itemCode"/></td>
                        </tr><tr>
                            <th>Prepared By</th>
                             <td><input type="hidden" value="<%= user.getEmployeeNumber()%>"/><%= user.getFirstName()%></td>
                        </tr><tr>
                            <th>Date Made</th>
                            <td><input type="text" name="dateMade" class="input" readonly
                                       value="<% SupplierPurchaseOrder x = new SupplierPurchaseOrder();
                                           x.setDateMade();
                                       %><%=x.getDateMade()%>"/></td> 
                        </tr><tr>
                            <th>Delivery Date</th>
                           <td><input type="text" class="input" name="deliveryDate" id="datepicker"></td>  
                        </tr><tr>
                            <th>Vendor Type</th>
                            <td> <select name="vendorType">
                                    <option value="Complete">All the Vendor Types</option>
                                    <option value=""></option>
                                    <option value=""></option>
                                </select></td>
                        </tr>
                    </thead>
                </table>

                <table class="table detailsWidth table-bordered">
                    <colgroup>
                        <col style="width:30%"/>
                    </colgroup>
                    <thead><tr>
                            <th>Subcontractor</th>
                            <td><input type="text" class="input" name="deliveryDate" value="fast search but filtred by vendor type"/></td>
                        </tr></thead>
                </table>

                <table class="table detailsWidth table-bordered">
                    <colgroup>
                        <col style="width:30%"/>
                    </colgroup>
                    <thead><tr>
                        <th>Product Name</th>
                        <td><input type="text" class="input" name="productName"/></td>
                    </tr></thead>
                </table>
                        
                        
                    <br/>    
                <h2>Encode Supplier Purchase Order</h2><br/>
                <table class="table detailsWidth table-bordered">
                    <thead>
                        <tr>
                            <th>S</th>
                            <th>M</th>
                            <th>L</th>
                            <th>Quantity</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody id="dataTable">
                        <tr>
                            <td><input type="text" class="input" name="S"/></td>
                            <td class="value"><input type="text" class="input" name="M"/></td>
                            <td><input type="text" class="input" name="L"/></td>
                            <td><input type="text" class="input" name="qty"/></td>
                            <td><input type="text" class="input" name="total"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <th>TOTAL:</th>
                            <td><input type="text" name="Total" class="input" value ="TOTAL"/></td>
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
                        <br/><br/>
    </center>
    <script>
         $(function () {
            $("#datepicker").datepicker({minDate: 1, maxDate: "+4M +10D", dateFormat:'yy-mm-dd'});
            
        });
    </script>
</body>
</html>
