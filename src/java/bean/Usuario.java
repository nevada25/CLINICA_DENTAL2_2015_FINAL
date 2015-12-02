
package bean;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Usuario{
   
    private int id_usuario;
    private String nombre_usuario;
    private String nombres;
    private String password;
    private String estado;
    private String rol;
    private String email;
    private String ultima_session;
    private byte foto;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre_usuario, String nombres, String password, String estado, String rol, String email, String ultima_session, byte foto) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.nombres = nombres;
        this.password = password;
        this.estado = estado;
        this.rol = rol;
        this.email = email;
        this.ultima_session = ultima_session;
        this.foto = foto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUltima_session() {
        return ultima_session;
    }

    public void setUltima_session(String ultima_session) {
        this.ultima_session = ultima_session;
    }

    public byte getFoto() {
        return foto;
    }

    public void setFoto(byte foto) {
        this.foto = foto;
    }


}
