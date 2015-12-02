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
public class Det_consulta_serv {

    private String id_servicio;
    private String id_cita;
    private String cantidad;
    private String total;
    private String nro_laboratorio_String;
    private String motivo_consul;
    private String id_empleado;

    public Det_consulta_serv() {
    }

    public Det_consulta_serv(String id_servicio, String id_cita, String cantidad, String total, String nro_laboratorio_String, String motivo_consul, String id_empleado) {
        this.id_servicio = id_servicio;
        this.id_cita = id_cita;
        this.cantidad = cantidad;
        this.total = total;
        this.nro_laboratorio_String = nro_laboratorio_String;
        this.motivo_consul = motivo_consul;
        this.id_empleado = id_empleado;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(String id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getId_cita() {
        return id_cita;
    }

    public void setId_cita(String id_cita) {
        this.id_cita = id_cita;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getNro_laboratorio_String() {
        return nro_laboratorio_String;
    }

    public void setNro_laboratorio_String(String nro_laboratorio_String) {
        this.nro_laboratorio_String = nro_laboratorio_String;
    }

    public String getMotivo_consul() {
        return motivo_consul;
    }

    public void setMotivo_consul(String motivo_consul) {
        this.motivo_consul = motivo_consul;
    }
    
}
