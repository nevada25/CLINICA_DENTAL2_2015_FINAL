package daoimpl;
import Centro_Control.Conexion2;
import bean.Diagnostico_def;
import dao.Diagnostico_defDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Diagnostico_defDaoImpl implements Diagnostico_defDao{
 
     Conexion2 cn=new Conexion2();
     @Override
    public boolean agregardiagnosticoDef(Diagnostico_def diagnosticoDef) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO diagnostico_def(id_diagnostico_def, cie_10, descripcion) VALUES ( ,' ',' ')";
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
    public List<Diagnostico_def> mostrardiagnosticoDef() {
         List<Diagnostico_def> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Diagnostico_def empleado=null;
        String query="SELECT id_diagnostico_def, cie_10, descripcion FROM diagnostico_def";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
           empleado=new Diagnostico_def();
           
           lista.add(empleado);
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
    public boolean actualizardiagnosticoDef(Diagnostico_def diagnosticoDef) {
         boolean estado = false;
        Statement st=null;
        String query="UPDATE diagnostico_def SET cie_10=' ', descripcion='' WHERE id_diagnostico_def=";
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
    public boolean eliminardiagnosticoDef(int id_diagnosticoDef) {
         boolean estado = false;
        Statement st=null;
        String query="DELETE FROM diagnostico_def WHERE id_diagnostico_def=";
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