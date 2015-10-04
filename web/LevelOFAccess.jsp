<%@page import="Model.User"%>
<%
   User user = (User) session.getAttribute("login");
   String position = user.getPosition().toLowerCase().trim();
    if (position.equalsIgnoreCase("promo")) {
%>         <jsp:include page ="nPromoNavBar.jsp" />
<%
} else if (position.equalsIgnoreCase("receipthandler")) {
%>          <jsp:include page ="nReceiptHandlerNavBar.jsp" />
<%          } else if (position.equalsIgnoreCase("deliverymanager")) {

%>          <jsp:include page ="nDeliveryManagerNavBar.jsp" />
<%} else if (position.equalsIgnoreCase("generalmanager")) {
%>          <jsp:include page ="nGeneralManagerNavBar.jsp" />
<%          } else if (position.equalsIgnoreCase("productionmanager")) {
%>          <jsp:include page ="nProductionManagerNavBar.jsp" />
<%          } else if (position.equalsIgnoreCase("assistantproductionmanager")) {
%>          <jsp:include page ="nAssistantProductionManagerNavBar.jsp" />
<%          } else if (position.equalsIgnoreCase("cuttingmaster")) {
%>          <jsp:include page="nCuttingMasterNavBar.jsp"/>
<%          } else if (position.equalsIgnoreCase("promotersupervisor")) {
%>          <jsp:include page="nPromoterSupervisorNavBar.jsp"/>
<%          } else if (position.equalsIgnoreCase("warehousemanager")) {
%>          <jsp:include page="nWarehouseManagerNavBar.jsp"/>
<%          } else if (position.equalsIgnoreCase("administrator")) {
%>          <jsp:include page="nadministratorNavBar.jsp"/>
<%          } else if (position.equalsIgnoreCase("deliveryman")||position.equalsIgnoreCase("employee")) {
%>          <jsp:include page="nemployeeNavBar.jsp"/>
<%          } else {
        response.sendRedirect("index.jsp");
    }

%> 
