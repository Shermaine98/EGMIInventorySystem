package Controller;

import DAO.RefItemDAO;
import DAO.RefSupplierDAO;
import Model.RefItem;
import Model.RefSupplier;
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
public class EncodeSupplierServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        RefSupplier refSupplier = new RefSupplier();
        ArrayList<RefSupplier> arrSupplier = new ArrayList<RefSupplier>();
        RefSupplierDAO refSupplierDAO = new RefSupplierDAO();
        String[] supplierID = request.getParameterValues("suppliervalue");
        String[] itemCode = request.getParameterValues("itemCode");
        String[] itemName = request.getParameterValues("itemName");
        String[] companyName = request.getParameterValues("companyName");
        String[] companyAddress = request.getParameterValues("companyAddress");
        String[] contactPerson = request.getParameterValues("contactPerson");
        String[] contactNumber = request.getParameterValues("contactNumber");
        boolean x = false;
        for (int i = 0; i < supplierID.length; i++) {
            refSupplier.setSupplierID(Integer.parseInt(supplierID[i]));
            refSupplier.setItemCode(Integer.parseInt(itemCode[i]));
            refSupplier.setItemName(itemName[i]);
            refSupplier.setCompanyName(companyName[i]);
            refSupplier.setCompanyAddress(companyAddress[i]);
            refSupplier.setContactPerson(contactPerson[i]);
            refSupplier.setContactNumber(Integer.parseInt(contactNumber[i]));

            if (refSupplierDAO.EncodeRefSupplier(refSupplier)) {
                x = true;
                arrSupplier.add(refSupplier);
            } else {
                x = false;
            }
        }
        if (x == true) {
            RequestDispatcher rd = this.getServletConfig().getServletContext().getRequestDispatcher("/ViewSuppliersServlet");
           
            request.setAttribute("arrSupplier", arrSupplier);
            rd.forward(request, response);

        } else {
           ServletContext context = getServletContext();
          // request.setAttribute("errorMessage", "error");
           RequestDispatcher rd = context.getRequestDispatcher("/SuppliersAndItems.jsp");
           rd.forward(request, response);
        }

    }

}
