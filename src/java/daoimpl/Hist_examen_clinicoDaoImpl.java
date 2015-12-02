
package daoimpl;
import Centro_Control.Conexion2;
import bean.Hist_examen_clinico;
import dao.Hist_examen_clinicoDao;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Hist_examen_clinicoDaoImpl implements Hist_examen_clinicoDao{
Conexion2 cn=new Conexion2();

    @Override
    public boolean agregarhis_ex_cli(Hist_examen_clinico his_ex_cli) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO hist_examen_clinico(id_historia_clinica, id_examen_clinico, descripcion, estado) VALUES ( ,  ,' ','1')";
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
    public List<Hist_examen_clinico> listarhistoria() {
        List<Hist_examen_clinico> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Hist_examen_clinico diagnosticoDef=null;
        String query="SELECT id_historia_clinica, id_examen_clinico, descripcion, estado FROM hist_examen_clinico";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            diagnosticoDef=new Hist_examen_clinico();
          
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
    public boolean actualizarhis_ex_cli(Hist_examen_clinico his_ex_cli) {
        boolean estado = false;
        Statement st=null;
        String query="UPDATE hist_examen_clinico SET id_historia_clinica=, descripcion='', estado='' WHERE id_examen_clinico=";
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
    public boolean eliminarhis_ex_cli(Hist_examen_clinico his_ex_cli) {
       boolean estado = false;
        Statement st=null;
        String query="DELETE FROM hist_examen_clinico WHERE id_examen_clinico=";
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

   
   

