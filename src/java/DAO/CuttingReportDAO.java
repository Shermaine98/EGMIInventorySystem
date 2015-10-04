package DAO;

import Database.DBConnectionFactory;
import Model.CuttingReport;
import java.sql.*;
import java.text.ParseException;
import java.util.*;
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

public class CuttingReportDAO {

    public boolean EncodeCuttingReport(CuttingReport newCuttingReport) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into cutting_report"
                    + "(productionNumber, productID, drNumber, poNumber, itemCode, rawQty, calculatedQty,"
                    + "actualQty, cuttingMaster, note) values (?,?,?,?,?,?,?,?,?,?) ";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newCuttingReport.getProductionNumber());
            pstmt.setInt(2, newCuttingReport.getProductID());
            pstmt.setInt(3, newCuttingReport.getDrNumber());
            pstmt.setInt(4, newCuttingReport.getPoNumber());
            pstmt.setInt(5, newCuttingReport.getItemCode());
            pstmt.setDouble(6, newCuttingReport.getRawQty());
            pstmt.setInt(7, newCuttingReport.getCalculatedQty());
            pstmt.setInt(8, newCuttingReport.getActualQty());
            pstmt.setInt(9, newCuttingReport.getCuttingMaster());
            pstmt.setString(10, newCuttingReport.getNote());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(CuttingReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<CuttingReport> GetCuttingReportList() throws ParseException {

        ArrayList<CuttingReport> CuttingReport = new ArrayList<CuttingReport>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from cutting_report");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                CuttingReport temp = new CuttingReport();
                temp.setProductionNumber(rs.getInt("productionNumber"));
                temp.setProductID(rs.getInt("productID"));
                temp.setDrNumber(rs.getInt("drNumber"));
                temp.setPoNumber(rs.getInt("poNumber"));
                temp.setItemCode(rs.getInt("itemCode"));
                temp.setRawQty(rs.getDouble("rawQty"));
                temp.setCalculatedQty(rs.getInt("calculatedQty"));
                temp.setActualQty(rs.getInt("actualQty"));
                temp.setCuttingMaster(rs.getInt("cuttingMaster"));
                temp.setNote(rs.getString("note"));
                CuttingReport.add(temp);
            }
            pstmt.close();
            conn.close();

            return CuttingReport;
        } catch (SQLException ex) {
            Logger.getLogger(CuttingReportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
