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
public class Embarazo {

    private String id_historia_clinica;
    private String nro_semanas;
    private String ultimo_control;
    private String trata_farma;
    private String estado;

    public Embarazo() {
    }

    public String getId_historia_clinica() {
        return id_historia_clinica;
    }

    public void setId_historia_clinica(String id_historia_clinica) {
        this.id_historia_clinica = id_historia_clinica;
    }

    public String getNro_semanas() {
        return nro_semanas;
    }

    public void setNro_semanas(String nro_semanas) {
        this.nro_semanas = nro_semanas;
    }

    public String getUltimo_control() {
        return ultimo_control;
    }

    public void setUltimo_control(String ultimo_control) {
        this.ultimo_control = ultimo_control;
    }

    public String getTrata_farma() {
        return trata_farma;
    }

    public void setTrata_farma(String trata_farma) {
        this.trata_farma = trata_farma;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
