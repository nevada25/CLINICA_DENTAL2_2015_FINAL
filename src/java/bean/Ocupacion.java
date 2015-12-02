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
public class Ocupacion {

    private String id_ocupacion;
    private String nombre_ocupacion;
    private String estado;

    public Ocupacion() {
    }

    public Ocupacion(String id_ocupacion, String nombre_ocupacion, String estado) {
        this.id_ocupacion = id_ocupacion;
        this.nombre_ocupacion = nombre_ocupacion;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId_ocupacion() {
        return id_ocupacion;
    }

    public void setId_ocupacion(String id_ocupacion) {
        this.id_ocupacion = id_ocupacion;
    }

    public String getNombre_ocupacion() {
        return nombre_ocupacion;
    }

    public void setNombre_ocupacion(String nombre_ocupacion) {
        this.nombre_ocupacion = nombre_ocupacion;
    }
    
}
