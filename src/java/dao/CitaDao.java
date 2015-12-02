/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Cita;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface CitaDao {
    public boolean  agregaruCita(Cita cita);
    public List<Cita> mostrarCita();
    public boolean actualizarCita(Cita cita);
    public boolean eliminarCita(int id_cita);
}
