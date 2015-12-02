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
public class Diagnostico_pre {

    private String id_diagnostico_pre;
    private String descripcion;
    private String id_historia_clinica;

    public Diagnostico_pre() {
    }

    public Diagnostico_pre(String id_diagnostico_pre, String descripcion, String id_historia_clinica) {
        this.id_diagnostico_pre = id_diagnostico_pre;
        this.descripcion = descripcion;
        this.id_historia_clinica = id_historia_clinica;
    }

    public String getId_historia_clinica() {
        return id_historia_clinica;
    }

    public void setId_historia_clinica(String id_historia_clinica) {
        this.id_historia_clinica = id_historia_clinica;
    }

    public String getId_diagnostico_pre() {
        return id_diagnostico_pre;
    }

    public void setId_diagnostico_pre(String id_diagnostico_pre) {
        this.id_diagnostico_pre = id_diagnostico_pre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
