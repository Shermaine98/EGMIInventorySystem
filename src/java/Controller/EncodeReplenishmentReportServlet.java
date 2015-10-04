/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ReplenishmentRequestDAO;
import Model.ReplenishmentRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
public class EncodeReplenishmentReportServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();    
    
        try {
            
            ReplenishmentRequest ReplenishmentRequest = new ReplenishmentRequest();
            ReplenishmentRequest.setPromo(Integer.parseInt(request.getParameter("preparedBy")));
        try {
            ReplenishmentRequest.setDateMade();
        } catch (ParseException ex) {
            Logger.getLogger(EncodeInventoryReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            ReplenishmentRequest.setProductID(Integer.parseInt(request.getParameter("productID")));
            ReplenishmentRequest.setRequestedQty(Integer.parseInt(request.getParameter("requestedQty")));
            ReplenishmentRequest.setLocation(request.getParameter("location"));
            ReplenishmentRequest.setSize(request.getParameter("size"));
            ReplenishmentRequest.setMadeBy(Integer.parseInt(request.getParameter("madeBy")));
        try {
            ReplenishmentRequest.setDateMade();
        } catch (ParseException ex) {
            Logger.getLogger(EncodeInventoryReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            ReplenishmentRequestDAO IRDAO = new ReplenishmentRequestDAO();
            
            if (IRDAO.EncodeReplenishmentRequest(ReplenishmentRequest)) {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/dashboard.jsp");
               
                request.setAttribute("ReplenishmentRequest", ReplenishmentRequest);
                rd.forward(request, response);
            } else {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/ReplenishmentRequest.jsp");
                rd.forward(request, response);

            }
        } finally {
            out.close();
        }
    }
}
