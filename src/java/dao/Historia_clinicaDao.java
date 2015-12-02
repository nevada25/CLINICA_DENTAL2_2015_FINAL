/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Historia_clinica;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface Historia_clinicaDao {
    public boolean  agregarHistoriaClinica(Historia_clinica historiaClinica);
    public List<Historia_clinica> mostrarHistoriaClinica();
    public boolean actualizarHistoriaClinica(Historia_clinica historiaClinica);
    public boolean eliminarHistoriaClinica(int historiaClinica);
}
