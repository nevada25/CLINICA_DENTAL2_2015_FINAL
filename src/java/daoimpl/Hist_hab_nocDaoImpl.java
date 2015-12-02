package daoimpl;
import Centro_Control.Conexion2;
import dao.Hist_hab_nocDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Hist_hab_nocDaoImpl implements Hist_hab_nocDao {
Conexion2 cn=new Conexion2();

    @Override
    public boolean agregarHist_hab_nocDao(Hist_hab_nocDao hist_hab_nocDao) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO hist_hab_noc(id_historia_clinica, id_habito_nocivo, estado)  VALUES ( , ,'1')";
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
    public List<Hist_hab_nocDao> mostrarHist_hab_nocDao() {
        List<Hist_hab_nocDao> lista = null;
        Statement st=null;
        ResultSet rs=null;
        String query="SELECT id_historia_clinica, id_habito_nocivo, estado FROM hist_hab_noc";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
           
          
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
    public boolean actualizarHist_hab_nocDao(Hist_hab_nocDao hist_hab_nocDao) {
         boolean estado = false;
        Statement st=null;
        String query="UPDATE hist_hab_noc SET estado='' WHERE id_historia_clinica= and id_habito_nocivo= ";
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
    public boolean eliminarHist_hab_nocDao(int hist_hab_nocDao) {
         boolean estado = false;
        Statement st=null;
        String query="DELETE FROM hist_hab_noc WHERE  id_habito_nocivo=";
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
   