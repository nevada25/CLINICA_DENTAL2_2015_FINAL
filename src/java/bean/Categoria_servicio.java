/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Luis Lavado
 */
public class Categoria_servicio {

    private String id_cat_serv;
    private String nombre_cat_serv;

    public Categoria_servicio() {
    }

    public Categoria_servicio(String id_cat_serv, String nombre_cat_serv) {
        this.id_cat_serv = id_cat_serv;
        this.nombre_cat_serv = nombre_cat_serv;
    }
    

    public String getId_cat_serv() {
        return id_cat_serv;
    }

    public void setId_cat_serv(String id_cat_serv) {
        this.id_cat_serv = id_cat_serv;
    }

    public String getNombre_cat_serv() {
        return nombre_cat_serv;
    }

    public void setNombre_cat_serv(String nombre_cat_serv) {
        this.nombre_cat_serv = nombre_cat_serv;
    }
    
}

