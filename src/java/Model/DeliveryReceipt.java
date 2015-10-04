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
public class DeliveryReceipt {
    private int drNumber;
    private int doNumber;
    private int promo;
    private String location;
    private Date dateMade;
    private Date deliveryDate;
    
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    
    /**
     * @return the drNumber
     */
    public int getDrNumber(){
        return drNumber;
    }
    
    /**
     * @param drNumber set a value to drNumber
     */
    public void setDrNumber(int drNumber){
        this.drNumber = drNumber;
    }
    
    /**
     * @return the doNumber
     */
    public int getDoNumber(){
        return doNumber;
    }
    
    /**
     * @param doNumber set a value to doNumber
     */
    public void setDoNumber(int doNumber){
        this.doNumber = doNumber;
    }
    
    /**
     * @return the promo
     */
    public int getPromo(){
        return promo;
    }
    
    /**
     * @param promo set the promo
     */
    public void setPromo(int promo){
        this.promo = promo;
    }
    
    /**
     * @return the location
     */
    public String getLocation(){
        return location;
    }
    
    /**
     * @param location set the location
     */
    public void setLocation(String location){
        this.location = location;
    }
    
  
    
    /**
     * @return the dateMade
     */
    public java.sql.Date getDateMade(){
        return dateMade;
    }
    
    /**
     * @param dateMade set the dateMade
     */
    public void setDateMade() throws ParseException{
        java.util.Date currentDate = new java.util.Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date currentDate1 = formatter.parse(df.format(currentDate));
        java.sql.Date sqlDate = new java.sql.Date(currentDate1.getTime());
        this.dateMade = sqlDate;
    }
    
    /**
     * @return the deliveryDate
     */
    public Date getDeliveryDate(){
        return deliveryDate;
    }
    
    /**
     * @param deliveryDate set the deliveryDate
     */
    public void setDeliveryDate(java.util.Date deliveryDate) throws ParseException{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = formatter.parse(df.format(deliveryDate));
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
        this.deliveryDate = sqlDate;
    }
    
}
