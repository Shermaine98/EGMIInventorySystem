package Controller;

import DAO.DeliveryOrderDAO;
import Model.DeliveryOrder;
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

public class ViewDeliveryOrderServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DeliveryOrderDAO DAO = new DeliveryOrderDAO();
            ArrayList<DeliveryOrder> doList = DAO.GetDeliveryOrderList();
            
            ServletContext context = getServletContext();
            
            RequestDispatcher rd = context.getRequestDispatcher("/ViewDeliveryOrder.jsp");
            request.setAttribute("doList", doList);
            rd.forward(request, response);         
        } catch (ParseException ex) {
            Logger.getLogger(ViewDeliveryOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
}