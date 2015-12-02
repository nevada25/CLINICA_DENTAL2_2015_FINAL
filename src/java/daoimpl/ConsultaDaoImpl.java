package daoimpl;
import Centro_Control.Conexion2;
import bean.Consulta;
import dao.ConsultaDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ConsultaDaoImpl implements ConsultaDao{
     Conexion2 cn=new Conexion2();
     
 @Override
    public boolean agregarConsulta(Consulta consulta) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO consulta(id_cliente, id_empleado, id_consulta, especificaciones, observaciones,pronostico) VALUES ( ,  ,  ,' ',' ',' ')";
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
    public List<Consulta> mostrarConsulta() {
            List<Consulta> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Consulta consulta=null;
        String query="SELECT id_cliente, id_empleado, id_consulta, especificaciones, observaciones,pronostico FROM consulta";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
          consulta=new Consulta();
          
            lista.add(consulta);
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
    public boolean actualizarConsulta(Consulta consulta) {
         boolean estado = false;
        Statement st=null;
        String query="UPDATE consulta SET id_empleado= , id_consulta= , especificaciones='',observaciones='', pronostico='' WHERE id_cliente=";
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
    public boolean eliminarConsulta(int id_consulta) {
 boolean estado = false;
        Statement st=null;
        String query="DELETE FROM consulta WHERE id_cliente=";
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