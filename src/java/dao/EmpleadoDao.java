/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Empleado;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface EmpleadoDao {
    
    public boolean  agregarempleado(Empleado empleado);
    public List<Empleado> mostrarempleado();
    public boolean actualizarempleado(Empleado empleado);
    public boolean eliminarempleado(int idEmpleado);
    
}
