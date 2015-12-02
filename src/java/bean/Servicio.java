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
public class Servicio extends Categoria_servicio{

    private String id_servicio;
    private String id_cat_serv;
    private String nombre_serv;
    private String precio_max;
    private String precio_min;
    private String estado;
    private String precio;

    public Servicio() {
    }

    public Servicio(String id_servicio, String id_cat_serv, String nombre_serv, String precio_max, String precio_min, String estado, String precio) {
        this.id_servicio = id_servicio;
        this.id_cat_serv = id_cat_serv;
        this.nombre_serv = nombre_serv;
        this.precio_max = precio_max;
        this.precio_min = precio_min;
        this.estado = estado;
        this.precio = precio;
    }
    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(String id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getId_cat_serv() {
        return id_cat_serv;
    }

    public void setId_cat_serv(String id_cat_serv) {
        this.id_cat_serv = id_cat_serv;
    }

    public String getNombre_serv() {
        return nombre_serv;
    }

    public void setNombre_serv(String nombre_serv) {
        this.nombre_serv = nombre_serv;
    }

    public String getPrecio_max() {
        return precio_max;
    }

    public void setPrecio_max(String precio_max) {
        this.precio_max = precio_max;
    }

    public String getPrecio_min() {
        return precio_min;
    }

    public void setPrecio_min(String precio_min) {
        this.precio_min = precio_min;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
}
