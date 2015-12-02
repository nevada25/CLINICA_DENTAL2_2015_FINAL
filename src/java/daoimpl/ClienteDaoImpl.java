
package daoimpl;

import Centro_Control.Conexion2;
import bean.Cliente;
import dao.ClienteDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao{
    Conexion2 cn=new Conexion2();
    @Override
    public boolean agregarcliente(Cliente cliente) {
              boolean estado = false;
        Statement st=null;
        String query="INSERT INTO publiccliente(id_cliente) VALUES (?)";
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

     return  estado;
    }

    @Override
    public List<Cliente> listarclientes() {
        List<Cliente> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Cliente cliente=null;
        String query="SELECT id_cliente FROM public.cliente";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            cliente=new Cliente();
          
            lista.add(cliente);
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
    public boolean updatecliente(Cliente cliente) {
          boolean estado = false;
        Statement st=null;
        String query="UPDATE public.cliente SET id_cliente=? WHERE id_cliente=?";
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
    public boolean deletecliente(int id_cliente) {
    boolean estado = false;
        Statement st=null;
        String query="DELETE FROM public.cliente WHERE id_cliente=?";
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
