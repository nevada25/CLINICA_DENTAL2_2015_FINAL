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
    public boolean fn_registrar_Persona(Persona persona, int opcion) {
        boolean flat = false;
        Statement st = null;
        ResultSet rs = null;
        String COMANDO = " SELECT fn_add_persona(" + persona.getId_grado_instruccion()
                + ", " + persona.getId_ocupacion()
                + ", " + persona.getId_ubigeo_nac()
                + ", " + persona.getId_ubigeo_act()
                + ", '" + persona.getNombres()
                + "', '" + persona.getApepat()
                + "', '" + persona.getApemat()
                + "', '" + persona.getFecha_nac()
                + "', '" + persona.getCorreo_gmail()
                + "', '" + persona.getCorreo_hotmail()
                + "', '" + persona.getCorreo_otros()
                + "', '" + persona.getCelular()
                + "', '" + persona.getTelefono()
                + "', '" + persona.getSexo()
                + "', '" + persona.getDireccion()
                + "', '" + persona.getPagina_web()
                + "', '" + persona.getFoto_persona()
                + "', '" + persona.getEstado()
                + "', " + persona.getId_tipo_doc()
                + ", '" + persona.getNro_doc()
                + "', " + opcion + ") resultado";
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
    public List<Persona> listarPersona() {
        List<Persona> lista = null;
        Statement st = null;
        ResultSet rs = null;
        Persona persona = null;
        String query = "select * from persona";
        try {
            lista = new ArrayList<Persona>();
            st = cn.traerconeccion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {

                persona = new Persona();
                persona.setId_persona(rs.getString("id_persona"));
                persona.setNombres(rs.getString("nombres"));
                persona.setApepat(rs.getString("apepat"));
                persona.setApemat(rs.getString("apemat"));
                persona.setId_tipo_doc(rs.getString("id_tipo_doc"));
                persona.setNro_doc(rs.getString("nro_doc"));
                persona.setSexo(rs.getString("sexo"));
                persona.setFecha_nac(rs.getString("fecha_nac"));
                persona.setCelular(rs.getString("celular"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setCorreo_gmail(rs.getString("correo_gmail"));
                persona.setCorreo_hotmail(rs.getString("correo_hotmail"));
                persona.setCorreo_otros(rs.getString("correo_otros"));
                persona.setId_ubigeo_nac(rs.getString("id_ubigeo_nac"));
                persona.setId_ubigeo_act(rs.getString("id_ubigeo_act"));
                persona.setId_grado_instruccion(rs.getString("id_grado_instruccion"));
                persona.setId_ocupacion(rs.getString("id_ocupacion"));
                persona.setPagina_web(rs.getString("pagina_web"));
                persona.setFoto_persona(rs.getString("foto_persona"));
                persona.setEstado(rs.getString("estado"));
                lista.add(persona);
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
    public int fn_registrar_Persona2(Persona persona, int opcion) {
        boolean flat = false;
        Statement st = null;
        ResultSet rs = null;
        int id_persona=0;
        String COMANDO = " SELECT fn_add_persona(" + persona.getId_grado_instruccion()
                + ", " + persona.getId_ocupacion()
                + ", " + persona.getId_ubigeo_nac()
                + ", " + persona.getId_ubigeo_act()
                + ", '" + persona.getNombres()
                + "', '" + persona.getApepat()
                + "', '" + persona.getApemat()
                + "', '" + persona.getFecha_nac()
                + "', '" + persona.getCorreo_gmail()
                + "', '" + persona.getCorreo_hotmail()
                + "', '" + persona.getCorreo_otros()
                + "', '" + persona.getCelular()
                + "', '" + persona.getTelefono()
                + "', '" + persona.getSexo()
                + "', '" + persona.getDireccion()
                + "', '" + persona.getPagina_web()
                + "', '" + persona.getFoto_persona()
                + "', '" + persona.getEstado()
                + "', " + persona.getId_tipo_doc()
                + ", '" + persona.getNro_doc()
                + "', '" + persona.getResponsable_apoderado()
                + "', " + opcion + ") resultado";
        System.out.println("comando: " + COMANDO);
        try {
            st = cn.traerconeccion().createStatement();
            rs = st.executeQuery(COMANDO);
            cn.guardar();
            rs.next();
            System.out.println(rs.getString("resultado"));
             id_persona=rs.getInt("resultado");
            cn.cerrar();
            flat = true;
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
            cn.cerrar();
            flat = false;
        }
        return id_persona;        
    }

}
