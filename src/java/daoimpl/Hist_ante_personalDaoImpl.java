/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import Centro_Control.Conexion2;
import bean.Hist_ante_personal;
import dao.Hist_ante_personalDao;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Luis Lavado
 */
public class Hist_ante_personalDaoImpl implements Hist_ante_personalDao{

    Conexion2 cn = new Conexion2();
    @Override
    public int fn_hist_ante_personal(Hist_ante_personal hist_ante_personal, int opcion) {
        Statement st = null;
        ResultSet rs = null;
        int id_hist_cli=0;
        String COMANDO = "SELECT fn_hist_ante_personal(" + hist_ante_personal.getId_historia_clinica()
                + ", " + hist_ante_personal.getId_ante_personal()
                + "," + opcion + ") resultado";
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
    
}
