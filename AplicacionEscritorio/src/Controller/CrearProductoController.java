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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author 4784.joan23
 */
public class CrearProductoController {

    Conexion conecControl = new Conexion();
    Connection cn = conecControl.conectar();

    

    public CrearProductoController() {
    }

    public boolean crearProductoController(String prod_nom, String prod_descripcio, int prod_descompte, float prod_preu, String serie_nom, String num_bloc, String num_passadis, String num_lleixa, int estoc_q_min, int estoc_q_actual, int estoc_q_max) {
        //conectarm a la base de datos
        
        String queryIDSerie = "SELECT `serie_id` FROM `tbl_serie` WHERE `serie_nom` = '"+serie_nom+"'";
        String insertProducto = "INSERT INTO `tbl_producte`(`prod_nom`, `prod_foto`, `serie_id`, `prod_descripcio`, `prod_descompte`, `prod_preu`) VALUES (?,?,?,?,?,?)";
        String lastInsertProducto = "SELECT DISTINCT last_insert_id() FROM tbl_producte";
        String insertTblLloc = "INSERT INTO `tbl_lloc`(`num_bloc`, `num_passadis`, `num_lleixa`) VALUES ('"+num_bloc+"','"+num_passadis+"','"+num_lleixa+"')";
        String lastInsertLloc = "SELECT DISTINCT last_insert_id() FROM tbl_lloc";
        String insertTblEstoc = "INSERT INTO `tbl_estoc`(`estoc_q_max`, `estoc_q_min`, `estoc_q_actual`, `prod_id`, `lloc_id`) VALUES (?,?,?,?,?)";
        
        PreparedStatement insert1Producto = null;
        PreparedStatement insert2Lloc = null;
        PreparedStatement insert3Estoc = null;
        
        Statement st1 = null;
        Statement st2 = null;
        Statement st3 = null;
        
        ResultSet rs = null;

        
        
        try {
            cn.setAutoCommit(false);
            
            /*********************   SELECT ID SERIE   ***********************/
            
            st1 = cn.createStatement();
            rs = st1.executeQuery(queryIDSerie);
            int idst1 = 0;
            while (rs.next()) {
                idst1 = rs.getInt(1);
            }
            
            /*********************   INSERT EN LA TABLA PRODUCTO   ***********************/
            
            String idSerieEscogido = String.valueOf(idst1);
            insert1Producto = cn.prepareStatement(insertProducto);
            insert1Producto.setString(1, prod_nom);
            insert1Producto.setString(2, "foto1.jpg");
            insert1Producto.setString(3, idSerieEscogido);
            insert1Producto.setString(4, prod_descripcio);
            insert1Producto.setString(5, String.valueOf(prod_descompte));
            insert1Producto.setString(6, String.valueOf(prod_preu));
            insert1Producto.executeUpdate();
            
            /*********************   SELECT ID ULTIMO TABLA PRODUCTO   ***********************/
            
            st2 = cn.createStatement();
            rs = st2.executeQuery(lastInsertProducto);
            int idst2 = 0;
            while (rs.next()) {
                idst2 = rs.getInt(1);
            }
            
            /*********************   INSERT EN LA TABLA LLOC   ***********************/
            
            insert2Lloc = cn.prepareStatement(insertTblLloc);
            insert2Lloc.executeUpdate();
            
            /*********************   SELECT ID ULTIMO TABLA LLOC   ***********************/
            
            st3 = cn.createStatement();
            rs = st3.executeQuery(lastInsertLloc);
            int idst3 = 0;
            while (rs.next()) {
                idst3 = rs.getInt(1);
            }
            
            /*********************   INSERT EN LA TABLA ESTOC   ***********************/
            
            String idLloc = String.valueOf(idst3);
            String idProd = String.valueOf(idst2);

            insert3Estoc = cn.prepareStatement(insertTblEstoc);
            insert3Estoc.setString(1, String.valueOf(estoc_q_max));
            insert3Estoc.setString(2, String.valueOf(estoc_q_min));
            insert3Estoc.setString(3, String.valueOf(estoc_q_actual));
            insert3Estoc.setString(4, idProd);
            insert3Estoc.setString(5, idLloc);
            insert3Estoc.executeUpdate();
            
            
            cn.commit();

            JOptionPane.showMessageDialog(null, "Producto añadido correctamente");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            try {
                cn.rollback();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se puede deshacer");
            }
            return false;
        }
        //ver si el ussuario existe mediante query 

    }

    public void llenarComboCategoria(JComboBox box) {
        ArrayList<Integer> idCategoria = new ArrayList<Integer>();
        ArrayList<String> nombreCategoria = new ArrayList<String>();
        DefaultComboBoxModel value;
        String mostrarCamposCategoria = "SELECT * FROM tbl_categoria";
        Statement st = null;
        ResultSet rs = null;

        try {
            st = cn.createStatement();
            rs = st.executeQuery(mostrarCamposCategoria);

            value = new DefaultComboBoxModel();
            box.setModel(value);

            while (rs.next()) {
                idCategoria.add(rs.getInt("categoria_id"));
                nombreCategoria.add(rs.getString("categoria_nom"));

                value.addElement(rs.getString("categoria_nom"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void llenarComboSerie(JComboBox box1) {
        ArrayList<Integer> idSerie = new ArrayList<Integer>();
        ArrayList<String> nombreSerie = new ArrayList<String>();
        ArrayList<Integer> categoriaIDFK = new ArrayList<Integer>();
        DefaultComboBoxModel valor;
        String mostrarCamposCategoria = "SELECT * FROM tbl_serie";
        Statement st = null;
        ResultSet rs = null;

        try {
            st = cn.createStatement();
            rs = st.executeQuery(mostrarCamposCategoria);

            valor = new DefaultComboBoxModel();
            box1.setModel(valor);

            while (rs.next()) {
                idSerie.add(rs.getInt("serie_id"));
                nombreSerie.add(rs.getString("serie_nom"));
                categoriaIDFK.add(rs.getInt("categoria_id"));

                valor.addElement(rs.getString("serie_nom"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void llenarComboLugar(JComboBox jcNumBloque, JComboBox jcNumeroPasillo, JComboBox jcNumEstanteria) {
        try {
            DefaultComboBoxModel valorBloque;
            DefaultComboBoxModel valorPasillo;
            DefaultComboBoxModel valorEstanteria;

            String numBloque[] = {"Bloc 1", "Bloc 2", "Bloc3", "Bloc 4", "Bloc 5", "Bloc 6", "Bloc 7", "Bloc 8"};
            String numPasillo[] = {"passadis 1", "passadis 2", "passadis 3", "passadis 4", "passadis 5", "passadis 6", "passadis 7", "passadis 8", "passadis 9", "passadis 10", "passadis 11", "passadis 12"};
            String numEstanteria[] = {"lleixa 1", "lleixa 2", "lleixa 3", "lleixa 4", "lleixa 5", "lleixa 6", "lleixa 7", "lleixa 8"};

            valorBloque = new DefaultComboBoxModel();
            valorPasillo = new DefaultComboBoxModel();
            valorEstanteria = new DefaultComboBoxModel();

            jcNumBloque.setModel(valorBloque);
            jcNumeroPasillo.setModel(valorPasillo);
            jcNumEstanteria.setModel(valorEstanteria);

            for (int i = 0; i <= 7; i++) {
                valorBloque.addElement(numBloque[i]);
                valorEstanteria.addElement(numEstanteria[i]);
            }

            for (int i = 0; i <= 11; i++) {
                valorPasillo.addElement(numPasillo[i]);
            }

        } catch (Exception e) {
        }

    }
}
