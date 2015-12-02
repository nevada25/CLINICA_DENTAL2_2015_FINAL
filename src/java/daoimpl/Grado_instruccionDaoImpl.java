package daoimpl;
import Centro_Control.Conexion2;
import bean.Grado_instruccion;
import dao.Grado_instruccionDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Grado_instruccionDaoImpl implements Grado_instruccionDao{
   Conexion2 cn=new Conexion2();
   @Override
    public boolean agregarGradoInstruccion(Grado_instruccion gradoInstruccion) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO grado_instruccion(id_grado_instruccion, nombre_grad_inst, estado) VALUES ( ,'','1')";
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
    public List<Grado_instruccion> mostrarGradoInstruccion() {
            List<Grado_instruccion> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Grado_instruccion gradoInstruccion=null;
        String query="SELECT id_grado_instruccion, nombre_grad_inst, estado  FROM grado_instruccion";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            gradoInstruccion=new Grado_instruccion();
          
            lista.add(gradoInstruccion);
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
    public boolean actualizarGradoInstruccion(Grado_instruccion gradoInstruccion) {
         boolean estado = false;
        Statement st=null;
        String query="UPDATE grado_instruccion SET nombre_grad_inst='', estado='1' WHERE id_grado_instruccion=";
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
    public boolean eliminarGradoInstruccion(int gradoInstruccion) {
         boolean estado = false;
        Statement st=null;
        String query="DELETE FROM grado_instruccion WHERE id_grado_instruccion=";
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
