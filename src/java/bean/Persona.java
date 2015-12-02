/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Persona {
     @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_persona;
    private int id_grado_instruccion;
    private int id_ocupacion;
    private int id_ubigeo_nac;
    private int id_ubigeo_act;
    private String nombre;
    private String nombres;
    private String apepat;
    private String apemat;
    private Date fecha_nac;
    private String correo_gmail;
    private String correo_hotmail;
    private String correo_otros;
    private String celular;
    private String telefono;
    private String sexo;
    private String direccion;
    private String pagina_web;
    private String estado;
    private String nro_doc;
    private int id_tipo_doc;
    private byte foto_persona;

    public Persona() {
    }

    public Persona(int id_persona, int id_grado_instruccion, int id_ocupacion, int id_ubigeo_nac, int id_ubigeo_act, String nombre, String nombres, String apepat, String apemat, Date fecha_nac, String correo_gmail, String correo_hotmail, String correo_otros, String celular, String telefono, String sexo, String direccion, String pagina_web, String estado, String nro_doc, int id_tipo_doc, byte foto_persona) {
        this.id_persona = id_persona;
        this.id_grado_instruccion = id_grado_instruccion;
        this.id_ocupacion = id_ocupacion;
        this.id_ubigeo_nac = id_ubigeo_nac;
        this.id_ubigeo_act = id_ubigeo_act;
        this.nombre = nombre;
        this.nombres = nombres;
        this.apepat = apepat;
        this.apemat = apemat;
        this.fecha_nac = fecha_nac;
        this.correo_gmail = correo_gmail;
        this.correo_hotmail = correo_hotmail;
        this.correo_otros = correo_otros;
        this.celular = celular;
        this.telefono = telefono;
        this.sexo = sexo;
        this.direccion = direccion;
        this.pagina_web = pagina_web;
        this.estado = estado;
        this.nro_doc = nro_doc;
        this.id_tipo_doc = id_tipo_doc;
        this.foto_persona = foto_persona;
    }

    public String getNro_doc() {
        return nro_doc;
    }

    public void setNro_doc(String nro_doc) {
        this.nro_doc = nro_doc;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getId_grado_instruccion() {
        return id_grado_instruccion;
    }

    public void setId_grado_instruccion(int id_grado_instruccion) {
        this.id_grado_instruccion = id_grado_instruccion;
    }

    public int getId_ocupacion() {
        return id_ocupacion;
    }

    public void setId_ocupacion(int id_ocupacion) {
        this.id_ocupacion = id_ocupacion;
    }

    public int getId_ubigeo_nac() {
        return id_ubigeo_nac;
    }

    public void setId_ubigeo_nac(int id_ubigeo_nac) {
        this.id_ubigeo_nac = id_ubigeo_nac;
    }

    public int getId_ubigeo_act() {
        return id_ubigeo_act;
    }

    public void setId_ubigeo_act(int id_ubigeo_act) {
        this.id_ubigeo_act = id_ubigeo_act;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApepat() {
        return apepat;
    }

    public void setApepat(String apepat) {
        this.apepat = apepat;
    }

    public String getApemat() {
        return apemat;
    }

    public void setApemat(String apemat) {
        this.apemat = apemat;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCorreo_gmail() {
        return correo_gmail;
    }

    public void setCorreo_gmail(String correo_gmail) {
        this.correo_gmail = correo_gmail;
    }

    public String getCorreo_hotmail() {
        return correo_hotmail;
    }

    public void setCorreo_hotmail(String correo_hotmail) {
        this.correo_hotmail = correo_hotmail;
    }

    public String getCorreo_otros() {
        return correo_otros;
    }

    public void setCorreo_otros(String correo_otros) {
        this.correo_otros = correo_otros;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPagina_web() {
        return pagina_web;
    }

    public void setPagina_web(String pagina_web) {
        this.pagina_web = pagina_web;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_tipo_doc() {
        return id_tipo_doc;
    }

    public void setId_tipo_doc(int id_tipo_doc) {
        this.id_tipo_doc = id_tipo_doc;
    }

    public byte getFoto_persona() {
        return foto_persona;
    }

    public void setFoto_persona(byte foto_persona) {
        this.foto_persona = foto_persona;
    }

    
    
    
}
