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
public class Ubigeo {

    private String id_ubigeo;
    private String departamento;
    private String provincia;
    private String distrito;
    private String estado;

    public Ubigeo() {
    }

    public Ubigeo(String id_ubigeo, String departamento, String provincia, String distrito, String estado) {
        this.id_ubigeo = id_ubigeo;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId_ubigeo() {
        return id_ubigeo;
    }

    public void setId_ubigeo(String id_ubigeo) {
        this.id_ubigeo = id_ubigeo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
    
}
