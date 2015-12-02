package daoimpl;
import Centro_Control.Conexion2;
import dao.ProductoDao;
import bean.Producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ProductoDaoImpl implements ProductoDao{
    Conexion2 cn=new Conexion2();
     @Override
    public boolean agregarProducto(Producto producto) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO producto( id_producto, id_unidad_medida) VALUES ( ,  )";
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
    public List<Producto> mostrarProducto() {
        List<Producto> lista=null;
        Statement st=null;
        ResultSet rs=null;
        Producto produ=null;
        String query="SELECT id_producto, id_unidad_medida, nombre_producto  FROM producto";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
           produ=new Producto();
           produ.setId_producto(rs.getString("id_producto"));
           produ.setId_unidad_medida(rs.getString("id_unidad_medida"));
           produ.setNombre_producto(rs.getString("nombre_producto"));
           
           lista.add(produ);
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
    public boolean actualizarProducto(Producto producto) {
         boolean estado = false;
        Statement st=null;
        String query="UPDATE producto SET  id_unidad_medida='"+producto.getId_unidad_medida()+"', nombre_producto='"+producto.getNombre_producto()+"' WHERE WHERE id_producto='"+producto.getId_producto()+"'";
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
    public boolean eliminarProducto(int idProducto) {
         boolean estado = false;
        Statement st=null;
        String query="DELETE FROM producto WHERE id_producto='"+idProducto+"'";
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
    public List<Producto> mostrarproductosaedidar(String buscar, String limit) {
         List<Producto> lista=null;
        Statement st=null;
        ResultSet rs=null;
        Producto produ=null;
        String query="SELECT   pro.id_producto as id_producto, pro.nombre_producto as nombre,  uni_da.nombre_uni_med as unidad" +
                     " FROM   public.producto pro,public.unidad_medida uni_da " +
                     "WHERE  uni_da.id_unidad_medida = pro.id_unidad_medida and (pro.nombre_producto||uni_da.nombre_uni_med) like '%"+buscar+"%' limit "+limit+"";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
           produ=new Producto();
           produ.setId_producto(rs.getString("id_producto"));
           produ.setId_unidad_medida(rs.getString("unidad"));
           produ.setNombre_producto(rs.getString("nombre"));
           
           lista.add(produ);
           System.out.println(query);
        }
        cn.cerrar();
            System.out.println(query);
        } catch (Exception e) {
             System.out.println("ERROR:"+e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }

        return lista;
    }
    
}