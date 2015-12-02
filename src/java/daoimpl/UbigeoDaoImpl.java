package daoimpl;
import Centro_Control.Conexion2;
import bean.Ubigeo;
import dao.UbigeoDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class UbigeoDaoImpl implements UbigeoDao{
    Conexion2 cn=new Conexion2();
    @Override
    public boolean agregarUbigeo(Ubigeo ubigeo) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO ubigeo(id_ubigeo, departamento, provincia, distrito, estado)"
                + " VALUES ( ,'','', '', '1')";
        try {
            st=cn.traerconeccion().createStatement();
            st.executeUpdate(query);
           cn.traerconeccion().getAutoCommit();
            cn.cerrar();
            estado = true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
           cn. restablecer();
            cn.cerrar();
            estado = false;
        }

        return estado;
    }

    @Override
    public List<Ubigeo> mostrarUbigeo() {
           List<Ubigeo> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Ubigeo  ubigeo=null;
        String query="SELECT id_ubigeo, departamento, provincia, distrito, estado  FROM ubigeo";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            ubigeo=new Ubigeo();
          
            lista.add(ubigeo);
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
    public boolean actualizarUbigeo(Ubigeo ubigeo) {
         boolean estado = false;
        Statement st=null;
        String query="UPDATE ubigeo SET departamento='', provincia='', distrito='', estado='' WHERE id_ubigeo=";
        try {
            st=cn.traerconeccion().createStatement();
            st.executeUpdate(query);
           cn.traerconeccion().getAutoCommit();
            cn.cerrar();
            estado = true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
           cn. restablecer();
            cn.cerrar();
            estado = false;
        }

        return estado;
    }

    @Override
    public boolean eliminarUbigeo(int ubigeo) {
         boolean estado = false;
        Statement st=null;
        String query="DELETE FROM ubigeo WHERE id_ubigeo=";
        try {
            st=cn.traerconeccion().createStatement();
            st.executeUpdate(query);
           cn.traerconeccion().getAutoCommit();
            cn.cerrar();
            estado = true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
           cn. restablecer();
            cn.cerrar();
            estado = false;
        }

        return estado;
    }
    
}
