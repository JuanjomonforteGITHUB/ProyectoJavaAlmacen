/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 4784.joan23
 */
public class ListadoInventario {
    String prod_id;
    String prod_nom;
    String prod_foto;
    String prod_descripcio;
    String prod_descompte;
    String prod_preu;
    String serie_nom;
    String num_bloc;
    String num_passadis;
    String num_lleixa;
    String estoc_q_min;
    String estoc_q_actual;
    String estoc_q_max;
    String categoria_nom;

    public ListadoInventario() {
    }

    public ListadoInventario(String prod_id, String prod_nom, String prod_foto, String prod_descripcio, String prod_descompte, String prod_preu, String serie_nom, String num_bloc, String num_passadis, String num_lleixa, String estoc_q_min, String estoc_q_actual, String estoc_q_max, String categoria_nom) {
        this.prod_id = prod_id;
        this.prod_nom = prod_nom;
        this.prod_foto = prod_foto;
        this.prod_descripcio = prod_descripcio;
        this.prod_descompte = prod_descompte;
        this.prod_preu = prod_preu;
        this.serie_nom = serie_nom;
        this.num_bloc = num_bloc;
        this.num_passadis = num_passadis;
        this.num_lleixa = num_lleixa;
        this.estoc_q_min = estoc_q_min;
        this.estoc_q_actual = estoc_q_actual;
        this.estoc_q_max = estoc_q_max;
        this.categoria_nom = categoria_nom;
    }

    public String getProd_id() {
        return prod_id;
    }

    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_nom() {
        return prod_nom;
    }

    public void setProd_nom(String prod_nom) {
        this.prod_nom = prod_nom;
    }

    public String getProd_foto() {
        return prod_foto;
    }

    public void setProd_foto(String prod_foto) {
        this.prod_foto = prod_foto;
    }

    public String getProd_descripcio() {
        return prod_descripcio;
    }

    public void setProd_descripcio(String prod_descripcio) {
        this.prod_descripcio = prod_descripcio;
    }

    public String getProd_descompte() {
        return prod_descompte;
    }

    public void setProd_descompte(String prod_descompte) {
        this.prod_descompte = prod_descompte;
    }

    public String getProd_preu() {
        return prod_preu;
    }

    public void setProd_preu(String prod_preu) {
        this.prod_preu = prod_preu;
    }

    public String getSerie_nom() {
        return serie_nom;
    }

    public void setSerie_nom(String serie_nom) {
        this.serie_nom = serie_nom;
    }

    public String getNum_bloc() {
        return num_bloc;
    }

    public void setNum_bloc(String num_bloc) {
        this.num_bloc = num_bloc;
    }

    public String getNum_passadis() {
        return num_passadis;
    }

    public void setNum_passadis(String num_passadis) {
        this.num_passadis = num_passadis;
    }

    public String getNum_lleixa() {
        return num_lleixa;
    }

    public void setNum_lleixa(String num_lleixa) {
        this.num_lleixa = num_lleixa;
    }

    public String getEstoc_q_min() {
        return estoc_q_min;
    }

    public void setEstoc_q_min(String estoc_q_min) {
        this.estoc_q_min = estoc_q_min;
    }

    public String getEstoc_q_actual() {
        return estoc_q_actual;
    }

    public void setEstoc_q_actual(String estoc_q_actual) {
        this.estoc_q_actual = estoc_q_actual;
    }

    public String getEstoc_q_max() {
        return estoc_q_max;
    }

    public void setEstoc_q_max(String estoc_q_max) {
        this.estoc_q_max = estoc_q_max;
    }

    public String getCategoria_nom() {
        return categoria_nom;
    }

    public void setCategoria_nom(String categoria_nom) {
        this.categoria_nom = categoria_nom;
    }
    
    
}

