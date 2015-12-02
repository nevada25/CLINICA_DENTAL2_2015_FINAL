package daoimpl;
import Centro_Control.Conexion2;
import bean.Tipo_doc;
import dao.Tipo_docDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Tipo_docDaoImpl implements Tipo_docDao{
    Conexion2 cn=null;
    @Override
    public List<Tipo_doc> mostrartipo_doc() {
       List<Tipo_doc> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Tipo_doc tipo_doc=null;
        String query="SELECT id_tipo_doc, nombre_tipo_doc, estado FROM tipo_doc";
        try {
        lista=new ArrayList<Tipo_doc>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
           tipo_doc=new Tipo_doc();
           tipo_doc.setId_tipo_doc(rs.getString("id_tipo_doc"));
           tipo_doc.setNombre_tipo_doc(rs.getString("nombre_tipo_doc"));
           tipo_doc.setEstado(rs.getString("estado"));
           lista.add(tipo_doc);
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
    

