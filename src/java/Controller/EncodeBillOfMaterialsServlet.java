package Controller;

import DAO.BillOfMaterialsDAO;
import DAO.ConsumptionReportDAO;
import Model.BillOfMaterials;
import java.io.IOException;
import java.sql.SQLException;
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
public class EncodeBillOfMaterialsServlet extends BaseServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BillOfMaterials billOfMaterials = new BillOfMaterials();
        ArrayList<BillOfMaterials> arrBillOfMaterials = new ArrayList<>();
        BillOfMaterialsDAO billOfMaterialsDAO = new BillOfMaterialsDAO();

        String productID = request.getParameter("productID");
        String productName = request.getParameter("productName");
        String sizeName = request.getParameter("sizeName");
        String[] itemCode = request.getParameterValues("itemCode");
        String[] itemConsumption = request.getParameterValues("itemConsumption");
        String[] unitMeasurement = request.getParameterValues("unitMeasurement");

        boolean x = false;
        for (int i = 0; i < itemCode.length; i++) {
            billOfMaterials.setProductID(Integer.parseInt(productID));
            billOfMaterials.setItemCode(Integer.parseInt(itemCode[i]));
            billOfMaterials.setProductName(productName);
            billOfMaterials.setItemConsumption(Double.parseDouble(itemConsumption[i]));
            billOfMaterials.setUnitMeasurement(unitMeasurement[i]);
            billOfMaterials.setSizeName(sizeName);

            if (billOfMaterialsDAO.EncodeBillOfMaterials(billOfMaterials)) {
                x = true;
                arrBillOfMaterials.add(billOfMaterials);
            } else {
                x = false;
            }
        }
        
        

        if (x == true) {
            
            ConsumptionReportDAO DAO = new ConsumptionReportDAO();
            Integer numberCR = 0;
            try {
                numberCR = DAO.getProductionNumber();

            } catch (SQLException ex) {
                Logger.getLogger(GetPRIDServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/ConsumptionReport.jsp");
            request.setAttribute("BillofMaterials", arrBillOfMaterials);
            request.setAttribute("CRPRNumber", numberCR);
            rd.forward(request, response);
        } else {
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/dashboard.jsp");
            rd.forward(request, response);

        }

    }

}
