package daoimpl;
import Centro_Control.Conexion2;
import bean.Categoria_servicio;
import dao.Categoria_servicioDao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Categoria_servicioDaoImpl implements Categoria_servicioDao{
Conexion2 cn=new Conexion2();

    @Override
    public boolean agregarServicio(Categoria_servicio Categoria_servicio) {
          boolean estado = false;
        Statement st=null;
        String query="INSERT INTO categoria_servicio(id_cat_serv, nombre_cat_serv)VALUES ((select nextval('sec_cat_servicio')),'"+Categoria_servicio.getNombre_cat_serv()+"')";
        try {
            st=cn.traerconeccion().createStatement();
            st.executeUpdate(query);
            cn.guardar();
            cn.cerrar();
            estado = true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            cn.restablecer();
            cn.cerrar();
            estado = false;
        } if (cn.traerconeccion()!=null) {
                 cn.restablecer();
            cn.cerrar();
            }

        return estado;
    }


    @Override
    public List<Categoria_servicio> listarServicio() {
 
             List<Categoria_servicio> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Categoria_servicio cat_ser=null;
        String query="SELECT id_cat_serv, nombre_cat_serv  FROM categoria_servicio  where estado='1' order by nombre_cat_serv ";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            cat_ser=new Categoria_servicio();
          cat_ser.setId_cat_serv(rs.getString("id_cat_serv"));
          cat_ser.setNombre_cat_serv(rs.getString("nombre_cat_serv"));
            lista.add(cat_ser);
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
    public boolean actualizarServicio(Categoria_servicio Categoria_servicio) {
          boolean estado = false;
        Statement st=null;
        String query="UPDATE categoria_servicio SET nombre_cat_serv='"+Categoria_servicio.getNombre_cat_serv()+"' WHERE id_cat_serv="+Categoria_servicio.getId_cat_serv()+"";
        try {
            st=cn.traerconeccion().createStatement();
            st.executeUpdate(query);
            cn.guardar();
            cn.cerrar();
            estado = true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            cn.restablecer();
            cn.cerrar();
            estado = false;
        }finally{
            if (cn.traerconeccion()!=null) {
                 cn.restablecer();
            cn.cerrar();
            }
        
        }

        return estado;
    }


    @Override
    public boolean eliminarServicio(int id_cat_serv) {
          boolean estado = false;
        Statement st=null;
        String query="DELETE FROM categoria_servicio WHERE id_cat_serv="+id_cat_serv;
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
        } if (cn.traerconeccion()!=null) {
                 cn.restablecer();
            cn.cerrar();
            }

        return estado;
    }

    @Override
    public Categoria_servicio datosServicio(int id_servicio) {
       Statement st=null;
        ResultSet rs=null;
        Categoria_servicio cat_ser=null;
        String query="SELECT id_cat_serv, nombre_cat_serv FROM categoria_servicio where id_cat_serv="+id_servicio;
        try {
       st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
          cat_ser=new Categoria_servicio();
          cat_ser.setId_cat_serv(rs.getString("id_cat_serv"));
          cat_ser.setNombre_cat_serv(rs.getString("nombre_cat_serv"));
         
        }
        cn.cerrar();
        } catch (Exception e) {
             System.out.println("ERROR:"+e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }

       return cat_ser;
    }

    @Override
    public List<Categoria_servicio> listarServicios(String buscar, String limit) {
          List<Categoria_servicio> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Categoria_servicio cat_ser=null;
        String query="SELECT *  FROM categoria_servicio where upper(nombre_cat_serv) like upper('%"+buscar+"%') and estado='1' order by nombre_cat_serv limit "+limit+"";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
          cat_ser=new Categoria_servicio();
          cat_ser.setId_cat_serv(rs.getString("id_cat_serv"));
          cat_ser.setNombre_cat_serv(rs.getString("nombre_cat_serv"));
            lista.add(cat_ser);
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
    public boolean eliminasercategoriaser(int id_servicio) {
          boolean estado = false;
        Statement st=null;
        String query="UPDATE categoria_servicio  SET  estado='0' WHERE id_cat_serv="+id_servicio+"";
        try {
            st=cn.traerconeccion().createStatement();
            st.executeUpdate(query);
            cn.guardar();
            cn.cerrar();
            estado = true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            cn.restablecer();
            cn.cerrar();
            estado = false;
        }finally{
            if (cn.traerconeccion()!=null) {
                 cn.restablecer();
            cn.cerrar();
            }
        
        }

        return estado;
    }


}
