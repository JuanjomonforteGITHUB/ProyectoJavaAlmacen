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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author 4784.joan23
 */
public class CrearUserController {

    Conexion conecControl = new Conexion();
    Connection cn = conecControl.conectar();

    PreparedStatement insert1Usuario = null;
    ResultSet rs = null;

    public CrearUserController() {
    }

    public boolean crearUsuarioController(String nuevouserNombre, String nuevouserApellidos, String nuevouserCorreo, String nuevouserUsuario, String nuevouserPassword) {
        //conectarm a la base de datos
        try {
            String insertUsuari = "INSERT INTO `tbl_persona`(`Persona_Nom`, `Persona_Cognom`, `Persona_Correu`, `Persona_Username`, `Persona_Contra`) VALUES (?,?,?,?,?)";
            insert1Usuario = cn.prepareStatement(insertUsuari);
            insert1Usuario.setString(1, nuevouserNombre);
            insert1Usuario.setString(2, nuevouserApellidos);
            insert1Usuario.setString(3, nuevouserCorreo);
            insert1Usuario.setString(4, nuevouserUsuario);
            insert1Usuario.setString(5, nuevouserPassword);

            insert1Usuario.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuario añadido correctamente");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
//ver si el ussuario existe mediante query 

    }
}
