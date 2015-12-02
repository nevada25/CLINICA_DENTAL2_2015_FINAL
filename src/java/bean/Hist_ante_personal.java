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
public class Hist_ante_personal {

    private String id_historia_clinica;
    private String id_ante_personal;
    private String estado;

    public Hist_ante_personal() {
    }

    public String getId_historia_clinica() {
        return id_historia_clinica;
    }

    public void setId_historia_clinica(String id_historia_clinica) {
        this.id_historia_clinica = id_historia_clinica;
    }

    public String getId_ante_personal() {
        return id_ante_personal;
    }

    public void setId_ante_personal(String id_ante_personal) {
        this.id_ante_personal = id_ante_personal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
