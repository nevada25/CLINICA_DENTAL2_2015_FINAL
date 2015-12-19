/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import Centro_Control.Conexion2;

import bean.Diagnostico_def;
import dao.Diagnostico_defDao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public class Diagnostico_defDaoImpl implements Diagnostico_defDao {

    Conexion2 cn = new Conexion2();

    public List<Diagnostico_def> listarDiagnosticoPor() {
        List<Diagnostico_def> lista = null;
        Statement st = null;
        ResultSet rs = null;
        Diagnostico_def diagnostico_def = null;
        String COMANDO = "select id_diagnostico_def, cie_10, descripcion from diagnostico_def order by descripcion limit 5";
        try {
            lista = new ArrayList<Diagnostico_def>();
            st = cn.traerconeccion().createStatement();
            rs = st.executeQuery(COMANDO);
            while (rs.next()) {

                diagnostico_def = new Diagnostico_def();
                diagnostico_def.setId_diagnostico_def(rs.getString("id_diagnostico_def"));
                diagnostico_def.setDescripcion(rs.getString("descripcion"));
                diagnostico_def.setCie_10(rs.getString("cie_10"));
                lista.add(diagnostico_def);
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
