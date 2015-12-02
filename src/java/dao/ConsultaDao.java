/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Consulta;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface ConsultaDao {
    public boolean  agregarConsulta(Consulta consulta);
    public List<Consulta> mostrarConsulta();
    public boolean actualizarConsulta(Consulta consulta);
    public boolean eliminarConsulta(int id_consulta);
}
