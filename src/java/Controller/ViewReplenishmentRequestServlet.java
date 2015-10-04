package Controller;

import DAO.ReplenishmentRequestDAO;
import Model.ReplenishmentRequest;
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
public class ViewReplenishmentRequestServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReplenishmentRequestDAO ReplenishmentRequestDAO = new ReplenishmentRequestDAO();
        ArrayList<ReplenishmentRequest> ReplenishmentRequestList = new  ArrayList<ReplenishmentRequest> ();
        try {
            ReplenishmentRequestList = ReplenishmentRequestDAO.GetReplenishmentRe();
        } catch (ParseException ex) {
            Logger.getLogger(ViewReplenishmentRequestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServletContext context = getServletContext();
       
        RequestDispatcher rd = context.getRequestDispatcher("/ReplenishmentRequest.jsp");
        request.setAttribute("ReplenishmentRequestList", ReplenishmentRequestList);
        rd.forward(request, response); 
    }
}
