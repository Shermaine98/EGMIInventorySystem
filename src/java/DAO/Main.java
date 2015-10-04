/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ConsumptionReport;
import DAO.ConsumptionReportDAO;
import Model.RefSupplier;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author shermainesy
 */
public class Main {
    public static void main (String args[]) throws ParseException, SQLException{
      ConsumptionReportDAO ConsumptionReportDAO = new ConsumptionReportDAO();
    System.out.println(ConsumptionReportDAO.GetConsumptionReportList(300000000));
   
    }
}
