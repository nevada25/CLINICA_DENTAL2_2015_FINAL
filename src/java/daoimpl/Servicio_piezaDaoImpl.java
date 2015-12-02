package daoimpl;

import Centro_Control.Conexion2;
import bean.Servicio_pieza;
import dao.Servicio_piezaDao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Servicio_piezaDaoImpl implements Servicio_piezaDao{
    Conexion2 cn=new Conexion2();

    @Override
    public boolean agregarServicioPieza(Servicio_pieza servicioPieza) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO servicio_pieza(id_servicio, id_pieza) VALUES ( , )";
        try {
            st=cn.traerconeccion().createStatement();
            st.executeUpdate(query);
           cn.traerconeccion().getAutoCommit();
            cn.cerrar();
            estado = true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            cn.restablecer();

           cn.cerrar();
            estado = false;
        }

        return estado;
    }

    @Override
    public List<Servicio_pieza> mostrarServicioPieza() {
         List<Servicio_pieza> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Servicio_pieza   servicioPieza=null;
        String query="SELECT id_servicio, id_pieza FROM servicio_pieza";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            servicioPieza=new Servicio_pieza();
          
            lista.add(servicioPieza);
        }
       cn.cerrar();
        } catch (Exception e) {
             System.out.println("ERROR:"+e.getMessage());
            e.printStackTrace();
           cn.cerrar();
        }

        return lista;
    }

    @Override
    public boolean actualizarServicioPieza(Servicio_pieza servicioPieza) {
         boolean estado = false;
        Statement st=null;
        String query="UPDATE servicio_pieza SET id_servicio=?, id_pieza=? WHERE id_servicio= and id_pieza=";
        try {
            st=cn.traerconeccion().createStatement();
            st.executeUpdate(query);
            cn.traerconeccion().getAutoCommit();
           cn.cerrar();
            estado = true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
           cn.restablecer();
           cn.cerrar();
            estado = false;
        }

        return estado;
    }

    @Override
    public boolean eliminarServicioPieza(int servicioPieza) {
         boolean estado = false;
        Statement st=null;
        String query="DELETE FROM servicio_pieza WHERE id_servicio=";
        try {
            st=cn.traerconeccion().createStatement();
            st.executeUpdate(query);
            cn.traerconeccion().getAutoCommit();
           cn.cerrar();
            estado = true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
           cn.restablecer();
           cn.cerrar();
            estado = false;
        }

        return estado;
    }
    
}
