package daoimpl;
import Centro_Control.Conexion2;
import bean.Ocupacion;
import dao.OcupacionDao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OcupacionDaoImpl implements OcupacionDao{
Conexion2 cn=new Conexion2();


    @Override
    public boolean agregarOcupacion(Ocupacion ocupacion) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO ocupacion(id_ocupacion, nombre_ocupacion, estado) VALUES ( ,'','1')";
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
    public List<Ocupacion> mostrarOcupacion() {
            List<Ocupacion> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Ocupacion   ocupacion=null;
        String query="SELECT id_ocupacion, nombre_ocupacion, estado  FROM ocupacion";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            ocupacion=new Ocupacion();
          
            lista.add(ocupacion);
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
    public boolean actualizarOcupacion(Ocupacion ocupacion) {
         boolean estado = false;
        Statement st=null;
        String query="UPDATE ocupacion SET nombre_ocupacion='', estado='' WHERE id_ocupacion=";
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
    public boolean eliminarOcupacion(int ocupacion) {
         boolean estado = false;
        Statement st=null;
        String query="DELETE FROM ocupacion WHERE id_ocupacion=";
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