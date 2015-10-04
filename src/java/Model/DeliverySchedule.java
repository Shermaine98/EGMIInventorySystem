package Model;

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

public class DeliverySchedule {
private java.sql.Date dateMade;
private java.sql.Date deliveryDate;
private int driver;
private int preparedBy;
private int boxQty;
private int doNumber;
private int promo;
private String location;

 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * @return the dateMade
     */
    public java.sql.Date getDateMade() {
        return dateMade;
    }

    /**
     * @param dateMade the dateMade to set
     */
   public void setDateMade() throws ParseException{
        @SuppressWarnings("deprecation")
        java.util.Date madeDate0 = new java.util.Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date madeDate1 = formatter.parse(df.format(madeDate0));
        java.sql.Date sqlreceivedDate1 = new java.sql.Date(madeDate1.getTime());
        this.dateMade = sqlreceivedDate1;
    }

    /**
     * @return the deliveryDate
     */
    public java.sql.Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * @param deliveryDate the deliveryDate to set
     */
    public void setDeliveryDate(String deliveryDate) throws ParseException {
        @SuppressWarnings("deprecation")
        java.util.Date deliveryDate2 = formatter.parse(deliveryDate);
        java.sql.Date deliveryDate1 = new java.sql.Date(deliveryDate2.getTime());
        this.deliveryDate = deliveryDate1;
    }

    /**
     * @return the driver
     */
    public int getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(int driver) {
        this.driver = driver;
    }

    /**
     * @return the preparedBy
     */
    public int getPreparedBy() {
        return preparedBy;
    }

    /**
     * @param preparedBy the preparedBy to set
     */
    public void setPreparedBy(int preparedBy) {
        this.preparedBy = preparedBy;
    }

    /**
     * @return the boxQty
     */
    public int getBoxQty() {
        return boxQty;
    }

    /**
     * @param boxQty the boxQty to set
     */
    public void setBoxQty(int boxQty) {
        this.boxQty = boxQty;
    }

    /**
     * @return the doNumber
     */
    public int getDoNumber() {
        return doNumber;
    }

    /**
     * @param doNumber the doNumber to set
     */
    public void setDoNumber(int doNumber) {
        this.doNumber = doNumber;
    }

    /**
     * @return the promo
     */
    public int getPromo() {
        return promo;
    }

    /**
     * @param promo the promo to set
     */
    public void setPromo(int promo) {
        this.promo = promo;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    
}
