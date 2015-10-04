package Controller;

import DAO.DeliveryReceiptDAO;
import Model.DeliveryReceipt;
import java.io.IOException;
import java.text.ParseException;
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
public class ViewDeliveryReceiptServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DeliveryReceiptDAO DAO = new DeliveryReceiptDAO();
            ArrayList<DeliveryReceipt> drList = DAO.GetDeliveryReceiptList();

            ServletContext context = getServletContext();
            
            RequestDispatcher rd = context.getRequestDispatcher("/ViewDeliveryReceipt.jsp");
            request.setAttribute("drList", drList);
            rd.forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ViewDeliveryOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
