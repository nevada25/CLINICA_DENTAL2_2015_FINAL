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
public class Hist_diagnost_def {

    private String id_historia_clinica;
    private String id_diagnostico_def;

    public Hist_diagnost_def() {
    }

    public Hist_diagnost_def(String id_historia_clinica, String id_diagnostico_def) {
        this.id_historia_clinica = id_historia_clinica;
        this.id_diagnostico_def = id_diagnostico_def;
    }

    public String getId_diagnostico_def() {
        return id_diagnostico_def;
    }

    public void setId_diagnostico_def(String id_diagnostico_def) {
        this.id_diagnostico_def = id_diagnostico_def;
    }

    public String getId_historia_clinica() {
        return id_historia_clinica;
    }

    public void setId_historia_clinica(String id_historia_clinica) {
        this.id_historia_clinica = id_historia_clinica;
    }
    
}
