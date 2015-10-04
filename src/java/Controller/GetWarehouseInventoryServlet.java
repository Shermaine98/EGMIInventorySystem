package Controller;

import DAO.WarehouseInventoryDAO;
import Model.WarehouseInventory;
import java.io.IOException;
import java.io.PrintWriter;
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
public class GetWarehouseInventoryServlet extends BaseServlet {

     @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WarehouseInventoryDAO WarehouseInventoryDAO = new WarehouseInventoryDAO();
        ArrayList<WarehouseInventory> WarehouseInventoryList = new  ArrayList<WarehouseInventory> ();
        try {
            WarehouseInventoryList = WarehouseInventoryDAO.GetBoutiqueInventory();
        } catch (ParseException ex) {
            Logger.getLogger(ViewReplenishmentRequestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServletContext context = getServletContext();
       
        RequestDispatcher rd = context.getRequestDispatcher("/WarehouseInventory.jsp");
        request.setAttribute("WarehouseInventoryList", WarehouseInventoryList);
        rd.forward(request, response); 
    }

}
