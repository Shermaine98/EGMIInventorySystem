package Controller;

import DAO.PickingFormDAO;
import Model.PickingForm;
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
public class GetPickingFormForDeliveryOrderServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PickingFormDAO PickingFormDAO = new PickingFormDAO();
        ArrayList<PickingForm> PickingFormList = new  ArrayList<PickingForm> ();
        try {
            PickingFormList = PickingFormDAO.GetAllPickingForm();
        } catch (ParseException ex) {
            Logger.getLogger(GetPickingFormForDeliveryOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServletContext context = getServletContext();
       
        RequestDispatcher rd = context.getRequestDispatcher("/DeliveryOrder.jsp");
        request.setAttribute("GetPickingFormList", PickingFormList);
        rd.forward(request, response); 
    }
}
