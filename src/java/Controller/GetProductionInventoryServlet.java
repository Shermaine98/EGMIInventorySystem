package Controller;

import DAO.ProductionInventoryDAO;
import Model.ProductionInventory;
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
public class GetProductionInventoryServlet extends BaseServlet {

     @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductionInventoryDAO ProductionInventoryDAO = new ProductionInventoryDAO();
        ArrayList<ProductionInventory> ProductionInventoryList = new  ArrayList<ProductionInventory> ();
        try {
            ProductionInventoryList = ProductionInventoryDAO.GetBoutiqueInventory();
        } catch (ParseException ex) {
            Logger.getLogger(ViewReplenishmentRequestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServletContext context = getServletContext();
       
        RequestDispatcher rd = context.getRequestDispatcher("/ProductionInventory.jsp");
        request.setAttribute("ProductionInventoryList", ProductionInventoryList);
        rd.forward(request, response); 
    }

}
