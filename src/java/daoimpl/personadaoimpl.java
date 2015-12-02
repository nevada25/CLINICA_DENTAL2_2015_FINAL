package daoimpl;
import Centro_Control.Conexion2;
import dao.personadao;
import bean.Persona;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class personadaoimpl implements personadao {
    Conexion2 cn=new Conexion2();
    @Override
    public boolean agregarpersona(Persona person, int opcion) {
        boolean estado = false;
        Statement st=null;
        String query="select fn_add_personal("+person.getId_grado_instruccion()+" ,"+person.getId_ocupacion()+","+person.getId_ubigeo_nac()+","+person.getId_ubigeo_act()+",'"+person.getNombres()+"'," +
" '"+person.getApepat()+"','"+person.getApemat()+"','"+person.getFecha_nac()+"','"+person.getCorreo_gmail()+"','"+person.getCorreo_hotmail()+"','"+person.getCorreo_otros()+"','"+person.getCelular()+"','"+person.getTelefono()+"','"+person.getSexo()+"'," +
"'"+person.getDireccion()+"','"+person.getPagina_web()+"','"+person.getFoto_persona()+"',1,"+person.getId_tipo_doc()+","+opcion+")";
        try {
            st=cn.traerconeccion().createStatement();
            st.executeUpdate(query);
            cn.traerconeccion().getAutoCommit();
            cn.guardar();
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
    public List<Persona> mostrarpersona() {
        List<Persona> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Persona persona=null;
        String query="SELECT * FROM persona";
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            persona=new Persona();
            persona.setId_persona(rs.getInt("id_persona"));
            persona.setId_grado_instruccion(rs.getInt("id_grado_instruccion"));
            persona.setId_ocupacion(rs.getInt("id_ocupacion"));
            persona.setId_ubigeo_nac(rs.getInt("id_ubigeo_nac"));
            persona.setId_ubigeo_act(rs.getInt("id_ubigeo_act"));
            persona.setNombre(rs.getString("nombre"));
            persona.setNombres(rs.getString("nombres"));
            persona.setApepat(rs.getString("apepat"));
            persona.setApemat(rs.getString("apemat"));
            persona.setFecha_nac(rs.getDate("fecha_nac"));
            persona.setCorreo_gmail(rs.getString("correo"));
            persona.setCorreo_hotmail(rs.getString("correo"));
            persona.setCorreo_otros(rs.getString("correo"));
            persona.setCelular(rs.getString("celular"));
            persona.setTelefono(rs.getString("telefono"));
            persona.setSexo(rs.getString("sexo"));
            persona.setDireccion(rs.getString("direccion"));
            persona.setPagina_web(rs.getString("pagina_web"));
            persona.setEstado(rs.getString("estado"));
            persona.setId_tipo_doc(rs.getInt("id_tipo_doc"));
            persona.setFoto_persona(rs.getByte("foto_persona"));
            persona.setNro_doc(rs.getString("nro_doc"));
            lista.add(persona);
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
    public boolean actualizarpersona(Persona persona) {
        boolean estado = false;
        Statement st=null;
        String query="UPDATE persona SET id_grado_instruccion= , id_ocupacion= , id_ubigeo_nac=  ,id_ubigeo_act= , nombre=' ', nombres='', apepat='', apemat='', fecha_nac='', \n" +
"       correo_gmail='', correo_hotmail='', correo_otros='', celular='', telefono='', sexo='', direccion='', pagina_web='', estado='', id_tipo_doc= , \n" +
"       foto_persona=\n" +
" WHERE id_persona=";
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
    public boolean eliminarpersona(int id) {
        boolean estado = false;
        Statement st=null;
        String query="DELETE FROM persona WHERE id_persona="+id+"";
        try {
            st=cn.traerconeccion().createStatement();
            st.executeUpdate(query);
            cn.guardar();
            cn.cerrar();
            estado=true;
        } catch (Exception e) {
            System.out.println("ERROR:"+e.getMessage());
            cn.cerrar();
        }

        return estado;
    }

    @Override
    public List<Persona> mostrarpersona(String buscar,String limit) {
       List<Persona> lista = null;
        Statement st=null;
        ResultSet rs=null;
        Persona persona=null;
        String query="SELECT id_persona, id_grado_instruccion, id_ocupacion, id_ubigeo_nac,id_ubigeo_act, nombres, apepat, apemat, fecha_nac, correo_gmail," +
"       correo_hotmail, correo_otros, celular, telefono, sexo, direccion,pagina_web, foto_persona, estado, id_tipo_doc, nro_doc," +
"       fecha_registro_per,hora_registro FROM persona where upper(nombres||apepat||apemat) like upper('%"+buscar+"%') order by apepat limit"+limit;
        try {
        lista=new ArrayList<>();
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
              persona=new Persona();
            persona.setId_persona(rs.getInt("id_persona"));
            persona.setId_grado_instruccion(rs.getInt("id_grado_instruccion"));
            persona.setId_ocupacion(rs.getInt("id_ocupacion"));
            persona.setId_ubigeo_nac(rs.getInt("id_ubigeo_nac"));
            persona.setId_ubigeo_act(rs.getInt("id_ubigeo_act"));
            persona.setNombre(rs.getString("nombre"));
            persona.setNombres(rs.getString("nombres"));
            persona.setApepat(rs.getString("apepat"));
            persona.setApemat(rs.getString("apemat"));
            persona.setFecha_nac(rs.getDate("fecha_nac"));
            persona.setCorreo_gmail(rs.getString("correo"));
            persona.setCorreo_hotmail(rs.getString("correo"));
            persona.setCorreo_otros(rs.getString("correo"));
            persona.setCelular(rs.getString("celular"));
            persona.setTelefono(rs.getString("telefono"));
            persona.setSexo(rs.getString("sexo"));
            persona.setDireccion(rs.getString("direccion"));
            persona.setPagina_web(rs.getString("pagina_web"));
            persona.setEstado(rs.getString("estado"));
            persona.setId_tipo_doc(rs.getInt("id_tipo_doc"));
            persona.setFoto_persona(rs.getByte("foto_persona"));
            persona.setNro_doc(rs.getString("nro_doc"));
            lista.add(persona);
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
    public Persona datoper(int id) {

        Statement st = null;
        ResultSet rs = null;
        Persona persona = null;
        String query = "SELECT * FROM persona where id_persona="+id+"";
        System.out.println(query);
        try {
        
        st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
            persona=new Persona();
            persona.setId_persona(rs.getInt("id_persona"));
            persona.setId_grado_instruccion(rs.getInt("id_grado_instruccion"));
            persona.setId_ocupacion(rs.getInt("id_ocupacion"));
            persona.setId_ubigeo_nac(rs.getInt("id_ubigeo_nac"));
            persona.setId_ubigeo_act(rs.getInt("id_ubigeo_act"));
            persona.setNombre(rs.getString("nombre"));
            persona.setNombres(rs.getString("nombres"));
            persona.setApepat(rs.getString("apepat"));
            persona.setApemat(rs.getString("apemat"));
            persona.setFecha_nac(rs.getDate("fecha_nac"));
            persona.setCorreo_gmail(rs.getString("correo"));
            persona.setCorreo_hotmail(rs.getString("correo"));
            persona.setCorreo_otros(rs.getString("correo"));
            persona.setCelular(rs.getString("celular"));
            persona.setTelefono(rs.getString("telefono"));
            persona.setSexo(rs.getString("sexo"));
            persona.setDireccion(rs.getString("direccion"));
            persona.setPagina_web(rs.getString("pagina_web"));
            persona.setEstado(rs.getString("estado"));
            persona.setId_tipo_doc(rs.getInt("id_tipo_doc"));
            persona.setFoto_persona(rs.getByte("foto_persona"));
            persona.setNro_doc(rs.getString("nro_doc"));
            
        }
        cn.cerrar();
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }
        return persona;
    }

    @Override
    public List<Persona> mostrarpersonas(int id) {
        List<Persona> lista=null;
        Statement st=null;
        ResultSet rs=null;
        Persona alumo=null;
        String query="SELECT * from persona where id_persona="+id+"";
        try {
            lista = new ArrayList<>();
            st= cn.traerconeccion().createStatement();
            rs=st.executeQuery(query);
            while (rs.next()) {
                
                alumo =new Persona();
                alumo.setId_persona(rs.getInt("id_persona"));
                alumo.setNombre(rs.getString("nombre"));
                alumo.setApepat(rs.getString("apepat"));
                lista.add(alumo);
            }
        } catch (Exception e) {
            System.out.println("ERROR:"+e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }
        return lista;
}

}
