/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Servicio_pieza;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface Servicio_piezaDao {
     public boolean  agregarServicioPieza(Servicio_pieza servicioPieza);
    public List<Servicio_pieza> mostrarServicioPieza();
    public boolean actualizarServicioPieza(Servicio_pieza servicioPieza);
    public boolean eliminarServicioPieza(int servicioPieza);
}
