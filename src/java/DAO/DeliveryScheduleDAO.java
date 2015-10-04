package DAO;

import Database.DBConnectionFactory;
import Model.DeliverySchedule;
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
public class DeliveryScheduleDAO {

    public boolean EncodeDeliverySchedule(DeliverySchedule newDeliverySchedule) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into delivery_schedule"
                    + "(dateMade,deliveryDate,driver,preparedBy,boxQty,doNumber,promo,location) values (?,?,?,?,?,?,?,?) ";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setDate(1, newDeliverySchedule.getDateMade());
            pstmt.setDate(2, newDeliverySchedule.getDeliveryDate());
            pstmt.setInt(3, newDeliverySchedule.getDriver());
            pstmt.setInt(4, newDeliverySchedule.getPreparedBy());
            pstmt.setInt(5, newDeliverySchedule.getBoxQty());
            pstmt.setInt(6, newDeliverySchedule.getDoNumber());
            pstmt.setInt(7, newDeliverySchedule.getPromo());
            pstmt.setString(8, newDeliverySchedule.getLocation());

            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<DeliverySchedule> GetDeliveryScheduleList() throws ParseException {

        ArrayList<DeliverySchedule> DeliverySchedule = new ArrayList<DeliverySchedule>();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from delivery_schedule");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DeliverySchedule newDeliverySchedule = new DeliverySchedule();
                newDeliverySchedule.setDateMade();
                newDeliverySchedule.setDeliveryDate(rs.getString("deliveryDate"));
                newDeliverySchedule.setDriver(rs.getInt("driver"));
                newDeliverySchedule.setPreparedBy(rs.getInt("preparedBy"));
                newDeliverySchedule.setBoxQty(rs.getInt("boxQty"));
                newDeliverySchedule.setDoNumber(rs.getInt("doNumber"));
                newDeliverySchedule.setPromo(rs.getInt("promo"));
                newDeliverySchedule.setLocation(rs.getString("location"));

                DeliverySchedule.add(newDeliverySchedule);
            }
            pstmt.close();
            conn.close();

            return DeliverySchedule;
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
