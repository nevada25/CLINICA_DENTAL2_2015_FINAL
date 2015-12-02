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
public class Contrato {

    private String id_contrato;
    private String id_consulta;
    private String fecha_consult;
    private String fecha_registro;

    public Contrato() {
    }

    public Contrato(String id_contrato, String id_consulta, String fecha_consult, String fecha_registro) {
        this.id_contrato = id_contrato;
        this.id_consulta = id_consulta;
        this.fecha_consult = fecha_consult;
        this.fecha_registro = fecha_registro;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(String id_contrato) {
        this.id_contrato = id_contrato;
    }

    public String getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(String id_consulta) {
        this.id_consulta = id_consulta;
    }

    public String getFecha_consult() {
        return fecha_consult;
    }

    public void setFecha_consult(String fecha_consult) {
        this.fecha_consult = fecha_consult;
    }
    
    
}
