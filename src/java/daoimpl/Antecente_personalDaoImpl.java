
package daoimpl;

import Centro_Control.Conexion2;
import bean.Antecente_personal;
import dao.Antecente_personalDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Antecente_personalDaoImpl implements Antecente_personalDao{

   Conexion2 cn=new Conexion2();
  
    @Override
    public List<Antecente_personal> listarAntedente_personal1() {
        List<Antecente_personal> lista = null;
        Statement st = null;
        ResultSet rs = null;
        Antecente_personal antecente_personal = null;
        String query = " select id_ante_personal, nombre_antecedente from antecedente_personal "
                + " where id_ante_personal between 1 and 8";
        try {
            lista = new ArrayList<Antecente_personal>();
            st = cn.traerconeccion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {

                antecente_personal = new Antecente_personal();
                antecente_personal.setId_ante_personal(rs.getString("id_ante_personal"));
                antecente_personal.setNombre_antecedente(rs.getString("nombre_antecedente"));
                lista.add(antecente_personal);
            }
            cn.cerrar();
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }
        return lista;
    }

    @Override
    public List<Antecente_personal> listarAntedente_personal2() {
        List<Antecente_personal> lista = null;
        Statement st = null;
        ResultSet rs = null;
        Antecente_personal antecente_personal = null;
        String query = " select id_ante_personal, nombre_antecedente from antecedente_personal "
                + " where id_ante_personal between 9 and 16 ";
        try {
            lista = new ArrayList<Antecente_personal>();
            st = cn.traerconeccion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {

                antecente_personal = new Antecente_personal();
                antecente_personal.setId_ante_personal(rs.getString("id_ante_personal"));
                antecente_personal.setNombre_antecedente(rs.getString("nombre_antecedente"));
                lista.add(antecente_personal);
            }
            cn.cerrar();
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }
        return lista;
    }

}
