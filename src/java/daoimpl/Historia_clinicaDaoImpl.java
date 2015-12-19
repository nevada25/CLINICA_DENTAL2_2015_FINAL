/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import Centro_Control.Conexion2;
import bean.Historia_clinica;
import dao.Historia_clinicaDao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public class Historia_clinicaDaoImpl implements Historia_clinicaDao{

    Conexion2 cn = new Conexion2();
    @Override
    public int fn_crud_historia_clinica(Historia_clinica historia_clinica, int opcion) {
      
        Statement st = null;
        ResultSet rs = null;
        int id_hist_cli=0;
        String COMANDO = "SELECT fn_crud_historia_clinica(" 
                + historia_clinica.getId_historia_clinica() 
                + ", " + historia_clinica.getId_cliente()
                + ", '" + historia_clinica.getNro_historia()
                + "', '" + historia_clinica.getComentario()
                + "', '" + historia_clinica.getAntecedentes_familiar()
                + "', '" + historia_clinica.getFecha_reg()
                + "', '" + historia_clinica.getHora_reg()
                + "', '" + historia_clinica.getResponsable_apoderado()
                + "', '" + historia_clinica.getMotivo_consulta()
                + "', '" + historia_clinica.getPeso()
                + "', '" + historia_clinica.getTalla()
                + "', '" + historia_clinica.getPa()
                + "', '" + historia_clinica.getEstado()
                + "', '" + historia_clinica.getEspecificaciones()
                + "', '" + historia_clinica.getObservaciones()
                + "', '" + historia_clinica.getPronostico()
                + "'," + opcion + ") resultado";
        System.out.println("comando: " + COMANDO);
        try {
            st = cn.traerconeccion().createStatement();
            rs = st.executeQuery(COMANDO);
            cn.guardar();
            rs.next();
            System.out.println(rs.getString("resultado"));
             id_hist_cli=rs.getInt("resultado");
            cn.cerrar();
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }
        return id_hist_cli;
    }

    @Override
    public List<Historia_clinica> listarHistCli(String id_hist_cli) {
         List<Historia_clinica> lista = null;
        Statement st = null;
        ResultSet rs = null;
        Historia_clinica historia_clinica = null;
        String query = "SELECT    INITCAP(nombres)||' ' ||INITCAP(apepat)||' ' ||INITCAP(apemat) cliente, fecha_nac, "
                + "nro_historia, antecedentes_familiar, motivo_consulta, comentario, fecha_reg_hist, " +
                 " hora_reg, responsable_apoderado, peso, talla, pa, especificaciones, observaciones,"
                + " pronostico, telefono, sexo, direccion, nro_doc, fecha_reg_per, hora_registro " +
                " FROM v_cliente_hist_clinica";
        try {
            lista = new ArrayList<Historia_clinica>();
            st = cn.traerconeccion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {

                historia_clinica = new Historia_clinica();
                historia_clinica.setNombres(rs.getString("cliente"));
                historia_clinica.setFecha_nac(rs.getString("fecha_nac"));
                historia_clinica.setNro_historia(rs.getString("nro_historia"));
                historia_clinica.setAntecedentes_familiar(rs.getString("antecedentes_familiar"));
                historia_clinica.setMotivo_consulta(rs.getString("motivo_consulta"));
                historia_clinica.setComentario(rs.getString("comentario"));
                historia_clinica.setFecha_reg(rs.getString("fecha_reg_hist"));
                historia_clinica.setHora_reg(rs.getString("hora_reg"));
                historia_clinica.setResponsable_apoderado(rs.getString("responsable_apoderado"));
                historia_clinica.setPeso(rs.getString("peso"));
                historia_clinica.setTalla(rs.getString("talla"));
                historia_clinica.setPa(rs.getString("pa"));
                historia_clinica.setEspecificaciones(rs.getString("especificaciones"));
                historia_clinica.setObservaciones(rs.getString("observaciones"));
                historia_clinica.setPronostico(rs.getString("pronostico"));
                historia_clinica.setTelefono(rs.getString("telefono"));
                historia_clinica.setSexo(rs.getString("sexo"));
                historia_clinica.setDireccion(rs.getString("direccion"));
                historia_clinica.setNro_doc(rs.getString("nro_doc"));
                historia_clinica.setFoto_persona(rs.getString("fecha_reg_per"));
                historia_clinica.setCorreo_otros(rs.getString("hora_registro"));
                lista.add(historia_clinica);
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
    public Historia_clinica buscardatos(int id_cliente) {
         Statement st=null;
        ResultSet rs=null;
        Historia_clinica historia_clinica=null;
        String query="SELECT   cli.id_cliente, his_cli.id_historia_clinica, per.nombres,per.apepat,per.apemat,his_cli.nro_historia, his_cli.comentario, " +
"  his_cli.antecedentes_familiar,his_cli.fecha_reg_hist,his_cli.responsable_apoderado,his_cli.hora_reg,his_cli.motivo_consulta, " +
"  his_cli.peso, his_cli.talla, his_cli.pa,  his_cli.estado, his_cli.especificaciones,his_cli.observaciones,  his_cli.pronostico, " +
" CASE sexo WHEN 'M' THEN 'MASCULINO' WHEN 'F' THEN 'FEMENINO' END  sexo,  per.telefono, per.nro_doc, per.hora_registro, per.fecha_reg_per," +
"  (select (to_date(to_char(now(),'yyyy'),'yy')-(select to_date(to_char(per.fecha_nac,'yy'),'yy')))/360) edad, " +
"  per.fecha_nac FROM   public.cliente cli,  public.persona per, public.historia_clinica his_cli " +
"WHERE   cli.id_cliente = per.id_persona AND  cli.id_cliente = his_cli.id_cliente  and cli.id_cliente="+id_cliente+"";
        try {
       st=cn.traerconeccion().createStatement();
        rs=st.executeQuery(query);
        while(rs.next())
        {
         
                historia_clinica = new Historia_clinica();
                historia_clinica.setNombres(rs.getString("cliente"));
                historia_clinica.setApepat(rs.getString("edad"));
                historia_clinica.setFecha_nac(rs.getString("fecha_nac"));
                historia_clinica.setNro_historia(rs.getString("nro_historia"));
                historia_clinica.setAntecedentes_familiar(rs.getString("antecedentes_familiar"));
                historia_clinica.setMotivo_consulta(rs.getString("motivo_consulta"));
                historia_clinica.setComentario(rs.getString("comentario"));
                historia_clinica.setFecha_reg(rs.getString("fecha_reg_hist"));
                historia_clinica.setHora_reg(rs.getString("hora_reg"));
                historia_clinica.setResponsable_apoderado(rs.getString("responsable_apoderado"));
                historia_clinica.setPeso(rs.getString("peso"));
                historia_clinica.setTalla(rs.getString("talla"));
                historia_clinica.setPa(rs.getString("pa"));
                historia_clinica.setEspecificaciones(rs.getString("especificaciones"));
                historia_clinica.setObservaciones(rs.getString("observaciones"));
                historia_clinica.setPronostico(rs.getString("pronostico"));
                historia_clinica.setTelefono(rs.getString("telefono"));
                historia_clinica.setSexo(rs.getString("sexo"));
                historia_clinica.setDireccion(rs.getString("direccion"));
                historia_clinica.setNro_doc(rs.getString("nro_doc"));
                historia_clinica.setFoto_persona(rs.getString("fecha_reg_per"));
                historia_clinica.setCorreo_otros(rs.getString("hora_registro"));
                System.out.println(query);
        }
        
        cn.cerrar();
        } catch (Exception e) {
            System.out.println(query);
             System.out.println("ERROR:"+e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }

       return historia_clinica;
    }

    @Override
    public List<Historia_clinica> listarHistCla(int id_cliente) {
           List<Historia_clinica> lista = null;
        Statement st = null;
        ResultSet rs = null;
        Historia_clinica historia_clinica = null;
        String query = "SELECT   cli.id_cliente as id_cliente,per.direccion as direccion, his_cli.id_historia_clinica as his_cli , per.nombres||' '||per.apepat||' '||per.apemat as cliente,his_cli.nro_historia as nro_his, his_cli.comentario as comen, " +
"  his_cli.antecedentes_familiar as ante_fa,his_cli.fecha_reg_hist,his_cli.responsable_apoderado as nom_apo,his_cli.hora_reg,his_cli.motivo_consulta mo_con, " +
"  his_cli.peso as peso, his_cli.talla as talla, his_cli.pa as pa,  his_cli.estado, his_cli.especificaciones,his_cli.observaciones,  his_cli.pronostico, " +
" CASE sexo WHEN 'M' THEN 'MASCULINO' WHEN 'F' THEN 'FEMENINO' END  sexo,  per.telefono as telefono, per.nro_doc as  dni, per.hora_registro as ho_reg, per.fecha_reg_per as fe_reg," +
"  (select (to_date(to_char(now(),'yyyy'),'yy')-(select to_date(to_char(per.fecha_nac,'yy'),'yy')))/360) as edad, " +
"  per.fecha_nac as fe_na FROM   public.cliente cli,  public.persona per, public.historia_clinica his_cli " +
"WHERE   cli.id_cliente = per.id_persona AND  cli.id_cliente = his_cli.id_cliente  and cli.id_cliente="+id_cliente+"";
        try {
            lista = new ArrayList<Historia_clinica>();
            st = cn.traerconeccion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {

                historia_clinica = new Historia_clinica();
                historia_clinica.setId_historia_clinica(rs.getString("his_cli"));
                historia_clinica.setId_cliente(rs.getString("id_cliente"));
                historia_clinica.setNombres(rs.getString("cliente"));
                historia_clinica.setNro_historia(rs.getString("nro_his"));
                historia_clinica.setApepat(rs.getString("edad"));
                historia_clinica.setSexo(rs.getString("sexo"));
                historia_clinica.setDireccion(rs.getString("direccion"));
                historia_clinica.setNro_doc(rs.getString("dni"));
                historia_clinica.setTelefono(rs.getString("telefono"));
                historia_clinica.setFecha_reg(rs.getString("fe_reg"));
                historia_clinica.setPagina_web(rs.getString("nom_apo"));
                historia_clinica.setMotivo_consulta(rs.getString("mo_con"));
                historia_clinica.setFecha_nac(rs.getString("fe_na"));
                historia_clinica.setComentario(rs.getString("comen"));
                historia_clinica.setAntecedentes_familiar(rs.getString("ante_fa"));
                historia_clinica.setPeso(rs.getString("peso"));
                historia_clinica.setTalla(rs.getString("talla"));
                historia_clinica.setPa(rs.getString("pa"));
                 lista.add(historia_clinica);
            }
            cn.cerrar();
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }
        return lista;
    }
    
}
