/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle_infos;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author 215082627
 */
public class ConnectionUtil { //database connection class for centralization
    Connection con = null;  
     public static  Connection connectdb() {
       try{
           //Class.forName("com.mysql.jdbc.Driver");
           Class.forName("com.mysql.cj.jdbc.Driver");//loading driver
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicles","root","");
           JOptionPane.showMessageDialog(null,"Connection has been established!");//confirmation of conncection
           return con;
           
       } 
       catch(Exception ex){
           System.out.println("Error:+exjdbc");
           return null;
       }
       }
    
    
    
}
