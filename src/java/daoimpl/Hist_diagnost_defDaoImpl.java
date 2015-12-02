package daoimpl;
import Centro_Control.Conexion2;
import bean.Hist_diagnost_def;
import dao.Hist_diagnost_defDao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Hist_diagnost_defDaoImpl implements Hist_diagnost_defDao{
Conexion2 cn=new Conexion2();
 @Override
    public boolean agregarDiagnosticoDef(Hist_diagnost_def diagnosticoDef) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO public.hist_diagnost_def(id_historia_clinica, id_diagnostico_def) VALUES ( , )";
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
    public List<Hist_diagnost_def> mostrarDiagnosticoDef() {
        List<Hist_diagnost_def> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Hist_diagnost_def diagnosticoDef=null;
        String query="SELECT id_historia_clinica, id_diagnostico_def  FROM hist_diagnost_def";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            diagnosticoDef=new Hist_diagnost_def();
          
            lista.add(diagnosticoDef);
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
    public boolean actualizarDiagnosticoDef(Hist_diagnost_def diagnosticoDef) {
         boolean estado = false;
        Statement st=null;
        String query="UPDATE hist_diagnost_def SET id_historia_clinica= WHERE id_diagnostico_def=";
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
    public boolean eliminarDiagnosticoDef(int diagnosticoDef) {
         boolean estado = false;
        Statement st=null;
        String query="DELETE FROM hist_diagnost_def WHERE id_diagnostico_def=";
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