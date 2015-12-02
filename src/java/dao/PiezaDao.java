/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Pieza;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface PiezaDao {
     public boolean  agregarPieza(Pieza pieza);
    public List<Pieza> mostrarPieza();
    public boolean actualizarPieza(Pieza pieza);
    public boolean eliminarPieza(int pieza);
}
