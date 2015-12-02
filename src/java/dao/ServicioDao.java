/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Servicio;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface ServicioDao {
    public boolean fn_crud_servicio(Servicio servicio, int opcion);
    public List<Servicio> listarServicioedi(String buscar,String limit);
    public Servicio BuscarServicio(int id_servicio) ;
}
