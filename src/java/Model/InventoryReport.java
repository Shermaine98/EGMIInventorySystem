package Model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */

public class InventoryReport {
    private int promo;
    private String location;
    private java.sql.Date dateMade;
    private int productID;
    private String size;
    private int remainingQty;
    private int soldQty;
    private int pulledOutQty;
    private String requestNComment;
    
    
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    //THIS IS A LINE DIVIDING VARIABLES FROM GETTERS AND SETTERS//

    /**
     * 
     * @return the promo
     */
    public int getPromo() {
        return promo;
    }

    /**
     * 
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }
     /**
     * 
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * 
     * @param promo the promo to set
     */
    public void setPromo(int promo) {
        this.promo = promo;
    }

    /**
     * 
     * @return the dateMade
     */
    public Date getDateMade() {
        return dateMade;
    }

    /**
     * 
     * @param dateMade the dateMade to set
     * @throws ParseException 
     */
    public void setDateMade() throws ParseException {
        @SuppressWarnings("deprecation")
        java.util.Date madeDate0 = new java.util.Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date madeDate1 = formatter.parse(df.format(madeDate0));
        java.sql.Date sqlreceivedDate1 = new java.sql.Date(madeDate1.getTime());
        this.dateMade = sqlreceivedDate1;
    }

    /**
     * 
     * @return the productID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * 
     * @param productID the productID to set
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * 
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * 
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

  

    /**
     * 
     * @return the remainingQty
     */
    public int getRemainingQty() {
        return remainingQty;
    }

    /**
     * 
     * @param remainingQty the remainingQty to set
     */
    public void setRemainingQty(int remainingQty) {
        this.remainingQty = remainingQty;
    }

    /**
     * 
     * @return the soldQty
     */
    public int getSoldQty() {
        return soldQty;
    }

    /**
     * 
     * @param soldQty the soldQty to set
     */
    public void setSoldQty(int soldQty) {
        this.soldQty = soldQty;
    }

    /**
     * 
     * @return the pulledOutQty
     */
    public int getPulledOutQty() {
        return pulledOutQty;
    }

    /**
     * 
     * @param pulledOutQty the pulledOutQty to set
     */
    public void setPulledOutQty(int pulledOutQty) {
        this.pulledOutQty = pulledOutQty;
    }
    
    /**
     * 
     * @return the requestNComment
     */
    public String getrequestNComment() {
        return requestNComment;
    }

    /**
     * 
     * @param requestNComment the requestNComment to set
     */
    public void setrequestNComment(String requestNComment) {
        this.requestNComment = requestNComment;
    }
    
    
}
