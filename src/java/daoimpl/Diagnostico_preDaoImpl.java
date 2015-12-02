package daoimpl;
import Centro_Control.Conexion2;
import bean.Diagnostico_pre;
import dao.Diagnostico_preDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Diagnostico_preDaoImpl implements Diagnostico_preDao{
    Conexion2 cn=new Conexion2();
     @Override
    public boolean agregarDiagnosticoPre(Diagnostico_pre diagnosticoPre) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO diagnostico_pre(id_diagnostico_pre, descripcion, id_historia_clinica) VALUES ( ,' ', )";
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
    public List<Diagnostico_pre> mostrarDiagnosticoPre() {
         List<Diagnostico_pre> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Diagnostico_pre empleado=null;
        String query="SELECT id_diagnostico_pre, descripcion, id_historia_clinica  FROM diagnostico_pre";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
           empleado=new Diagnostico_pre();
           empleado.getId_diagnostico_pre();
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
    public boolean actualizarDiagnosticoPre(Diagnostico_pre diagnosticoPre) {
         boolean estado = false;
        Statement st=null;
        String query="UPDATE diagnostico_pre SET descripcion=' ', id_historia_clinica=  WHERE id_diagnostico_pre=";
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
    public boolean eliminarDiagnosticoPre(int id_diagnosticoPre) {
         boolean estado = false;
        Statement st=null;
        String query="DELETE FROM diagnostico_pre WHERE id_diagnostico_pre=";
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




    