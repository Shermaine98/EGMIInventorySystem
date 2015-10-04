package Controller;

import DAO.SubconPurchaseOrderDAO;
import DAO.SupplierPurchaseOrderDAO;
import Model.SubconPurchaseOrder;
import Model.SupplierPurchaseOrder;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */
public class EncodeSubcontractorPurchaseOrderServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            SubconPurchaseOrder SubconPurchaseOrder = new SubconPurchaseOrder();
            ArrayList<SubconPurchaseOrder> arrSubconPurchaseOrder = new ArrayList<SubconPurchaseOrder>();
            SubconPurchaseOrderDAO SubconPurchaseOrderDAO = new SubconPurchaseOrderDAO();

            String[] poNumber = request.getParameterValues("poNumber");
            String[] productionNumber = request.getParameterValues("itemCode");
            String[] productID = request.getParameterValues("inventoryType");
            String[] size = request.getParameterValues("supplier");
            String[] Qty = request.getParameterValues("volumeQty");
            String[] unitPrice = request.getParameterValues("unitPrice");
            String[] deliveryDate = request.getParameterValues("deliveryDate");
            String[] preparedBy =  request.getParameterValues("preparedBy");
            String[] approvedBy = request.getParameterValues("approvedBy");
            String[] receivingStatus = request.getParameterValues("receivingStatus");
            String[] reconcileStatus = request.getParameterValues("reconcileStatus");
            String[] subcon = request.getParameterValues("note");
            String[] service = request.getParameterValues("note");
            
            
            boolean x = false;

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            
            for (int i = 0; i < poNumber.length; i++) {
                
                SubconPurchaseOrder.setPoNumber(Integer.parseInt(poNumber[i]));
                SubconPurchaseOrder.setProductionNumber(Integer.parseInt(productionNumber[i]));
                SubconPurchaseOrder.setProductID(Integer.parseInt(productID[i]));
                SubconPurchaseOrder.setSize(size[i]);
                SubconPurchaseOrder.setQty(Integer.parseInt(Qty[i]));
                SubconPurchaseOrder.setUnitPrice(Double.parseDouble(unitPrice[i]));
                SubconPurchaseOrder.setDateMade();
                SubconPurchaseOrder.setDeliveryDate(deliveryDate[i]);
                SubconPurchaseOrder.setPreparedBy(Integer.parseInt(preparedBy[i]));
                SubconPurchaseOrder.setApprovedby(Integer.parseInt(approvedBy[i]));
                SubconPurchaseOrder.setReceivingStatus(receivingStatus[i]);
                SubconPurchaseOrder.setReconcileStatus(reconcileStatus[i]);
                SubconPurchaseOrder.setSubcon(Integer.parseInt(subcon[i]));
                SubconPurchaseOrder.setService(service[i]);
                
                

                if (SubconPurchaseOrderDAO.EncodeSubconPurchaseOrder(SubconPurchaseOrder)) {
                    x = true;
                    arrSubconPurchaseOrder.add(SubconPurchaseOrder);
                } else {
                    x = false;
                }
            }

            if (x == true) {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/ViewSubcontractorPurchaseOrder.jsp");
               
                request.setAttribute("arrSubconPurchaseOrder", arrSubconPurchaseOrder);
                rd.forward(request, response);

            } else {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/ViewSubcontractorPurchaseOrder.jsp");
                rd.forward(request, response);

            }
        } catch (ParseException ex) {
            Logger.getLogger(EncodeSupplierPurchaseOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }

    }
}
