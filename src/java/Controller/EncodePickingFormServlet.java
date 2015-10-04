package Controller;

import DAO.PickingFormDAO;
import Model.PickingForm;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
 * @author gcla109
 */
public class EncodePickingFormServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();    
    
        try {
            
            PickingForm PickingForm = new PickingForm();
            PickingForm.setPromo(Integer.parseInt(request.getParameter("preparedBy")));
        try {
            PickingForm.setDateMade();
        } catch (ParseException ex) {
            Logger.getLogger(EncodeInventoryReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            PickingForm.setProductID(Integer.parseInt(request.getParameter("productID")));
            PickingForm.setRequestedQty(Integer.parseInt(request.getParameter("requestedQty")));
            PickingForm.setApprovedQty(Integer.parseInt(request.getParameter("approvedQty")));
            PickingForm.setApprovedBy(Integer.parseInt(request.getParameter("approvedBy")));
            PickingForm.setLocation(request.getParameter("location"));
            PickingForm.setSize(request.getParameter("size"));
        try {
            PickingForm.setDateMade();
        } catch (ParseException ex) {
            Logger.getLogger(EncodeInventoryReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            PickingFormDAO PikingDAO = new PickingFormDAO();
            
            if (PikingDAO.EncodepickingForm(PickingForm)) {
              
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/ViewPickingForm.jsp");
              
                request.setAttribute("PickingForm", PickingForm);
                rd.forward(request, response);
            } else {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/PickingForm.jsp");
                rd.forward(request, response);

            }
        } finally {
            out.close();
        }
    }
}
