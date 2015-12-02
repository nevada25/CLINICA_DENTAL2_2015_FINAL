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
public class Consulta {

    private String id_cliente;
    private String id_empleado;
    private String id_consulta;
    private String especificaciones;
    private String observaciones;
    private String pronostico;

    public Consulta() {
    }

    public Consulta(String id_cliente, String id_empleado, String id_consulta, String especificaciones, String observaciones, String pronostico) {
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.id_consulta = id_consulta;
        this.especificaciones = especificaciones;
        this.observaciones = observaciones;
        this.pronostico = pronostico;
    }

    public String getPronostico() {
        return pronostico;
    }

    public void setPronostico(String pronostico) {
        this.pronostico = pronostico;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(String id_consulta) {
        this.id_consulta = id_consulta;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
}
