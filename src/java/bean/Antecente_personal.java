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
public class Antecente_personal {

    private String id_ante_personal;
    private String nombre_antecedente;

    public Antecente_personal() {
    }

    public Antecente_personal(String id_ante_personal, String nombre_antecedente) {
        this.id_ante_personal = id_ante_personal;
        this.nombre_antecedente = nombre_antecedente;
    }
    

    public String getId_ante_personal() {
        return id_ante_personal;
    }

    public void setId_ante_personal(String id_ante_personal) {
        this.id_ante_personal = id_ante_personal;
    }

    public String getNombre_antecedente() {
        return nombre_antecedente;
    }

    public void setNombre_antecedente(String nombre_antecedente) {
        this.nombre_antecedente = nombre_antecedente;
    }
    
}
