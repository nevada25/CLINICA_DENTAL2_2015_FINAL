
package daoimpl;

import Centro_Control.Conexion2;
import bean.Cliente;
import dao.ClienteDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao{
    Conexion2 cn=new Conexion2();
    @Override
    public boolean agregarcliente(Cliente cliente) {
              boolean estado = false;
        Statement st=null;
        String query="INSERT INTO publiccliente(id_cliente) VALUES (?)";
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

     return  estado;
    }

    @Override
    public List<Cliente> listarclientes() {
        List<Cliente> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Cliente cliente=null;
        String query="SELECT id_cliente FROM public.cliente";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            cliente=new Cliente();
          
            lista.add(cliente);
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
    public boolean updatecliente(Cliente cliente) {
          boolean estado = false;
        Statement st=null;
        String query="UPDATE public.cliente SET id_cliente=? WHERE id_cliente=?";
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
    public boolean deletecliente(int id_cliente) {
    boolean estado = false;
        Statement st=null;
        String query="DELETE FROM public.cliente WHERE id_cliente=?";
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
    public List<Cliente> buscarclientes(String buscar, String limit) {
        List<Cliente> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Cliente cliente=null;
        String query="SELECT cl.id_cliente as id, upper(per.nombres||' '|| per.apepat||' '||per.apemat) Nombres, " +
                     "  per.fecha_nac as fecha,CASE sexo WHEN 'M' THEN 'MASCULINO' WHEN 'F' THEN 'FEMENINO' END " +
                     "  sexo,  upper(per.direccion)as dirección, per.nro_doc as dni,per.telefono as celular " +
                     "FROM   public.persona per, public.cliente cl WHERE  per.id_persona = cl.id_cliente and " +
                     "(per.nombres||per.apepat||per.apemat||per.nro_doc) like '%"+buscar+"%' limit "+limit+"";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            cliente=new Cliente();
            cliente.setId_cliente(rs.getString("id"));
            cliente.setNombres(rs.getString("Nombres"));
            cliente.setFecha_nac(rs.getString("fecha"));
            cliente.setSexo(rs.getString("sexo"));
            cliente.setDireccion(rs.getString("dirección"));
            cliente.setNro_doc(rs.getString("dni"));
            cliente.setTelefono(rs.getString("celular"));
            lista.add(cliente);
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
    public List<Cliente> listarclientesfecha(String fecha_ini, String fecha_fin) {
        List<Cliente> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Cliente cliente=null;
        String query="SELECT   per.nombres||' '||per.apepat||' '||per.apemat as nombres,  per.fecha_nac as fecha_na,  per.telefono as telefono, CASE per.sexo WHEN 'M' THEN 'MASCULINO' WHEN 'F' THEN 'FEMENINO' END sexo,  per.direccion as direccion,   per.nro_doc as dni," +
"  per.fecha_reg_per as re_per,  per.hora_registro hor_re,  hc.nro_historia as nro_his FROM   public.persona per,  public.historia_clinica hc, " +
"  public.cliente cl WHERE    per.id_persona = cl.id_cliente AND  cl.id_cliente = hc.id_cliente and per.fecha_reg_per " +
"  between  '"+fecha_ini+"' and '"+fecha_fin+"'";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            cliente=new Cliente();
            cliente.setNombres(rs.getString("nombres"));
            cliente.setFecha_nac(rs.getString("fecha_na"));
            cliente.setTelefono(rs.getString("telefono"));
            cliente.setSexo(rs.getString("sexo"));
            cliente.setDireccion(rs.getString("direccion"));
            cliente.setNro_doc(rs.getString("dni"));
            cliente.setFecha_nac(rs.getString("re_per"));
            cliente.setEstado(rs.getString("hor_re"));
            cliente.setCelular(rs.getString("nro_his"));
            lista.add(cliente);
        }
        cn.cerrar();
        } catch (Exception e) {
             System.out.println("ERROR:"+e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }

        return lista;
    }
    
}
