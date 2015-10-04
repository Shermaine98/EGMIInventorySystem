package Controller;

import DAO.InventoryReportDAO;
import Model.InventoryReport;
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
public class ViewInventoryReportServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InventoryReportDAO InventoryReportDAO = new InventoryReportDAO();
        ArrayList<InventoryReport> InventoryReportList = new  ArrayList<InventoryReport> ();
        try {
            InventoryReportList = InventoryReportDAO.GetAllInventoryReport();
        } catch (ParseException ex) {
            Logger.getLogger(ViewInventoryReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        ServletContext context = getServletContext();
        
        RequestDispatcher rd = context.getRequestDispatcher("/GetBoutiqueInventoryForInventoryReport");
        request.setAttribute("InventoryReportList", InventoryReportList);
        rd.forward(request, response); 
    }
}
