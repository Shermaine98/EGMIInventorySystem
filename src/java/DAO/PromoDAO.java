package DAO;

import Database.DBConnectionFactory;
import Model.Promo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class PromoDAO {

    public boolean RegisterPromo(Promo newPromo) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            int rows;
            try (Connection conn = myFactory.getConnection()) {
                String query = "insert into promo"
                        + "(address, employeeID,location) "
                        + "values (?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, newPromo.getAddress());
                pstmt.setInt(2, newPromo.getEmployeeID());
                pstmt.setString(3, newPromo.getlocation());
                rows = pstmt.executeUpdate();
            }
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(PromoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Promo> GetAllPromo() {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            ArrayList<Promo> Promo;
            try (Connection conn = myFactory.getConnection();
                    PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM promo")) {
                Promo = new ArrayList<>();
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Promo newPromo = new Promo();
                    newPromo.setEmployeeID(rs.getInt("employeeID"));
                    newPromo.setLocation(rs.getString("location"));
                    newPromo.setAddress(rs.getString("address"));
                    Promo.add(newPromo);

                }
            }
            return Promo;
        } catch (SQLException ex) {
            Logger.getLogger(PromoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
