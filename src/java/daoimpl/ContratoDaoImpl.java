package daoimpl;
import Centro_Control.Conexion2;
import bean.Contrato;
import dao.ContratoDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ContratoDaoImpl  implements ContratoDao{
     Conexion2 cn=new Conexion2();
     @Override
    public boolean agregarContrato(Contrato contrato) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO contrato(id_contrato, id_consulta, fecha_consult, fecha_registro) VALUES ( , ,' ','')";
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
    public List<Contrato> mostrarContrato() {
            List<Contrato> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Contrato contrato=null;
        String query="SELECT id_contrato, id_consulta, fecha_consult, fecha_registro  FROM contrato";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            contrato=new Contrato();
          
            lista.add(contrato);
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
    public boolean actualizarContrato(Contrato contrato) {
     boolean estado = false;
        Statement st=null;
        String query="UPDATE contrato SET id_consulta= , fecha_consult='', fecha_registro='' WHERE id_contrato= ";
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
    public boolean eliminarContrato(int id_contrato) {
    boolean estado = false;
        Statement st=null;
        String query="DELETE FROM public.contrato WHERE id_contrato= ";
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