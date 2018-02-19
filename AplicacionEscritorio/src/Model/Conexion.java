/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 4784.joan23
 */
public class Conexion {
    public String db="bd_estoc";
    public String url="jdbc:mysql://127.0.0.1/" +db;
    public String user="root";
    public String pass="";

    public Conexion() {
    }
    
    public Connection conectar(){
        Connection link = null;
        
        try {
            //Usar la classe DriverManager para eso he de importar el Driver 
            //a traves de un fichero jar
            
            Class.forName("org.gjt.mm.mysql.Driver");
            link=DriverManager.getConnection(this.url, this.user, this.pass);
            
            //System.out.println("conexion establecida con exito");
                    
            //JOptionPane.showMessageDialog(null, "conexion correcta");      
            
            
        } catch (ClassNotFoundException e) {
            JOptionPane.showConfirmDialog(null, e);
            JOptionPane.showMessageDialog(null, "conexion erronea");
            
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            JOptionPane.showMessageDialog(null, "conexion erronea");
        }
        
       return link;
    }
}
