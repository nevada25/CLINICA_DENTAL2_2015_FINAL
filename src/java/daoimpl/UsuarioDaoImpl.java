/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import Centro_Control.Conexion2;

import bean.Usuario;
import dao.UsuarioDao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NEVADA
 */
public class UsuarioDaoImpl implements UsuarioDao{
    Conexion2 cn=new Conexion2();
    @Override
    public boolean agregarUsuario(Usuario usuario) {
        boolean estado=false;
        String query="INSERT INTO usuario(id_usuario, nombre_usuario, password, estado, rol, email, ultima_session) "+
                     "VALUES ( "+usuario.getId_usuario()+" ,'"+usuario.getNombre_usuario()+"','"+usuario.getPassword()+"'"
                + ",'1','usuario','"+usuario.getEmail()+"',now())";
        Statement st=null;
        try {
            st=cn.traerconeccion().createStatement();
            st.executeUpdate(query);
            cn.guardar();
            cn.cerrar();
            estado=true;
            System.out.println(query);
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
            System.out.println(query);
            cn.restablecer();
            cn.cerrar();
            estado=false;
        }
        
        return  estado;
    }
    

    @Override
    public boolean deleteUsuario(int id_usuario) {
         boolean estado=false;
        String query="DELETE FROM usuario WHERE id_usuario="+id_usuario+"";
        Statement st=null;
        try {
            st=cn.traerconeccion().createStatement();
            st.executeUpdate(query);
            cn.guardar();
            cn.cerrar();
            estado=true;
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
            cn.restablecer();
            cn.cerrar();
            estado=false;
        }
        
        return  estado;
    }

    @Override
    public boolean updateUsuario(Usuario usuario) {
         boolean estado=false;
       Statement st=null;
       String query="UPDATE usuario SET nombre_usuario='"+usuario.getNombre_usuario()+"', password='"+usuario.getPassword()+"', email='"+usuario.getEmail()+"' WHERE id_usuario="+usuario.getId_usuario()+"";
       try {
         st=cn.traerconeccion().createStatement();
         st.executeUpdate(query);
         cn.guardar();
         cn.cerrar();
         estado=true;
           System.out.println(query);
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
           cn.restablecer();
           cn.cerrar();
           System.out.println(query);
//            
        }finally{
           if (cn.traerconeccion() !=null) {
            cn.restablecer();
            cn.cerrar();
           }
       }
        
        return estado;
    }

    @Override
    public List<Usuario> mostrarUsuario() {
         List<Usuario> lista=null;
        Statement st=null;
        ResultSet rs=null;
        Usuario usuario=null;
        String query="SELECT id_usuario, nombre_usuario, password, rol, estado FROM usuario";
        try {
            lista=new ArrayList<>();
            st=cn.traerconeccion().createStatement();
            rs=st.executeQuery(query);
            while (rs.next()) {                
             usuario=new Usuario();
             usuario.setId_usuario(rs.getInt("id_usuario"));
             usuario.setNombre_usuario(rs.getString("nombre_usuario"));
             usuario.setPassword(rs.getString("password"));
             usuario.setRol(rs.getString("rol"));
             usuario.setEstado(rs.getString("estado"));
             lista.add(usuario);
            }
            cn.cerrar();
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }
        return  lista;
    }

    @Override
    public Usuario validarUsuario(String nombre_usuario, String password) {
        Usuario u=null;
        String query="SELECT id_usuario, nombre_usuario, password, estado, rol, email, ultima_session from usuario where nombre_usuario= '"+nombre_usuario+"' and password='"+password+"'";
        Statement st;
        ResultSet rs;
        try {
             st=cn.traerconeccion().createStatement();
             rs=st.executeQuery(query);
              u=new Usuario();
             while (rs.next()) {   
               u.setId_usuario(rs.getInt("id_usuario"));
               u.setNombre_usuario(rs.getString("nombre_usuario"));
               u.setPassword(rs.getString("password"));
               u.setEstado(rs.getString("estado"));
               u.setRol(rs.getString("rol"));
               u.setEmail(rs.getString("email"));
               u.setUltima_session(rs.getString("ultima_session"));
            }
             System.out.println(query);
             cn.cerrar();
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
            cn.cerrar();
        }finally{
            if (cn.traerconeccion() !=null) {
                cn.cerrar(); 
            }
        }return  u;
    }
    
    @Override
    public Usuario DatosUsuario(int id_usuario) {
     Statement st=null;
        ResultSet rs=null;
        Usuario usu=null;
        String query="SELECT id_usuario, nombre_usuario, password, estado, rol, email, ultima_session  FROM usuario where id_usuario=="+id_usuario;
        try {
       st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
          usu=new Usuario();
          usu.setId_usuario(rs.getInt("id_usuario"));
          usu.setNombre_usuario(rs.getString("nombre_usuario"));
          usu.setPassword(rs.getString("password"));
          usu.setRol(rs.getString("rol"));
          usu.setEmail(rs.getString("email"));
         
        }
        cn.cerrar();
        } catch (Exception e) {
             System.out.println("ERROR:"+e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }

       return usu;
    }
}
