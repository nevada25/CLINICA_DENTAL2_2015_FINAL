/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Categoria_servicio;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface Categoria_servicioDao {
    public boolean  agregarServicio(Categoria_servicio Categoria_servicio);
    public List<Categoria_servicio> listarServicio();
    public List<Categoria_servicio> listarServicios(String buscar,String limit);
    public boolean actualizarServicio(Categoria_servicio Categoria_servicio);
    public boolean eliminarServicio(int id_cat_serv);
    public boolean eliminasercategoriaser(int id_servicio);
    public Categoria_servicio datosServicio(int id_servicio);
  
}
