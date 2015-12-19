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
public class Cliente extends Persona{

    private String id_cliente;
    private String responsable_apoderado;

    public Cliente() {
    }

    public String getResponsable_apoderado() {
        return responsable_apoderado;
    }

    public void setResponsable_apoderado(String responsable_apoderado) {
        this.responsable_apoderado = responsable_apoderado;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }
    
}
