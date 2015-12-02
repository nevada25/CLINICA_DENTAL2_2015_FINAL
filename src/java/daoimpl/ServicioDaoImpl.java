package daoimpl;

import Centro_Control.Conexion2;
import bean.Servicio;
import dao.ServicioDao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServicioDaoImpl implements ServicioDao {

    Conexion2 cn = new Conexion2();

   
    @Override
    public List<Servicio> listarServicioedi(String buscar, String limit) {
        List<Servicio> lista = null;
        Statement st = null;
        ResultSet rs = null;
        Servicio servicio = null;
        String query = "SELECT categoria_servicio.id_cat_serv,"
                + "  categoria_servicio.nombre_cat_serv,"
                + "  servicio.id_servicio,"
                + "  servicio.nombre_serv,"
                + "  servicio.precio_max,"
                + "  servicio.precio_min,"
                + "  servicio.precio,"
                + "  servicio.estado FROM  servicio,  categoria_servicio "
                + "  WHERE UPPER(categoria_servicio.nombre_cat_serv||servicio.nombre_serv)"
                + " like upper('%" + buscar + "%') and  categoria_servicio.id_cat_serv = servicio.id_cat_serv "
                + " order by categoria_servicio.nombre_cat_serv||servicio.nombre_serv  limit " + limit + "";
        try {
            lista = new ArrayList<>();
            st = cn.traerconeccion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                servicio = new Servicio();
                servicio.setId_servicio(rs.getString("id_servicio"));
                servicio.setNombre_serv(rs.getString("nombre_serv"));
                servicio.setId_cat_serv(rs.getString("id_cat_serv"));
                servicio.setNombre_cat_serv(rs.getString("nombre_cat_serv"));
                servicio.setPrecio_min(rs.getString("precio_min"));
                servicio.setPrecio_max(rs.getString("precio_max"));
                servicio.setPrecio(rs.getString("precio"));
                servicio.setEstado(rs.getString("estado"));
                lista.add(servicio);

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
    public boolean fn_crud_servicio(Servicio servicio, int opcion) {
          boolean flat = false;
        Statement st = null;
        ResultSet rs = null;
        String COMANDO = "SELECT fn_crud_servicio("+servicio.getId_servicio()
                +", "+servicio.getId_cat_serv()
                +", '"+servicio.getNombre_serv()
                +"', "+servicio.getPrecio_max()
                +", "+servicio.getPrecio_min()
                +", '"+servicio.getEstado()
                +"', '"+opcion+"') resultado";
        System.out.println("comando: " + COMANDO);
        try {
            st = cn.traerconeccion().createStatement();
            rs = st.executeQuery(COMANDO);
            cn.guardar();
            rs.next();
            System.out.println(rs.getString("resultado"));
            cn.cerrar();
            flat = true;
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
            cn.cerrar();
            flat = false;
        }
        return flat;
    }

    @Override
    public Servicio BuscarServicio(int id_servicio) {
         Statement st = null;
        ResultSet rs = null;
        Servicio servicio = null;
        String query = "select id_servicio, id_cat_serv, nombre_serv, precio_max, precio_min, estado "
                + " from servicio "
                + " where id_servicio = "+id_servicio+" ";
        System.out.println(query);
        try {
            st = cn.traerconeccion().createStatement();
            rs = st.executeQuery(query);
           rs.next();
                servicio = new Servicio();
                servicio.setId_servicio(rs.getString("id_servicio"));
                servicio.setId_cat_serv(rs.getString("id_cat_serv"));
                servicio.setNombre_serv(rs.getString("nombre_serv"));
                servicio.setPrecio_max(rs.getString("precio_max"));
                servicio.setPrecio_min(rs.getString("precio_min"));
                servicio.setEstado(rs.getString("estado"));
             cn.cerrar();
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }
        return servicio;
    }

   
}
