package Controller;

import DAO.BoutiqueInventoryDAO;
import Model.BoutiqueInventory;
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
public class GetBoutiqueInventoryForInventoryReport extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BoutiqueInventoryDAO BoutiqueInventoryDAO = new BoutiqueInventoryDAO();
        ArrayList<BoutiqueInventory> BoutiqueInventoryList = new  ArrayList<BoutiqueInventory> ();
        try {
            BoutiqueInventoryList = BoutiqueInventoryDAO.GetBoutiqueInventory();
        } catch (ParseException ex) {
            Logger.getLogger(GetPickingFormForDeliveryOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(BoutiqueInventoryList.get(0).getPromo());
        ServletContext context = getServletContext();
       
       RequestDispatcher rd = context.getRequestDispatcher("/InventoryReport.jsp");
        request.setAttribute("BoutiqueInventoryList", BoutiqueInventoryList);
        rd.forward(request, response); 
    }
}
