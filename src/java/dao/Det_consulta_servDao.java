/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Det_consulta_serv;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface Det_consulta_servDao {
    public boolean  agregarDetConsultaServ(Det_consulta_serv detConsultaServ);
    public List<Det_consulta_serv> mostrarDetConsultaServ();
    public boolean actualizarDetConsultaServ(Det_consulta_serv detConsultaServ);
    public boolean eliminarDetConsultaServ(int id_detConsultaServ);
}
