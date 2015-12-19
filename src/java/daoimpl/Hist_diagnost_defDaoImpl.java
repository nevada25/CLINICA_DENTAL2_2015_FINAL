/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import Centro_Control.Conexion2;
import bean.Hist_diagnost_def;
import dao.Hist_diagnost_defDao;
import java.sql.Statement;

/**
 *
 * @author Luis Lavado
 */
public class Hist_diagnost_defDaoImpl implements Hist_diagnost_defDao {

    Conexion2 cn = new Conexion2();

    @Override
    public boolean agregarHist_diag_daf(Hist_diagnost_def hist_diagnost_def) {
        boolean flat = false;
        Statement st = null;
        String query = " insert into hist_diagnost_def(id_historia_clinica, id_diagnostico_def) values( "
                            + hist_diagnost_def.getId_historia_clinica() +", " + hist_diagnost_def.getId_diagnostico_def() + ")";
        try {
            st = cn.traerconeccion().createStatement();
            st.executeUpdate(query);
            cn.guardar();
            cn.cerrar();
            flat = true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            cn.restablecer();
            cn.cerrar();
            flat = false;
        }
        return flat;
    }

}
