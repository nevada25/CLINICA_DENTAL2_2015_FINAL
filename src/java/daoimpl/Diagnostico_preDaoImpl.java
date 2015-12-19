/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import Centro_Control.Conexion2;
import bean.Diagnostico_pre;
import dao.Diagnostico_preDao;
import java.sql.Statement;

/**
 *
 * @author Luis Lavado
 */
public class Diagnostico_preDaoImpl implements Diagnostico_preDao{

    Conexion2 cn = new Conexion2();
    @Override
    public boolean agregarDiag_pre(Diagnostico_pre diagnostico_pre) {
        boolean flat = false;
        Statement st = null;
        String query = "insert into diagnostico_pre(descripcion, id_historia_clinica) values ('"
                + diagnostico_pre.getDescripcion() +"',"+ diagnostico_pre.getId_historia_clinica() +")";
        try {
            st = cn.traerconeccion().createStatement();
            st.executeUpdate(query);
            cn.guardar();
            cn.cerrar();
            flat = true;
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
            cn.restablecer();
            cn.cerrar();
            flat = false;
        }finally{
        if( cn.traerconeccion()!=null){
            cn.cerrar();
        }
        }
        return flat; 
    }
   
}
