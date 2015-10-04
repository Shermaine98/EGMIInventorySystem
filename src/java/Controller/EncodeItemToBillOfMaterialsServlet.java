package Controller;

import DAO.RefItemDAO;
import Model.RefItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class EncodeItemToBillOfMaterialsServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        RefItem item = new RefItem();
        ArrayList<RefItem> arrItem = new ArrayList<RefItem>();
        RefItemDAO itemDAO = new RefItemDAO();
        String[] itemCode = request.getParameterValues("itemCode");
        String[] itemName = request.getParameterValues("itemName");
        String[] inventoryType = request.getParameterValues("inventoryType");
        boolean x = false;

        for (int i = 0; i < itemCode.length; i++) {

            item.setItemCode(Integer.parseInt(itemCode[i]));
            item.setItemName(itemName[i]);
            item.setInventoryType(inventoryType[i]);

            if (itemDAO.UpdateInventory(item)) {
                x = true;
                arrItem.add(item);
            } else {
                x = false;
            }
        }
        if (x == true) {
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/dashboard.jsp");
           
            request.setAttribute("arrItem", arrItem);
            rd.forward(request, response);

        } else {
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/Receiving.jsp");
            rd.forward(request, response);

        }

    }

}
