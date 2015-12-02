package daoimpl;
import Centro_Control.Conexion2;
import bean.Examen_clinico;
import dao.Examen_clinicoDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Examen_clinicoDaoImpl implements Examen_clinicoDao{
 Conexion2 cn=new Conexion2();
 
    @Override
    public boolean agregarExamenClinico(Examen_clinico examenClinico) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO examen_clinico(id_examen_clinico, aplicado_en) VALUES ( ,' ')";
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
    public List<Examen_clinico> mostrarExamenClinico() {
            List<Examen_clinico> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Examen_clinico examenClinico=null;
        String query="SELECT id_examen_clinico, aplicado_en  FROM examen_clinico";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            examenClinico=new Examen_clinico();
          
            lista.add(examenClinico);
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
    public boolean actualizarExamenClinico(Examen_clinico examenClinico) {
         boolean estado = false;
        Statement st=null;
        String query="UPDATE examen_clinico SET aplicado_en='' WHERE id_examen_clinico= ";
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
    public boolean eliminarExamenClinico(int id_examenClinico) {
         boolean estado = false;
        Statement st=null;
        String query="DELETE FROM public.examen_clinico WHERE id_examen_clinico=";
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