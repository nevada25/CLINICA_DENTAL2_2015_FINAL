
package daoimpl;

import Centro_Control.Conexion2;
import bean.Laboratorios_externos;
import dao.Laboratorios_externosDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Laboratorios_externosDaoImpl implements Laboratorios_externosDao {
Conexion2 cn=new Conexion2();
   
    @Override
    public boolean agregarLaboratoriosExternos(Laboratorios_externos laboratoriosExternos) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO laboratorios_externos(id_lab_externo, nombre_lab_ext, descripcion, estado) VALUES ( ,'','','1')";
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
    public List<Laboratorios_externos> mostrarLaboratoriosExternos() {
            List<Laboratorios_externos> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Laboratorios_externos laboratoriosExternos=null;
        String query="SELECT id_lab_externo, nombre_lab_ext, descripcion, estado  FROM laboratorios_externos";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            laboratoriosExternos=new Laboratorios_externos();
          
            lista.add(laboratoriosExternos);
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
    public boolean actualizarLaboratoriosExternos(Laboratorios_externos laboratoriosExternos) {
         boolean estado = false;
        Statement st=null;
        String query="UPDATE laboratorios_externos  SET nombre_lab_ext='', descripcion='', estado='' WHERE id_lab_externo=";
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
    public boolean eliminarLaboratoriosExternos(int laboratoriosExternos) {
         boolean estado = false;
        Statement st=null;
        String query="DELETE FROM laboratorios_externos WHERE id_lab_externo=";
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
