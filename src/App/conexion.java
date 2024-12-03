/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;


import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author jonat
 */
public class conexion {
    
    public static Connection getConexion(){
    Connection conexion = null;
    
   
    try {        
//        conexion = DriverManager.getConnection("jdbc:mysql://26.183.76.152:3306/farmacia", "remote", "Ne59481739#");
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/farmacia", "root", "Ne59481739#");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error de conexion: " + e.getMessage());
    }
    return conexion;
}

}
