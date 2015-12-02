
package daoimpl;

import Centro_Control.Conexion2;
import bean.Cita;
import dao.CitaDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class CitaDaoImpl implements CitaDao{
   Conexion2 cn=new Conexion2();
    @Override
    public boolean agregaruCita(Cita cita) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO public.cita(id_cita, id_contrato, fecha_cita, hora, estado, condicion, id_empleado) VALUES ( , ,' ','','','', )";
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
    public List<Cita> mostrarCita() {
            List<Cita> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Cita cita=null;
        String query="SELECT id_cita, id_contrato, fecha_cita, hora, estado, condicion, id_empleado FROM public.cita";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            cita=new Cita();
          
            lista.add(cita);
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
    public boolean actualizarCita(Cita cita) {
         boolean estado = false;
        Statement st=null;
        String query="UPDATE public.cita SET id_contrato=?, fecha_cita=?, hora=?, estado=?, condicion=?,  id_empleado=? WHERE id_cita=";
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
    public boolean eliminarCita(int id_cita) {
         boolean estado = false;
        Statement st=null;
        String query="DELETE FROM public.cita WHERE id_cita=";
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
