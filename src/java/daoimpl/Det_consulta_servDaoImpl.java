package daoimpl;
import Centro_Control.Conexion2;
import bean.Det_consulta_serv;
import dao.Det_consulta_servDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Det_consulta_servDaoImpl implements  Det_consulta_servDao{
   Conexion2 cn=new Conexion2();
   @Override
    public boolean agregarDetConsultaServ(Det_consulta_serv detConsultaServ) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO det_consulta_serv(id_servicio, id_cita, cantidad, total, nro_laboratorio_int, motivo_consul,id_empleado) VALUES (, , , ,'','',)";
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
    public List<Det_consulta_serv> mostrarDetConsultaServ() {
            List<Det_consulta_serv> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Det_consulta_serv detConsultaServ=null;
        String query="SELECT id_servicio, id_cita, cantidad, total, nro_laboratorio_int, motivo_consul,id_empleado FROM det_consulta_serv";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            detConsultaServ=new Det_consulta_serv();
          
            lista.add(detConsultaServ);
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
    public boolean actualizarDetConsultaServ(Det_consulta_serv detConsultaServ) {
         boolean estado = false;
        Statement st=null;
        String query="UPDATE det_consulta_serv SET id_cita= , cantidad= , total= , nro_laboratorio_int='',motivo_consul='', id_empleado= WHERE id_servicio=";
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
    public boolean eliminarDetConsultaServ(int id_detConsultaServ) {
         boolean estado = false;
        Statement st=null;
        String query="DELETE FROM det_consulta_serv WHERE id_servicio=";
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
