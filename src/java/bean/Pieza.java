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
public class Pieza {

    private String id_pieza;
    private String nro_pieza;

    public Pieza() {
    }

    public Pieza(String id_pieza, String nro_pieza) {
        this.id_pieza = id_pieza;
        this.nro_pieza = nro_pieza;
    }

    public String getNro_pieza() {
        return nro_pieza;
    }

    public void setNro_pieza(String nro_pieza) {
        this.nro_pieza = nro_pieza;
    }

    public String getId_pieza() {
        return id_pieza;
    }

    public void setId_pieza(String id_pieza) {
        this.id_pieza = id_pieza;
    }
    
}
