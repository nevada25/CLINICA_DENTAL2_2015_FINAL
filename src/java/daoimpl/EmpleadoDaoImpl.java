package daoimpl;
import Centro_Control.Conexion2;
import dao.EmpleadoDao;
import bean.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class EmpleadoDaoImpl implements EmpleadoDao{
Conexion2 cn=new Conexion2();

       @Override
    public boolean agregarempleado(Empleado empleado) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO empleado(id_empleado) VALUES ( )";
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
    public List<Empleado> mostrarempleado() {
        List<Empleado> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Empleado empleado=null;
        String query="SELECT  em.id_empleado as empleado,pe.nombres||' '||pe.apepat||' '|| pe.apemat as persona " +
                     "FROM   public.empleado em,  public.persona pe " +
                     "WHERE   pe.id_persona = em.id_empleado;";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
           empleado=new Empleado();
           empleado.setId_empleado(rs.getString("empleado"));
           empleado.setNombres(rs.getString("persona"));
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
    public boolean actualizarempleado(Empleado empleado) {
        boolean estado = false;
        Statement st=null;
        String query="UPDATE empleado  SET id_empleado=  WHERE id_empleado="+empleado.getId_empleado()+"";
        try {
            st=cn.traerconeccion().createStatement();
            st.executeUpdate(query);
            cn.guardar();
            cn.cerrar();
        } catch (Exception e) {
             System.out.println("ERROR:"+e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }
        return estado;
    }

    @Override
    public boolean eliminarempleado(int idEmpleado) {
         boolean estado = false;
        Statement st=null;
        String query="DELETE FROM empleado WHERE id_empleado=";
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
    
