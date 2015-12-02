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
public class Habito_nocivo {

    private String id_habito_nocivo;
    private String nombre_hab_noc;

    public Habito_nocivo() {
    }

    public Habito_nocivo(String id_habito_nocivo, String nombre_hab_noc) {
        this.id_habito_nocivo = id_habito_nocivo;
        this.nombre_hab_noc = nombre_hab_noc;
    }

    public String getNombre_hab_noc() {
        return nombre_hab_noc;
    }

    public void setNombre_hab_noc(String nombre_hab_noc) {
        this.nombre_hab_noc = nombre_hab_noc;
    }

    public String getId_habito_nocivo() {
        return id_habito_nocivo;
    }

    public void setId_habito_nocivo(String id_habito_nocivo) {
        this.id_habito_nocivo = id_habito_nocivo;
    }
    
}
