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
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmacia", "root", "Ne59481739#");
        //JOptionPane.showMessageDialog(null, "Conexion exitosa");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error de conexion: " + e.getMessage());
        e.printStackTrace();
    }
    return conexion;
}

}
