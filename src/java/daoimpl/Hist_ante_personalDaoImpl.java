package daoimpl;

import Centro_Control.Conexion2;
import bean.Hist_ante_personal;
import dao.Hist_ante_personalDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Hist_ante_personalDaoImpl implements Hist_ante_personalDao{
Conexion2 cn=new Conexion2();
  @Override
    public boolean agregarHist_ante_personal(Hist_ante_personal hist_ante_personal) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO hist_ante_personal(id_historia_clinica, id_ante_personal, estado)  VALUES ( , ,'1')";
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
   public boolean actualizarHist_ante_personalDao(Hist_ante_personal hist_ante_personal) {
         boolean estado = false;
        Statement st=null;
        String query="UPDATE hist_ante_personal SET id_historia_clinica= , estado='' WHERE  id_ante_personal=";
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
    public boolean eliminarHist_ante_personalDao(int id_diagnosticoPre) {
         boolean estado = false;
        Statement st=null;
        String query="DELETE FROM hist_ante_personal WHERE id_ante_personal=";
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
    public List<Hist_ante_personal> listarHist_ante_personal() {
          List<Hist_ante_personal> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Hist_ante_personal hist_ante_personal=null;
        String query="SELECT id_historia_clinica, id_ante_personal, estado  FROM hist_ante_personal";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            hist_ante_personal=new Hist_ante_personal();
          
            lista.add(hist_ante_personal);
        }
        cn.cerrar();
        } catch (Exception e) {
             System.out.println("ERROR:"+e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }

        return lista;
    }

   
    
}