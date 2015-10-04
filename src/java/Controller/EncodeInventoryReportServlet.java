/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.InventoryReportDAO;
import Model.InventoryReport;
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
public class EncodeInventoryReportServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();    
    
        try {
            
            InventoryReport inventoryReport = new InventoryReport();
            inventoryReport.setPromo(Integer.parseInt(request.getParameter("preparedBy")));
        try {
            inventoryReport.setDateMade();
        } catch (ParseException ex) {
            Logger.getLogger(EncodeInventoryReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            inventoryReport.setProductID(Integer.parseInt(request.getParameter("productID")));
            inventoryReport.setRemainingQty(Integer.parseInt(request.getParameter("remainingQuantity")));
            inventoryReport.setSoldQty(Integer.parseInt(request.getParameter("soldQuantity")));
            inventoryReport.setPulledOutQty(Integer.parseInt(request.getParameter("pulledQuantity")));
            inventoryReport.setrequestNComment(request.getParameter("requestComments"));
            inventoryReport.setLocation(request.getParameter("location"));
            inventoryReport.setSize(request.getParameter("size"));
        try {
            inventoryReport.setDateMade();
        } catch (ParseException ex) {
            Logger.getLogger(EncodeInventoryReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            InventoryReportDAO IRDAO = new InventoryReportDAO();
            
            if (IRDAO.EncodeInventoryReport(inventoryReport)) {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/InventoryReports.jsp");
               
                request.setAttribute("inventoryReport", inventoryReport);
                rd.forward(request, response);
            } else {
              
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/InventoryReport.jsp");
                rd.forward(request, response);

            }
        } finally {
            out.close();
        }
    }
}
