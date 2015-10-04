package Model;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */
public class Promo {

    private int employeeID;
    private String location;
    private String address;

    //THIS IS A LINE DIVIDING VARIABLES FROM GETTERS AND SETTERS//
    /**
     *
     * @return the promo
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     *
     * @param promo the promo to set
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     *
     * @return the outlet
     */
    public String getlocation() {
        return location;
    }

    /**
     *
     * @param outlet the outlet to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

}
