/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import Centro_Control.Conexion2;
import bean.Hist_hab_noc;
import dao.Hist_hab_nocDao;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Luis Lavado
 */
public class Hist_hab_nocDaoImpl implements Hist_hab_nocDao {

    Conexion2 cn = new Conexion2();

    @Override
    public int fn_hist_hab_noc(Hist_hab_noc hist_hab_noc, int opcion) {
        Statement st = null;
        ResultSet rs = null;
        int id_hist_cli = 0;
        String COMANDO = "SELECT fn_hist_hab_noc(" + hist_hab_noc.getId_historia_clinica()
                + ", " + hist_hab_noc.getId_habito_nocivo()
                + "," + opcion + ") resultado";
        System.out.println("comando: " + COMANDO);
        try {
            st = cn.traerconeccion().createStatement();
            rs = st.executeQuery(COMANDO);
            cn.guardar();
            rs.next();
            System.out.println(rs.getString("resultado"));
            id_hist_cli = rs.getInt("resultado");
            cn.cerrar();
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
            cn.cerrar();
        }
        return id_hist_cli;
    }

}
