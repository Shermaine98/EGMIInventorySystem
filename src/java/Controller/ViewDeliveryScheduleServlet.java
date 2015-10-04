package Controller;

import DAO.DeliveryScheduleDAO;
import Model.DeliverySchedule;
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
 * @author gcla109
 */
public class ViewDeliveryScheduleServlet extends BaseServlet {
    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeliveryScheduleDAO DeliveryScheduleDAO = new DeliveryScheduleDAO();
        ArrayList<DeliverySchedule> DeliveryScheduleList = new  ArrayList<DeliverySchedule> ();
        try {
            DeliveryScheduleList = DeliveryScheduleDAO.GetDeliveryScheduleList();
        } catch (ParseException ex) {
            Logger.getLogger(ViewDeliveryScheduleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServletContext context = getServletContext();
        
        RequestDispatcher rd = context.getRequestDispatcher("/ViewDeliverySchedule.jsp");
        request.setAttribute("DeliveryScheduleList", DeliveryScheduleList);
        rd.forward(request, response); 
    }
}
