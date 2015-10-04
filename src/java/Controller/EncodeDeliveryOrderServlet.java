package Controller;

import DAO.DeliveryOrderDAO;
import Model.DeliveryOrder;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */
public class EncodeDeliveryOrderServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            DeliveryOrder deliveryOrder = new DeliveryOrder();
            ArrayList<DeliveryOrder> arrDeliveryOrder = new ArrayList<DeliveryOrder>();
            DeliveryOrderDAO deliveryOrderDAO = new DeliveryOrderDAO();

            String[] doNumber = request.getParameterValues("doNumber");
            String[] qty = request.getParameterValues("qty");
            String[] deliveryDate = request.getParameterValues("deliveryDate");
            String[] promo = request.getParameterValues("promo");
            String[] location = request.getParameterValues("location");
            String[] productID = request.getParameterValues("productID");
            String[] size = request.getParameterValues("size");

            boolean x = false;

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            for (int i = 0; i < doNumber.length; i++) {

                deliveryOrder.setDoNumber(Integer.parseInt(doNumber[i]));
                deliveryOrder.setQty(Integer.parseInt(qty[i]));
                deliveryOrder.setDeliveryDate(format.parse(deliveryDate[i]));
                deliveryOrder.setDateMade();
                deliveryOrder.setPromo(Integer.parseInt(promo[i]));
                deliveryOrder.setLocation(location[i]);
                deliveryOrder.setProductID(Integer.parseInt(productID[i]));
                deliveryOrder.setSize(size[i]);

                if (deliveryOrderDAO.EncodeDeliveryOrder(deliveryOrder)) {
                    x = true;
                    arrDeliveryOrder.add(deliveryOrder);
                } else {
                    x = false;
                }
            }

            if (x == true) {
              
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/DeliveryOrder.jsp");
               
                request.setAttribute("arrDeliveryOrder", arrDeliveryOrder);
                rd.forward(request, response);

            } else {
               
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/DeliveryOrder.jsp");
                rd.forward(request, response);

            }
        } catch (ParseException ex) {
            Logger.getLogger(EncodeDeliveryOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }

    }
}
