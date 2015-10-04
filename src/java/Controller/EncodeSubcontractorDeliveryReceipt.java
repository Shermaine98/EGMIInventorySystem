package Controller;


import DAO.SubconDeliveryReceiptDAO;
import Model.SubconDeliveryReceipt;
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
public class EncodeSubcontractorDeliveryReceipt extends BaseServlet {

     @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            SubconDeliveryReceipt SubconDeliveryReceipt = new SubconDeliveryReceipt();
            ArrayList<SubconDeliveryReceipt> arrSubconDeliveryReceipt = new ArrayList<SubconDeliveryReceipt>();
            SubconDeliveryReceiptDAO SubconDeliveryReceiptDAO = new SubconDeliveryReceiptDAO();

            String[] drNumber = request.getParameterValues("drNumber");
            String[] poNumber = request.getParameterValues("poNumber");
            String[] productionNumber = request.getParameterValues("proudctionNumber");
            String[] productID = request.getParameterValues("productID");
            String[] size = request.getParameterValues("size");
            String[] dateReceived = request.getParameterValues("dateReceived");
            String[] qty = request.getParameterValues("qty");
            String[] receivedBy = request.getParameterValues("receivedBy");
            String[] approvedBy = request.getParameterValues("approvedBy");
            String[] status = request.getParameterValues("status");
            
            boolean x = false;

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            
            for (int i = 0; i < drNumber.length; i++) {
                
                SubconDeliveryReceipt.setDrNumber(Integer.parseInt(drNumber[i]));
                SubconDeliveryReceipt.setPoNumber(Integer.parseInt(poNumber[i]));
                SubconDeliveryReceipt.setProductionNumber(Integer.parseInt(productionNumber[i]));
                SubconDeliveryReceipt.setProductID(Integer.parseInt(productID[i]));
                SubconDeliveryReceipt.setSize(size[i]);
                SubconDeliveryReceipt.setDateReceived(format.parse(dateReceived[i]));
                SubconDeliveryReceipt.setQty(Integer.parseInt(qty[i]));
                SubconDeliveryReceipt.setReceivedBy(Integer.parseInt(receivedBy[i]));
                SubconDeliveryReceipt.setAppovedBy(Integer.parseInt(approvedBy[i]));
                SubconDeliveryReceipt.setStatus(status[i]);
                
                
                if (SubconDeliveryReceiptDAO.EncodeSubconDeliveryReceipt(SubconDeliveryReceipt)) {
                    x = true;
                    arrSubconDeliveryReceipt.add(SubconDeliveryReceipt);
                } else {
                    x = false;
                }
            }

            if (x == true) {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/SubcontractorDeliveryReceipt.jsp");
               
                request.setAttribute("arrSupplierDeliveryReceipt", arrSubconDeliveryReceipt);
                rd.forward(request, response);

            } else {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/SubcontractorDeliveryReceipt.jsp");
                rd.forward(request, response);

            }
        } catch (ParseException ex) {
            Logger.getLogger(EncodeSupplierDeliveryReceiptServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }

    }

}
