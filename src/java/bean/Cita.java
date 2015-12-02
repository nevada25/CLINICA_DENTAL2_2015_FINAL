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
public class Cita {

    private String id_cita;
    private String id_contrato;
    private String fecha_cita;
    private String hora;
    private String estado;
    private String condicion;
    private String id_empleado;

    public Cita() {
    }

    public Cita(String id_cita, String id_contrato, String fecha_cita, String hora, String estado, String condicion, String id_empleado) {
        this.id_cita = id_cita;
        this.id_contrato = id_contrato;
        this.fecha_cita = fecha_cita;
        this.hora = hora;
        this.estado = estado;
        this.condicion = condicion;
        this.id_empleado = id_empleado;
    }
    

    public String getId_cita() {
        return id_cita;
    }

    public void setId_cita(String id_cita) {
        this.id_cita = id_cita;
    }

    public String getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(String id_contrato) {
        this.id_contrato = id_contrato;
    }

    public String getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }
    
}
