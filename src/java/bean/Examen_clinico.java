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
public class Examen_clinico {

    private String id_examen_clinico;
    private String aplicado_en;

    public Examen_clinico() {
    }

    public Examen_clinico(String id_examen_clinico, String aplicado_en) {
        this.id_examen_clinico = id_examen_clinico;
        this.aplicado_en = aplicado_en;
    }

    public String getAplicado_en() {
        return aplicado_en;
    }

    public void setAplicado_en(String aplicado_en) {
        this.aplicado_en = aplicado_en;
    }

    public String getId_examen_clinico() {
        return id_examen_clinico;
    }

    public void setId_examen_clinico(String id_examen_clinico) {
        this.id_examen_clinico = id_examen_clinico;
    }
    
}
