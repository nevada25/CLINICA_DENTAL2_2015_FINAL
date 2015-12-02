package daoimpl;
import Centro_Control.Conexion2;
import dao.Unidad_medidaDao;
import bean.Unidad_medida;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Unidad_medidaDaoImpl implements Unidad_medidaDao{
    Conexion2 cn=new Conexion2();
    @Override
    public boolean agregaridUnidadMedida(Unidad_medida unidadMedida) {
       boolean estado = false;
        Statement st=null;
        String query="INSERT INTO unidad_medida(id_unidad_medida, nombre_uni_med, estado) VALUES ( , '','1')";
        try {
            st=cn.traerconeccion().createStatement();
            st.executeUpdate(query);
            cn.traerconeccion().getAutoCommit();
            cn.cerrar();
            estado = true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
           cn. restablecer();
            cn.cerrar();
            estado = false;
        }

        return estado;
    }

    @Override
    public List<Unidad_medida> mostrarusuario() {
        List<Unidad_medida> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Unidad_medida unidadmedida=null;
        String query="SELECT id_unidad_medida, nombre_uni_med, estado FROM unidad_medida";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
           unidadmedida=new Unidad_medida();
           unidadmedida.getId_unidad_medida();
           unidadmedida.getNombre_uni_med();
           lista.add(unidadmedida);
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
    public boolean actualizaridUnidadMedida(Unidad_medida unidadMedida) {
        boolean estado = false;
        Statement st=null;
        String query="UPDATE unidad_medida SET nombre_uni_med='', estado='' WHERE id_unidad_medida=";
        try {
            st=cn.traerconeccion().createStatement();
            st.executeUpdate(query);
            cn.traerconeccion().getAutoCommit();
            cn.cerrar();
            estado = true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
           cn. restablecer();
            cn.cerrar();
            estado = false;
        }

        return estado;
    }
    

    @Override
    public boolean eliminaridUnidadMedida(int idUnidadMedida) {
      boolean estado = false;
        Statement st=null;
        String query="DELETE FROM unidad_medida WHERE id_unidad_medida=";
        try {
            st=cn.traerconeccion().createStatement();
            st.executeUpdate(query);
            cn.traerconeccion().getAutoCommit();
            cn.cerrar();
            estado = true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
           cn. restablecer();
            cn.cerrar();
            estado = false;
        }

        return estado;
    }
    
}
