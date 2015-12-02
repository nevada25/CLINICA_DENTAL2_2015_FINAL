
package daoimpl;

import Centro_Control.Conexion2;
import bean.Compra;
import dao.CompraDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompraDaoImpl implements CompraDao{
  Conexion2 cn=new Conexion2();
  
    @Override
    public boolean agregarCompra(Compra compra) {
         boolean estado = false;
        Statement st=null;
        String query="INSERT INTO compra(id_compra, fecha, serie_fac, subtotal, descuento, igv, total,id_persona) VALUES ( ,'','', , , , , )";
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
    public List<Compra> mostrarCompra() {
            List<Compra> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Compra compra=null;
        String query="SELECT id_compra, fecha, serie_fac, subtotal, descuento, igv, total, id_persona FROM compra";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
         compra=new Compra();
          
            lista.add(compra);
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
    public boolean actualizarCompra(Compra compra) {
         boolean estado = false;
        Statement st=null;
        String query="UPDATE compra SET fecha='', serie_fac='', subtotal= , descuento= , igv= , total= , id_persona= WHERE id_compra=";
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
    public boolean eliminarCompra(int id_compra) {
         boolean estado = false;
        Statement st=null;
        String query="DELETE FROM public.compra WHERE id_compra=";
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
