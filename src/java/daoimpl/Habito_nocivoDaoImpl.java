package daoimpl;
import Centro_Control.Conexion2;
import bean.Habito_nocivo;
import dao.Habito_nocivoDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Habito_nocivoDaoImpl implements Habito_nocivoDao{
  Conexion2 cn=new Conexion2();
   
    @Override
    public List<Habito_nocivo> listarHabitoNocivo1() {
        List<Habito_nocivo> lista = null;
        Statement st = null;
        ResultSet rs = null;
        Habito_nocivo habito_nocivo = null;
        String query = " select id_habito_nocivo, nombre_hab_noc from habito_nocivo "
                + " where id_habito_nocivo between 1 and 3";
        try {
            lista = new ArrayList<Habito_nocivo>();
            st = cn.traerconeccion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {

                habito_nocivo = new Habito_nocivo();
                habito_nocivo.setId_habito_nocivo(rs.getString("id_habito_nocivo"));
                habito_nocivo.setNombre_hab_noc(rs.getString("nombre_hab_noc"));
                lista.add(habito_nocivo);
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
    public List<Habito_nocivo> listarHabitoNocivo2() {
        List<Habito_nocivo> lista = null;
        Statement st = null;
        ResultSet rs = null;
        Habito_nocivo habito_nocivo = null;
        String query = " select id_habito_nocivo, nombre_hab_noc from habito_nocivo "
                + " where id_habito_nocivo between 4 and 6";
        try {
            lista = new ArrayList<Habito_nocivo>();
            st = cn.traerconeccion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {

                habito_nocivo = new Habito_nocivo();
                habito_nocivo.setId_habito_nocivo(rs.getString("id_habito_nocivo"));
                habito_nocivo.setNombre_hab_noc(rs.getString("nombre_hab_noc"));
                lista.add(habito_nocivo);
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
