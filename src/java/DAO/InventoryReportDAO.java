package DAO;

import Database.DBConnectionFactory;
import Model.InventoryReport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */
public class InventoryReportDAO {

    public boolean EncodeInventoryReport(InventoryReport newInventoryReport) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into inventory_report"
                    + "(dateMade, remainingQty,pulledOutQty,soldQty,requestNcomment,promo,location,productID, size) "
                    + "values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setDate(1, newInventoryReport.getDateMade());
            pstmt.setInt(2, newInventoryReport.getRemainingQty());
            pstmt.setInt(3, newInventoryReport.getPulledOutQty());
            pstmt.setInt(4, newInventoryReport.getSoldQty());
            pstmt.setString(5, newInventoryReport.getrequestNComment());
            pstmt.setInt(6, newInventoryReport.getPromo());
            pstmt.setString(7, newInventoryReport.getLocation());
            pstmt.setInt(8, newInventoryReport.getProductID());
            pstmt.setString(9, newInventoryReport.getSize());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(InventoryReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<InventoryReport> GetAllInventoryReport() throws ParseException {
        ArrayList<InventoryReport> InventoryReport = new ArrayList<InventoryReport>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM inventory_report");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                InventoryReport newInventoryReport = new InventoryReport();
                newInventoryReport.setDateMade();
                newInventoryReport.setRemainingQty(rs.getInt("remainingQty"));
                newInventoryReport.setSoldQty(rs.getInt("soldQty"));
                newInventoryReport.setPulledOutQty(rs.getInt("pulledOutQty"));
                newInventoryReport.setrequestNComment(rs.getString("requestNcomment"));
                newInventoryReport.setPromo(rs.getInt("promo"));
                newInventoryReport.setLocation(rs.getString("location"));
                newInventoryReport.setProductID(rs.getInt("productID"));
                newInventoryReport.setSize(rs.getString("size"));

                InventoryReport.add(newInventoryReport);

            }

            pstmt.close();
            rs.close();
            conn.close();

            return InventoryReport;
        } catch (SQLException ex) {
            Logger.getLogger(InventoryReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
