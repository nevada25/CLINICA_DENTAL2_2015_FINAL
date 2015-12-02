
package Centro_Control;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion2 {
    public static Connection conectar(){
        Connection cn=null;
    
        try {
             Class.forName("org.postgresql.Driver");
            cn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/centro_odonto","postgres","1234");
        } catch (Exception e) {
               System.out.println("ERROR CONEXION"+e.getMessage());
               e.printStackTrace();
        }
    
    return cn;
    }
    public Connection traerconeccion(){
    Connection cn=Conexion2.conectar();
    return  cn;
    }
    
    public  void cerrar(){
        try {
            conectar().close();
        } catch (Exception e) {
        }
    }
      public  void guardar(){
        try {
            conectar().commit();
        } catch (Exception e) {
        }
    }
       public  void restablecer(){
        try {
            conectar().rollback();
        } catch (Exception e) {
        }
    }
}
