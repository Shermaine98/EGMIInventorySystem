package DAO;

import Database.DBConnectionFactory;
import Model.DeliveryReceipt;
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
public class DeliveryReceiptDAO {

    public boolean EncodeDeliveryReceipt(DeliveryReceipt newDeliveryReceipt) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into deliver_receipt"
                    + "(drNumber, doNumber, promo, location, deliveryDate) "
                    + "values (?,?,?,?,?,?) ";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, newDeliveryReceipt.getDrNumber());
            pstmt.setInt(2, newDeliveryReceipt.getDoNumber());
            pstmt.setInt(3, newDeliveryReceipt.getPromo());
            pstmt.setString(4, newDeliveryReceipt.getLocation());
            pstmt.setDate(7, newDeliveryReceipt.getDateMade());
            pstmt.setDate(8, newDeliveryReceipt.getDeliveryDate());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryReceiptDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<DeliveryReceipt> GetDeliveryReceiptList() throws ParseException {

        ArrayList<DeliveryReceipt> DeliveryReceipt = new ArrayList<DeliveryReceipt>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from deliver_receipt");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DeliveryReceipt temp = new DeliveryReceipt();
                temp.setDrNumber(rs.getInt("drNumber"));
                temp.setDoNumber(rs.getInt("doNumber"));
                temp.setPromo(rs.getInt("promo"));
                temp.setLocation(rs.getString("location"));
                temp.setDateMade();
                temp.setDeliveryDate(rs.getDate("deliveryDate"));
                DeliveryReceipt.add(temp);
            }
            pstmt.close();
            conn.close();

            return DeliveryReceipt;
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryReceiptDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
