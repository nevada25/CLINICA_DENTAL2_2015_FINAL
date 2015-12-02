/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Centro_Control;

import bean.Categoria_servicio;
import bean.Empleado;
import bean.Producto;
import bean.Usuario;
import dao.Categoria_servicioDao;
import dao.EmpleadoDao;
import dao.ProductoDao;
import dao.UsuarioDao;
import daoimpl.Categoria_servicioDaoImpl;
import daoimpl.EmpleadoDaoImpl;
import daoimpl.ProductoDaoImpl;
import daoimpl.UsuarioDaoImpl;

/**
 *
 * @author NEVADA
 */
public class prueba {
    public static void main(String[] args) {
        prueba p=new prueba();
//        p.validar();
//        p.agregarcat_Ser();
//p.mostrardatos();
//p.actualizarr();
//p.elimianr();
//p.agregarusua();
p.mostrarproducto();
//p.empleador();
        
    }
     Categoria_servicioDao dao=new Categoria_servicioDaoImpl();
        Categoria_servicio ca=new Categoria_servicio();
    public void agregarcat_Ser(){
           
        
        ca.setNombre_cat_serv("quien quiere");
        if (dao.agregarServicio(ca)) {
            System.out.println("SE AGREGO CORRECTAMENTE");
        } else {
            System.out.println("ERROR AL AGREGAR");
        }
    }
    public void mostrardatos(){
      
               Categoria_servicioDao das = new Categoria_servicioDaoImpl();
        
     Categoria_servicio catsers = das.datosServicio(5);
               System.out.println("NOMBRE:"+catsers.getNombre_cat_serv());
    
    }
    public void actualizarr(){
        Usuario user=new Usuario();
        UsuarioDao dao=new UsuarioDaoImpl();
        user.setId_usuario(1);
        user.setNombre_usuario("lavado");
        user.setPassword("1234");
        user.setEmail("yo solo");
        if (dao.updateUsuario(user)) {
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }
    
    }
    public void elimianr(){
        UsuarioDao a=new UsuarioDaoImpl();
        if (a.deleteUsuario(4)) {
            System.out.println("ok");
        } else {
            System.out.println("ERROR");
        }
    }
    public void validar(){
        Usuario usa=new Usuario();
        UsuarioDao as=new UsuarioDaoImpl();
        
        usa=as.validarUsuario("kevin","kevin");
//        
//            System.out.println("ID_USUARIO"+usa.getId_usuario()+"USUARIO:"+usa.getNombre_usuario()+"CONTRASEÑA:"+usa.getPassword() );
//     
        System.out.println("USUARIO:"+usa.getNombre_usuario());
    }
    public void agregarusua(){
    
    UsuarioDao das=new UsuarioDaoImpl();
    Usuario usu=new Usuario();
    usu.setId_usuario(3);
    usu.setNombre_usuario("ambar");
    usu.setNombres("ambar georgina calderon guabloche");
    usu.setPassword("4321");
    usu.setEmail("eles@gmail.com");
        if (das.agregarUsuario(usu)) {
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }
    }
    
    
    
    public void empleador(){
        EmpleadoDao da=new EmpleadoDaoImpl();
        
        for (Empleado asd : da.mostrarempleado()) {
            System.out.println("id: "+asd.getId_empleado()+
                                "NOMBRES: "+asd.getNombres());
        }
    
    }
    public void mostrarproducto(){
        ProductoDao dao=new ProductoDaoImpl();
        
        for (Producto asd:dao.mostrarproductosaedidar(""," 1")) {
            System.out.println("id_producto:"+asd.getId_producto()+"nombre_producto: "+asd.getNombre_producto()
            +"UNIDAD DE MEDIDA: "+asd.getId_unidad_medida()
            ); 
        }
    }
    
    }

