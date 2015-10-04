<%-- 
    Document   : EncodeCuttingReport
    Created on : 08 20, 15, 7:36:54 PM
    Author     : Geraldine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="LevelOFAccess.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
          <link rel="stylesheet" type="text/css" href="bootstrap/tableBoarder.css">
        <title>Encode Cutting Report</title>
        
        <script>
                  </script>

    </head>
    <body>  
        <br/><br/><br/>
    <center><h2>Encode Cutting Report</h2></center>
    <form method="POST" action="EncodeCuttingReportServlet">
        <div align="center" class="container">
            <table class="table table-bordered">
                <thead><tr>
                        <th></th>
                        <th>Production #</th>
                        <th>Product ID</th>
                        <th>Delivery Receipt #</th>
                        <th>Purchase Order #</th>
                        <th>Item Code</th>
                        <th>Raw Quantity</th>
                        <th>Calculated Quantity</th>
                        <th>Actual Quantity</th>
                        <th>Cutting Master</th>
                        <th>Note</th>
                    </tr></thead>
                <tbody id="dataTable" class="scrollContent">
                    <tr>
                        <td><input type="checkbox" name="chk" id="chk" style="width:50px;"/></td>
                        <td><input type="text" name="productionNumber" /></td>          
                        <td><input type="text" name="productID" /></td>      
                        <td><input type="text" name="drNumber" /></td>
                        <td><input type="text" name="poNumber" /></td>
                        <td><input type="text" name="itemCode" /></td>  
                        <td><input type="text" name="rawQty" /></td>
                        <td><input type="text" name="calculatedQty" /></td>
                        <td><input type="text" name="actualQty" /></td>
                        <td><input type="text" name="cuttingMaster" /></td>
                        <td><input type="text" name="note" /></td>

<!--                        <td><input type="checkbox" name="chk" onClick="document.getElementById('createCommentName(<%=1%>)').disabled = this.checked;
        document.getElementById('createActualQuantity(<%=1%>)').disabled = this.checked;" checked/></td>-->
                    </tr>
                </tbody>
            </table>
            <br/><br/>
            <input type="button" class="btn btn-danger" value="Add Row" onclick="addRow('dataTable')" />
            <input type="button" class="btn btn-danger" value="Delete Row" onclick="deleteRow('dataTable')" />

            <br/><br/>
            <input type="submit" class="btn btn-danger" value="Submit">
            <a href="dashboard.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
        </div>
    </form>

</body>
</html>
 