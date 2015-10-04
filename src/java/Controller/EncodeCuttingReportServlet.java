package Controller;

import DAO.CuttingReportDAO;
import Model.CuttingReport;
import java.io.IOException;
import java.io.PrintWriter;
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
public class EncodeCuttingReportServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        CuttingReport cuttingReport = new CuttingReport();

        cuttingReport.setProductionNumber(Integer.parseInt(request.getParameter("productionNumber")));
        cuttingReport.setProductID(Integer.parseInt(request.getParameter("productID")));
        cuttingReport.setDrNumber(Integer.parseInt(request.getParameter("drNumber")));
        cuttingReport.setPoNumber(Integer.parseInt(request.getParameter("poNumber")));
        cuttingReport.setItemCode(Integer.parseInt(request.getParameter("itemCode")));
        cuttingReport.setRawQty(Integer.parseInt(request.getParameter("rawQty")));
        cuttingReport.setCalculatedQty(Integer.parseInt(request.getParameter("calculatedQty")));
        cuttingReport.setActualQty(Integer.parseInt(request.getParameter("actualQty")));
        cuttingReport.setCuttingMaster(Integer.parseInt(request.getParameter("cuttingMaster")));
        cuttingReport.setNote(request.getParameter("note"));

        CuttingReportDAO cuttingReportDAO = new CuttingReportDAO();
        if (cuttingReportDAO.EncodeCuttingReport(cuttingReport)) {

            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/CuttingReport.jsp");

            request.setAttribute("cuttingReport", cuttingReport);
            rd.forward(request, response);
        } else {
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/CuttingReport.jsp");
            rd.forward(request, response);

        }
    }

}
