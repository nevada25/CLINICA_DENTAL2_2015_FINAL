package daoimpl;
import Centro_Control.Conexion2;
import bean.Embarazo;
import dao.EmbarazoDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class EmbarazoDaoImpl implements EmbarazoDao{
    Conexion2 cn=new Conexion2();
    @Override
    public boolean agregarEmbarazo(Embarazo embarazo) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO embarazo(id_historia_clinica, nro_semanas, ultimo_control, trata_farma) VALUES ( ,'','','')";
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
    public List<Embarazo> mostrarEmbarazo() {
        List<Embarazo> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Embarazo empleado=null;
        String query="SELECT id_historia_clinica, nro_semanas, ultimo_control, trata_farma  FROM embarazo";
        try {
        lista=new ArrayList<Embarazo>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
           empleado=new Embarazo();
           empleado.getId_historia_clinica();
           lista.add(empleado);
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
    public boolean actualizarEmbarazo(Embarazo embarazo) {
         boolean estado = false;
        Statement st=null;
        String query="UPDATE embarazo SET nro_semanas='', ultimo_control='', trata_farma='' WHERE id_historia_clinica= ";
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
    public boolean eliminarEmbarazo(int embarazo) {
         boolean estado = false;
        Statement st=null;
        String query="DELETE FROM embarazo WHERE  id_historia_clinica=";
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
