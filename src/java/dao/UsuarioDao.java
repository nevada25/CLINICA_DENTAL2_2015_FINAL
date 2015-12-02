/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Usuario;
import java.util.List;

/**
 *
 * @author NEVADA
 */
public interface UsuarioDao {
   public boolean agregarUsuario(Usuario usuario);
public boolean  deleteUsuario(int id_usuario);
public boolean  updateUsuario(Usuario usuario);
List<Usuario> mostrarUsuario();
public Usuario validarUsuario(String nombre_usuario,String password);
public Usuario DatosUsuario(int id_usuario);
}
