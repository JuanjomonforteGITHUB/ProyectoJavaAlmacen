/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author 4784.joan23
 */
public class CrearProductoController {

    Conexion conecControl = new Conexion();
    Connection cn = conecControl.conectar();

    PreparedStatement insert1Producto = null;
    ResultSet rs = null;

    public CrearProductoController() {
    }
    
    public boolean crearProductoController(prod_nom, prod_foto, prod_descripcio, prod_descompte, prod_preu, serie_nom, num_bloc, num_passadis , num_lleixa, estoc_q_min, estoc_q_actual, estoc_q_max, categoria_nom) {
        //conectarm a la base de datos
        try {
            String insertUsuari = "INSERT INTO `tbl_persona`(`Persona_Nom`, `Persona_Cognom`, `Persona_Correu`, `Persona_Username`, `Persona_Contra`) VALUES (?,?,?,?,?)";
            insert1Producto = cn.prepareStatement(insertUsuari);
            insert1Producto.setString(1, nuevouserNombre);
            insert1Producto.setString(2, nuevouserApellidos);
            insert1Producto.setString(3, nuevouserCorreo);
            insert1Producto.setString(4, nuevouserUsuario);
            insert1Producto.setString(5, nuevouserPassword);

            insert1Producto.executeUpdate();

            JOptionPane.showMessageDialog(null, "Proucto añadido correctamente");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
        //ver si el ussuario existe mediante query 

    }
}
