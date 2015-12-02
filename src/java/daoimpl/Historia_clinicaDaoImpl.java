package daoimpl;

import Centro_Control.Conexion2;
import bean.Historia_clinica;
import dao.Historia_clinicaDao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Historia_clinicaDaoImpl implements Historia_clinicaDao{
Conexion2 cn=new Conexion2();
 

    @Override
    public boolean agregarHistoriaClinica(Historia_clinica historiaClinica) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO historia_clinica(id_historia_clinica, id_cliente, nro_historia, comentario, antecedentes_familiar,fecha_reg, hora_reg, " +
"responsable_apoderado, motivo_consulta,peso, talla, pa, estado)" +
" VALUES ( ,  ,'','','','','','','','','','','1')";
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
    public List<Historia_clinica> mostrarHistoriaClinica() {
            List<Historia_clinica> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Historia_clinica historiaClinica=null;
        String query="SELECT id_historia_clinica, id_cliente, nro_historia, comentario, antecedentes_familiar, fecha_reg, hora_reg, responsable_apoderado, motivo_consulta, " +
"       peso, talla, pa, estado  FROM historia_clinica";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            historiaClinica=new Historia_clinica();
          
            lista.add(historiaClinica);
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
    public boolean actualizarHistoriaClinica(Historia_clinica historiaClinica) {
         boolean estado = false;
        Statement st=null;
        String query="UPDATE historia_clinica SET id_cliente= , nro_historia='', comentario='',antecedentes_familiar='', " +
"fecha_reg='', hora_reg='', responsable_apoderado='', motivo_consulta='', peso='', talla='', pa='', estado='' " +
" WHERE id_historia_clinica=";
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
    public boolean eliminarHistoriaClinica(int historiaClinica) {
         boolean estado = false;
        Statement st=null;
        String query="DELETE FROM historia_clinica WHERE id_historia_clinica=";
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
