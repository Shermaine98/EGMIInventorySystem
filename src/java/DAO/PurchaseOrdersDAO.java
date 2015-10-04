//package DAO;
//
//import Database.DBConnectionFactory;
//import Model.PurchaseOrders;
//import Model.RefSupplier;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//public class PurchaseOrdersDAO {
//    
//       public ArrayList<PurchaseOrders> getPurchaseOrders(int supplierID) throws SQLException {
//        DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
//        Connection conn = myFactory.getConnection();
//        
//        String query = "SELECT * FROM `ref_supplier`";
//        
//        PreparedStatement ps = conn.prepareStatement(query);
//     //   ps.setInt(0, supplierID);
//        ArrayList<RefSupplier> RefSupplierList = new ArrayList();
//        ResultSet rs = ps.executeQuery();
//       
//        while (rs.next()) {
//             RefSupplier RefSupplierN = new RefSupplier();
//             RefSupplierN.setSupplierID(rs.getInt("supplierID"));
//             RefSupplierN.setItemCode(rs.getInt("itemCode"));
//             RefSupplierN.setItemName(rs.getString("itemName"));
//             RefSupplierN.setCompanyName(rs.getString("companyName"));
//             RefSupplierN.setCompanyAddress(rs.getString("companyAddress"));
//             RefSupplierN.setContactPerson(rs.getString("contactPerson"));
//             RefSupplierN.setContactNumber(rs.getInt("contactNumber"));
//             if(RefSupplierN.getSupplierID()==supplierID){
//                 RefSupplierList.add(RefSupplierN);  
//             }
//        }
//        rs.close();
//      //  return RefSupplierList;
//
//    }
//    
//    
//}
