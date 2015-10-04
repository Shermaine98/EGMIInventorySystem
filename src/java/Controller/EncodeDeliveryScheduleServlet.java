package Controller;

import DAO.DeliveryScheduleDAO;
import Model.DeliverySchedule;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */
public class EncodeDeliveryScheduleServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            DeliverySchedule DeliverySchedule = new DeliverySchedule();
            ArrayList<DeliverySchedule> arrDeliverySchedule = new ArrayList<DeliverySchedule>();
            DeliveryScheduleDAO DeliveryScheduleDAO = new DeliveryScheduleDAO();

            String[] doNumber = request.getParameterValues("doNumber");
            String[] location = request.getParameterValues("location");
            String[] promo = request.getParameterValues("promo");
            String[] driver = request.getParameterValues("driver");
            String[] deliveryDate = request.getParameterValues("deliveryDate");
            String[] preparedBy = request.getParameterValues("preparedBy");
            String[] boxQty = request.getParameterValues("boxQty");

            boolean x = false;

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            for (int i = 0; i < doNumber.length; i++) {

                DeliverySchedule.setDoNumber(Integer.parseInt(doNumber[i]));
                DeliverySchedule.setLocation(location[i]);
                DeliverySchedule.setPromo(Integer.parseInt(promo[i]));
                DeliverySchedule.setDateMade();
                DeliverySchedule.setDriver(Integer.parseInt(driver[i]));
                DeliverySchedule.setDeliveryDate(deliveryDate[i]);
                DeliverySchedule.setPreparedBy(Integer.parseInt(preparedBy[i]));
                DeliverySchedule.setBoxQty(Integer.parseInt(boxQty[i]));

                if (DeliveryScheduleDAO.EncodeDeliverySchedule(DeliverySchedule)) {
                    x = true;
                    arrDeliverySchedule.add(DeliverySchedule);
                } else {
                    x = false;
                }
            }

            if (x == true) {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/DeliverySchedule.jsp");
                request.setAttribute("arrDeliverySchedule", arrDeliverySchedule);
                rd.forward(request, response);

            } else {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/DeliverySchedule.jsp");
                rd.forward(request, response);

            }
        } catch (ParseException ex) {
            Logger.getLogger(EncodeDeliveryOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }

    }
}
