/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DeliveryReceiptDAO;
import Model.DeliveryReceipt;
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
 * @author Geraldine
 */
public class EncodeDeliveryReceiptServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            DeliveryReceipt deliveryReceipt = new DeliveryReceipt();
            ArrayList<DeliveryReceipt> arrDeliveryReceipt = new ArrayList<DeliveryReceipt>();
            DeliveryReceiptDAO deliveryReceiptDAO = new DeliveryReceiptDAO();

            String[] drNumber = request.getParameterValues("drNumber");
            String[] doNumber = request.getParameterValues("doNumber");
            String[] promo = request.getParameterValues("promo");
            String[] location = request.getParameterValues("location");
            String[] deliveryDate = request.getParameterValues("deliveryDate");
            
            boolean x = false;

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            
            for (int i = 0; i < doNumber.length; i++) {
                
                deliveryReceipt.setDrNumber(Integer.parseInt(drNumber[i]));
                deliveryReceipt.setDoNumber(Integer.parseInt(doNumber[i]));
                deliveryReceipt.setPromo(Integer.parseInt(promo[i]));
                deliveryReceipt.setLocation(location[i]);
                deliveryReceipt.setDateMade();
                deliveryReceipt.setDeliveryDate(format.parse(deliveryDate[i]));
                
                if (deliveryReceiptDAO.EncodeDeliveryReceipt(deliveryReceipt)) {
                    x = true;
                    arrDeliveryReceipt.add(deliveryReceipt);
                } else {
                    x = false;
                }
            }

            if (x == true) {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/DeliveryReceipt.jsp");
               
                request.setAttribute("arrDeliveryReceipt", arrDeliveryReceipt);
                rd.forward(request, response);

            } else {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/DeliveryReceipt.jsp");
                rd.forward(request, response);

            }
        } catch (ParseException ex) {
            Logger.getLogger(EncodeDeliveryOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }

    }
}
