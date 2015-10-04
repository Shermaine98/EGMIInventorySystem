package Model;

/**
 * 
 * @author Atayan
 * @author Lapidario
 * @author Sy
 * @author Nunez
 *
 */

public class CuttingReport {
    private int productionNumber;
    private int productID;
    private int drNumber;
    private int poNumber;
    private int itemCode;
    private double rawQty;
    private int calculatedQty;
    private int actualQty;
    private int cuttingMaster;
    private String note;
    
    /**
     * @return the productionNumber
     */
    public int getProductionNumber(){
        return productionNumber;
    }
    
    /**
     * @param productionNumber set the productionNumber
     */
    public void setProductionNumber(int productionNumber){
        this.productionNumber = productionNumber;
    }
    
    /**
     * @return the productID
     */
    public int getProductID(){
        return productID;
    }
    
    /**
     * @param productID set the productID
     */
    public void setProductID(int productID){
        this.productID = productID;
    }
    
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
     * @return the poNumber
     */
    public int getPoNumber(){
        return poNumber;
    }
    
    /**
     * @param poNumber set a value to poNumber
     */
    public void setPoNumber(int poNumber){
        this.poNumber = poNumber;
    }
    
    /**
     * @return the itemCode
     */
    public int getItemCode(){
        return itemCode;
    }
    
    /**
     * @param itemCode set the itemCode
     */
    public void setItemCode(int itemCode){
        this.itemCode = itemCode;
    }
    
    /**
     * @return the rawQty
     */
    public double getRawQty(){
        return rawQty;
    }
    
    /**
     * @param rawQty set the rawQty
     */
    public void setRawQty(double rawQty){
        this.rawQty = rawQty;
    }
    
    /**
     * @return the calculatedQty
     */
    public int getCalculatedQty(){
        return calculatedQty;
    }
    
    /**
     * @param calculatedQty set the calculatedQty
     */
    public void setCalculatedQty(int calculatedQty){
        this.calculatedQty = calculatedQty;
    }
    
    /**
     * @return the actualQty
     */
    public int getActualQty(){
        return actualQty;
    }
    
    /**
     * @param actualQty set the actualQty
     */
    public void setActualQty(int actualQty){
        this.actualQty = actualQty;
    }
    
    /**
     * @return the cuttingMaster
     */
    public int getCuttingMaster(){
        return cuttingMaster;
    }
    
    /**
     * @param cuttingMaster set the cuttingMaster
     */
    public void setCuttingMaster(int cuttingMaster){
        this.cuttingMaster = cuttingMaster;
    }
    
    /**
     * @return the note
     */
    public String getNote(){
        return note;
    }
    
    /**
     * @param note set the note
     */
    public void setNote(String note){
        this.note = note;
    }
    
}
