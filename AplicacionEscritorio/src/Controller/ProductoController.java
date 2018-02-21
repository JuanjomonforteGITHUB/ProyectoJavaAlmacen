/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexion;
import Model.ListadoInventario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 4784.joan23
 */
public class ProductoController {

    public ProductoController() {
    }

    Conexion conecControl = new Conexion();
    Connection cn = conecControl.conectar();

    private ArrayList<Integer> posicionCategoria = new ArrayList<Integer>();
    private ArrayList<String> nombreCategoria = new ArrayList<String>();
    //public ArrayList<ListadoInventario> listadoInventario = new ArrayList<ListadoInventario>();

    public DefaultTableModel mostrarProducto() {
        DefaultTableModel tblProducto = null;

        String productos_sql = "SELECT tbl_producte.prod_id , tbl_producte.prod_nom, tbl_producte.prod_foto, tbl_producte.prod_descripcio, tbl_producte.prod_descompte, tbl_producte.prod_preu, tbl_serie.serie_nom, tbl_lloc.num_bloc, tbl_lloc.num_passadis, tbl_lloc.num_lleixa, tbl_estoc.estoc_q_min, tbl_estoc.estoc_q_actual, tbl_estoc.estoc_q_max, tbl_categoria.categoria_nom FROM `tbl_categoria` LEFT JOIN `tbl_serie` ON tbl_serie.categoria_id = tbl_categoria.categoria_id LEFT JOIN `tbl_producte` ON tbl_producte.serie_id = tbl_serie.serie_id LEFT JOIN `tbl_estoc` ON tbl_estoc.prod_id = tbl_producte.prod_id LEFT JOIN `tbl_lloc` ON tbl_lloc.lloc_id = tbl_estoc.lloc_id";
        Statement st1 = null;
        String vectorProducto[] = new String[14];
        String vectorProducto1[] = new String[14];
        vectorProducto1[0] = "ID";
        vectorProducto1[1] = "Nombre";
        vectorProducto1[2] = "Foto";
        vectorProducto1[3] = "Descripcion";
        vectorProducto1[4] = "Descuento";
        vectorProducto1[5] = "Precio";
        vectorProducto1[6] = "Numero de serie";
        vectorProducto1[7] = "Numero de bloque";
        vectorProducto1[8] = "Numero de pasillo";
        vectorProducto1[9] = "Numero de estanteria";
        vectorProducto1[10] = "Stock minimo";
        vectorProducto1[11] = "Stock actual";
        vectorProducto1[12] = "Stock maximo";
        vectorProducto1[13] = "Nombre Categoria";

        tblProducto = new DefaultTableModel(null, vectorProducto1);

        try {
            st1 = cn.createStatement();
            ResultSet rs = st1.executeQuery(productos_sql);
            while (rs.next()) {
                vectorProducto[0] = rs.getString("prod_id");
                vectorProducto[1] = rs.getString("prod_nom");
                vectorProducto[2] = rs.getString("prod_foto");
                vectorProducto[3] = rs.getString("prod_descripcio");
                vectorProducto[4] = String.valueOf(rs.getInt("prod_descompte"));
                vectorProducto[5] = String.valueOf(rs.getInt("prod_preu"));
                vectorProducto[6] = rs.getString("serie_nom");
                vectorProducto[7] = rs.getString("num_bloc");
                vectorProducto[8] = rs.getString("num_passadis");
                vectorProducto[9] = rs.getString("num_lleixa");
                vectorProducto[10] = String.valueOf(rs.getInt("estoc_q_min"));
                vectorProducto[11] = String.valueOf(rs.getInt("estoc_q_actual"));
                vectorProducto[12] = String.valueOf(rs.getInt("estoc_q_max"));
                vectorProducto[13] = rs.getString("categoria_nom");
                tblProducto.addRow(vectorProducto);
                //listadoInventario.add(vectorProducto);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return tblProducto;
    }

    public ArrayList<ListadoInventario> mostrarListadoProductos() {
         
    ArrayList<ListadoInventario> listadoInventario = new ArrayList<ListadoInventario>();

    String productos_sql = "SELECT tbl_producte.prod_id , tbl_producte.prod_nom, tbl_producte.prod_foto, tbl_producte.prod_descripcio, tbl_producte.prod_descompte, tbl_producte.prod_preu, tbl_serie.serie_nom, tbl_lloc.num_bloc, tbl_lloc.num_passadis, tbl_lloc.num_lleixa, tbl_estoc.estoc_q_min, tbl_estoc.estoc_q_actual, tbl_estoc.estoc_q_max, tbl_categoria.categoria_nom FROM `tbl_categoria` LEFT JOIN `tbl_serie` ON tbl_serie.categoria_id = tbl_categoria.categoria_id LEFT JOIN `tbl_producte` ON tbl_producte.serie_id = tbl_serie.serie_id LEFT JOIN `tbl_estoc` ON tbl_estoc.prod_id = tbl_producte.prod_id LEFT JOIN `tbl_lloc` ON tbl_lloc.lloc_id = tbl_estoc.lloc_id";
    Statement st1 = null;
        try {
            st1 = cn.createStatement();
            ResultSet rs = st1.executeQuery(productos_sql);
            while (rs.next()) {
                ListadoInventario miProducto = new ListadoInventario();
                miProducto.setProd_id(rs.getString("prod_id"));
                miProducto.setProd_nom(rs.getString("prod_nom"));
                miProducto.setProd_foto(rs.getString("prod_foto"));
                miProducto.setProd_descripcio(rs.getString("prod_descripcio"));
                miProducto.setProd_descompte(String.valueOf(rs.getInt("prod_descompte")));
                miProducto.setProd_preu(String.valueOf(rs.getInt("prod_preu")));
                miProducto.setSerie_nom(rs.getString("serie_nom"));
                miProducto.setNum_bloc(rs.getString("num_bloc"));
                miProducto.setNum_passadis(rs.getString("num_passadis"));
                miProducto.setNum_lleixa(rs.getString("num_lleixa"));
                miProducto.setEstoc_q_min(String.valueOf(rs.getInt("estoc_q_min")));
                miProducto.setEstoc_q_actual(String.valueOf(rs.getInt("estoc_q_actual")));
                miProducto.setEstoc_q_max(String.valueOf(rs.getInt("estoc_q_max")));
                miProducto.setCategoria_nom(rs.getString("categoria_nom"));
                listadoInventario.add(miProducto);
            }

        }
        catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                return null;
        }

    return listadoInventario ;
}

}
