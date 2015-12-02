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
public class Hist_hab_noc {

    private String id_historia_clinica;
    private String id_habito_nocivo;
    private String estado;

    public Hist_hab_noc() {
    }

    public Hist_hab_noc(String id_historia_clinica, String id_habito_nocivo, String estado) {
        this.id_historia_clinica = id_historia_clinica;
        this.id_habito_nocivo = id_habito_nocivo;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId_historia_clinica() {
        return id_historia_clinica;
    }

    public void setId_historia_clinica(String id_historia_clinica) {
        this.id_historia_clinica = id_historia_clinica;
    }

    public String getId_habito_nocivo() {
        return id_habito_nocivo;
    }

    public void setId_habito_nocivo(String id_habito_nocivo) {
        this.id_habito_nocivo = id_habito_nocivo;
    }
    
}
