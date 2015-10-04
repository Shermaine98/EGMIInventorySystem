package Controller;

import DAO.RefSubconDAO;
import Model.RefSubcon;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */
public class GetSubcontractorAndServiceForSubcontracorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String SubconID = request.getParameter("SubconID");
            System.out.print(SubconID);
            int SubconIDIDInt = Integer.parseInt(SubconID);
            System.out.print(SubconID);
            ArrayList<RefSubcon> RefSubconList = new RefSubconDAO().getSubcon(SubconIDIDInt);
            System.out.print(RefSubconList.get(0).getCompanyName());
            JSONArray array = new JSONArray();
            for (int i = 0; i < RefSubconList.size(); i++) {
                JSONObject obj = new JSONObject();
                try {
                    obj.put("SubconID", RefSubconList.get(i).getSubconID());
                    obj.put("companyName", RefSubconList.get(i).getCompanyName());
                    obj.put("companyAddress", RefSubconList.get(i).getCompanyAddress());
                    obj.put("contactPerson", RefSubconList.get(i).getContactPerson());
                    obj.put("contactNumber", RefSubconList.get(i).getContactNumber());
                    obj.put("service", RefSubconList.get(i).getService());
                    array.put(obj);

                } catch (JSONException ex) {
                    Logger.getLogger(GetSubcontractorAndServiceForSubcontracorServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            out.print(array);
            out.flush();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(GetSubcontractorAndServiceForSubcontracorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(GetSubcontractorAndServiceForSubcontracorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

