<%-- 
    Document   : EncodeConsumptionReport
    Created on : 08 20, 15, 6:43:37 PM
    Author     : Geraldine
--%>

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
        <title>Encode Consumption Report</title>
      
        <script>
           
        </script>
    </head>
    <body>  
        <br/><br/><br/>
    <center><h2>Encode Consumption Report</h2></center>
    <form method="POST" action="EncodeConsumptionReportServlet">
        <div align="center" class="container">
            <table class="table table-bordered">
                <th>Production #</th>
                <td class="value"><input type="text" name="productionNumber" size="12" value="auto"/></td>

                <tr>
                    <th>Prepared By</th> 
                    <td><input type="text" name="preparedBy" size="12" value="auto"/></td>
                </tr>
                <tr>
                    <th>Date Made</th>
                    <td><input type="text" name="dateMade"  readonly size="12"
                               value="<%                                       ConsumptionReport x = new ConsumptionReport();
                                   x.setDateMade();
                               %><%=x.getDateMade()%>"/></td>                 
                </tr>

            </table>

            <center><h1>Bill of Materials</h1></center>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Product ID</th>
                        <td><input type="text" name="size" size="12" value="auto"/></td>

                    </tr>
                    <tr>
                        <th>Product Name</th>
                        <td><input type="text" name="size" size="12" value="auto"/></td>
                    </tr>
                </thead>
            </table>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Item Name</th>
                        <th>Consumption Per Unit</th>
                        <th>Total Consumption</th>
                        <th>Order Now</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text" name="itemCode" size="12"/></td>
                        <td><input type="text" name="" size="12" value="bill of materialss"/></td>
                        <td><input type="text" name="volumeQty" size="14" value="CPU*TOTAL"/></td>                    
                        <td> <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myAddSupplier">Order Now</button></td>
                </tbody>
            </table>

            <br/><br/>
            <input type="submit" style="width:77px; height:34px" class="btn btn-danger" value="Submit">
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
        </div>
    </form>

    <div class="modal fade" id="myAddSupplier" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">Add Item</h4>
                </div>
                <form method="POST" action="EncodeSupplierPurchaseOrderServlet">
                    <div align="center" class="container">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Purchase Order number</th>
                                    <td class="value"><input type="text" name="poNumber" size="5" value="AUTO"/></td>
                                </tr>
                                <tr>
                                    <th>Prepared By</th>
                                    <td><input type="text" name="preparedBy" size="5" value="AUTO"/></td>
                                </tr>
                                <tr>
                                    <th>Date Made</th>
                                    <td><input type="text" name="dateMade"  readonly size="12" value="AUTO"/></td>  
                                </tr>
                                <tr>
                                    <th>Delivery </th>
                                    <td><input type="text" name="dateMade"  readonly size="12" value="datepicker" /></td>                 
                                </tr>
                                <tr>
                                    <th>Date Made</th>
                                    <td><input type="text" name="dateMade"  readonly size="12" value="auto" /></td>                 
                                </tr>
                            </thead>
                        </table>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Supplier </th>
                                    <td><input type="text" name="dateMade"  readonly size="12" value="searchSupplierWithProducts" /></td> 
                                </tr>
                            </thead>
                        </table>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Item Code</th>
                                    <th>Unit Price</th>
                                    <th>Quantity</th>
                                    <th>Total Price</th>
                                </tr>
                            </thead>
                            <tbody id="dataTable">
                                <tr>
                                    <td><input type="text" name="itemCode" size="12" value="auto"/></td>
                                    <td><input type="text" name="unitPrice" size="12" value="auto"/></td>
                                    <td><input type="text" name="qty" size="12" value="auto"/></td>
                                    <td><input type="text" name="Total Price" size="12" value ="unitPrice*Qty"/></td>
                                   
                                </tr>
                            </tbody>
                        </table>
                        <br/><br/>
                        <input type="submit" style="width:77px; height:34px" class="btn btn-danger" value="Submit">
                        <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
