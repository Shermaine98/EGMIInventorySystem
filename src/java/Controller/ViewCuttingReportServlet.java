package Controller;

import DAO.CuttingReportDAO;
import Model.CuttingReport;
import java.io.IOException;
import java.text.ParseException;
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
public class ViewCuttingReportServlet extends BaseServlet {

    @Override
    public void servletAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            CuttingReportDAO DAO = new CuttingReportDAO();
            ArrayList<CuttingReport> cutrList = DAO.GetCuttingReportList();

            ServletContext context = getServletContext();
           
            RequestDispatcher rd = context.getRequestDispatcher("/ViewCuttingReport.jsp");
            request.setAttribute("cuttingreportlist", cutrList);
            rd.forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ViewCuttingReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
