package daoimpl;

import Centro_Control.Conexion2;
import bean.Pieza;
import dao.PiezaDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PiezaDaoImpl implements PiezaDao{
    Conexion2 cn=new Conexion2();
        @Override
    public boolean agregarPieza(Pieza pieza) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO pieza(id_pieza, nro_pieza)VALUES (,'')";
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
    public List<Pieza> mostrarPieza() {
            List<Pieza> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Pieza   pieza=null;
        String query="SELECT id_pieza, nro_pieza FROM pieza";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            pieza=new Pieza();
          
            lista.add(pieza);
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
    public boolean actualizarPieza(Pieza pieza) {
         boolean estado = false;
        Statement st=null;
        String query="UPDATE pieza SET nro_pieza='' WHERE id_pieza=";
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
    public boolean eliminarPieza(int pieza) {
         boolean estado = false;
        Statement st=null;
        String query="DELETE FROM pieza WHERE id_pieza=";
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