package daoimpl;

import Centro_Control.Conexion2;
import bean.Proveedor;
import dao.ProveedorDao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDaoImpl implements ProveedorDao{
    Conexion2 cn=new Conexion2();
    @Override
    public boolean agregaruProveedor(Proveedor proveedor) {
        boolean estado = false;
        Statement st=null;
        String query="INSERT INTO public.proveedor(id_proveedor, estado) VALUES ( ,'1')";
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
    public List<Proveedor> mostrarProveedor() {
        List<Proveedor> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Proveedor   proveedor=null;
        String query="SELECT id_proveedor, estado FROM proveedor";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            proveedor=new Proveedor();
          
            lista.add(proveedor);
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
    public boolean actualizarProveedor(Proveedor proveedor) {
         boolean estado = false;
        Statement st=null;
        String query="UPDATE proveedor SET estado='' WHERE id_proveedor=";
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
    public boolean eliminarProveedor(int proveedor) {
         boolean estado = false;
        Statement st=null;
        String query="DELETE FROM proveedor WHERE id_proveedor=";
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
