/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexion;
import View.Login;
import View.VentanaPrincipal;
import java.sql.Connection;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;



public class LoginController {
    Conexion conecControl = new Conexion();
    Connection cn = conecControl.conectar();
    
    
    Statement st1 = null;
    ResultSet rs = null;

    public LoginController() {
    }

    public boolean logearUsuarioController(String usuarioLogin, String passwordLogin) throws SQLException {
        //conectarm a la base de datos
        //ver si el ussuario existe mediante query 
        String queryLogin = "SELECT * FROM tbl_Persona WHERE `Persona_Username` = '"+usuarioLogin+"' AND `Persona_Contra` = '"+passwordLogin+"'";
        st1 = cn.createStatement();
        rs = st1.executeQuery(queryLogin);
        
        if (rs.next()) {
            VentanaPrincipal gotoPrincipal = new VentanaPrincipal();
            Login ventanalogin = new Login();
            JOptionPane.showMessageDialog(null, "Login Correcto");
            gotoPrincipal.setVisible(true);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Login Incorrecto");
            return false;
        }
    }
    
}
