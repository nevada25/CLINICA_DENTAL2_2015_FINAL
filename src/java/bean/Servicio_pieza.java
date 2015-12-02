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
public class Servicio_pieza {

    private String id_servicio;
    private String id_pieza;

    public Servicio_pieza() {
    }

    public Servicio_pieza(String id_servicio, String id_pieza) {
        this.id_servicio = id_servicio;
        this.id_pieza = id_pieza;
    }

    public String getId_pieza() {
        return id_pieza;
    }

    public void setId_pieza(String id_pieza) {
        this.id_pieza = id_pieza;
    }

    public String getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(String id_servicio) {
        this.id_servicio = id_servicio;
    }
    
}
