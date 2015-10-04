/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ReplenishmentRequestDAO;
import DAO.SupplierPurchaseOrderDAO;
import Model.ReplenishmentRequest;
import Model.SupplierPurchaseOrder;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shermainesy
 */
public class GetSupplierPurchaseOrderForReconcilingServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        SupplierPurchaseOrderDAO SupplierPurchaseOrderDAO = new SupplierPurchaseOrderDAO();
        ArrayList<SupplierPurchaseOrder> SupplierPurchaseOrderListR = new ArrayList<SupplierPurchaseOrder>();
        
        try{
            SupplierPurchaseOrderListR = SupplierPurchaseOrderDAO.GetAllPurchaseOrder();
        } catch (ParseException ex) {
            Logger.getLogger(ViewSupplierPurchaseOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServletContext context = getServletContext();
       
        RequestDispatcher rd = context.getRequestDispatcher("/Reconcile.jsp");
        request.setAttribute("SupplierPurchaseOrderListR", SupplierPurchaseOrderListR);
        rd.forward(request, response); 
    }
}

