package Controller;

import DAO.BillOfMaterialsDAO;
import Model.BillOfMaterials;
import java.io.IOException;
import java.sql.SQLException;
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
public class GetPRIDServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BillOfMaterialsDAO DAO = new BillOfMaterialsDAO();
        Integer productnumber=0;
        try {
            productnumber = DAO.getProductNumber();
        } catch (SQLException ex) {
            Logger.getLogger(GetPRIDServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(productnumber ==0){
            productnumber=200000000;
        }
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/BillOFMaterials.jsp");
        request.setAttribute("BoMPrNumber", productnumber);
        rd.forward(request, response);

    }
}
