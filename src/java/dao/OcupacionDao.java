/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Ocupacion;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface OcupacionDao {
     public boolean  agregarOcupacion(Ocupacion ocupacion);
    public List<Ocupacion> mostrarOcupacion();
    public boolean actualizarOcupacion(Ocupacion ocupacion);
    public boolean eliminarOcupacion(int ocupacion);
}
